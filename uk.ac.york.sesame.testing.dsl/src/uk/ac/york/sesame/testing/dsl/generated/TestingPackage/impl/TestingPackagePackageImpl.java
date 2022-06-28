/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.EvolutionaryAlgorithm;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ExecutionEndTrigger;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarConstraint;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpecification;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSPackagePackageImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAEvolutionaryAlgorithm;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.RandomTestGeneration;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ResultSetStatus;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.impl.ResultsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestGenerationApproach;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackageFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedEnd;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestingPackagePackageImpl extends EPackageImpl implements TestingPackagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testingSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testCampaignEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass campaignResultSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionEndTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeBasedEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass grammarConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testGenerationApproachEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomTestGenerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evolutionaryAlgorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nsgaEvolutionaryAlgorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass grammarSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resultSetStatusEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestingPackagePackageImpl() {
		super(eNS_URI, TestingPackageFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TestingPackagePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestingPackagePackage init() {
		if (isInited) return (TestingPackagePackage)EPackage.Registry.INSTANCE.getEPackage(TestingPackagePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestingPackagePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestingPackagePackageImpl theTestingPackagePackage = registeredTestingPackagePackage instanceof TestingPackagePackageImpl ? (TestingPackagePackageImpl)registeredTestingPackagePackage : new TestingPackagePackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AttacksPackage.eNS_URI);
		AttacksPackageImpl theAttacksPackage = (AttacksPackageImpl)(registeredPackage instanceof AttacksPackageImpl ? registeredPackage : AttacksPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(registeredPackage instanceof MetricsPackageImpl ? registeredPackage : MetricsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
		ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(registeredPackage instanceof ResultsPackageImpl ? registeredPackage : ResultsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MRSPackagePackage.eNS_URI);
		MRSPackagePackageImpl theMRSPackagePackage = (MRSPackagePackageImpl)(registeredPackage instanceof MRSPackagePackageImpl ? registeredPackage : MRSPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theTestingPackagePackage.createPackageContents();
		theAttacksPackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theResultsPackage.createPackageContents();
		theMRSPackagePackage.createPackageContents();

		// Initialize created meta-data
		theTestingPackagePackage.initializePackageContents();
		theAttacksPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theResultsPackage.initializePackageContents();
		theMRSPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestingPackagePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestingPackagePackage.eNS_URI, theTestingPackagePackage);
		return theTestingPackagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestingSpace() {
		return testingSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestingSpace_Name() {
		return (EAttribute)testingSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestingSpace_Metrics() {
		return (EReference)testingSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestingSpace_PossibleAttacks() {
		return (EReference)testingSpaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestingSpace_GrammarSpecfication() {
		return (EReference)testingSpaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestingSpace_Campaigns() {
		return (EReference)testingSpaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestingSpace_Mrs() {
		return (EReference)testingSpaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestCampaign() {
		return testCampaignEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestCampaign_Name() {
		return (EAttribute)testCampaignEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCampaign_Metrics() {
		return (EReference)testCampaignEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCampaign_IncludedAttacks() {
		return (EReference)testCampaignEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCampaign_Constraints() {
		return (EReference)testCampaignEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCampaign_Approach() {
		return (EReference)testCampaignEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCampaign_PerformedTests() {
		return (EReference)testCampaignEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCampaign_ResultSets() {
		return (EReference)testCampaignEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestCampaign_DefaultEndTrigger() {
		return (EReference)testCampaignEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTest() {
		return testEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTest_Name() {
		return (EAttribute)testEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTest_Attacks() {
		return (EReference)testEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTest_Metrics() {
		return (EReference)testEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTest_EndTrigger() {
		return (EReference)testEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTest_DevelopedFrom() {
		return (EReference)testEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTest_ParentCampaign() {
		return (EReference)testEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCampaignResultSet() {
		return campaignResultSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCampaignResultSet_Name() {
		return (EAttribute)campaignResultSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCampaignResultSet_Status() {
		return (EAttribute)campaignResultSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCampaignResultSet_Results() {
		return (EReference)campaignResultSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionEndTrigger() {
		return executionEndTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeBasedEnd() {
		return timeBasedEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeBasedEnd_TimeLimitSeconds() {
		return (EAttribute)timeBasedEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGrammarConstraint() {
		return grammarConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestGenerationApproach() {
		return testGenerationApproachEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomTestGeneration() {
		return randomTestGenerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvolutionaryAlgorithm() {
		return evolutionaryAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNSGAEvolutionaryAlgorithm() {
		return nsgaEvolutionaryAlgorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNSGAEvolutionaryAlgorithm_PopulationSize() {
		return (EAttribute)nsgaEvolutionaryAlgorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNSGAEvolutionaryAlgorithm_Iterations() {
		return (EAttribute)nsgaEvolutionaryAlgorithmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGrammarSpecification() {
		return grammarSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResultSetStatus() {
		return resultSetStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestingPackageFactory getTestingPackageFactory() {
		return (TestingPackageFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		testingSpaceEClass = createEClass(TESTING_SPACE);
		createEAttribute(testingSpaceEClass, TESTING_SPACE__NAME);
		createEReference(testingSpaceEClass, TESTING_SPACE__METRICS);
		createEReference(testingSpaceEClass, TESTING_SPACE__POSSIBLE_ATTACKS);
		createEReference(testingSpaceEClass, TESTING_SPACE__GRAMMAR_SPECFICATION);
		createEReference(testingSpaceEClass, TESTING_SPACE__CAMPAIGNS);
		createEReference(testingSpaceEClass, TESTING_SPACE__MRS);

		testCampaignEClass = createEClass(TEST_CAMPAIGN);
		createEAttribute(testCampaignEClass, TEST_CAMPAIGN__NAME);
		createEReference(testCampaignEClass, TEST_CAMPAIGN__METRICS);
		createEReference(testCampaignEClass, TEST_CAMPAIGN__INCLUDED_ATTACKS);
		createEReference(testCampaignEClass, TEST_CAMPAIGN__CONSTRAINTS);
		createEReference(testCampaignEClass, TEST_CAMPAIGN__APPROACH);
		createEReference(testCampaignEClass, TEST_CAMPAIGN__PERFORMED_TESTS);
		createEReference(testCampaignEClass, TEST_CAMPAIGN__RESULT_SETS);
		createEReference(testCampaignEClass, TEST_CAMPAIGN__DEFAULT_END_TRIGGER);

		testEClass = createEClass(TEST);
		createEAttribute(testEClass, TEST__NAME);
		createEReference(testEClass, TEST__ATTACKS);
		createEReference(testEClass, TEST__METRICS);
		createEReference(testEClass, TEST__END_TRIGGER);
		createEReference(testEClass, TEST__DEVELOPED_FROM);
		createEReference(testEClass, TEST__PARENT_CAMPAIGN);

		campaignResultSetEClass = createEClass(CAMPAIGN_RESULT_SET);
		createEAttribute(campaignResultSetEClass, CAMPAIGN_RESULT_SET__NAME);
		createEAttribute(campaignResultSetEClass, CAMPAIGN_RESULT_SET__STATUS);
		createEReference(campaignResultSetEClass, CAMPAIGN_RESULT_SET__RESULTS);

		executionEndTriggerEClass = createEClass(EXECUTION_END_TRIGGER);

		timeBasedEndEClass = createEClass(TIME_BASED_END);
		createEAttribute(timeBasedEndEClass, TIME_BASED_END__TIME_LIMIT_SECONDS);

		grammarConstraintEClass = createEClass(GRAMMAR_CONSTRAINT);

		testGenerationApproachEClass = createEClass(TEST_GENERATION_APPROACH);

		randomTestGenerationEClass = createEClass(RANDOM_TEST_GENERATION);

		evolutionaryAlgorithmEClass = createEClass(EVOLUTIONARY_ALGORITHM);

		nsgaEvolutionaryAlgorithmEClass = createEClass(NSGA_EVOLUTIONARY_ALGORITHM);
		createEAttribute(nsgaEvolutionaryAlgorithmEClass, NSGA_EVOLUTIONARY_ALGORITHM__POPULATION_SIZE);
		createEAttribute(nsgaEvolutionaryAlgorithmEClass, NSGA_EVOLUTIONARY_ALGORITHM__ITERATIONS);

		grammarSpecificationEClass = createEClass(GRAMMAR_SPECIFICATION);

		// Create enums
		resultSetStatusEEnum = createEEnum(RESULT_SET_STATUS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AttacksPackage theAttacksPackage = (AttacksPackage)EPackage.Registry.INSTANCE.getEPackage(AttacksPackage.eNS_URI);
		MetricsPackage theMetricsPackage = (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		ResultsPackage theResultsPackage = (ResultsPackage)EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
		MRSPackagePackage theMRSPackagePackage = (MRSPackagePackage)EPackage.Registry.INSTANCE.getEPackage(MRSPackagePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theAttacksPackage);
		getESubpackages().add(theMetricsPackage);
		getESubpackages().add(theResultsPackage);
		getESubpackages().add(theMRSPackagePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		timeBasedEndEClass.getESuperTypes().add(this.getExecutionEndTrigger());
		randomTestGenerationEClass.getESuperTypes().add(this.getTestGenerationApproach());
		evolutionaryAlgorithmEClass.getESuperTypes().add(this.getTestGenerationApproach());
		nsgaEvolutionaryAlgorithmEClass.getESuperTypes().add(this.getEvolutionaryAlgorithm());

		// Initialize classes, features, and operations; add parameters
		initEClass(testingSpaceEClass, TestingSpace.class, "TestingSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestingSpace_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestingSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestingSpace_Metrics(), theMetricsPackage.getMetric(), null, "metrics", null, 0, -1, TestingSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestingSpace_PossibleAttacks(), theAttacksPackage.getAttack(), null, "possibleAttacks", null, 0, -1, TestingSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestingSpace_GrammarSpecfication(), this.getGrammarSpecification(), null, "grammarSpecfication", null, 0, 1, TestingSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestingSpace_Campaigns(), this.getTestCampaign(), null, "campaigns", null, 0, -1, TestingSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestingSpace_Mrs(), theMRSPackagePackage.getMRS(), null, "mrs", null, 1, 1, TestingSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testCampaignEClass, TestCampaign.class, "TestCampaign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestCampaign_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestCampaign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCampaign_Metrics(), theMetricsPackage.getMetric(), null, "metrics", null, 0, -1, TestCampaign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCampaign_IncludedAttacks(), theAttacksPackage.getAttack(), null, "includedAttacks", null, 0, -1, TestCampaign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCampaign_Constraints(), this.getGrammarConstraint(), null, "constraints", null, 0, -1, TestCampaign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCampaign_Approach(), this.getTestGenerationApproach(), null, "approach", null, 1, 1, TestCampaign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCampaign_PerformedTests(), this.getTest(), this.getTest_ParentCampaign(), "performedTests", null, 0, -1, TestCampaign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCampaign_ResultSets(), this.getCampaignResultSet(), null, "resultSets", null, 0, -1, TestCampaign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCampaign_DefaultEndTrigger(), this.getExecutionEndTrigger(), null, "defaultEndTrigger", null, 1, 1, TestCampaign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testEClass, Test.class, "Test", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTest_Name(), ecorePackage.getEString(), "name", null, 0, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTest_Attacks(), theAttacksPackage.getAttack(), theAttacksPackage.getAttack_ContainingTest(), "attacks", null, 0, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTest_Metrics(), theMetricsPackage.getMetricInstance(), null, "metrics", null, 0, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTest_EndTrigger(), this.getExecutionEndTrigger(), null, "endTrigger", null, 1, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTest_DevelopedFrom(), this.getTest(), null, "developedFrom", null, 0, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTest_ParentCampaign(), this.getTestCampaign(), this.getTestCampaign_PerformedTests(), "parentCampaign", null, 1, 1, Test.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(campaignResultSetEClass, CampaignResultSet.class, "CampaignResultSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCampaignResultSet_Name(), ecorePackage.getEString(), "name", null, 0, 1, CampaignResultSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCampaignResultSet_Status(), this.getResultSetStatus(), "status", null, 0, 1, CampaignResultSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCampaignResultSet_Results(), this.getTest(), null, "results", null, 0, -1, CampaignResultSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionEndTriggerEClass, ExecutionEndTrigger.class, "ExecutionEndTrigger", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timeBasedEndEClass, TimeBasedEnd.class, "TimeBasedEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeBasedEnd_TimeLimitSeconds(), ecorePackage.getELong(), "timeLimitSeconds", null, 0, 1, TimeBasedEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(grammarConstraintEClass, GrammarConstraint.class, "GrammarConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(testGenerationApproachEClass, TestGenerationApproach.class, "TestGenerationApproach", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(randomTestGenerationEClass, RandomTestGeneration.class, "RandomTestGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(evolutionaryAlgorithmEClass, EvolutionaryAlgorithm.class, "EvolutionaryAlgorithm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nsgaEvolutionaryAlgorithmEClass, NSGAEvolutionaryAlgorithm.class, "NSGAEvolutionaryAlgorithm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNSGAEvolutionaryAlgorithm_PopulationSize(), ecorePackage.getEInt(), "populationSize", null, 0, 1, NSGAEvolutionaryAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNSGAEvolutionaryAlgorithm_Iterations(), ecorePackage.getEInt(), "iterations", null, 0, 1, NSGAEvolutionaryAlgorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(grammarSpecificationEClass, GrammarSpecification.class, "GrammarSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(resultSetStatusEEnum, ResultSetStatus.class, "ResultSetStatus");
		addEEnumLiteral(resultSetStatusEEnum, ResultSetStatus.FINAL);
		addEEnumLiteral(resultSetStatusEEnum, ResultSetStatus.INTERMEDIATE);

		// Create resource
		createResource(eNS_URI);
	}

} //TestingPackagePackageImpl
