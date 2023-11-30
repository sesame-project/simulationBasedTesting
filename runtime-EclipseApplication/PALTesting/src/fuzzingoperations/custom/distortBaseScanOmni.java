package fuzzingoperations.custom;

public class distortBaseScanOmni extends distortBaseScan {
	private static final long serialVersionUID = 1L;

	protected String getTargetTopic() {
		return "/omni_base_1/scan";
	}
}
