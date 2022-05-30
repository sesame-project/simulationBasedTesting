package uk.ac.york.sesame.testing.evolutionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uma.jmetal.solution.*;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl;

public class SESAMETestSolution implements Solution<SESAMETestAttack> {
	private static final long serialVersionUID = 1L;

	private TestImpl t;
	
	private boolean actuallyRun;
	private double exptRunTime;
	
	private Map<Object, Object> attributes = new HashMap<Object, Object>();
	private Map<Integer, Double> objectives = new HashMap<Integer, Double>();
	private Map<Integer, Metric> objectiveMetrics = new HashMap<Integer, Metric>();
	private Map<Integer, Double> constraints = new HashMap<Integer, Double>();
	private List<SESAMETestAttack> contents = new ArrayList<SESAMETestAttack>();

	public SESAMETestSolution() {
		
	}
	
	public TestImpl getInternalType() {
		return t;
	}

	public SESAMETestSolution(List<SESAMETestAttack> recs) {
		this.contents = new ArrayList<SESAMETestAttack>(recs.size());

		for (SESAMETestAttack fi : recs) {
			this.contents.add(fi.dup());
		}
		System.out.println("contents = " + contents);
	}

	SESAMETestSolution(SESAMETestSolution other) {
		this.actuallyRun = other.actuallyRun;
		this.exptRunTime = other.exptRunTime;
		this.contents = new ArrayList<SESAMETestAttack>(other.contents.size());

		for (SESAMETestAttack fi : other.contents) {
			this.contents.add(fi.dup());
		}
	}

	public static SESAMETestSolution empty(SESAMETestSolution other) {
		SESAMETestSolution fi = new SESAMETestSolution();
		fi.contents = new ArrayList<SESAMETestAttack>();
		return fi;
	}

	public void setObjective(int index, double value) {
		objectives.put(index, value);
	}

	public double getObjective(int index) {
		return objectives.get(index);
	}

	public double[] getObjectives() {
		int size = objectives.size();
		double[] res = new double[size];
		for (int i = 0; i < size; i++) {
			res[i] = objectives.get(i);
		}
		return res;
	}

	public SESAMETestAttack getVariable(int index) {
		// System.out.println("index = " + index + ",contents.size()=" +
		// contents.size());
		if (index < contents.size() && index >= 0) {
			return contents.get(index);
		} else {
			return null;
		}
	}

	public List<SESAMETestAttack> getVariables() {
		return contents;
	}

	public void setVariable(int index, SESAMETestAttack variable) {
		contents.set(index, variable);
	}

	public double[] getConstraints() {
		int size = constraints.size();
		double[] res = new double[size];
		for (int i = 0; i < size; i++) {
			res[i] = getConstraint(i);
		}
		return res;
	}

	double FuzzingSelectionIntensity(SESAMETestAttack fs) {
		// Assume the intensity is always 1 unless otherwise
		double intensity = 1.0;
		return intensity;
	}

	public double getConstraint(int index) {
		return 0.0;
	}

	public void setConstraint(int index, double value) {
		constraints.put(index, value);
	}

	public int getNumberOfVariables() {
		return contents.size();
	}

	public int getNumberOfObjectives() {
		return objectives.size();
	}

	public int getNumberOfConstraints() {
		return constraints.size();
	}

	public SESAMETestSolution copy() {
		SESAMETestSolution copy = new SESAMETestSolution(this);
		return copy;
	}

	public SESAMETestSolution dup() {
		return this.copy();
	}

	public List<SESAMETestAttack> getFuzzingSelections() {
		return contents;
	}

	public void setContents(int index, SESAMETestAttack fi) {
		contents.set(index, fi);
	}

	public void addContents(int index, SESAMETestAttack fi) {
		contents.add(index, fi);
	}

	public int numberOfFuzzingSelections() {
		return contents.size();
	}

	public void setAttribute(Object id, Object value) {
		attributes.put(id, value);
	}

	public Object getAttribute(Object id) {
		return attributes.get(id);
	}

	public boolean hasAttribute(Object id) {
		return attributes.containsKey(id);
	}

	public Map<Object, Object> getAttributes() {
		return attributes;
	}

	public void setAllContents(List<SESAMETestAttack> fis) {
		int i = 0;
		for (SESAMETestAttack fi : fis) {
			addContents(i, fi);
			i++;
		}
	}

	public List<SESAMETestAttack> variables() {
		return getVariables();
	}

	public double[] objectives() {
		return getObjectives();
	}

	public double[] constraints() {
		return getConstraints();
	}

	public Map<Object, Object> attributes() {
		return getAttributes();
	}

	public String toString() {
		String out = "CSV:" + getTestModelFileName() + "\n";
		for (int i = 0; i < contents.size(); i++) {
			out += contents.get(i).generateDebugInfo() + "\n";
		}
		return out;
	}

	public String getTestModelFileName() {
		return ensureModelFileName();
	}

	private String ensureModelFileName() {
		return "TEST-MODEL-FILE.model";
	}

//	public boolean containsTopicKey(String key) {
//		return contents.stream().anyMatch(r -> r.containsTopic(key));
//	}

//	public void deleteOverlapping() {
//		List<FuzzingKeySelectionRecord> toRemove = new ArrayList<FuzzingKeySelectionRecord>();
//		// Find all matching overlapping keys and delete them
//		// Find any with two keys - and with timing overlapping
//		for (FuzzingSelectionRecord r1 : contents) {
//			for (FuzzingSelectionRecord r2 : contents) {
//				FuzzingKeySelectionRecord rk1 = (FuzzingKeySelectionRecord)r1;
//				FuzzingKeySelectionRecord rk2 = (FuzzingKeySelectionRecord)r2;
//				if (rk1.getKey().equals(rk2.getKey())) {
//					
//					if (isInside(rk1.getTimeSpec(), rk2.getTimeSpec())) {
//						// delete rk1
//						toRemove.add(rk1);
//					} else {					
//							if (isInside(rk2.getTimeSpec(), rk1.getTimeSpec())) {
//								// delete rk1
//								toRemove.add(rk2);
//							} else {
//								// If there is a partial overlapping between the two of them? cut them to not overlap
//								trimIfOverlap(rk1, rk2);
//							}
//					}
//				}
//			}
//		}
//		
//		// Remove the selected records
//		for (FuzzingKeySelectionRecord r : toRemove) {
//			contents.remove(r);
//		}
//	}

//	// If ts1 and ts2 overlap (ts1 before ts2), trim it so ts1 ends before ts2
//	// starts
//	private void trimIfOverlap(FuzzingKeySelectionRecord rk1, FuzzingKeySelectionRecord rk2) {
//		FuzzingTimeSpecification timeSpec1 = rk1.getTimeSpec();
//		FuzzingTimeSpecification timeSpec2 = rk2.getTimeSpec();
//		if ((timeSpec1 instanceof FuzzingFixedTimeSpecification)
//				&& (timeSpec2 instanceof FuzzingFixedTimeSpecification)) {
//			FuzzingFixedTimeSpecification tsfixed1 = (FuzzingFixedTimeSpecification) timeSpec1;
//			FuzzingFixedTimeSpecification tsfixed2 = (FuzzingFixedTimeSpecification) timeSpec2;
//			if ((tsfixed1.getStartTime() < tsfixed2.getStartTime())
//					&& (tsfixed1.getEndTime() > tsfixed2.getStartTime())) {
//				tsfixed1.setEndTime(tsfixed2.getStartTime());
//			}
//		}
//	}
//
//	// Returns true if 1 is inside 2
//	private boolean isInside(FuzzingTimeSpecification timeSpec1, FuzzingTimeSpecification timeSpec2) {
//		if ((timeSpec1 instanceof FuzzingFixedTimeSpecification)
//				&& (timeSpec2 instanceof FuzzingFixedTimeSpecification)) {
//			FuzzingFixedTimeSpecification tsfixed1 = (FuzzingFixedTimeSpecification) timeSpec1;
//			FuzzingFixedTimeSpecification tsfixed2 = (FuzzingFixedTimeSpecification) timeSpec2;
//			return ((tsfixed1.getStartTime() > tsfixed2.getStartTime())
//					&& (tsfixed1.getEndTime() < tsfixed2.getEndTime()));
//		} else {
//			return false;
//		}
//	}

	public void setObjectiveMetric(int i, Metric m) {
		objectiveMetrics.put(i, m);
	}
	
	public Metric getObjectiveMetric(int i) {
		return objectiveMetrics.get(i);
	}
	
	public String getObjectiveMetricName(int i) {
		Metric m = objectiveMetrics.get(i);
		return m.getName();
	}

	public String getMainClassName() {
		return t.getName() + "_testSuiteRunner.java";
	}

	public void ensureModelUpdated(String spaceModelFileName) {
		// TODO ensure the newly updated model is generated
	}
}