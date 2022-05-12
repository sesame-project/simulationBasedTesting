/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import simlog.server.PubRequest;
import simlog.server.ROSMessage;
import simlog.server.SimlogAPIGrpc;
import simlog.server.TopicDescriptor;

/**
 *
 * @author rovere
 */
public class GrpcClient {

    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    private final SimlogAPIGrpc.SimlogAPIBlockingStub blockingStub;
    private final SimlogAPIGrpc.SimlogAPIStub asyncStub;

    private StreamObserver<PubRequest> publisher;

    /**
     * Construct client for accessing RouteGuide server using the existing
     * channel.
     */
    public GrpcClient(Channel channel) {
        blockingStub = SimlogAPIGrpc.newBlockingStub(channel);
        asyncStub = SimlogAPIGrpc.newStub(channel);
    }

    /**
     * Blocking unary call example. Calls getFeature and prints the response.
     */
    public void subscribe(String path) {
        TopicDescriptor request = TopicDescriptor.newBuilder().setPath(path).build();
        try {
            ROSObserver ro = new ROSObserver(path);
            asyncStub.subscribe(request, ro);
        } catch (StatusRuntimeException e) {
            warning("RPC failed: {0}", e.getStatus());
            return;
        }
    }

    public void publish(String path, double value) {
        if (publisher == null) {
            publisher = asyncStub.publish(new StreamObserver<Empty>() {

                @Override
                public void onNext(Empty v) {
                }

                @Override
                public void onError(Throwable thrwbl) {
                }

                @Override
                public void onCompleted() {
                }
            });
        }
        TopicDescriptor td = TopicDescriptor.newBuilder().setMsgType("double").setPath(path).build();
        ROSMessage m = ROSMessage.newBuilder().setType("double").setValue(String.valueOf(value)).build();
        PubRequest pr = PubRequest.newBuilder().setTopic(td).setData(m).build();
        publisher.onNext(pr);

    }

    /**
     * Issues several different requests and then exits.
     */
    public static void main(String[] args) throws InterruptedException {
        String target = "localhost:8089";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        System.out.println("Created channel");
        try {
            System.out.println("Creating client");
            GrpcClient client = new GrpcClient(channel);
            // Looking for a valid feature
            System.out.println("Subscribing");
           
            client.subscribe("joints/R3200/Link1/R/position");
            client.subscribe("joints/R3200/Link2/R/position");
            client.subscribe("joints/Lumpa/Link3/R/position");
            //Thread.sleep(1000);
//            new Thread(() -> {
                for (int i = 0; i < 90 * 50; i++) {
                    double v = Math.toRadians(i * 0.1);
                    client.publish("joints/R3200/Link1/R/position", v);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GrpcClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
//            }).start();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    private void info(String msg, Object... params) {
        logger.log(Level.INFO, msg, params);
    }

    private void warning(String msg, Object... params) {
        logger.log(Level.WARNING, msg, params);
    }

    private static class ROSObserver implements StreamObserver<ROSMessage> {

        private String path;

        public ROSObserver(String p) {
            this.path = p;
        }

        @Override
        public void onNext(ROSMessage m) {
            System.out.println(path + ":message received value=" + m.getValue());
        }

        @Override
        public void onError(Throwable t) {
            System.err.println(path + ":failed: " + Status.fromThrowable(t));
        }

        @Override
        public void onCompleted() {
            System.out.println(path + ":finished");
        }
    }

}
