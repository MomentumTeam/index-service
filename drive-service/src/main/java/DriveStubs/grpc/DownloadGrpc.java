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
 * <pre>
 * Interface exported by the server
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: download_service.proto")
public final class DownloadGrpc {

  private DownloadGrpc() {}

  public static final String SERVICE_NAME = "download.Download";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<DriveStubs.grpc.DownloadService.DownloadRequest,
      DriveStubs.grpc.DownloadService.DownloadResponse> getDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Download",
      requestType = DriveStubs.grpc.DownloadService.DownloadRequest.class,
      responseType = DriveStubs.grpc.DownloadService.DownloadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<DriveStubs.grpc.DownloadService.DownloadRequest,
      DriveStubs.grpc.DownloadService.DownloadResponse> getDownloadMethod() {
    io.grpc.MethodDescriptor<DriveStubs.grpc.DownloadService.DownloadRequest, DriveStubs.grpc.DownloadService.DownloadResponse> getDownloadMethod;
    if ((getDownloadMethod = DownloadGrpc.getDownloadMethod) == null) {
      synchronized (DownloadGrpc.class) {
        if ((getDownloadMethod = DownloadGrpc.getDownloadMethod) == null) {
          DownloadGrpc.getDownloadMethod = getDownloadMethod = 
              io.grpc.MethodDescriptor.<DriveStubs.grpc.DownloadService.DownloadRequest, DriveStubs.grpc.DownloadService.DownloadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "download.Download", "Download"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.DownloadService.DownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DriveStubs.grpc.DownloadService.DownloadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DownloadMethodDescriptorSupplier("Download"))
                  .build();
          }
        }
     }
     return getDownloadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DownloadStub newStub(io.grpc.Channel channel) {
    return new DownloadStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DownloadBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DownloadBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DownloadFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DownloadFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server
   * </pre>
   */
  public static abstract class DownloadImplBase implements io.grpc.BindableService {

    /**
     */
    public void download(DriveStubs.grpc.DownloadService.DownloadRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.DownloadService.DownloadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDownloadMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDownloadMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                DriveStubs.grpc.DownloadService.DownloadRequest,
                DriveStubs.grpc.DownloadService.DownloadResponse>(
                  this, METHODID_DOWNLOAD)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server
   * </pre>
   */
  public static final class DownloadStub extends io.grpc.stub.AbstractStub<DownloadStub> {
    private DownloadStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DownloadStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DownloadStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DownloadStub(channel, callOptions);
    }

    /**
     */
    public void download(DriveStubs.grpc.DownloadService.DownloadRequest request,
        io.grpc.stub.StreamObserver<DriveStubs.grpc.DownloadService.DownloadResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server
   * </pre>
   */
  public static final class DownloadBlockingStub extends io.grpc.stub.AbstractStub<DownloadBlockingStub> {
    private DownloadBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DownloadBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DownloadBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DownloadBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<DriveStubs.grpc.DownloadService.DownloadResponse> download(
        DriveStubs.grpc.DownloadService.DownloadRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getDownloadMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server
   * </pre>
   */
  public static final class DownloadFutureStub extends io.grpc.stub.AbstractStub<DownloadFutureStub> {
    private DownloadFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DownloadFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DownloadFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DownloadFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DOWNLOAD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DownloadImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DownloadImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DOWNLOAD:
          serviceImpl.download((DriveStubs.grpc.DownloadService.DownloadRequest) request,
              (io.grpc.stub.StreamObserver<DriveStubs.grpc.DownloadService.DownloadResponse>) responseObserver);
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

  private static abstract class DownloadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DownloadBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DriveStubs.grpc.DownloadService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Download");
    }
  }

  private static final class DownloadFileDescriptorSupplier
      extends DownloadBaseDescriptorSupplier {
    DownloadFileDescriptorSupplier() {}
  }

  private static final class DownloadMethodDescriptorSupplier
      extends DownloadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DownloadMethodDescriptorSupplier(String methodName) {
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
      synchronized (DownloadGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DownloadFileDescriptorSupplier())
              .addMethod(getDownloadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
