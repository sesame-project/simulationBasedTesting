package uk.ac.york.sesame.testing.architecture.ros;

import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Service;
import edu.wpi.rail.jrosbridge.services.ServiceRequest;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertySetter;
import uk.ac.york.sesame.testing.architecture.simulator.ParameterGetTimedOut;

public class ROS2ParameterSetter extends ROS2ParameterInterface implements IPropertySetter {

	// Include an internal property getter to retrieve original value
	private ROS2ParameterGetter getter;
	private Object originalValue;
	private boolean isSet = false;
	private boolean isRestored = false;
	
	private String srvName;
	private String srvType = "rcl_interfaces/srv/SetParameters";
	private Service srv;

	
	public ROS2ParameterSetter(String componentName, String paramName, Ros ros) {
		super(componentName, paramName, ros);
		srvName = componentName + "/set_parameters";
		srv = new Service(this.ros, srvName, srvType);
		getter = new ROS2ParameterGetter(componentName, paramName, ros);
	}
	
	private void internalSet(Object value) {
		// TODO: only doing integer parameters
		int paramTypeNum = 2;
		String paramStr = "{\"name\" : \"" + paramName + "\", \"value\" : { \"type\": " + Integer.toString(paramTypeNum) + ", \"integer_value\" : " + Integer.toString((Integer)value) + "}}";
		String paramSRVContent = "{\"parameters\": [" + paramStr + "]}";
		System.out.println(paramSRVContent);
		ServiceRequest rq = new ServiceRequest(paramSRVContent);
		// TODO: handle failure status from the service call
		srv.callService(rq, new ROSSetParamServiceCallback(paramName, value));
	}
	
	@Override
	public void set(Object value) {
		// Need to store the original value
		try {
			System.out.println("set called for " + this.toString());
			originalValue = getter.getSync();
			System.out.println("originalValue for " + paramName + " = " + originalValue);
		} catch (ParameterGetTimedOut e) {
			e.printStackTrace();
		}
		
		// TODO: do we need a wait before calling here?
		internalSet(value);
		isSet = true;
	}
	
	@Override
	public void setRelative(Object value) {
		// Need to store the original value
		try {
			System.out.println("set called for " + this.toString());
			originalValue = getter.getSync();
			System.out.println("originalValue for " + paramName + " = " + originalValue);
		} catch (ParameterGetTimedOut e) {
			e.printStackTrace();
		}
		
		// TODO: do we need a wait before calling here?
		internalSet(value);
		isSet = true;
	}
	
	public void restoreOriginalValue() {
		internalSet(originalValue);
		isRestored = true;
	}

	@Override
	public boolean isSet() {
		return isSet;
	}
	
	@Override
	public boolean isRestored() {
		return isRestored;
	}

}
