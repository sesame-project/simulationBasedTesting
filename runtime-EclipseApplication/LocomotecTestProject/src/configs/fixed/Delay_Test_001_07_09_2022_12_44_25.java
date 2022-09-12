package configs.fixed;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import datatypes.*;
import datatypes.custom.*;

import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.TimerService;

import org.apache.flink.util.Collector;

import org.json.simple.*;

import fuzzingoperations.custom.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public class Delay_Test_001_07_09_2022_12_44_25 extends TimeBasedFuzzingOperation {


	private static final long serialVersionUID = 1L;
	private long delayTime;
	Random rng;
	
	private MapState<Long,List<EventMessage>> queue;

	public Delay_Test_001_07_09_2022_12_44_25(String topic, double start, double end, double time, long seed) {
		super(topic,start,end);
		this.rng = new Random(seed);
		this.delayTime = Math.round(time * 10000.0); 
		System.out.println("Creating new latency delay operation, time seconds = " + time + ",delayTime = " + delayTime);
	}
	
	
	public void open(Configuration parameters) throws Exception {
		super.open(parameters);
		// TODO: need to change this queue name
		String queueName = "queue-";
		this.queue = getRuntimeContext().getMapState(new MapStateDescriptor<>(queueName, 
				TypeInformation.of(Long.class),
				TypeInformation.of(new TypeHint<List<EventMessage>>() {})));
	}
	
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception {
		long currentTime = ctx.timestamp();
		long scheduledTime = currentTime + delayTime;
		double simTime = SimCore.getInstance().getTime();
		
		List<EventMessage> currentPending = queue.get(scheduledTime);
		
		if (currentPending == null) {
			currentPending = new ArrayList<EventMessage>();
		}
		currentPending.add(value);
		queue.put(scheduledTime, currentPending);
		System.out.println("currentTime = " + currentTime + ",sim time=" + simTime + ", scheduling new timer at " + scheduledTime);
		ctx.timerService().registerProcessingTimeTimer(scheduledTime);
	}
	
	public void onTimer(long timestamp, OnTimerContext ctx, Collector<EventMessage> out) {
		long currentTime = ctx.timestamp();

		try {
			for (Iterator<Entry<Long, List<EventMessage>>> it = queue.entries().iterator(); it.hasNext();) {
				Entry<Long, List<EventMessage>> entry = it.next();
				long schedTime = entry.getKey();
				if (schedTime >= currentTime) {
					List<EventMessage> queuedMsgs = entry.getValue();
					for (EventMessage m : queuedMsgs) {
						out.collect(m);
					}
					it.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void preprocessing() {

	}	
}

