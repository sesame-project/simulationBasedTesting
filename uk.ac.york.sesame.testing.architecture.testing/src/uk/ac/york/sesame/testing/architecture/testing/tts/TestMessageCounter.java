package uk.ac.york.sesame.testing.architecture.testing.tts;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class TestMessageCounter extends KeyedProcessFunction<String, EventMessage, Long> {

	private static final long serialVersionUID = 1L;
	/** The state that is maintained by this process function */
    private ValueState<Long> state;

    @Override
    public void open(Configuration parameters) throws Exception {
        state = getRuntimeContext().getState(new ValueStateDescriptor<>("myState", Long.class));
    }

    @Override
    public void processElement(EventMessage msg, Context ctx, Collector<Long> out)
            throws Exception {
    	
        Long currentCount = state.value();
        if (currentCount == null) {
        	currentCount = 0L;
        }
        
        currentCount++;
        state.update(currentCount);
        out.collect(currentCount);
    }
}