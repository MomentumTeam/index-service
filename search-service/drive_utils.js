const grpc = require("@grpc/grpc-js");
const protoLoader = require("@grpc/proto-loader");
const logger = require("./logger");

const conditions = {
  keepCase: true,
  longs: String,
  enums: String,
  defaults: true,
  oneofs: true,
};

// Proto loader
const PERMMISSION_PROTO_PATH = `${__dirname}/proto/permission/permission.proto`;
const FILE_PROTO_PATH = `${__dirname}/proto/file/file.proto`;

const permissionPackageDefinition = protoLoader.loadSync(PERMMISSION_PROTO_PATH, conditions);
const filePackageDefinition = protoLoader.loadSync(FILE_PROTO_PATH, conditions);

const permission_proto = grpc.loadPackageDefinition(permissionPackageDefinition).permission;
const file_proto = grpc.loadPackageDefinition(filePackageDefinition).file;

const fileClient = new file_proto.FileService(
  `${process.env.INDEXING_FILE_SERVICE_URL}`,
  grpc.credentials.createInsecure()
);

const permissionClient = new permission_proto.Permission(
  `${process.env.INDEXING_PERMISSION_SERVICE_URL}`,
  grpc.credentials.createInsecure()
);

function getFileByID(fileId) {
  return new Promise((resolve, reject) => {
    fileClient.GetFileByID({ id: fileId }, function (err, response) {
      if (err) {
        logger.log({
          level: "error",
          message: `in GetFileByID request to Drive - ${err.details}`,
          label: `userId: ${fileId}`,
        });
        reject(err);
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
          label: `folderId: ${folderId}`,
        });
        resolve(null);
      }
      resolve(response.descendants);
    });
  });
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

module.exports = { getDesendantsById, getFileByID, getUsersPermissions, conditions };
