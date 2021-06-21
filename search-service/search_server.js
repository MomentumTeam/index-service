const grpc = require("@grpc/grpc-js");
const axios = require("axios").default;
const health = require("grpc-health-check");
const protoLoader = require("@grpc/proto-loader");
const dotenv = require("dotenv");
const logger = require("./logger");
const { Client } = require("@elastic/elasticsearch");
const { getFileByID, getDesendantsById, getUsersPermissions, conditions } = require("./drive_utils");
const { cleanString, getStringWithBold } = require("./str_utils");

dotenv.config({ path: "../.env" });

// Define service status map. Key is the service name, value is the corresponding status.
// By convention, the empty string "" key represents that status of the entire server.
const healthCheckStatusMap = {
  "": proto.grpc.health.v1.HealthCheckResponse.ServingStatus.UNKNOWN,
};
let healthImpl = new health.Implementation(healthCheckStatusMap);

// Elastic
const elasticUrls = process.env.INDEXING_ELASTIC_URLS.split(",");
const clientES = new Client({ node: elasticUrls });

// Search Proto loader
const SEARCH_PROTO_PATH = `${__dirname}/proto/search/search.proto`;
const searchPackageDefinition = protoLoader.loadSync(SEARCH_PROTO_PATH, conditions);
const search_proto = grpc.loadPackageDefinition(searchPackageDefinition).searchService;

// Health check - without elastic access the service won't work
async function healthCheck() {
  let isHealthy = false;

  await Promise.all(
    elasticUrls.map(async (elasticUrl) => {
      try {
        let response = await axios.get(elasticUrl + "/_cluster/health");

        if (response.status === 200) {
          isHealthy = true;
          healthImpl.setStatus("", proto.grpc.health.v1.HealthCheckResponse.ServingStatus.SERVING);
        } else {
          logger.log({
            level: "error",
            message: `elastic url ${elasticUrl} not healthy, status: ${response.status}`,
            label: `elastic-health`,
          });
        }
      } catch (error) {
        logger.log({
          level: "error",
          message: `elastic url ${elasticUrl} not healthy`,
          label: `elastic-health`,
          error,
        });
      }
    })
  );

  if (!isHealthy) {
    healthImpl.setStatus("", proto.grpc.health.v1.HealthCheckResponse.ServingStatus.NOT_SERVING);
  }
}

function main() {
  var server = new grpc.Server();
  server.addService(search_proto.Search.service, { search: search });

  // Check the health status every 5 min
  healthCheck();
  setInterval(healthCheck, 300000);

  // Add the service and implementation to your pre-existing gRPC-node server
  server.addService(health.service, healthImpl);

  server.bindAsync(`${process.env.INDEXING_SEARCH_URL}`, grpc.ServerCredentials.createInsecure(), () => {
    server.start();
    logger.log({
      level: "info",
      message: `SERVER START AT:${process.env.INDEXING_SEARCH_URL}`,
      label: `search-server`,
    });
  });
}

main();
let userId;

async function indexesCollector(permissionArray) {
  let filesArray = [];
  let ownersArray = [];
  let fileObj;

  await Promise.all(
    permissionArray.map(async (permission) => {
      try {
        fileObj = await getFileByID(permission.fileID);
        filesArray.push(fileObj);
      } catch (error) {
        logger.log({
          level: "error",
          message: `Error in getFileById for fileId=${permission.fileID}, error: ${error.message}`,
          label: `indexesCollector`,
        });
      }
    })
  );

  for (let file of filesArray) {
    if (file) {
      if (file.type.includes("folder")) {
        let desendantsArray = await getDesendantsById(file.id);
        if (!desendantsArray) desendantsArray = [];

        let ownersIds = desendantsArray.map((desendants) => desendants.file.ownerID);
        ownersIds.push(file.ownerID);
        ownersArray = ownersArray.concat(ownersIds);
      } else {
        ownersArray.push(file.ownerID);
      }
    }
  }

  logger.log({
    level: "info",
    message: `indexes collected successfully`,
    label: `userId: ${userId}`,
  });

  return ownersArray;
}

function getQueryShould(fields, exactMatch) {
  let should = [];
  if (fields.fileName && fields.fileName !== "") {
    const fileNameQuery = {
      query_string: {
        default_field: "fileName",
        query: `*${fields.fileName}*`,
      },
    };
    should.push(fileNameQuery);
  }

  if (fields.content && fields.content !== "") {
    let contentQuery;
    if (exactMatch) {
      contentQuery = {
        match_phrase: {
          content: fields.content,
        },
      };
    } else {
      contentQuery = {
        query_string: {
          default_field: "content",
          query: `*${fields.content}*`,
        },
      };
    }
    should.push(contentQuery);
  }

  return should;
}

function getDatesShould(fields) {
  const should = [];
  if (fields.updatedAt) {
    const updatedAt = {
      range: {
        updatedAt: {
          gte: fields.updatedAt.start,
          lte: fields.updatedAt.end,
        },
      },
    };
    pushDateToQuery(fields.updatedAt, should, updatedAt);
  }

  if (fields.createdAt) {
    const createdAt = {
      range: {
        createdAt: {
          gte: fields.createdAt.start,
          lte: fields.createdAt.end,
        },
      },
    };
    pushDateToQuery(fields.createdAt, should, createdAt);
  }
  return should;
}

function getQueryMust(fields, userId) {
  const query = [];
  query.push({
    nested: {
      path: "permissions",
      query: {
        match: {
          "permissions.user.userId": userId,
        },
      },
    },
  });
  if (fields.sharedWith && fields.sharedWith !== "") {
    query.push({
      nested: {
        path: "permissions",
        query: {
          match: {
            "permissions.user.userId": fields.sharedWith,
          },
        },
      },
    });
  }

  if (fields.ownerId && fields.ownerId !== "") {
    const ownerIdQuery = {
      query_string: {
        default_field: "owner.userId",
        query: `${fields.ownerId}`,
      },
    };
    query.push(ownerIdQuery);
  }

  if (fields.updatedAt || fields.createdAt) {
    const datesShould = getDatesShould(fields);
    query.push({
      bool: {
        should: datesShould,
        minimum_should_match: 1,
      },
    });
  }

  if (fields.type && fields.type !== "") {
    const typeQuery = {
      match_phrase: {
        type: fields.type,
      },
    };
    query.push(typeQuery);
  }

  return query;
}

function pushDateToQuery(field, query, rangeQuery) {
  const oldest = new Date(
    process.env.INDEXING_OLDEST_YEAR,
    process.env.INDEXING_OLDEST_MONTH,
    process.env.INDEXING_OLDEST_DAY
  )
    .getTime()
    .toString();
  const newest = Date.now().toString();
  const fieldName = Object.keys(rangeQuery.range)[0];

  if (field.start && field.end) {
    query.push(rangeQuery);
  } else if (field.start || field.end) {
    if (!field.end) {
      field.end = newest;
      rangeQuery.range[fieldName].lte = field.end;
    }

    if (!field.start) {
      field.start = oldest;
      rangeQuery.range[fieldName].gte = field.start;
    }

    query.push(rangeQuery);
  }
}

async function search(call, callback) {
  try {
    let indexesArray = [];
    const exactMatch = call.request.exactMatch;
    const fields = call.request.fields;
    userId = call.request.userID;

    if (fields.content) fields.content = cleanString(fields.content);
    if (fields.fileName) fields.fileName = cleanString(fields.fileName);

    const must = getQueryMust(fields, userId);
    const should = getQueryShould(fields, exactMatch);

    const usersPermissions = await getUsersPermissions(userId);
    if (usersPermissions.permissions.length) {
      const ownersArray = await indexesCollector(usersPermissions.permissions);
      ownersArray.unshift(userId);
      indexesArray = [...new Set(ownersArray)]; //returns an Array of ownerIDs of files that were shared with the user.
    }

    const indices_boost = new Object();
    indices_boost[userId] = 2; //boost the files of the user who did the search to the top of the results.

    const elasticRequest = {
      index: indexesArray,
      ignore_unavailable: true,
      body: {
        indices_boost: [indices_boost],
        from: call.request.resultsAmount.from,
        size: call.request.resultsAmount.amount,
        query: {
          bool: {
            must: must,
            should: should,
            minimum_should_match: should.length === 0 ? 0 : 1,
          },
        },
        highlight: {
          pre_tags: ["<b>"],
          post_tags: ["</b>"],
          fields: {
            content: {},
            fileName: {},
          },
        },
        collapse: {
          //return uniqe file Ids-(one result from each file)
          field: "fileId.keyword",
        },
        aggs: {
          //return uniqe count of total results -(one result from each file)
          fileId_count: {
            cardinality: {
              field: "fileId.keyword",
            },
          },
        },
      },
    };

    const result = await clientES.search(elasticRequest);
    const itemCount = JSON.stringify(result.body.aggregations.fileId_count.value);

    const results = await result.body.hits.hits.map((document) => {
      let highlightedContent = null,
        highlightedFileName = null;
      if (fields.content && fields.content != "" && document.highlight.content) {
        highlightedContent = document.highlight.content[0];
      }
      if (fields.fileName && fields.fileName != "" && document.highlight.fileName) {
        highlightedFileName = document.highlight.fileName[0];
      }

      const fileResult = {
        fileId: document._source.fileId,
        highlightedContent: getStringWithBold(highlightedContent, fields.content),
        highlightedFileName: getStringWithBold(highlightedFileName, fields.fileName),
      };

      return fileResult;
    });

    logger.log({
      level: "info",
      message: `Search completed successfully!, total hits: ${itemCount}`,
      label: `userId: ${userId}`,
    });

    callback(null, { results: results, itemCount });
  } catch (err) {
    logger.log({
      level: "error",
      message: `${err} `,
      label: `userId: ${userId}`,
    });
    callback(err, null);
  }
}
