package uk.ac.york.sesame.testing.architecture.ros;

import edu.wpi.rail.jrosbridge.callback.ServiceCallback;
import edu.wpi.rail.jrosbridge.services.ServiceResponse;

public class ROSServiceCallback implements ServiceCallback {
	private String paramName;
	private double paramVal;

	public ROSServiceCallback(String paramName, double paramVal) {
		this.paramName = paramName;
		this.paramVal = paramVal;
	}
	
	public void handleServiceResponse(ServiceResponse response) {
		System.out.println("Response received: " + response);
		boolean responseOK = response.getResult();
		System.out.println("Service call to set paramName=" + paramName + " -> " + paramVal + " responded: " + responseOK);
	}
}
