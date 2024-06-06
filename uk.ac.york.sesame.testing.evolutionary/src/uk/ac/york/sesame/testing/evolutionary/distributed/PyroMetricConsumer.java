package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.Optional;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.evolutionary.InvalidTestCampaign;
import uk.ac.york.sesame.testing.evolutionary.MetricConsumerBase;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

public class PyroMetricConsumer extends MetricConsumerBase {

	public PyroMetricConsumer(TestCampaign selectedCampaign, SESAMETestSolution solution) throws InvalidTestCampaign {
		super(selectedCampaign);
		this.currentSolution = Optional.of(solution);
	}
}
