/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.york.sesame.testing.architecture.tts;

import java.util.concurrent.CountDownLatch;

import com.google.protobuf.Empty;
import com.ttsnetwork.simulator3.SimServerAPIGrpc;
import com.ttsnetwork.simulator3.SimStatus;
import com.ttsnetwork.simulator3.StartRequest;
import com.ttsnetwork.simulator3.StepRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

/**
 *
 * @author rovere
 */
public class GRPCController {

	
    private SimServerAPIGrpc.SimServerAPIBlockingStub server;
    private SimServerAPIGrpc.SimServerAPIStub asynchStub;
    
    private SimCore testingPlatformCore;
    private CountDownLatch cl;

    public GRPCController(String targetController) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(targetController).usePlaintext().build();
        this.server = SimServerAPIGrpc.newBlockingStub(channel);
        this.asynchStub = SimServerAPIGrpc.newStub(channel);
        this.testingPlatformCore = SimCore.getInstance();
        this.cl = new CountDownLatch(1);
    }
    
    public GRPCController() {
    	this("localhost:8089");
    }

    boolean step() {
        StepRequest sr = StepRequest.newBuilder().setDeltaTime(50).build();
        SimStatus rsp = server.step(sr);
        System.out.println("--------- Step: --------------");
        boolean isAlive = rsp.getAlive();
        print(rsp);
        return isAlive;
    }

    void start() {
        StartRequest sr = StartRequest.newBuilder().setDeltaTime(50).build();
        SimStatus s = server.start(sr);
        System.out.println(" ---------- Started: --------");
        print(s);
    }

    static void print(SimStatus m) {
        System.out.println("Status:");
        System.out.println("Clock:" + m.getClock());
        System.out.println("Alive:" + m.getAlive());
        System.out.println("Playing:" + m.getPlaying());
        System.out.println("Exit code:" + m.getExitCode());
    }

    void stop() {
        SimStatus s = server.stop(Empty.getDefaultInstance());
        System.out.println(" ---------- Stopped: --------");
        print(s);
    }

    void subscribe() {
        asynchStub.subscribe(Empty.getDefaultInstance(), new StatusObs());
    }
    
    private void updateTime(long timeNS) {
    	testingPlatformCore.setTime(0.0);
	}
    
    public synchronized void notifyStepMessage() {
    	cl.countDown();
    }

    private class StatusObs implements StreamObserver<SimStatus> {

        public StatusObs() {
        }

        @Override
        public void onNext(SimStatus m) {
            System.out.println("Status:");
            System.out.println("Clock:" + m.getClock());
            System.out.println("Alive:" + m.getAlive());
            System.out.println("Playing:" + m.getPlaying());
            System.out.println("Exit code:" + m.getExitCode());
            
            long time = m.getClock();
            updateTime(time);
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

	public void waitForReady() {
        try {
			this.cl.await();
		// TODO: can this InterruptedException cause a problem here?
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        this.cl = new CountDownLatch(1);
	}
}
