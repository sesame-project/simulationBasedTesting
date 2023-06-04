package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;

public class NullMetricQualityValue extends MetricQualityValue {

	public Double generateMetricQualityValue(Test t, TestCampaign selectedCampaign) {
		return 0.0;
	}
}
