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
    comments = "Source: users.proto")
public final class UsersGrpc {

  private UsersGrpc() {}

  public static final String SERVICE_NAME = "users.Users";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetByMailRequest,
      DriveStubs.grpc.UsersOuterClass.GetUserResponse> getGetUserByMailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserByMail",
      requestType = DriveStubs.grpc.UsersOuterClass.GetByMailRequest.class,
      responseType = DriveStubs.grpc.UsersOuterClass.GetUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetByMailRequest,
      DriveStubs.grpc.UsersOuterClass.GetUserResponse> getGetUserByMailMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetByMailRequest, DriveStubs.grpc.UsersOuterClass.GetUserResponse> getGetUserByMailMethod;
    if ((getGetUserByMailMethod = UsersGrpc.getGetUserByMailMethod) == null) {
      synchronized (UsersGrpc.class) {
        if ((getGetUserByMailMethod = UsersGrpc.getGetUserByMailMethod) == null) {
          UsersGrpc.getGetUserByMailMethod = getGetUserByMailMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.UsersOuterClass.GetByMailRequest, DriveStubs.grpc.UsersOuterClass.GetUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "users.Users", "GetUserByMail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.UsersOuterClass.GetByMailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.UsersOuterClass.GetUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UsersMethodDescriptorSupplier("GetUserByMail"))
                  .build();
          }
        }
     }
     return getGetUserByMailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetByIDRequest,
      DriveStubs.grpc.UsersOuterClass.GetUserResponse> getGetUserByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserByID",
      requestType = DriveStubs.grpc.UsersOuterClass.GetByIDRequest.class,
      responseType = DriveStubs.grpc.UsersOuterClass.GetUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetByIDRequest,
      DriveStubs.grpc.UsersOuterClass.GetUserResponse> getGetUserByIDMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetByIDRequest, DriveStubs.grpc.UsersOuterClass.GetUserResponse> getGetUserByIDMethod;
    if ((getGetUserByIDMethod = UsersGrpc.getGetUserByIDMethod) == null) {
      synchronized (UsersGrpc.class) {
        if ((getGetUserByIDMethod = UsersGrpc.getGetUserByIDMethod) == null) {
          UsersGrpc.getGetUserByIDMethod = getGetUserByIDMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.UsersOuterClass.GetByIDRequest, DriveStubs.grpc.UsersOuterClass.GetUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "users.Users", "GetUserByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.UsersOuterClass.GetByIDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.UsersOuterClass.GetUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UsersMethodDescriptorSupplier("GetUserByID"))
                  .build();
          }
        }
     }
     return getGetUserByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest,
      DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse> getFindUserByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindUserByName",
      requestType = DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest.class,
      responseType = DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest,
      DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse> getFindUserByNameMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest, DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse> getFindUserByNameMethod;
    if ((getFindUserByNameMethod = UsersGrpc.getFindUserByNameMethod) == null) {
      synchronized (UsersGrpc.class) {
        if ((getFindUserByNameMethod = UsersGrpc.getFindUserByNameMethod) == null) {
          UsersGrpc.getFindUserByNameMethod = getFindUserByNameMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest, DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "users.Users", "FindUserByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UsersMethodDescriptorSupplier("FindUserByName"))
                  .build();
          }
        }
     }
     return getFindUserByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest,
      DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse> getGetApproverInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApproverInfo",
      requestType = DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest.class,
      responseType = DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest,
      DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse> getGetApproverInfoMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest, DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse> getGetApproverInfoMethod;
    if ((getGetApproverInfoMethod = UsersGrpc.getGetApproverInfoMethod) == null) {
      synchronized (UsersGrpc.class) {
        if ((getGetApproverInfoMethod = UsersGrpc.getGetApproverInfoMethod) == null) {
          UsersGrpc.getGetApproverInfoMethod = getGetApproverInfoMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest, DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "users.Users", "GetApproverInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UsersMethodDescriptorSupplier("GetApproverInfo"))
                  .build();
          }
        }
     }
     return getGetApproverInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UsersStub newStub(io.grpc.Channel channel) {
    return new UsersStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UsersBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UsersBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UsersFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UsersFutureStub(channel);
  }

  /**
   */
  public static abstract class UsersImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserByMail(DriveStubs.grpc.UsersOuterClass.GetByMailRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserByMailMethod(), responseObserver);
    }

    /**
     */
    public void getUserByID(DriveStubs.grpc.UsersOuterClass.GetByIDRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserByIDMethod(), responseObserver);
    }

    /**
     */
    public void findUserByName(DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindUserByNameMethod(), responseObserver);
    }

    /**
     */
    public void getApproverInfo(DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetApproverInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserByMailMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.UsersOuterClass.GetByMailRequest,
                DriveStubs.grpc.UsersOuterClass.GetUserResponse>(
                  this, METHODID_GET_USER_BY_MAIL)))
          .addMethod(
            getGetUserByIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.UsersOuterClass.GetByIDRequest,
                DriveStubs.grpc.UsersOuterClass.GetUserResponse>(
                  this, METHODID_GET_USER_BY_ID)))
          .addMethod(
            getFindUserByNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest,
                DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse>(
                  this, METHODID_FIND_USER_BY_NAME)))
          .addMethod(
            getGetApproverInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest,
                DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse>(
                  this, METHODID_GET_APPROVER_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class UsersStub extends io.grpc.stub.AbstractStub<UsersStub> {
    private UsersStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsersStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsersStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsersStub(channel, callOptions);
    }

    /**
     */
    public void getUserByMail(DriveStubs.grpc.UsersOuterClass.GetByMailRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserByMailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserByID(DriveStubs.grpc.UsersOuterClass.GetByIDRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findUserByName(DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindUserByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getApproverInfo(DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetApproverInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UsersBlockingStub extends io.grpc.stub.AbstractStub<UsersBlockingStub> {
    private UsersBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsersBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsersBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsersBlockingStub(channel, callOptions);
    }

    /**
     */
    public DriveStubs.grpc.UsersOuterClass.GetUserResponse getUserByMail(DriveStubs.grpc.UsersOuterClass.GetByMailRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserByMailMethod(), getCallOptions(), request);
    }

    /**
     */
    public DriveStubs.grpc.UsersOuterClass.GetUserResponse getUserByID(DriveStubs.grpc.UsersOuterClass.GetByIDRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserByIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse findUserByName(DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindUserByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse getApproverInfo(DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetApproverInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UsersFutureStub extends io.grpc.stub.AbstractStub<UsersFutureStub> {
    private UsersFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsersFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsersFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsersFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.UsersOuterClass.GetUserResponse> getUserByMail(
        DriveStubs.grpc.UsersOuterClass.GetByMailRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserByMailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.UsersOuterClass.GetUserResponse> getUserByID(
        DriveStubs.grpc.UsersOuterClass.GetByIDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserByIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse> findUserByName(
        DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindUserByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse> getApproverInfo(
        DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetApproverInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_BY_MAIL = 0;
  private static final int METHODID_GET_USER_BY_ID = 1;
  private static final int METHODID_FIND_USER_BY_NAME = 2;
  private static final int METHODID_GET_APPROVER_INFO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UsersImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UsersImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_BY_MAIL:
          serviceImpl.getUserByMail((DriveStubs.grpc.UsersOuterClass.GetByMailRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetUserResponse>) responseObserver);
          break;
        case METHODID_GET_USER_BY_ID:
          serviceImpl.getUserByID((DriveStubs.grpc.UsersOuterClass.GetByIDRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetUserResponse>) responseObserver);
          break;
        case METHODID_FIND_USER_BY_NAME:
          serviceImpl.findUserByName((DriveStubs.grpc.UsersOuterClass.FindUserByNameRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.FindUserByNameResponse>) responseObserver);
          break;
        case METHODID_GET_APPROVER_INFO:
          serviceImpl.getApproverInfo((DriveStubs.grpc.UsersOuterClass.GetApproverInfoRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.UsersOuterClass.GetApproverInfoResponse>) responseObserver);
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

  private static abstract class UsersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UsersBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DriveStubs.grpc.UsersOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Users");
    }
  }

  private static final class UsersFileDescriptorSupplier
      extends UsersBaseDescriptorSupplier {
    UsersFileDescriptorSupplier() {}
  }

  private static final class UsersMethodDescriptorSupplier
      extends UsersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UsersMethodDescriptorSupplier(String methodName) {
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
      synchronized (UsersGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UsersFileDescriptorSupplier())
              .addMethod(getGetUserByMailMethod())
              .addMethod(getGetUserByIDMethod())
              .addMethod(getFindUserByNameMethod())
              .addMethod(getGetApproverInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
