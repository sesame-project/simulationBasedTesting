package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import net.razorvine.pyro.NameServerProxy;
import net.razorvine.pyro.PyroProxy;

public class PyroDaemons {
	
	private static String DEFAULT_NS_HOSTNAME = "192.168.1.19";
	private static int DEFAULT_NS_PORT = 9523;
		
	private static String nsHostname = DEFAULT_NS_HOSTNAME;
	private static int nsPort = DEFAULT_NS_PORT;
	
	private static NameServerProxy ns_single;
	private static Map<String,PyroProxy> proxies_by_host = new HashMap<String,PyroProxy>();
	
	public static void setHostname(String nsHostname) {
		nsHostname = nsHostname;
	}
	
	public static NameServerProxy getNameserver() throws IOException {
		if(ns_single == null) {
			ns_single = NameServerProxy.locateNS(nsHostname, nsPort);
		}
		return ns_single;
	}
	
	public static PyroProxy getPyroDaemonByHost(String targetHost) throws UnknownHostException, IOException {
		NameServerProxy ns = PyroDaemons.getNameserver();
		if (!proxies_by_host.containsKey(targetHost)) {
			// TODO: check this daemon by its IP address
			PyroProxy daemon = new PyroProxy(getNameserver().lookup("SOPRANOWorkerDaemon"));
			proxies_by_host.put(targetHost, daemon);
			return daemon;
		} else {
			return proxies_by_host.get(targetHost);
		}
	}
}
