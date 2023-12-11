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
    
    private boolean simIsAlive = true;

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
        System.out.println("--SBT Calling Step: --------------");
        simIsAlive = rsp.getAlive();
        // Ask Diego: should we get time from this or the StatusObs below
        long timeMS = rsp.getClock();
        updateTimeMS(timeMS);
        print(rsp);
        return simIsAlive;
    }
    
    boolean simIsAlive() {
    	return simIsAlive;
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
    
    private void updateTimeMS(long timeMS) {
    	double time = ((double)timeMS) / 1000.0;
    	testingPlatformCore.setTime(time);
	}
    
    public synchronized void notifyStepMessage() {
    	cl.countDown();
    }
    
	public void waitForReady() {
        try {
        	System.out.println("Waiting for ready");
			this.cl.await();
		// TODO: Check with Diego - can this InterruptedException cause a problem here?
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        this.cl = new CountDownLatch(1);
	}

    private class StatusObs implements StreamObserver<SimStatus> {

        public StatusObs() {
        }

        @Override
        public void onNext(SimStatus m) {
            System.out.println("GRPC Controller: Clock:" + m.getClock());
            //System.out.println("Alive:" + m.getAlive());
            //System.out.println("Playing:" + m.getPlaying());
            //System.out.println("Exit code:" + m.getExitCode());
            long timeMS = m.getClock();
            updateTimeMS(timeMS);
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
}
