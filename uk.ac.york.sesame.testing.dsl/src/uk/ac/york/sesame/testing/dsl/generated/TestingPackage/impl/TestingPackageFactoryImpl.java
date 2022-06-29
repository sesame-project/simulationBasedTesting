/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestingPackageFactoryImpl extends EFactoryImpl implements TestingPackageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestingPackageFactory init() {
		try {
			TestingPackageFactory theTestingPackageFactory = (TestingPackageFactory)EPackage.Registry.INSTANCE.getEFactory(TestingPackagePackage.eNS_URI);
			if (theTestingPackageFactory != null) {
				return theTestingPackageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestingPackageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestingPackageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TestingPackagePackage.TESTING_SPACE: return createTestingSpace();
			case TestingPackagePackage.TEST_CAMPAIGN: return createTestCampaign();
			case TestingPackagePackage.TEST: return createTest();
			case TestingPackagePackage.CAMPAIGN_RESULT_SET: return createCampaignResultSet();
			case TestingPackagePackage.TIME_BASED_END: return createTimeBasedEnd();
			case TestingPackagePackage.GRAMMAR_CONSTRAINT: return createGrammarConstraint();
			case TestingPackagePackage.RANDOM_TEST_GENERATION: return createRandomTestGeneration();
			case TestingPackagePackage.NSGA_EVOLUTIONARY_ALGORITHM: return createNSGAEvolutionaryAlgorithm();
			case TestingPackagePackage.GRAMMAR_SPECIFICATION: return createGrammarSpecification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TestingPackagePackage.RESULT_SET_STATUS:
				return createResultSetStatusFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TestingPackagePackage.RESULT_SET_STATUS:
				return convertResultSetStatusToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestingSpace createTestingSpace() {
		TestingSpaceImpl testingSpace = new TestingSpaceImpl();
		return testingSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCampaign createTestCampaign() {
		TestCampaignImpl testCampaign = new TestCampaignImpl();
		return testCampaign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Test createTest() {
		TestImpl test = new TestImpl();
		return test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CampaignResultSet createCampaignResultSet() {
		CampaignResultSetImpl campaignResultSet = new CampaignResultSetImpl();
		return campaignResultSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeBasedEnd createTimeBasedEnd() {
		TimeBasedEndImpl timeBasedEnd = new TimeBasedEndImpl();
		return timeBasedEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarConstraint createGrammarConstraint() {
		GrammarConstraintImpl grammarConstraint = new GrammarConstraintImpl();
		return grammarConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomTestGeneration createRandomTestGeneration() {
		RandomTestGenerationImpl randomTestGeneration = new RandomTestGenerationImpl();
		return randomTestGeneration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NSGAEvolutionaryAlgorithm createNSGAEvolutionaryAlgorithm() {
		NSGAEvolutionaryAlgorithmImpl nsgaEvolutionaryAlgorithm = new NSGAEvolutionaryAlgorithmImpl();
		return nsgaEvolutionaryAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarSpecification createGrammarSpecification() {
		GrammarSpecificationImpl grammarSpecification = new GrammarSpecificationImpl();
		return grammarSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultSetStatus createResultSetStatusFromString(EDataType eDataType, String initialValue) {
		ResultSetStatus result = ResultSetStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResultSetStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestingPackagePackage getTestingPackagePackage() {
		return (TestingPackagePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestingPackagePackage getPackage() {
		return TestingPackagePackage.eINSTANCE;
	}

} //TestingPackageFactoryImpl