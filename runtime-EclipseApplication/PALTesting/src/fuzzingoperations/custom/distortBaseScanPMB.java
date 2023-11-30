package fuzzingoperations.custom;

public class distortBaseScanPMB extends distortBaseScan {
	private static final long serialVersionUID = 1L;

	protected String getTargetTopic() {
		return "/pmb2_1/scan";
	}
}
