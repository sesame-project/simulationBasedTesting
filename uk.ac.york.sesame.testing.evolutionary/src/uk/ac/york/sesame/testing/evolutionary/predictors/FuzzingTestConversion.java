package uk.ac.york.sesame.testing.evolutionary.predictors;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ExecutionEndTrigger;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedEnd;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;

public class FuzzingTestConversion {
	double FIXED_RESOLUTION_SECS = 1.0;
	private Test t;
 
	private HashMap<FuzzingOperation, DoubleColumn> colLookup;
	private int timeStepCount;
	private double resolution;
	private RelativeParameters relParams;
	
	public FuzzingTestConversion() {
		this.relParams = new RelativeParameters(); 
	}

	public FuzzingTestConversion(Test t) throws InvalidEndType {
		this.t = t;
		this.resolution = FIXED_RESOLUTION_SECS;
		
		ExecutionEndTrigger trigger = t.getParentCampaign().getEndTrigger();

		if (trigger instanceof TimeBasedEnd) {
			TimeBasedEnd tbe = (TimeBasedEnd) trigger;
			double timeLength = tbe.getTimeLimitSeconds();
			this.timeStepCount = (int) (Math.floor(timeLength / resolution));
		} else {
			throw new InvalidEndType(trigger);
		}
	}

	public Table convert() throws UnknownLength {

		colLookup = new HashMap<FuzzingOperation, DoubleColumn>();
		Table timeSeries = Table.create(t.getName() + "-timeSeries");

		for (FuzzingOperation op : t.getOperations()) {
			if (includeOp(t, op)) {
				// TODO: get column based upon the template name
				DoubleColumn colParentOp = lookupColumnFor(timeSeries, op);
				// Go through in time-steps
				Activation a = op.getActivation();
				if (a instanceof FixedTimeActivation) {
					FixedTimeActivation ta = (FixedTimeActivation) a;
					double start = ta.getStartTime();
					double end = ta.getEndTime();
					double intensity = getOperationIntensity(t, op);

					for (double time = start; time < end; time += resolution) {
						int index = (int)Math.floor(time / resolution);
						//System.out.println("index=" + index);
						// Increment intensity by this value
						double orig = colParentOp.get(index);
						colParentOp = colParentOp.set(index, orig + intensity);
					}
				}
			}
		}
		return timeSeries;
	}
	
	public void saveTableToCSV(Table tb, File file) throws IOException {
//		Destination d = new Destination(file);
//		CsvWriter w = new CsvWriter();
//		System.out.println("Saving CSV for test " + t.getName() + " to file " + file.getAbsolutePath());
//		w.write(tb, d);
		tb.write().csv(file);
	}
	
	private void initColumnZero(DoubleColumn col, int timeStepCount) {
		for (int i = 0; i < timeStepCount; i++) {
			col.set(i, 0.0);
		}
	}

	private DoubleColumn lookupColumnFor(Table tbl, FuzzingOperation op) {
		FuzzingOperation opBase = op.getFromTemplate();
		
		if (!colLookup.containsKey(opBase)) {
			DoubleColumn col = DoubleColumn.create(opBase.getName(), timeStepCount);
			//
			initColumnZero(col, timeStepCount);
			tbl.addColumns(col);
			colLookup.put(opBase, col);
		}
		return colLookup.get(opBase);
	}

	private double getOperationIntensity(Test t, FuzzingOperation op) {
		return relParams.scoreForOperation(op);
	}

	private boolean includeOp(Test t, FuzzingOperation op) {
		return true;
	}
}
