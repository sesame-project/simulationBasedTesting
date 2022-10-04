package uk.ac.york.sesame.testing.architecture.tts;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.Empty;

import simlog.server.InjectRequest;
import simlog.server.PubRequest;
import simlog.server.ROSMessage;
import simlog.server.SimlogAPIGrpc;
import simlog.server.TopicDescriptor;

public class SimMain_v4 {

    private final SimlogAPIGrpc.SimlogAPIBlockingStub blockingStub;
    private final SimlogAPIGrpc.SimlogAPIStub asyncStub;

    private static final Logger logger = Logger.getLogger(SimMain_v4.class.getName());
    
    private StreamObserver<PubRequest> publisher;

    /**
     * Construct client for accessing RouteGuide server using the existing
     * channel.
     */
    public SimMain_v4(Channel channel) {
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

    public void inject(String injected, String target) {
        TopicDescriptor injTopic = TopicDescriptor.newBuilder().setPath(injected).build();
        TopicDescriptor tarTopic = TopicDescriptor.newBuilder().setPath(target).build();
        InjectRequest requ = InjectRequest.newBuilder().setInjected(injTopic).setTarget(tarTopic).build();
        try {
            // inject service requires and instance of observer which is added to the
            // shadowed topic
            ROSObserver ro = new ROSObserver(target);
            asyncStub.inject(requ, ro);
        } catch (StatusRuntimeException e) {
            warning("RPC failed: {0}", e.getStatus());
            return;
        }
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
            SimMain_v4 client = new SimMain_v4(channel);
            System.out.println("Subscribing");
            client.subscribe("joints/R3200/Link1/R/position/out");
//            client.subscribe("model/clock");
            Thread.sleep(1000);
            System.out.println("== Injecting ==");
            client.inject("joints/R3200/Link1/R/position/shadow", "joints/R3200/Link1/R/position/in");
            for (int i = 0; i < 200; i++) {
                double v = Math.toRadians(i * 0.1);
                // Write on shadow - receive on /out
                client.publish("joints/R3200/Link1/R/position/shadow", v);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SimMain_v4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

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
            System.out.println(path + ":message received=" + m.toString());
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
