package uk.ac.york.sesame.testing.evolutionary.predictors.test;

import java.util.Random;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class TestTimeSeries {
	public static void main(String [] args) {
		int count = 10;
		DoubleColumn dc = DoubleColumn.create("TESTING", count);
		Table timeSeries = Table.create("TIMECONVERSION");
		Random rng = new Random();
		
		timeSeries.addColumns(dc);
		
		
		for (int i = 0; i < count; i++) {
			dc.set(i, rng.nextDouble());
		}
		System.out.println(timeSeries.print());
	}
}
