package DriveStubs.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: permission.proto")
public final class PermissionGrpc {

  private PermissionGrpc() {}

  public static final String SERVICE_NAME = "permission.Permission";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest,
      DriveStubs.grpc.PermissionOuterClass.PermissionObject> getCreatePermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePermission",
      requestType = DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest.class,
      responseType = DriveStubs.grpc.PermissionOuterClass.PermissionObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest,
      DriveStubs.grpc.PermissionOuterClass.PermissionObject> getCreatePermissionMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest, DriveStubs.grpc.PermissionOuterClass.PermissionObject> getCreatePermissionMethod;
    if ((getCreatePermissionMethod = PermissionGrpc.getCreatePermissionMethod) == null) {
      synchronized (PermissionGrpc.class) {
        if ((getCreatePermissionMethod = PermissionGrpc.getCreatePermissionMethod) == null) {
          PermissionGrpc.getCreatePermissionMethod = getCreatePermissionMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest, DriveStubs.grpc.PermissionOuterClass.PermissionObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "permission.Permission", "CreatePermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.PermissionObject.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionMethodDescriptorSupplier("CreatePermission"))
                  .build();
          }
        }
     }
     return getCreatePermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest,
      DriveStubs.grpc.PermissionOuterClass.PermissionObject> getDeletePermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePermission",
      requestType = DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest.class,
      responseType = DriveStubs.grpc.PermissionOuterClass.PermissionObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest,
      DriveStubs.grpc.PermissionOuterClass.PermissionObject> getDeletePermissionMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest, DriveStubs.grpc.PermissionOuterClass.PermissionObject> getDeletePermissionMethod;
    if ((getDeletePermissionMethod = PermissionGrpc.getDeletePermissionMethod) == null) {
      synchronized (PermissionGrpc.class) {
        if ((getDeletePermissionMethod = PermissionGrpc.getDeletePermissionMethod) == null) {
          PermissionGrpc.getDeletePermissionMethod = getDeletePermissionMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest, DriveStubs.grpc.PermissionOuterClass.PermissionObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "permission.Permission", "DeletePermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.PermissionObject.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionMethodDescriptorSupplier("DeletePermission"))
                  .build();
          }
        }
     }
     return getDeletePermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest,
      DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse> getGetFilePermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFilePermissions",
      requestType = DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest.class,
      responseType = DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest,
      DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse> getGetFilePermissionsMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest, DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse> getGetFilePermissionsMethod;
    if ((getGetFilePermissionsMethod = PermissionGrpc.getGetFilePermissionsMethod) == null) {
      synchronized (PermissionGrpc.class) {
        if ((getGetFilePermissionsMethod = PermissionGrpc.getGetFilePermissionsMethod) == null) {
          PermissionGrpc.getGetFilePermissionsMethod = getGetFilePermissionsMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest, DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "permission.Permission", "GetFilePermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionMethodDescriptorSupplier("GetFilePermissions"))
                  .build();
          }
        }
     }
     return getGetFilePermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest,
      DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse> getGetUserPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserPermissions",
      requestType = DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest.class,
      responseType = DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest,
      DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse> getGetUserPermissionsMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest, DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse> getGetUserPermissionsMethod;
    if ((getGetUserPermissionsMethod = PermissionGrpc.getGetUserPermissionsMethod) == null) {
      synchronized (PermissionGrpc.class) {
        if ((getGetUserPermissionsMethod = PermissionGrpc.getGetUserPermissionsMethod) == null) {
          PermissionGrpc.getGetUserPermissionsMethod = getGetUserPermissionsMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest, DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "permission.Permission", "GetUserPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionMethodDescriptorSupplier("GetUserPermissions"))
                  .build();
          }
        }
     }
     return getGetUserPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest,
      DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse> getIsPermittedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsPermitted",
      requestType = DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest.class,
      responseType = DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest,
      DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse> getIsPermittedMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest, DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse> getIsPermittedMethod;
    if ((getIsPermittedMethod = PermissionGrpc.getIsPermittedMethod) == null) {
      synchronized (PermissionGrpc.class) {
        if ((getIsPermittedMethod = PermissionGrpc.getIsPermittedMethod) == null) {
          PermissionGrpc.getIsPermittedMethod = getIsPermittedMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest, DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "permission.Permission", "IsPermitted"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionMethodDescriptorSupplier("IsPermitted"))
                  .build();
          }
        }
     }
     return getIsPermittedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest,
      DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse> getDeleteFilePermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFilePermissions",
      requestType = DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest.class,
      responseType = DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest,
      DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse> getDeleteFilePermissionsMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest, DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse> getDeleteFilePermissionsMethod;
    if ((getDeleteFilePermissionsMethod = PermissionGrpc.getDeleteFilePermissionsMethod) == null) {
      synchronized (PermissionGrpc.class) {
        if ((getDeleteFilePermissionsMethod = PermissionGrpc.getDeleteFilePermissionsMethod) == null) {
          PermissionGrpc.getDeleteFilePermissionsMethod = getDeleteFilePermissionsMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest, DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "permission.Permission", "DeleteFilePermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionMethodDescriptorSupplier("DeleteFilePermissions"))
                  .build();
          }
        }
     }
     return getDeleteFilePermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest,
      DriveStubs.grpc.PermissionOuterClass.PermissionObject> getGetPermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPermission",
      requestType = DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest.class,
      responseType = DriveStubs.grpc.PermissionOuterClass.PermissionObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest,
      DriveStubs.grpc.PermissionOuterClass.PermissionObject> getGetPermissionMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest, DriveStubs.grpc.PermissionOuterClass.PermissionObject> getGetPermissionMethod;
    if ((getGetPermissionMethod = PermissionGrpc.getGetPermissionMethod) == null) {
      synchronized (PermissionGrpc.class) {
        if ((getGetPermissionMethod = PermissionGrpc.getGetPermissionMethod) == null) {
          PermissionGrpc.getGetPermissionMethod = getGetPermissionMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest, DriveStubs.grpc.PermissionOuterClass.PermissionObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "permission.Permission", "GetPermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.PermissionObject.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionMethodDescriptorSupplier("GetPermission"))
                  .build();
          }
        }
     }
     return getGetPermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest,
      DriveStubs.grpc.PermissionOuterClass.PermissionObject> getGetPermissionByMongoIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPermissionByMongoID",
      requestType = DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest.class,
      responseType = DriveStubs.grpc.PermissionOuterClass.PermissionObject.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest,
      DriveStubs.grpc.PermissionOuterClass.PermissionObject> getGetPermissionByMongoIDMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest, DriveStubs.grpc.PermissionOuterClass.PermissionObject> getGetPermissionByMongoIDMethod;
    if ((getGetPermissionByMongoIDMethod = PermissionGrpc.getGetPermissionByMongoIDMethod) == null) {
      synchronized (PermissionGrpc.class) {
        if ((getGetPermissionByMongoIDMethod = PermissionGrpc.getGetPermissionByMongoIDMethod) == null) {
          PermissionGrpc.getGetPermissionByMongoIDMethod = getGetPermissionByMongoIDMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest, DriveStubs.grpc.PermissionOuterClass.PermissionObject>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "permission.Permission", "GetPermissionByMongoID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.PermissionOuterClass.PermissionObject.getDefaultInstance()))
                  .setSchemaDescriptor(new PermissionMethodDescriptorSupplier("GetPermissionByMongoID"))
                  .build();
          }
        }
     }
     return getGetPermissionByMongoIDMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PermissionStub newStub(io.grpc.Channel channel) {
    return new PermissionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PermissionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PermissionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PermissionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PermissionFutureStub(channel);
  }

  /**
   */
  public static abstract class PermissionImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * CreatePermission creates a new permission and returns it, if permission already exists, update it.
     * </pre>
     */
    public void createPermission(DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject> responseObserver) {
      asyncUnimplementedUnaryCall(getCreatePermissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * DeletePermission deletes a permission and returns it.
     * </pre>
     */
    public void deletePermission(DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject> responseObserver) {
      asyncUnimplementedUnaryCall(getDeletePermissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetFilePermissions returns the users and their role that have a permission to fileID.
     * </pre>
     */
    public void getFilePermissions(DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFilePermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetUserPermissions returns the files that the user was given permission to.
     * </pre>
     */
    public void getUserPermissions(DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserPermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * IsPermitted returns true if userID is permitted to a fileID with the wanted role.
     * </pre>
     */
    public void isPermitted(DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIsPermittedMethod(), responseObserver);
    }

    /**
     * <pre>
     * DeleteFilePermissions deletes all permissions of a file and returns them.
     * </pre>
     */
    public void deleteFilePermissions(DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFilePermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetPermission returns a permission of the user to a file.
     * </pre>
     */
    public void getPermission(DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPermissionMethod(), responseObserver);
    }

    /**
     */
    public void getPermissionByMongoID(DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPermissionByMongoIDMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreatePermissionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest,
                DriveStubs.grpc.PermissionOuterClass.PermissionObject>(
                  this, METHODID_CREATE_PERMISSION)))
          .addMethod(
            getDeletePermissionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest,
                DriveStubs.grpc.PermissionOuterClass.PermissionObject>(
                  this, METHODID_DELETE_PERMISSION)))
          .addMethod(
            getGetFilePermissionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest,
                DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse>(
                  this, METHODID_GET_FILE_PERMISSIONS)))
          .addMethod(
            getGetUserPermissionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest,
                DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse>(
                  this, METHODID_GET_USER_PERMISSIONS)))
          .addMethod(
            getIsPermittedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest,
                DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse>(
                  this, METHODID_IS_PERMITTED)))
          .addMethod(
            getDeleteFilePermissionsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest,
                DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse>(
                  this, METHODID_DELETE_FILE_PERMISSIONS)))
          .addMethod(
            getGetPermissionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest,
                DriveStubs.grpc.PermissionOuterClass.PermissionObject>(
                  this, METHODID_GET_PERMISSION)))
          .addMethod(
            getGetPermissionByMongoIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest,
                DriveStubs.grpc.PermissionOuterClass.PermissionObject>(
                  this, METHODID_GET_PERMISSION_BY_MONGO_ID)))
          .build();
    }
  }

  /**
   */
  public static final class PermissionStub extends io.grpc.stub.AbstractStub<PermissionStub> {
    private PermissionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PermissionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PermissionStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreatePermission creates a new permission and returns it, if permission already exists, update it.
     * </pre>
     */
    public void createPermission(DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreatePermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * DeletePermission deletes a permission and returns it.
     * </pre>
     */
    public void deletePermission(DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeletePermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetFilePermissions returns the users and their role that have a permission to fileID.
     * </pre>
     */
    public void getFilePermissions(DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFilePermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetUserPermissions returns the files that the user was given permission to.
     * </pre>
     */
    public void getUserPermissions(DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserPermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * IsPermitted returns true if userID is permitted to a fileID with the wanted role.
     * </pre>
     */
    public void isPermitted(DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsPermittedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * DeleteFilePermissions deletes all permissions of a file and returns them.
     * </pre>
     */
    public void deleteFilePermissions(DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFilePermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetPermission returns a permission of the user to a file.
     * </pre>
     */
    public void getPermission(DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPermissionByMongoID(DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPermissionByMongoIDMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PermissionBlockingStub extends io.grpc.stub.AbstractStub<PermissionBlockingStub> {
    private PermissionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PermissionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PermissionBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreatePermission creates a new permission and returns it, if permission already exists, update it.
     * </pre>
     */
    public DriveStubs.grpc.PermissionOuterClass.PermissionObject createPermission(DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreatePermissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * DeletePermission deletes a permission and returns it.
     * </pre>
     */
    public DriveStubs.grpc.PermissionOuterClass.PermissionObject deletePermission(DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeletePermissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetFilePermissions returns the users and their role that have a permission to fileID.
     * </pre>
     */
    public DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse getFilePermissions(DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFilePermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetUserPermissions returns the files that the user was given permission to.
     * </pre>
     */
    public DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse getUserPermissions(DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserPermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * IsPermitted returns true if userID is permitted to a fileID with the wanted role.
     * </pre>
     */
    public DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse isPermitted(DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest request) {
      return blockingUnaryCall(
          getChannel(), getIsPermittedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * DeleteFilePermissions deletes all permissions of a file and returns them.
     * </pre>
     */
    public DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse deleteFilePermissions(DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFilePermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetPermission returns a permission of the user to a file.
     * </pre>
     */
    public DriveStubs.grpc.PermissionOuterClass.PermissionObject getPermission(DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPermissionMethod(), getCallOptions(), request);
    }

    /**
     */
    public DriveStubs.grpc.PermissionOuterClass.PermissionObject getPermissionByMongoID(DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPermissionByMongoIDMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PermissionFutureStub extends io.grpc.stub.AbstractStub<PermissionFutureStub> {
    private PermissionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PermissionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PermissionFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreatePermission creates a new permission and returns it, if permission already exists, update it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.PermissionOuterClass.PermissionObject> createPermission(
        DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreatePermissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * DeletePermission deletes a permission and returns it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.PermissionOuterClass.PermissionObject> deletePermission(
        DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeletePermissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetFilePermissions returns the users and their role that have a permission to fileID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse> getFilePermissions(
        DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFilePermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetUserPermissions returns the files that the user was given permission to.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse> getUserPermissions(
        DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserPermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * IsPermitted returns true if userID is permitted to a fileID with the wanted role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse> isPermitted(
        DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getIsPermittedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * DeleteFilePermissions deletes all permissions of a file and returns them.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse> deleteFilePermissions(
        DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFilePermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetPermission returns a permission of the user to a file.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.PermissionOuterClass.PermissionObject> getPermission(
        DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPermissionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.PermissionOuterClass.PermissionObject> getPermissionByMongoID(
        DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPermissionByMongoIDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PERMISSION = 0;
  private static final int METHODID_DELETE_PERMISSION = 1;
  private static final int METHODID_GET_FILE_PERMISSIONS = 2;
  private static final int METHODID_GET_USER_PERMISSIONS = 3;
  private static final int METHODID_IS_PERMITTED = 4;
  private static final int METHODID_DELETE_FILE_PERMISSIONS = 5;
  private static final int METHODID_GET_PERMISSION = 6;
  private static final int METHODID_GET_PERMISSION_BY_MONGO_ID = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PermissionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PermissionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PERMISSION:
          serviceImpl.createPermission((DriveStubs.grpc.PermissionOuterClass.CreatePermissionRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject>) responseObserver);
          break;
        case METHODID_DELETE_PERMISSION:
          serviceImpl.deletePermission((DriveStubs.grpc.PermissionOuterClass.DeletePermissionRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject>) responseObserver);
          break;
        case METHODID_GET_FILE_PERMISSIONS:
          serviceImpl.getFilePermissions((DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.GetFilePermissionsResponse>) responseObserver);
          break;
        case METHODID_GET_USER_PERMISSIONS:
          serviceImpl.getUserPermissions((DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.GetUserPermissionsResponse>) responseObserver);
          break;
        case METHODID_IS_PERMITTED:
          serviceImpl.isPermitted((DriveStubs.grpc.PermissionOuterClass.IsPermittedRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.IsPermittedResponse>) responseObserver);
          break;
        case METHODID_DELETE_FILE_PERMISSIONS:
          serviceImpl.deleteFilePermissions((DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.DeleteFilePermissionsResponse>) responseObserver);
          break;
        case METHODID_GET_PERMISSION:
          serviceImpl.getPermission((DriveStubs.grpc.PermissionOuterClass.GetPermissionRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject>) responseObserver);
          break;
        case METHODID_GET_PERMISSION_BY_MONGO_ID:
          serviceImpl.getPermissionByMongoID((DriveStubs.grpc.PermissionOuterClass.GetPermissionByMongoIDRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.PermissionOuterClass.PermissionObject>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PermissionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PermissionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DriveStubs.grpc.PermissionOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Permission");
    }
  }

  private static final class PermissionFileDescriptorSupplier
      extends PermissionBaseDescriptorSupplier {
    PermissionFileDescriptorSupplier() {}
  }

  private static final class PermissionMethodDescriptorSupplier
      extends PermissionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PermissionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PermissionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PermissionFileDescriptorSupplier())
              .addMethod(getCreatePermissionMethod())
              .addMethod(getDeletePermissionMethod())
              .addMethod(getGetFilePermissionsMethod())
              .addMethod(getGetUserPermissionsMethod())
              .addMethod(getIsPermittedMethod())
              .addMethod(getDeleteFilePermissionsMethod())
              .addMethod(getGetPermissionMethod())
              .addMethod(getGetPermissionByMongoIDMethod())
              .build();
        }
      }
    }
    return result;
  }
}
