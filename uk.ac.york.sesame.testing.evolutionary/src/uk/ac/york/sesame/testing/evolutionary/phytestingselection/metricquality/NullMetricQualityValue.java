package uk.ac.york.sesame.testing.evolutionary.phytestingselection.metricquality;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;

public class NullMetricQualityValue extends MetricQualityValue {

	public double generateMetricQualityValue(Test t) {
		return 0.0;
	}

	public void setCampaign(TestCampaign selectedCampaign2) {
		
	}
}
