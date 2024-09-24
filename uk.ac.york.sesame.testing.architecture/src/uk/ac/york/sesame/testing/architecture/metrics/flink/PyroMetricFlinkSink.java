package uk.ac.york.sesame.testing.architecture.metrics.flink;

import java.io.IOException;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import uk.ac.york.sesame.testing.architecture.data.*;
import net.razorvine.pyro.NameServerProxy;
import net.razorvine.pyro.PyroProxy;

public class PyroMetricFlinkSink extends RichSinkFunction<MetricMessage> {
	private static final long serialVersionUID = 1L;
	private PyroProxy metricDaemon;
	private NameServerProxy ns_single;
	
	private String nsHostname;
	private int nsPort;
	private String testID;
	private String workerPyroName;
	
	public PyroMetricFlinkSink(String testID, String nsHostname, int nsPort, String workerPyroName) {
		this.nsHostname = nsHostname;
		this.nsPort = nsPort;
		this.workerPyroName = workerPyroName;
		this.testID = testID;			
	}
	
	@Override
	public void open(Configuration parameters) throws Exception {
		super.open(parameters);
	    // Initialize resources (e.g., database connections, file writers)
		
		try {
			this.ns_single = NameServerProxy.locateNS(nsHostname, nsPort);
			// We always connect to the worker metric holder with the current test ID
			//this.metricDaemon = new PyroProxy(ns_single.lookup("MetricValueHistory" + "_" + testID));
			// TODO: put in hostname/IP for worker
			this.metricDaemon = new PyroProxy(ns_single.lookup(workerPyroName));
			System.out.println("metricDaemon setup for Pyro");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
    public void invoke(MetricMessage mmsg, Context context) throws Exception {
    	//System.out.println("invoke pyro sink");
        // Get Pyro object for "MetricValueHolder" for local IP
    	// TODO: can we get the runUUID here? as a parameter passed from the daemon?
    	String metricName = mmsg.getMetricName();
    	Double value = (Double)mmsg.getValue();
    	double timestamp = mmsg.getTimestamp();
    	try {
    		Object result = metricDaemon.call("update_metric", testID, metricName, value, timestamp);
    		System.out.println("PyroMetricFlinkSink invoke result=" + result);
    	} catch (Exception e) {
    		e.printStackTrace();
    		// Ensure the Pyro exception is logged to the output stream
    		System.out.println("Pyro exception:");
    		e.printStackTrace(System.out);
    	}
    }
}