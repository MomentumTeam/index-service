package DriveStubs.grpc;

import io.grpc.stub.ClientCalls;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: file.proto")
public final class FileServiceGrpc {

  private FileServiceGrpc() {}

  public static final String SERVICE_NAME = "file.FileService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<FileOuterClass.GenerateKeyRequest,
      FileOuterClass.KeyResponse> getGenerateKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateKey",
      requestType = FileOuterClass.GenerateKeyRequest.class,
      responseType = FileOuterClass.KeyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.GenerateKeyRequest,
      FileOuterClass.KeyResponse> getGenerateKeyMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.GenerateKeyRequest, FileOuterClass.KeyResponse> getGenerateKeyMethod;
    if ((getGenerateKeyMethod = FileServiceGrpc.getGenerateKeyMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getGenerateKeyMethod = FileServiceGrpc.getGenerateKeyMethod) == null) {
          FileServiceGrpc.getGenerateKeyMethod = getGenerateKeyMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.GenerateKeyRequest, FileOuterClass.KeyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "GenerateKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GenerateKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.KeyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("GenerateKey"))
                  .build();
          }
        }
     }
     return getGenerateKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.CreateUploadRequest,
      FileOuterClass.CreateUploadResponse> getCreateUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUpload",
      requestType = FileOuterClass.CreateUploadRequest.class,
      responseType = FileOuterClass.CreateUploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.CreateUploadRequest,
      FileOuterClass.CreateUploadResponse> getCreateUploadMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.CreateUploadRequest, FileOuterClass.CreateUploadResponse> getCreateUploadMethod;
    if ((getCreateUploadMethod = FileServiceGrpc.getCreateUploadMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getCreateUploadMethod = FileServiceGrpc.getCreateUploadMethod) == null) {
          FileServiceGrpc.getCreateUploadMethod = getCreateUploadMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.CreateUploadRequest, FileOuterClass.CreateUploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "CreateUpload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.CreateUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.CreateUploadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("CreateUpload"))
                  .build();
          }
        }
     }
     return getCreateUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.CreateUploadRequest,
      FileOuterClass.CreateUploadResponse> getCreateUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUpdate",
      requestType = FileOuterClass.CreateUploadRequest.class,
      responseType = FileOuterClass.CreateUploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.CreateUploadRequest,
      FileOuterClass.CreateUploadResponse> getCreateUpdateMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.CreateUploadRequest, FileOuterClass.CreateUploadResponse> getCreateUpdateMethod;
    if ((getCreateUpdateMethod = FileServiceGrpc.getCreateUpdateMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getCreateUpdateMethod = FileServiceGrpc.getCreateUpdateMethod) == null) {
          FileServiceGrpc.getCreateUpdateMethod = getCreateUpdateMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.CreateUploadRequest, FileOuterClass.CreateUploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "CreateUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.CreateUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.CreateUploadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("CreateUpdate"))
                  .build();
          }
        }
     }
     return getCreateUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.UpdateUploadIDRequest,
      FileOuterClass.UpdateUploadIDResponse> getUpdateUploadIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUploadID",
      requestType = FileOuterClass.UpdateUploadIDRequest.class,
      responseType = FileOuterClass.UpdateUploadIDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.UpdateUploadIDRequest,
      FileOuterClass.UpdateUploadIDResponse> getUpdateUploadIDMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.UpdateUploadIDRequest, FileOuterClass.UpdateUploadIDResponse> getUpdateUploadIDMethod;
    if ((getUpdateUploadIDMethod = FileServiceGrpc.getUpdateUploadIDMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getUpdateUploadIDMethod = FileServiceGrpc.getUpdateUploadIDMethod) == null) {
          FileServiceGrpc.getUpdateUploadIDMethod = getUpdateUploadIDMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.UpdateUploadIDRequest, FileOuterClass.UpdateUploadIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "UpdateUploadID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.UpdateUploadIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.UpdateUploadIDResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("UpdateUploadID"))
                  .build();
          }
        }
     }
     return getUpdateUploadIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.GetUploadByIDRequest,
      FileOuterClass.GetUploadByIDResponse> getGetUploadByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUploadByID",
      requestType = FileOuterClass.GetUploadByIDRequest.class,
      responseType = FileOuterClass.GetUploadByIDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.GetUploadByIDRequest,
      FileOuterClass.GetUploadByIDResponse> getGetUploadByIDMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.GetUploadByIDRequest, FileOuterClass.GetUploadByIDResponse> getGetUploadByIDMethod;
    if ((getGetUploadByIDMethod = FileServiceGrpc.getGetUploadByIDMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getGetUploadByIDMethod = FileServiceGrpc.getGetUploadByIDMethod) == null) {
          FileServiceGrpc.getGetUploadByIDMethod = getGetUploadByIDMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.GetUploadByIDRequest, FileOuterClass.GetUploadByIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "GetUploadByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetUploadByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetUploadByIDResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("GetUploadByID"))
                  .build();
          }
        }
     }
     return getGetUploadByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.DeleteUploadByKeyRequest,
      FileOuterClass.DeleteUploadByKeyResponse> getDeleteUploadByKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUploadByKey",
      requestType = FileOuterClass.DeleteUploadByKeyRequest.class,
      responseType = FileOuterClass.DeleteUploadByKeyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.DeleteUploadByKeyRequest,
      FileOuterClass.DeleteUploadByKeyResponse> getDeleteUploadByKeyMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.DeleteUploadByKeyRequest, FileOuterClass.DeleteUploadByKeyResponse> getDeleteUploadByKeyMethod;
    if ((getDeleteUploadByKeyMethod = FileServiceGrpc.getDeleteUploadByKeyMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDeleteUploadByKeyMethod = FileServiceGrpc.getDeleteUploadByKeyMethod) == null) {
          FileServiceGrpc.getDeleteUploadByKeyMethod = getDeleteUploadByKeyMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.DeleteUploadByKeyRequest, FileOuterClass.DeleteUploadByKeyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "DeleteUploadByKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.DeleteUploadByKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.DeleteUploadByKeyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("DeleteUploadByKey"))
                  .build();
          }
        }
     }
     return getDeleteUploadByKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.DeleteUploadByIDRequest,
      FileOuterClass.DeleteUploadByIDResponse> getDeleteUploadByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUploadByID",
      requestType = FileOuterClass.DeleteUploadByIDRequest.class,
      responseType = FileOuterClass.DeleteUploadByIDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.DeleteUploadByIDRequest,
      FileOuterClass.DeleteUploadByIDResponse> getDeleteUploadByIDMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.DeleteUploadByIDRequest, FileOuterClass.DeleteUploadByIDResponse> getDeleteUploadByIDMethod;
    if ((getDeleteUploadByIDMethod = FileServiceGrpc.getDeleteUploadByIDMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDeleteUploadByIDMethod = FileServiceGrpc.getDeleteUploadByIDMethod) == null) {
          FileServiceGrpc.getDeleteUploadByIDMethod = getDeleteUploadByIDMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.DeleteUploadByIDRequest, FileOuterClass.DeleteUploadByIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "DeleteUploadByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.DeleteUploadByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.DeleteUploadByIDResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("DeleteUploadByID"))
                  .build();
          }
        }
     }
     return getDeleteUploadByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.GetByFileByIDRequest,
      FileOuterClass.File> getGetFileByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFileByID",
      requestType = FileOuterClass.GetByFileByIDRequest.class,
      responseType = FileOuterClass.File.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.GetByFileByIDRequest,
      FileOuterClass.File> getGetFileByIDMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.GetByFileByIDRequest, FileOuterClass.File> getGetFileByIDMethod;
    if ((getGetFileByIDMethod = FileServiceGrpc.getGetFileByIDMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getGetFileByIDMethod = FileServiceGrpc.getGetFileByIDMethod) == null) {
          FileServiceGrpc.getGetFileByIDMethod = getGetFileByIDMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.GetByFileByIDRequest, FileOuterClass.File>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "GetFileByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetByFileByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.File.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("GetFileByID"))
                  .build();
          }
        }
     }
     return getGetFileByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.GetFileByKeyRequest,
      FileOuterClass.File> getGetFileByKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFileByKey",
      requestType = FileOuterClass.GetFileByKeyRequest.class,
      responseType = FileOuterClass.File.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.GetFileByKeyRequest,
      FileOuterClass.File> getGetFileByKeyMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.GetFileByKeyRequest, FileOuterClass.File> getGetFileByKeyMethod;
    if ((getGetFileByKeyMethod = FileServiceGrpc.getGetFileByKeyMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getGetFileByKeyMethod = FileServiceGrpc.getGetFileByKeyMethod) == null) {
          FileServiceGrpc.getGetFileByKeyMethod = getGetFileByKeyMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.GetFileByKeyRequest, FileOuterClass.File>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "GetFileByKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetFileByKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.File.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("GetFileByKey"))
                  .build();
          }
        }
     }
     return getGetFileByKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.GetFilesByFolderRequest,
      FileOuterClass.GetFilesByFolderResponse> getGetFilesByFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFilesByFolder",
      requestType = FileOuterClass.GetFilesByFolderRequest.class,
      responseType = FileOuterClass.GetFilesByFolderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.GetFilesByFolderRequest,
      FileOuterClass.GetFilesByFolderResponse> getGetFilesByFolderMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.GetFilesByFolderRequest, FileOuterClass.GetFilesByFolderResponse> getGetFilesByFolderMethod;
    if ((getGetFilesByFolderMethod = FileServiceGrpc.getGetFilesByFolderMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getGetFilesByFolderMethod = FileServiceGrpc.getGetFilesByFolderMethod) == null) {
          FileServiceGrpc.getGetFilesByFolderMethod = getGetFilesByFolderMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.GetFilesByFolderRequest, FileOuterClass.GetFilesByFolderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "GetFilesByFolder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetFilesByFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetFilesByFolderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("GetFilesByFolder"))
                  .build();
          }
        }
     }
     return getGetFilesByFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.GetDescendantsByFolderRequest,
      FileOuterClass.GetDescendantsByFolderResponse> getGetDescendantsByFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDescendantsByFolder",
      requestType = FileOuterClass.GetDescendantsByFolderRequest.class,
      responseType = FileOuterClass.GetDescendantsByFolderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.GetDescendantsByFolderRequest,
      FileOuterClass.GetDescendantsByFolderResponse> getGetDescendantsByFolderMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.GetDescendantsByFolderRequest, FileOuterClass.GetDescendantsByFolderResponse> getGetDescendantsByFolderMethod;
    if ((getGetDescendantsByFolderMethod = FileServiceGrpc.getGetDescendantsByFolderMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getGetDescendantsByFolderMethod = FileServiceGrpc.getGetDescendantsByFolderMethod) == null) {
          FileServiceGrpc.getGetDescendantsByFolderMethod = getGetDescendantsByFolderMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.GetDescendantsByFolderRequest, FileOuterClass.GetDescendantsByFolderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "GetDescendantsByFolder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetDescendantsByFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetDescendantsByFolderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("GetDescendantsByFolder"))
                  .build();
          }
        }
     }
     return getGetDescendantsByFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.CreateFileRequest,
      FileOuterClass.File> getCreateFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFile",
      requestType = FileOuterClass.CreateFileRequest.class,
      responseType = FileOuterClass.File.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.CreateFileRequest,
      FileOuterClass.File> getCreateFileMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.CreateFileRequest, FileOuterClass.File> getCreateFileMethod;
    if ((getCreateFileMethod = FileServiceGrpc.getCreateFileMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getCreateFileMethod = FileServiceGrpc.getCreateFileMethod) == null) {
          FileServiceGrpc.getCreateFileMethod = getCreateFileMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.CreateFileRequest, FileOuterClass.File>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "CreateFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.CreateFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.File.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("CreateFile"))
                  .build();
          }
        }
     }
     return getCreateFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.DeleteFileRequest,
      FileOuterClass.DeleteFileResponse> getDeleteFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFile",
      requestType = FileOuterClass.DeleteFileRequest.class,
      responseType = FileOuterClass.DeleteFileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.DeleteFileRequest,
      FileOuterClass.DeleteFileResponse> getDeleteFileMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.DeleteFileRequest, FileOuterClass.DeleteFileResponse> getDeleteFileMethod;
    if ((getDeleteFileMethod = FileServiceGrpc.getDeleteFileMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDeleteFileMethod = FileServiceGrpc.getDeleteFileMethod) == null) {
          FileServiceGrpc.getDeleteFileMethod = getDeleteFileMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.DeleteFileRequest, FileOuterClass.DeleteFileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "DeleteFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.DeleteFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.DeleteFileResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("DeleteFile"))
                  .build();
          }
        }
     }
     return getDeleteFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.IsAllowedRequest,
      FileOuterClass.IsAllowedResponse> getIsAllowedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsAllowed",
      requestType = FileOuterClass.IsAllowedRequest.class,
      responseType = FileOuterClass.IsAllowedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.IsAllowedRequest,
      FileOuterClass.IsAllowedResponse> getIsAllowedMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.IsAllowedRequest, FileOuterClass.IsAllowedResponse> getIsAllowedMethod;
    if ((getIsAllowedMethod = FileServiceGrpc.getIsAllowedMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getIsAllowedMethod = FileServiceGrpc.getIsAllowedMethod) == null) {
          FileServiceGrpc.getIsAllowedMethod = getIsAllowedMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.IsAllowedRequest, FileOuterClass.IsAllowedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "IsAllowed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.IsAllowedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.IsAllowedResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("IsAllowed"))
                  .build();
          }
        }
     }
     return getIsAllowedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.UpdateFilesRequest,
      FileOuterClass.UpdateFilesResponse> getUpdateFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFiles",
      requestType = FileOuterClass.UpdateFilesRequest.class,
      responseType = FileOuterClass.UpdateFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.UpdateFilesRequest,
      FileOuterClass.UpdateFilesResponse> getUpdateFilesMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.UpdateFilesRequest, FileOuterClass.UpdateFilesResponse> getUpdateFilesMethod;
    if ((getUpdateFilesMethod = FileServiceGrpc.getUpdateFilesMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getUpdateFilesMethod = FileServiceGrpc.getUpdateFilesMethod) == null) {
          FileServiceGrpc.getUpdateFilesMethod = getUpdateFilesMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.UpdateFilesRequest, FileOuterClass.UpdateFilesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "UpdateFiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.UpdateFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.UpdateFilesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("UpdateFiles"))
                  .build();
          }
        }
     }
     return getUpdateFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.GetAncestorsRequest,
      FileOuterClass.GetAncestorsResponse> getGetAncestorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAncestors",
      requestType = FileOuterClass.GetAncestorsRequest.class,
      responseType = FileOuterClass.GetAncestorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.GetAncestorsRequest,
      FileOuterClass.GetAncestorsResponse> getGetAncestorsMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.GetAncestorsRequest, FileOuterClass.GetAncestorsResponse> getGetAncestorsMethod;
    if ((getGetAncestorsMethod = FileServiceGrpc.getGetAncestorsMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getGetAncestorsMethod = FileServiceGrpc.getGetAncestorsMethod) == null) {
          FileServiceGrpc.getGetAncestorsMethod = getGetAncestorsMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.GetAncestorsRequest, FileOuterClass.GetAncestorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "GetAncestors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetAncestorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetAncestorsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("GetAncestors"))
                  .build();
          }
        }
     }
     return getGetAncestorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.GetDescendantsByIDRequest,
      FileOuterClass.GetDescendantsByIDResponse> getGetDescendantsByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDescendantsByID",
      requestType = FileOuterClass.GetDescendantsByIDRequest.class,
      responseType = FileOuterClass.GetDescendantsByIDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.GetDescendantsByIDRequest,
      FileOuterClass.GetDescendantsByIDResponse> getGetDescendantsByIDMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.GetDescendantsByIDRequest, FileOuterClass.GetDescendantsByIDResponse> getGetDescendantsByIDMethod;
    if ((getGetDescendantsByIDMethod = FileServiceGrpc.getGetDescendantsByIDMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getGetDescendantsByIDMethod = FileServiceGrpc.getGetDescendantsByIDMethod) == null) {
          FileServiceGrpc.getGetDescendantsByIDMethod = getGetDescendantsByIDMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.GetDescendantsByIDRequest, FileOuterClass.GetDescendantsByIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "GetDescendantsByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetDescendantsByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.GetDescendantsByIDResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("GetDescendantsByID"))
                  .build();
          }
        }
     }
     return getGetDescendantsByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FileOuterClass.DeleteFileByIDRequest,
      FileOuterClass.DeleteFileByIDResponse> getDeleteFileByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFileByID",
      requestType = FileOuterClass.DeleteFileByIDRequest.class,
      responseType = FileOuterClass.DeleteFileByIDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FileOuterClass.DeleteFileByIDRequest,
      FileOuterClass.DeleteFileByIDResponse> getDeleteFileByIDMethod() {
    io.grpc.MethodDescriptor<FileOuterClass.DeleteFileByIDRequest, FileOuterClass.DeleteFileByIDResponse> getDeleteFileByIDMethod;
    if ((getDeleteFileByIDMethod = FileServiceGrpc.getDeleteFileByIDMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDeleteFileByIDMethod = FileServiceGrpc.getDeleteFileByIDMethod) == null) {
          FileServiceGrpc.getDeleteFileByIDMethod = getDeleteFileByIDMethod = 
              io.grpc.MethodDescriptor.<FileOuterClass.DeleteFileByIDRequest, FileOuterClass.DeleteFileByIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "file.FileService", "DeleteFileByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.DeleteFileByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FileOuterClass.DeleteFileByIDResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("DeleteFileByID"))
                  .build();
          }
        }
     }
     return getDeleteFileByIDMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileServiceStub newStub(io.grpc.Channel channel) {
    return new FileServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FileServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FileServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FileServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateKey(FileOuterClass.GenerateKeyRequest request,
                            io.grpc.stub.StreamObserver<FileOuterClass.KeyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateKeyMethod(), responseObserver);
    }

    /**
     */
    public void createUpload(FileOuterClass.CreateUploadRequest request,
                             io.grpc.stub.StreamObserver<FileOuterClass.CreateUploadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateUploadMethod(), responseObserver);
    }

    /**
     */
    public void createUpdate(FileOuterClass.CreateUploadRequest request,
                             io.grpc.stub.StreamObserver<FileOuterClass.CreateUploadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateUpdateMethod(), responseObserver);
    }

    /**
     */
    public void updateUploadID(FileOuterClass.UpdateUploadIDRequest request,
                               io.grpc.stub.StreamObserver<FileOuterClass.UpdateUploadIDResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUploadIDMethod(), responseObserver);
    }

    /**
     */
    public void getUploadByID(FileOuterClass.GetUploadByIDRequest request,
                              io.grpc.stub.StreamObserver<FileOuterClass.GetUploadByIDResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUploadByIDMethod(), responseObserver);
    }

    /**
     */
    public void deleteUploadByKey(FileOuterClass.DeleteUploadByKeyRequest request,
                                  io.grpc.stub.StreamObserver<FileOuterClass.DeleteUploadByKeyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteUploadByKeyMethod(), responseObserver);
    }

    /**
     */
    public void deleteUploadByID(FileOuterClass.DeleteUploadByIDRequest request,
                                 io.grpc.stub.StreamObserver<FileOuterClass.DeleteUploadByIDResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteUploadByIDMethod(), responseObserver);
    }

    /**
     */
    public void getFileByID(FileOuterClass.GetByFileByIDRequest request,
                            io.grpc.stub.StreamObserver<FileOuterClass.File> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFileByIDMethod(), responseObserver);
    }

    /**
     */
    public void getFileByKey(FileOuterClass.GetFileByKeyRequest request,
                             io.grpc.stub.StreamObserver<FileOuterClass.File> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFileByKeyMethod(), responseObserver);
    }

    /**
     */
    public void getFilesByFolder(FileOuterClass.GetFilesByFolderRequest request,
                                 io.grpc.stub.StreamObserver<FileOuterClass.GetFilesByFolderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFilesByFolderMethod(), responseObserver);
    }

    /**
     */
    public void getDescendantsByFolder(FileOuterClass.GetDescendantsByFolderRequest request,
                                       io.grpc.stub.StreamObserver<FileOuterClass.GetDescendantsByFolderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDescendantsByFolderMethod(), responseObserver);
    }

    /**
     */
    public void createFile(FileOuterClass.CreateFileRequest request,
                           io.grpc.stub.StreamObserver<FileOuterClass.File> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateFileMethod(), responseObserver);
    }

    /**
     */
    public void deleteFile(FileOuterClass.DeleteFileRequest request,
                           io.grpc.stub.StreamObserver<FileOuterClass.DeleteFileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFileMethod(), responseObserver);
    }

    /**
     */
    public void isAllowed(FileOuterClass.IsAllowedRequest request,
                          io.grpc.stub.StreamObserver<FileOuterClass.IsAllowedResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIsAllowedMethod(), responseObserver);
    }

    /**
     */
    public void updateFiles(FileOuterClass.UpdateFilesRequest request,
                            io.grpc.stub.StreamObserver<FileOuterClass.UpdateFilesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFilesMethod(), responseObserver);
    }

    /**
     */
    public void getAncestors(FileOuterClass.GetAncestorsRequest request,
                             io.grpc.stub.StreamObserver<FileOuterClass.GetAncestorsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAncestorsMethod(), responseObserver);
    }

    /**
     */
    public void getDescendantsByID(FileOuterClass.GetDescendantsByIDRequest request,
                                   io.grpc.stub.StreamObserver<FileOuterClass.GetDescendantsByIDResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDescendantsByIDMethod(), responseObserver);
    }

    /**
     */
    public void deleteFileByID(FileOuterClass.DeleteFileByIDRequest request,
                               io.grpc.stub.StreamObserver<FileOuterClass.DeleteFileByIDResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFileByIDMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateKeyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.GenerateKeyRequest,
                FileOuterClass.KeyResponse>(
                  this, METHODID_GENERATE_KEY)))
          .addMethod(
            getCreateUploadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.CreateUploadRequest,
                FileOuterClass.CreateUploadResponse>(
                  this, METHODID_CREATE_UPLOAD)))
          .addMethod(
            getCreateUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.CreateUploadRequest,
                FileOuterClass.CreateUploadResponse>(
                  this, METHODID_CREATE_UPDATE)))
          .addMethod(
            getUpdateUploadIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.UpdateUploadIDRequest,
                FileOuterClass.UpdateUploadIDResponse>(
                  this, METHODID_UPDATE_UPLOAD_ID)))
          .addMethod(
            getGetUploadByIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.GetUploadByIDRequest,
                FileOuterClass.GetUploadByIDResponse>(
                  this, METHODID_GET_UPLOAD_BY_ID)))
          .addMethod(
            getDeleteUploadByKeyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.DeleteUploadByKeyRequest,
                FileOuterClass.DeleteUploadByKeyResponse>(
                  this, METHODID_DELETE_UPLOAD_BY_KEY)))
          .addMethod(
            getDeleteUploadByIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.DeleteUploadByIDRequest,
                FileOuterClass.DeleteUploadByIDResponse>(
                  this, METHODID_DELETE_UPLOAD_BY_ID)))
          .addMethod(
            getGetFileByIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.GetByFileByIDRequest,
                FileOuterClass.File>(
                  this, METHODID_GET_FILE_BY_ID)))
          .addMethod(
            getGetFileByKeyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.GetFileByKeyRequest,
                FileOuterClass.File>(
                  this, METHODID_GET_FILE_BY_KEY)))
          .addMethod(
            getGetFilesByFolderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.GetFilesByFolderRequest,
                FileOuterClass.GetFilesByFolderResponse>(
                  this, METHODID_GET_FILES_BY_FOLDER)))
          .addMethod(
            getGetDescendantsByFolderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.GetDescendantsByFolderRequest,
                FileOuterClass.GetDescendantsByFolderResponse>(
                  this, METHODID_GET_DESCENDANTS_BY_FOLDER)))
          .addMethod(
            getCreateFileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.CreateFileRequest,
                FileOuterClass.File>(
                  this, METHODID_CREATE_FILE)))
          .addMethod(
            getDeleteFileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.DeleteFileRequest,
                FileOuterClass.DeleteFileResponse>(
                  this, METHODID_DELETE_FILE)))
          .addMethod(
            getIsAllowedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.IsAllowedRequest,
                FileOuterClass.IsAllowedResponse>(
                  this, METHODID_IS_ALLOWED)))
          .addMethod(
            getUpdateFilesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.UpdateFilesRequest,
                FileOuterClass.UpdateFilesResponse>(
                  this, METHODID_UPDATE_FILES)))
          .addMethod(
            getGetAncestorsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.GetAncestorsRequest,
                FileOuterClass.GetAncestorsResponse>(
                  this, METHODID_GET_ANCESTORS)))
          .addMethod(
            getGetDescendantsByIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.GetDescendantsByIDRequest,
                FileOuterClass.GetDescendantsByIDResponse>(
                  this, METHODID_GET_DESCENDANTS_BY_ID)))
          .addMethod(
            getDeleteFileByIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FileOuterClass.DeleteFileByIDRequest,
                FileOuterClass.DeleteFileByIDResponse>(
                  this, METHODID_DELETE_FILE_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class FileServiceStub extends io.grpc.stub.AbstractStub<FileServiceStub> {
    private FileServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected FileServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceStub(channel, callOptions);
    }

    /**
     */
    public void generateKey(FileOuterClass.GenerateKeyRequest request,
                            io.grpc.stub.StreamObserver<FileOuterClass.KeyResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createUpload(FileOuterClass.CreateUploadRequest request,
                             io.grpc.stub.StreamObserver<FileOuterClass.CreateUploadResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUploadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createUpdate(FileOuterClass.CreateUploadRequest request,
                             io.grpc.stub.StreamObserver<FileOuterClass.CreateUploadResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUploadID(FileOuterClass.UpdateUploadIDRequest request,
                               io.grpc.stub.StreamObserver<FileOuterClass.UpdateUploadIDResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUploadIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUploadByID(FileOuterClass.GetUploadByIDRequest request,
                              io.grpc.stub.StreamObserver<FileOuterClass.GetUploadByIDResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUploadByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUploadByKey(FileOuterClass.DeleteUploadByKeyRequest request,
                                  io.grpc.stub.StreamObserver<FileOuterClass.DeleteUploadByKeyResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUploadByKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUploadByID(FileOuterClass.DeleteUploadByIDRequest request,
                                 io.grpc.stub.StreamObserver<FileOuterClass.DeleteUploadByIDResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUploadByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFileByID(FileOuterClass.GetByFileByIDRequest request,
                            io.grpc.stub.StreamObserver<FileOuterClass.File> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFileByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFileByKey(FileOuterClass.GetFileByKeyRequest request,
                             io.grpc.stub.StreamObserver<FileOuterClass.File> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFileByKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFilesByFolder(FileOuterClass.GetFilesByFolderRequest request,
                                 io.grpc.stub.StreamObserver<FileOuterClass.GetFilesByFolderResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFilesByFolderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDescendantsByFolder(FileOuterClass.GetDescendantsByFolderRequest request,
                                       io.grpc.stub.StreamObserver<FileOuterClass.GetDescendantsByFolderResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDescendantsByFolderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createFile(FileOuterClass.CreateFileRequest request,
                           io.grpc.stub.StreamObserver<FileOuterClass.File> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFile(FileOuterClass.DeleteFileRequest request,
                           io.grpc.stub.StreamObserver<FileOuterClass.DeleteFileResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isAllowed(FileOuterClass.IsAllowedRequest request,
                          io.grpc.stub.StreamObserver<FileOuterClass.IsAllowedResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsAllowedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateFiles(FileOuterClass.UpdateFilesRequest request,
                            io.grpc.stub.StreamObserver<FileOuterClass.UpdateFilesResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFilesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAncestors(FileOuterClass.GetAncestorsRequest request,
                             io.grpc.stub.StreamObserver<FileOuterClass.GetAncestorsResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAncestorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDescendantsByID(FileOuterClass.GetDescendantsByIDRequest request,
                                   io.grpc.stub.StreamObserver<FileOuterClass.GetDescendantsByIDResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDescendantsByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFileByID(FileOuterClass.DeleteFileByIDRequest request,
                               io.grpc.stub.StreamObserver<FileOuterClass.DeleteFileByIDResponse> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFileByIDMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FileServiceBlockingStub extends io.grpc.stub.AbstractStub<FileServiceBlockingStub> {
    private FileServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected FileServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public FileOuterClass.KeyResponse generateKey(FileOuterClass.GenerateKeyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.CreateUploadResponse createUpload(FileOuterClass.CreateUploadRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateUploadMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.CreateUploadResponse createUpdate(FileOuterClass.CreateUploadRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.UpdateUploadIDResponse updateUploadID(FileOuterClass.UpdateUploadIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateUploadIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.GetUploadByIDResponse getUploadByID(FileOuterClass.GetUploadByIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUploadByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.DeleteUploadByKeyResponse deleteUploadByKey(FileOuterClass.DeleteUploadByKeyRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteUploadByKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.DeleteUploadByIDResponse deleteUploadByID(FileOuterClass.DeleteUploadByIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteUploadByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.File getFileByID(FileOuterClass.GetByFileByIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFileByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.File getFileByKey(FileOuterClass.GetFileByKeyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFileByKeyMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.GetFilesByFolderResponse getFilesByFolder(FileOuterClass.GetFilesByFolderRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFilesByFolderMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.GetDescendantsByFolderResponse getDescendantsByFolder(FileOuterClass.GetDescendantsByFolderRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDescendantsByFolderMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.File createFile(FileOuterClass.CreateFileRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateFileMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.DeleteFileResponse deleteFile(FileOuterClass.DeleteFileRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFileMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.IsAllowedResponse isAllowed(FileOuterClass.IsAllowedRequest request) {
      return blockingUnaryCall(
          getChannel(), getIsAllowedMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.UpdateFilesResponse updateFiles(FileOuterClass.UpdateFilesRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFilesMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.GetAncestorsResponse getAncestors(FileOuterClass.GetAncestorsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAncestorsMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.GetDescendantsByIDResponse getDescendantsByID(FileOuterClass.GetDescendantsByIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDescendantsByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public FileOuterClass.DeleteFileByIDResponse deleteFileByID(FileOuterClass.DeleteFileByIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFileByIDMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileServiceFutureStub extends io.grpc.stub.AbstractStub<FileServiceFutureStub> {
    private FileServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected FileServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.KeyResponse> generateKey(
        FileOuterClass.GenerateKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.CreateUploadResponse> createUpload(
        FileOuterClass.CreateUploadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateUploadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.CreateUploadResponse> createUpdate(
        FileOuterClass.CreateUploadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.UpdateUploadIDResponse> updateUploadID(
        FileOuterClass.UpdateUploadIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUploadIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.GetUploadByIDResponse> getUploadByID(
        FileOuterClass.GetUploadByIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUploadByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.DeleteUploadByKeyResponse> deleteUploadByKey(
        FileOuterClass.DeleteUploadByKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteUploadByKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.DeleteUploadByIDResponse> deleteUploadByID(
        FileOuterClass.DeleteUploadByIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteUploadByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.File> getFileByID(
        FileOuterClass.GetByFileByIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFileByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.File> getFileByKey(
        FileOuterClass.GetFileByKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFileByKeyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.GetFilesByFolderResponse> getFilesByFolder(
        FileOuterClass.GetFilesByFolderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFilesByFolderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.GetDescendantsByFolderResponse> getDescendantsByFolder(
        FileOuterClass.GetDescendantsByFolderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDescendantsByFolderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.File> createFile(
        FileOuterClass.CreateFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateFileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.DeleteFileResponse> deleteFile(
        FileOuterClass.DeleteFileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.IsAllowedResponse> isAllowed(
        FileOuterClass.IsAllowedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getIsAllowedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.UpdateFilesResponse> updateFiles(
        FileOuterClass.UpdateFilesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFilesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.GetAncestorsResponse> getAncestors(
        FileOuterClass.GetAncestorsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAncestorsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.GetDescendantsByIDResponse> getDescendantsByID(
        FileOuterClass.GetDescendantsByIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDescendantsByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FileOuterClass.DeleteFileByIDResponse> deleteFileByID(
        FileOuterClass.DeleteFileByIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFileByIDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_KEY = 0;
  private static final int METHODID_CREATE_UPLOAD = 1;
  private static final int METHODID_CREATE_UPDATE = 2;
  private static final int METHODID_UPDATE_UPLOAD_ID = 3;
  private static final int METHODID_GET_UPLOAD_BY_ID = 4;
  private static final int METHODID_DELETE_UPLOAD_BY_KEY = 5;
  private static final int METHODID_DELETE_UPLOAD_BY_ID = 6;
  private static final int METHODID_GET_FILE_BY_ID = 7;
  private static final int METHODID_GET_FILE_BY_KEY = 8;
  private static final int METHODID_GET_FILES_BY_FOLDER = 9;
  private static final int METHODID_GET_DESCENDANTS_BY_FOLDER = 10;
  private static final int METHODID_CREATE_FILE = 11;
  private static final int METHODID_DELETE_FILE = 12;
  private static final int METHODID_IS_ALLOWED = 13;
  private static final int METHODID_UPDATE_FILES = 14;
  private static final int METHODID_GET_ANCESTORS = 15;
  private static final int METHODID_GET_DESCENDANTS_BY_ID = 16;
  private static final int METHODID_DELETE_FILE_BY_ID = 17;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_KEY:
          serviceImpl.generateKey((FileOuterClass.GenerateKeyRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.KeyResponse>) responseObserver);
          break;
        case METHODID_CREATE_UPLOAD:
          serviceImpl.createUpload((FileOuterClass.CreateUploadRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.CreateUploadResponse>) responseObserver);
          break;
        case METHODID_CREATE_UPDATE:
          serviceImpl.createUpdate((FileOuterClass.CreateUploadRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.CreateUploadResponse>) responseObserver);
          break;
        case METHODID_UPDATE_UPLOAD_ID:
          serviceImpl.updateUploadID((FileOuterClass.UpdateUploadIDRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.UpdateUploadIDResponse>) responseObserver);
          break;
        case METHODID_GET_UPLOAD_BY_ID:
          serviceImpl.getUploadByID((FileOuterClass.GetUploadByIDRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.GetUploadByIDResponse>) responseObserver);
          break;
        case METHODID_DELETE_UPLOAD_BY_KEY:
          serviceImpl.deleteUploadByKey((FileOuterClass.DeleteUploadByKeyRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.DeleteUploadByKeyResponse>) responseObserver);
          break;
        case METHODID_DELETE_UPLOAD_BY_ID:
          serviceImpl.deleteUploadByID((FileOuterClass.DeleteUploadByIDRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.DeleteUploadByIDResponse>) responseObserver);
          break;
        case METHODID_GET_FILE_BY_ID:
          serviceImpl.getFileByID((FileOuterClass.GetByFileByIDRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.File>) responseObserver);
          break;
        case METHODID_GET_FILE_BY_KEY:
          serviceImpl.getFileByKey((FileOuterClass.GetFileByKeyRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.File>) responseObserver);
          break;
        case METHODID_GET_FILES_BY_FOLDER:
          serviceImpl.getFilesByFolder((FileOuterClass.GetFilesByFolderRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.GetFilesByFolderResponse>) responseObserver);
          break;
        case METHODID_GET_DESCENDANTS_BY_FOLDER:
          serviceImpl.getDescendantsByFolder((FileOuterClass.GetDescendantsByFolderRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.GetDescendantsByFolderResponse>) responseObserver);
          break;
        case METHODID_CREATE_FILE:
          serviceImpl.createFile((FileOuterClass.CreateFileRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.File>) responseObserver);
          break;
        case METHODID_DELETE_FILE:
          serviceImpl.deleteFile((FileOuterClass.DeleteFileRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.DeleteFileResponse>) responseObserver);
          break;
        case METHODID_IS_ALLOWED:
          serviceImpl.isAllowed((FileOuterClass.IsAllowedRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.IsAllowedResponse>) responseObserver);
          break;
        case METHODID_UPDATE_FILES:
          serviceImpl.updateFiles((FileOuterClass.UpdateFilesRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.UpdateFilesResponse>) responseObserver);
          break;
        case METHODID_GET_ANCESTORS:
          serviceImpl.getAncestors((FileOuterClass.GetAncestorsRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.GetAncestorsResponse>) responseObserver);
          break;
        case METHODID_GET_DESCENDANTS_BY_ID:
          serviceImpl.getDescendantsByID((FileOuterClass.GetDescendantsByIDRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.GetDescendantsByIDResponse>) responseObserver);
          break;
        case METHODID_DELETE_FILE_BY_ID:
          serviceImpl.deleteFileByID((FileOuterClass.DeleteFileByIDRequest) request,
              (io.grpc.stub.StreamObserver<FileOuterClass.DeleteFileByIDResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return FileOuterClass.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileService");
    }
  }

  private static final class FileServiceFileDescriptorSupplier
      extends FileServiceBaseDescriptorSupplier {
    FileServiceFileDescriptorSupplier() {}
  }

  private static final class FileServiceMethodDescriptorSupplier
      extends FileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FileServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FileServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileServiceFileDescriptorSupplier())
              .addMethod(getGenerateKeyMethod())
              .addMethod(getCreateUploadMethod())
              .addMethod(getCreateUpdateMethod())
              .addMethod(getUpdateUploadIDMethod())
              .addMethod(getGetUploadByIDMethod())
              .addMethod(getDeleteUploadByKeyMethod())
              .addMethod(getDeleteUploadByIDMethod())
              .addMethod(getGetFileByIDMethod())
              .addMethod(getGetFileByKeyMethod())
              .addMethod(getGetFilesByFolderMethod())
              .addMethod(getGetDescendantsByFolderMethod())
              .addMethod(getCreateFileMethod())
              .addMethod(getDeleteFileMethod())
              .addMethod(getIsAllowedMethod())
              .addMethod(getUpdateFilesMethod())
              .addMethod(getGetAncestorsMethod())
              .addMethod(getGetDescendantsByIDMethod())
              .addMethod(getDeleteFileByIDMethod())
              .build();
        }
      }
    }
    return result;
  }
}
