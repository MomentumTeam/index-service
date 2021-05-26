const { Client } = require("@elastic/elasticsearch");
const grpc = require("@grpc/grpc-js");
const axios = require("axios").default;
const health = require("grpc-health-check");
const protoLoader = require("@grpc/proto-loader");
const dotenv = require("dotenv");
const logger = require("./logger");

dotenv.config({ path: "../.env" });

// Define service status map. Key is the service name, value is the corresponding status.
// By convention, the empty string "" key represents that status of the entire server.
const healthCheckStatusMap = {
  "": proto.grpc.health.v1.HealthCheckResponse.ServingStatus.UNKNOWN,
};

// Construct the service implementation
let healthImpl = new health.Implementation(healthCheckStatusMap);

const elasticUrls = process.env.INDEXING_ELASTIC_URLS.split(",");
// Elastic
const clientES = new Client({ node: elasticUrls });

// Proto loader
const SEARCH_PROTO_PATH = `${__dirname}/proto/search/search.proto`;
const PERMMISSION_PROTO_PATH = `${__dirname}/proto/permission/permission.proto`;
const FILE_PROTO_PATH = `${__dirname}/proto/file/file.proto`;

const conditions = {
  keepCase: true,
  longs: String,
  enums: String,
  defaults: true,
  oneofs: true,
};

const searchPackageDefinition = protoLoader.loadSync(SEARCH_PROTO_PATH, conditions);
const permissionPackageDefinition = protoLoader.loadSync(PERMMISSION_PROTO_PATH, conditions);
const filePackageDefinition = protoLoader.loadSync(FILE_PROTO_PATH, conditions);

const search_proto = grpc.loadPackageDefinition(searchPackageDefinition).searchService;
const permission_proto = grpc.loadPackageDefinition(permissionPackageDefinition).permission;
const file_proto = grpc.loadPackageDefinition(filePackageDefinition).file;

const permissionClient = new permission_proto.Permission(`${process.env.INDEXING_PERMISSION_SERVICE_URL}`, grpc.credentials.createInsecure());
const fileClient = new file_proto.FileService(`${process.env.INDEXING_FILE_SERVICE_URL}`, grpc.credentials.createInsecure());

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

function cleanString(str) {
  cleanStr = str.replace(/[$&+,:;=?@#|'<>.^*()%!{}-]/g, " ");
  cleanStr = cleanStr.replace(/[^A-Za-z0-9\u0590-\u05FF\u0600-\u06FF]/g, " "); // Without special characters
  cleanStr = cleanStr.replace(/\r?\n|\r/g, " ");
  cleanStr = cleanStr.trim().replace(/\s+/g, " ");
  cleanStr = cleanStr.toLowerCase();
  return cleanStr;
}

function getStringWithBold(str, query) {
  if (!query || !str) {
    return str;
  }
  const queryArray = query.split(" ");
  str = str.replace(new RegExp("<b>", "g"), "");
  str = str.replace(new RegExp("</b>", "g"), "");
  queryArray.forEach((element) => {
    str = str.replace(new RegExp(element, "g"), `<b>${element}</b>`);
  });
  return str;
}

async function indexesCollector(permissionArray) {
  let filesArray = [];
  let ownersArray = [];
  let fileObj;

  await Promise.all(
    permissionArray.map(async (permission) => {
      fileObj = await getFileByID(permission.fileID);
      filesArray.push(fileObj);
    })
  );

  if (filesArray.includes(null)) {
    return [];
  }

  for (let file of filesArray) {
    if (file) {
      if (file.type.includes("folder")) {
        let desendantsArray = await getDesendantsById(file.id);
        if (!desendantsArray) {
          return [];
        }
        let ownersIds = desendantsArray.map((desendants) => {
          return desendants.file.ownerID;
        });

        ownersIds.push(file.ownerID);
        ownersArray = ownersArray.concat(ownersIds);
      } else if (file.type.includes("document")) {
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

function getUsersPermissions(userId) {
  return new Promise((resolve, reject) => {
    permissionClient.GetUserPermissions({ userID: userId }, function (err, response) {
      if (err) {
        logger.log({
          level: "error",
          message: `in GetUserPermissions request to Drive - ${err.details}`,
          label: `userId: ${userId}`,
        });
        resolve(null);
      }
      resolve(response);
    });
  });
}

function getFileByID(fileId) {
  return new Promise((resolve, reject) => {
    fileClient.GetFileByID({ id: fileId }, function (err, response) {
      if (err) {
        logger.log({
          level: "error",
          message: `in GetFileByID request to Drive - ${err.details}`,
          label: `userId: ${userId}`,
        });
        resolve(null);
      }
      resolve(response);
    });
  });
}

function getDesendantsById(folderId) {
  return new Promise((resolve, reject) => {
    fileClient.GetDescendantsByID({ id: folderId }, function (err, response) {
      if (err) {
        logger.log({
          level: "error",
          message: `in GetDescendantsByID request to Drive - ${err.details}`,
          label: `userId: ${userId}`,
        });
        resolve(null);
      }
      resolve(response.descendants);
    });
  });
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
      query_string: {
        default_field: "type",
        query: `*${fields.type}*`,
      },
    };
    query.push(typeQuery);
  }

  return query;
}

function pushDateToQuery(field, query, rangeQuery) {
  const oldest = new Date(process.env.INDEXING_OLDEST_YEAR, process.env.INDEXING_OLDEST_MONTH, process.env.INDEXING_OLDEST_DAY).getTime().toString();
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
    if (fields.content) {
      fields.content = cleanString(fields.content);
    }
    if (fields.fileName) {
      fields.fileName = cleanString(fields.fileName);
    }
    userId = call.request.userID;

    const must = getQueryMust(fields, userId);
    const should = getQueryShould(fields, exactMatch);

    //TODO UNCOMMENT
    // const usersPermissions = await getUsersPermissions(userId);

    // if (usersPermissions.permissions.length) {
    //   const ownersArray = await indexesCollector(usersPermissions.permissions);
    //   ownersArray.unshift(userId);
    //   indexesArray = [...new Set(ownersArray)]; //returns an Array of ownerIDs of files that were shared with the user.
    // }
    //TODO UNCOMMENT

    indexesArray = ["5e5688324203fc40043591aa"];
    const indices_boost = new Object();
    indices_boost[userId] = 2; //boost the files of the user who did the search to the top of the results.

    const elasticRequest = {
      index: indexesArray,
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
      },
    };

    const result = await clientES.search(elasticRequest);

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
      message: `Search completed successfully!`,
      label: `userId: ${userId}`,
    });

    callback(null, { results: results });
  } catch (err) {
    logger.log({
      level: "error",
      message: `${err} `,
      label: `userId: ${userId}`,
    });
    callback(err, null);
  }
}
