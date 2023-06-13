package uk.ac.york.sesame.testing.evolutionary.phytestingselection.metricquality;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;

/** Processes the Test to generate a set of coordinates **/
public abstract class MetricQualityValue {
	protected TestCampaign selectedCampaign;
	
	public abstract double generateMetricQualityValue(Test t);

	public void setCampaign(TestCampaign selectedCampaign) {
		this.selectedCampaign = selectedCampaign;
	}
}