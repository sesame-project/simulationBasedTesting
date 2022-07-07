/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackageFactory
 * @model kind="package"
 * @generated
 */
public interface TestingPackagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TestingPackage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "TestingMM";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TestingMM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestingPackagePackage eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl <em>Testing Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTestingSpace()
	 * @generated
	 */
	int TESTING_SPACE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE__METRICS = 1;

	/**
	 * The feature id for the '<em><b>Possible Attacks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE__POSSIBLE_ATTACKS = 2;

	/**
	 * The feature id for the '<em><b>Campaigns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE__CAMPAIGNS = 3;

	/**
	 * The feature id for the '<em><b>Mrs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE__MRS = 4;

	/**
	 * The number of structural features of the '<em>Testing Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Testing Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl <em>Test Campaign</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTestCampaign()
	 * @generated
	 */
	int TEST_CAMPAIGN = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__METRICS = 1;

	/**
	 * The feature id for the '<em><b>Included Attacks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__INCLUDED_ATTACKS = 2;

	/**
	 * The feature id for the '<em><b>Approach</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__APPROACH = 3;

	/**
	 * The feature id for the '<em><b>Performed Tests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__PERFORMED_TESTS = 4;

	/**
	 * The feature id for the '<em><b>Result Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__RESULT_SETS = 5;

	/**
	 * The feature id for the '<em><b>Default End Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__DEFAULT_END_TRIGGER = 6;

	/**
	 * The number of structural features of the '<em>Test Campaign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Test Campaign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl <em>Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTest()
	 * @generated
	 */
	int TEST = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__NAME = 0;

	/**
	 * The feature id for the '<em><b>Attacks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__ATTACKS = 1;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__METRICS = 2;

	/**
	 * The feature id for the '<em><b>End Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__END_TRIGGER = 3;

	/**
	 * The feature id for the '<em><b>Developed From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__DEVELOPED_FROM = 4;

	/**
	 * The feature id for the '<em><b>Parent Campaign</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__PARENT_CAMPAIGN = 5;

	/**
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.CampaignResultSetImpl <em>Campaign Result Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.CampaignResultSetImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getCampaignResultSet()
	 * @generated
	 */
	int CAMPAIGN_RESULT_SET = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMPAIGN_RESULT_SET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMPAIGN_RESULT_SET__STATUS = 1;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMPAIGN_RESULT_SET__RESULTS = 2;

	/**
	 * The number of structural features of the '<em>Campaign Result Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMPAIGN_RESULT_SET_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Campaign Result Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMPAIGN_RESULT_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.ExecutionEndTriggerImpl <em>Execution End Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.ExecutionEndTriggerImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getExecutionEndTrigger()
	 * @generated
	 */
	int EXECUTION_END_TRIGGER = 4;

	/**
	 * The number of structural features of the '<em>Execution End Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_END_TRIGGER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Execution End Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_END_TRIGGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TimeBasedEndImpl <em>Time Based End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TimeBasedEndImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTimeBasedEnd()
	 * @generated
	 */
	int TIME_BASED_END = 5;

	/**
	 * The feature id for the '<em><b>Time Limit Seconds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_BASED_END__TIME_LIMIT_SECONDS = EXECUTION_END_TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Time Based End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_BASED_END_FEATURE_COUNT = EXECUTION_END_TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Time Based End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_BASED_END_OPERATION_COUNT = EXECUTION_END_TRIGGER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestGenerationApproachImpl <em>Test Generation Approach</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestGenerationApproachImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTestGenerationApproach()
	 * @generated
	 */
	int TEST_GENERATION_APPROACH = 6;

	/**
	 * The number of structural features of the '<em>Test Generation Approach</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GENERATION_APPROACH_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Test Generation Approach</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GENERATION_APPROACH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.RandomTestGenerationImpl <em>Random Test Generation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.RandomTestGenerationImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getRandomTestGeneration()
	 * @generated
	 */
	int RANDOM_TEST_GENERATION = 7;

	/**
	 * The number of structural features of the '<em>Random Test Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TEST_GENERATION_FEATURE_COUNT = TEST_GENERATION_APPROACH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Random Test Generation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TEST_GENERATION_OPERATION_COUNT = TEST_GENERATION_APPROACH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.EvolutionaryAlgorithmImpl <em>Evolutionary Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.EvolutionaryAlgorithmImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getEvolutionaryAlgorithm()
	 * @generated
	 */
	int EVOLUTIONARY_ALGORITHM = 8;

	/**
	 * The number of structural features of the '<em>Evolutionary Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVOLUTIONARY_ALGORITHM_FEATURE_COUNT = TEST_GENERATION_APPROACH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Evolutionary Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVOLUTIONARY_ALGORITHM_OPERATION_COUNT = TEST_GENERATION_APPROACH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.NSGAEvolutionaryAlgorithmImpl <em>NSGA Evolutionary Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.NSGAEvolutionaryAlgorithmImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getNSGAEvolutionaryAlgorithm()
	 * @generated
	 */
	int NSGA_EVOLUTIONARY_ALGORITHM = 9;

	/**
	 * The feature id for the '<em><b>Population Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGA_EVOLUTIONARY_ALGORITHM__POPULATION_SIZE = EVOLUTIONARY_ALGORITHM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGA_EVOLUTIONARY_ALGORITHM__ITERATIONS = EVOLUTIONARY_ALGORITHM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>NSGA Evolutionary Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGA_EVOLUTIONARY_ALGORITHM_FEATURE_COUNT = EVOLUTIONARY_ALGORITHM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>NSGA Evolutionary Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NSGA_EVOLUTIONARY_ALGORITHM_OPERATION_COUNT = EVOLUTIONARY_ALGORITHM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ResultSetStatus <em>Result Set Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ResultSetStatus
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getResultSetStatus()
	 * @generated
	 */
	int RESULT_SET_STATUS = 10;


	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace <em>Testing Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Testing Space</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace
	 * @generated
	 */
	EClass getTestingSpace();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getName()
	 * @see #getTestingSpace()
	 * @generated
	 */
	EAttribute getTestingSpace_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getMetrics()
	 * @see #getTestingSpace()
	 * @generated
	 */
	EReference getTestingSpace_Metrics();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getPossibleAttacks <em>Possible Attacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possible Attacks</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getPossibleAttacks()
	 * @see #getTestingSpace()
	 * @generated
	 */
	EReference getTestingSpace_PossibleAttacks();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getCampaigns <em>Campaigns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Campaigns</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getCampaigns()
	 * @see #getTestingSpace()
	 * @generated
	 */
	EReference getTestingSpace_Campaigns();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getMrs <em>Mrs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mrs</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getMrs()
	 * @see #getTestingSpace()
	 * @generated
	 */
	EReference getTestingSpace_Mrs();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign <em>Test Campaign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Campaign</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign
	 * @generated
	 */
	EClass getTestCampaign();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getName()
	 * @see #getTestCampaign()
	 * @generated
	 */
	EAttribute getTestCampaign_Name();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Metrics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getMetrics()
	 * @see #getTestCampaign()
	 * @generated
	 */
	EReference getTestCampaign_Metrics();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getIncludedAttacks <em>Included Attacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Included Attacks</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getIncludedAttacks()
	 * @see #getTestCampaign()
	 * @generated
	 */
	EReference getTestCampaign_IncludedAttacks();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getApproach <em>Approach</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Approach</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getApproach()
	 * @see #getTestCampaign()
	 * @generated
	 */
	EReference getTestCampaign_Approach();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getPerformedTests <em>Performed Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Performed Tests</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getPerformedTests()
	 * @see #getTestCampaign()
	 * @generated
	 */
	EReference getTestCampaign_PerformedTests();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getResultSets <em>Result Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Result Sets</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getResultSets()
	 * @see #getTestCampaign()
	 * @generated
	 */
	EReference getTestCampaign_ResultSets();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getDefaultEndTrigger <em>Default End Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default End Trigger</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getDefaultEndTrigger()
	 * @see #getTestCampaign()
	 * @generated
	 */
	EReference getTestCampaign_DefaultEndTrigger();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test
	 * @generated
	 */
	EClass getTest();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getName()
	 * @see #getTest()
	 * @generated
	 */
	EAttribute getTest_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getAttacks <em>Attacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attacks</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getAttacks()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_Attacks();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getMetrics()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_Metrics();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getEndTrigger <em>End Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Trigger</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getEndTrigger()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_EndTrigger();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getDevelopedFrom <em>Developed From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Developed From</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getDevelopedFrom()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_DevelopedFrom();

	/**
	 * Returns the meta object for the container reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getParentCampaign <em>Parent Campaign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Campaign</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getParentCampaign()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_ParentCampaign();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet <em>Campaign Result Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Campaign Result Set</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet
	 * @generated
	 */
	EClass getCampaignResultSet();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet#getName()
	 * @see #getCampaignResultSet()
	 * @generated
	 */
	EAttribute getCampaignResultSet_Name();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet#getStatus()
	 * @see #getCampaignResultSet()
	 * @generated
	 */
	EAttribute getCampaignResultSet_Status();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Results</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet#getResults()
	 * @see #getCampaignResultSet()
	 * @generated
	 */
	EReference getCampaignResultSet_Results();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ExecutionEndTrigger <em>Execution End Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution End Trigger</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ExecutionEndTrigger
	 * @generated
	 */
	EClass getExecutionEndTrigger();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedEnd <em>Time Based End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Based End</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedEnd
	 * @generated
	 */
	EClass getTimeBasedEnd();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedEnd#getTimeLimitSeconds <em>Time Limit Seconds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Limit Seconds</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedEnd#getTimeLimitSeconds()
	 * @see #getTimeBasedEnd()
	 * @generated
	 */
	EAttribute getTimeBasedEnd_TimeLimitSeconds();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestGenerationApproach <em>Test Generation Approach</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Generation Approach</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestGenerationApproach
	 * @generated
	 */
	EClass getTestGenerationApproach();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.RandomTestGeneration <em>Random Test Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Test Generation</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.RandomTestGeneration
	 * @generated
	 */
	EClass getRandomTestGeneration();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.EvolutionaryAlgorithm <em>Evolutionary Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evolutionary Algorithm</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.EvolutionaryAlgorithm
	 * @generated
	 */
	EClass getEvolutionaryAlgorithm();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAEvolutionaryAlgorithm <em>NSGA Evolutionary Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NSGA Evolutionary Algorithm</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAEvolutionaryAlgorithm
	 * @generated
	 */
	EClass getNSGAEvolutionaryAlgorithm();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAEvolutionaryAlgorithm#getPopulationSize <em>Population Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population Size</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAEvolutionaryAlgorithm#getPopulationSize()
	 * @see #getNSGAEvolutionaryAlgorithm()
	 * @generated
	 */
	EAttribute getNSGAEvolutionaryAlgorithm_PopulationSize();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAEvolutionaryAlgorithm#getIterations <em>Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iterations</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAEvolutionaryAlgorithm#getIterations()
	 * @see #getNSGAEvolutionaryAlgorithm()
	 * @generated
	 */
	EAttribute getNSGAEvolutionaryAlgorithm_Iterations();

	/**
	 * Returns the meta object for enum '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ResultSetStatus <em>Result Set Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Result Set Status</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ResultSetStatus
	 * @generated
	 */
	EEnum getResultSetStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestingPackageFactory getTestingPackageFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl <em>Testing Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTestingSpace()
		 * @generated
		 */
		EClass TESTING_SPACE = eINSTANCE.getTestingSpace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESTING_SPACE__NAME = eINSTANCE.getTestingSpace_Name();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTING_SPACE__METRICS = eINSTANCE.getTestingSpace_Metrics();

		/**
		 * The meta object literal for the '<em><b>Possible Attacks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTING_SPACE__POSSIBLE_ATTACKS = eINSTANCE.getTestingSpace_PossibleAttacks();

		/**
		 * The meta object literal for the '<em><b>Campaigns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTING_SPACE__CAMPAIGNS = eINSTANCE.getTestingSpace_Campaigns();

		/**
		 * The meta object literal for the '<em><b>Mrs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTING_SPACE__MRS = eINSTANCE.getTestingSpace_Mrs();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl <em>Test Campaign</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTestCampaign()
		 * @generated
		 */
		EClass TEST_CAMPAIGN = eINSTANCE.getTestCampaign();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CAMPAIGN__NAME = eINSTANCE.getTestCampaign_Name();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CAMPAIGN__METRICS = eINSTANCE.getTestCampaign_Metrics();

		/**
		 * The meta object literal for the '<em><b>Included Attacks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CAMPAIGN__INCLUDED_ATTACKS = eINSTANCE.getTestCampaign_IncludedAttacks();

		/**
		 * The meta object literal for the '<em><b>Approach</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CAMPAIGN__APPROACH = eINSTANCE.getTestCampaign_Approach();

		/**
		 * The meta object literal for the '<em><b>Performed Tests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CAMPAIGN__PERFORMED_TESTS = eINSTANCE.getTestCampaign_PerformedTests();

		/**
		 * The meta object literal for the '<em><b>Result Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CAMPAIGN__RESULT_SETS = eINSTANCE.getTestCampaign_ResultSets();

		/**
		 * The meta object literal for the '<em><b>Default End Trigger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CAMPAIGN__DEFAULT_END_TRIGGER = eINSTANCE.getTestCampaign_DefaultEndTrigger();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl <em>Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTest()
		 * @generated
		 */
		EClass TEST = eINSTANCE.getTest();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST__NAME = eINSTANCE.getTest_Name();

		/**
		 * The meta object literal for the '<em><b>Attacks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__ATTACKS = eINSTANCE.getTest_Attacks();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__METRICS = eINSTANCE.getTest_Metrics();

		/**
		 * The meta object literal for the '<em><b>End Trigger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__END_TRIGGER = eINSTANCE.getTest_EndTrigger();

		/**
		 * The meta object literal for the '<em><b>Developed From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__DEVELOPED_FROM = eINSTANCE.getTest_DevelopedFrom();

		/**
		 * The meta object literal for the '<em><b>Parent Campaign</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__PARENT_CAMPAIGN = eINSTANCE.getTest_ParentCampaign();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.CampaignResultSetImpl <em>Campaign Result Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.CampaignResultSetImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getCampaignResultSet()
		 * @generated
		 */
		EClass CAMPAIGN_RESULT_SET = eINSTANCE.getCampaignResultSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMPAIGN_RESULT_SET__NAME = eINSTANCE.getCampaignResultSet_Name();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMPAIGN_RESULT_SET__STATUS = eINSTANCE.getCampaignResultSet_Status();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAMPAIGN_RESULT_SET__RESULTS = eINSTANCE.getCampaignResultSet_Results();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.ExecutionEndTriggerImpl <em>Execution End Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.ExecutionEndTriggerImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getExecutionEndTrigger()
		 * @generated
		 */
		EClass EXECUTION_END_TRIGGER = eINSTANCE.getExecutionEndTrigger();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TimeBasedEndImpl <em>Time Based End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TimeBasedEndImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTimeBasedEnd()
		 * @generated
		 */
		EClass TIME_BASED_END = eINSTANCE.getTimeBasedEnd();

		/**
		 * The meta object literal for the '<em><b>Time Limit Seconds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_BASED_END__TIME_LIMIT_SECONDS = eINSTANCE.getTimeBasedEnd_TimeLimitSeconds();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestGenerationApproachImpl <em>Test Generation Approach</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestGenerationApproachImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTestGenerationApproach()
		 * @generated
		 */
		EClass TEST_GENERATION_APPROACH = eINSTANCE.getTestGenerationApproach();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.RandomTestGenerationImpl <em>Random Test Generation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.RandomTestGenerationImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getRandomTestGeneration()
		 * @generated
		 */
		EClass RANDOM_TEST_GENERATION = eINSTANCE.getRandomTestGeneration();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.EvolutionaryAlgorithmImpl <em>Evolutionary Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.EvolutionaryAlgorithmImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getEvolutionaryAlgorithm()
		 * @generated
		 */
		EClass EVOLUTIONARY_ALGORITHM = eINSTANCE.getEvolutionaryAlgorithm();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.NSGAEvolutionaryAlgorithmImpl <em>NSGA Evolutionary Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.NSGAEvolutionaryAlgorithmImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getNSGAEvolutionaryAlgorithm()
		 * @generated
		 */
		EClass NSGA_EVOLUTIONARY_ALGORITHM = eINSTANCE.getNSGAEvolutionaryAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Population Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NSGA_EVOLUTIONARY_ALGORITHM__POPULATION_SIZE = eINSTANCE.getNSGAEvolutionaryAlgorithm_PopulationSize();

		/**
		 * The meta object literal for the '<em><b>Iterations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NSGA_EVOLUTIONARY_ALGORITHM__ITERATIONS = eINSTANCE.getNSGAEvolutionaryAlgorithm_Iterations();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ResultSetStatus <em>Result Set Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ResultSetStatus
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getResultSetStatus()
		 * @generated
		 */
		EEnum RESULT_SET_STATUS = eINSTANCE.getResultSetStatus();

	}

} //TestingPackagePackage
