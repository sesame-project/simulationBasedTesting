package uk.ac.york.sesame.testing.evolutionary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.uma.jmetal.solution.*;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackageFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;

public class SESAMETestSolution implements Solution<SESAMETestAttack> {
	private static final long serialVersionUID = 1L;

	private Test t;
	
	private boolean actuallyRun;
	private double exptRunTime;
	private TestingPackageFactory tFactory;
	
	private static Integer numTest = 0;
	
	private Map<Object, Object> attributes = new HashMap<Object, Object>();
	private Map<Integer, Double> objectives = new HashMap<Integer, Double>();
	private Map<Integer, Metric> objectiveMetrics = new HashMap<Integer, Metric>();
	private Map<Integer, Double> constraints = new HashMap<Integer, Double>();
	private List<SESAMETestAttack> contents = new ArrayList<SESAMETestAttack>();

	private void setupTestingFactory() {
		if (tFactory == null) {
			tFactory = TestingPackageFactory.eINSTANCE;
		}
	}
	
	public SESAMETestSolution() {
		setupTestingFactory();
		t = tFactory.createTest();
		t.setName(createTestName());
	}
	
	private String createTestName() {
		String date = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
		return "Test_" + String.format("%03d", ++numTest) + "_" + date;
	}

	public Test getInternalType() {
		return t;
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
		return t.getName();
	}

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
	
	private boolean modelContainsTest(EList<Test> tests, String targetName) {
		return tests.stream().anyMatch(test -> test.getName().equals(targetName));
	}

	public void ensureModelUpdated(TestCampaign campaign) {
		List<Attack> testAttacks = t.getAttacks();
		// First, ensure the model attack objects are all updated in the model object
		// from its contents
		for (SESAMETestAttack sta : contents) {
			Attack a = sta.getAttack();
			testAttacks.add(a);
		}
		
		// Add the test to the enclosing TestCampaign
		EList<Test> tests = campaign.getPerformedTests();
		if (!modelContainsTest(tests, t.getName())) {
			tests.add(t);
			
			System.out.println("Added a test to the model named " + t.getName());
		}
	}
}