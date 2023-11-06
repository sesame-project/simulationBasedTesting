/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.york.sesame.testing.architecture.tts;

import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import com.ttsnetwork.simlog.InjectRequest;
import com.ttsnetwork.simlog.InjectResponse;
import com.ttsnetwork.simlog.PubRequest;
import com.ttsnetwork.simlog.SimlogAPIGrpc;
import com.ttsnetwork.simlog.SimlogMessage;
import com.ttsnetwork.simlog.Subscriber;
import com.ttsnetwork.simlog.SubscriptionRequest;
import com.ttsnetwork.simlog.TopicInfo;
import com.ttsnetwork.simlog.TopicInfoRequest;
import com.ttsnetwork.simlog.ValueType;
import static com.ttsnetwork.simlog.ValueType.BOOL;
import static com.ttsnetwork.simlog.ValueType.NUMBER;
import static com.ttsnetwork.simlog.ValueType.STRING;
//import com.ttsnetwork.simlogdatasource.SimlogStepTopic;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 *
 * @author rovere
 */
public class SimlogClient {

    private SimlogAPIGrpc.SimlogAPIBlockingStub blockingStub;
    private SimlogAPIGrpc.SimlogAPIStub asynchStub;
    private static SimPathTranslator pathTranslator = new SimPathTranslator();  

    private volatile TDO sub;

    private String uuid;

    private static class EO implements StreamObserver<Empty> {

        @Override
        public void onNext(Empty v) {
        }

        @Override
        public void onError(Throwable thrwbl) {
            thrwbl.printStackTrace();
        }

        @Override
        public void onCompleted() {
        }
    };

    StreamObserver<PubRequest> pubChannel;

    public SimlogClient() {
        String target = "localhost:8090";
        uuid = UUID.randomUUID().toString();
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).idleTimeout(1, TimeUnit.MINUTES).usePlaintext().build();
        this.blockingStub = SimlogAPIGrpc.newBlockingStub(channel).withWaitForReady();
        this.asynchStub = SimlogAPIGrpc.newStub(channel).withWaitForReady();
        Subscriber s = Subscriber.newBuilder().setName("Trial").setUuid(uuid).build();
        sub = new TDO();
        this.asynchStub.createSubscriber(s, sub);
        this.pubChannel = asynchStub.publish(new EO());
    }
    
    void queryTopic(String topic) {
        TopicInfoRequest r = TopicInfoRequest.newBuilder()
                .setPath(topic)
                .build();
        TopicInfo info = blockingStub.getTopicInfo(r);
        System.out.println("Topic: " + info.getPath());
        System.out.println("Exists: " + info.getExists());
        System.out.println("Type: " + info.getType());
        System.out.println("Direction: " + info.getDirection());
    }

    void subscribe(String topic) {
        try {
            System.out.println("Subscribing to " + topic);
            SubscriptionRequest td = SubscriptionRequest
                    .newBuilder()
                    .setPath(topic)
                    .setSubscriberUUID(uuid)
                    .build();
//            asynchStub.subscribe(td, new EO());
            blockingStub.subscribe(td);
        } catch (Throwable ex) {
            System.out.println("Message: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    void publish(String topic, double value) {
        SimlogMessage msg = SimlogMessage.newBuilder()
                .setValue(Value.newBuilder().setNumberValue(value).build())
                .setType(ValueType.NUMBER)
                .build();
        PubRequest r = PubRequest
                .newBuilder()
                .setTopic(topic)
                .setData(msg)
                .build();
        pubChannel.onNext(r);

    }

    void publishSynch(String topic, double value) {
        SimlogMessage msg = SimlogMessage.newBuilder()
                .setValue(Value.newBuilder().setNumberValue(value).build())
                .setType(ValueType.NUMBER)
                .build();
        PubRequest r = PubRequest
                .newBuilder()
                .setTopic(topic)
                .setData(msg)
                .build();
        blockingStub.write(r);
    }

    private static class TDO implements StreamObserver<SimlogMessage> {

        private volatile List<String> lines = new ArrayList<>();
        
        private CountDownLatch cl;

        Map<String, Injector> injectors = new HashMap<>();

        public TDO() {
        }
        
        void setSemaphor(CountDownLatch cl){
            this.cl = cl;
        }

        private String toString(Timestamp ts) {
            return String.format("%6d:%03d", ts.getSeconds(), ts.getNanos()/1000000);
        }

        private String toString(ValueType t, Value v) {
            switch (t) {
                case BOOL:
                    return "" + v.getBoolValue();
                case NUMBER:
                    return "" + v.getNumberValue();
                case STRING:
                    return "" + v.getStringValue();
            }
            return "UNDEFINED";
        }

        @Override
        public void onNext(SimlogMessage m) {
            if (injectors.containsKey(m.getHeader().getPath())) {
                injectors.get(m.getHeader().getPath()).onNext(m);
            }
            String fixedStepTopic = pathTranslator.getStepTopicName();
            if (fixedStepTopic.equals(m.getHeader().getPath())) {
                lines.add("----------  Step " + (int) m.getValue().getNumberValue() + " ----------");
                cl.countDown();
            } else {
                lines.add(String.format("%s\t%s\t%s",
                        m.getHeader().getPath(),
                        toString(m.getHeader().getTimestamp()),
                        toString(m.getType(), m.getValue())
                ));
            }
        }

        public void notifyInjectors() {
            injectors.values().forEach(Injector::resend);
        }

        @Override
        public void onError(Throwable t) {
            System.err.println("Beddamatre " + t);
        }

        @Override
        public void onCompleted() {
            System.out.println(":finished");
        }
    }

    public void injectOnNumber(String topicTarget, String prefix, Function<Number, Number> transfer) {
        InjectRequest req = InjectRequest
                .newBuilder()
                .setTargetPath(topicTarget)
                .setShadowPathPrefix(prefix)
                .build();
        InjectResponse rsp = blockingStub.inject(req);
        Injector i = new Injector(rsp.getShadowPathIn(), transfer);
        sub.injectors.put(rsp.getShadowPathOut(), i);
        subscribe(rsp.getShadowPathOut());
    }

    public static void main(String[] a) throws InterruptedException, IOException {
        SimlogClient c = new SimlogClient();
        String fixedStepTopic = pathTranslator.getStepTopicName();
        Thread.sleep(1000);
        c.queryTopic("SIM://joints/Kuka.j1/R/out");
        System.out.println("===============================");
        c.queryTopic("SIM://joints/Kuka.j1/R/in");
        System.out.println("===============================");
        c.queryTopic("SIM://joints/Kuka.pippo");
        System.out.println("===============================");
        c.queryTopic(fixedStepTopic);
        System.out.println("===============================");
        c.subscribe("SIM://KukaTask/j2command");
        c.subscribe("SIM://joints/Kuka.j1/R/out");
        c.subscribe("SIM://joints/Kuka.j2/R/out");
        c.subscribe(fixedStepTopic);
        c.injectOnNumber("SIM://joints/Kuka.j1/R/in", "KukaTask/j1Shadow", v -> 50 * v.doubleValue());
        c.injectOnNumber("SIM://joints/Kuka.j2/R/in", "KukaTask/j2Shadow", v -> -1.5 * v.doubleValue());
        c.injectOnNumber("SIM://joints/R3.L2/R/in", "Column/J3", v -> 2.0 * v.doubleValue());

        Thread.sleep(1000);
        GRPCController sim = new GRPCController();
        for (int i = 0; i < 50; i++) {
            CountDownLatch cl = new CountDownLatch(1);
            c.sub.setSemaphor(cl);
            c.publish("SIM://joints/R3.L2/R/in", (float) Math.toRadians(i * 90.0 / 100.0));
            c.sub.notifyInjectors();
            System.out.println("Stepping");
            sim.step();
            cl.await();
//          Thread.sleep(100);
        }
//        Thread.sleep(120000);
        Files.write(new File("OUT-" + System.currentTimeMillis() + ".txt").toPath(), c.sub.lines);
//    c.start();
//    Thread.sleep(5000);
//    c.stop();

    }

    private class Injector {

        private Function<Number, Number> transfer;

        private String shadowPathIn;

        private double modValue;

        public Injector(String shIn, Function<Number, Number> transfer) {
            this.transfer = transfer;
            this.shadowPathIn = shIn;
        }

        public void resend() {
            System.out.println(shadowPathIn + " Resend: " + modValue);
            publishSynch(shadowPathIn, modValue);
        }

        public void onNext(SimlogMessage msg) {
            Value v = msg.getValue();
            double origValue = v.getNumberValue();
            modValue = transfer.apply(origValue).doubleValue();
            System.out.println(shadowPathIn + " Received: " + origValue);

        }

    }

}
