/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	 * The feature id for the '<em><b>Grammar Specfication</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE__GRAMMAR_SPECFICATION = 3;

	/**
	 * The feature id for the '<em><b>Campaigns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE__CAMPAIGNS = 4;

	/**
	 * The feature id for the '<em><b>Mrs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE__MRS = 5;

	/**
	 * The number of structural features of the '<em>Testing Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESTING_SPACE_FEATURE_COUNT = 6;

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
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__CONSTRAINTS = 3;

	/**
	 * The feature id for the '<em><b>Approach</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__APPROACH = 4;

	/**
	 * The feature id for the '<em><b>Performed Tests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN__PERFORMED_TESTS = 5;

	/**
	 * The number of structural features of the '<em>Test Campaign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CAMPAIGN_FEATURE_COUNT = 6;

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
	 * The feature id for the '<em><b>Attacks</b></em>' reference list.
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
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.GrammarConstraintImpl <em>Grammar Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.GrammarConstraintImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getGrammarConstraint()
	 * @generated
	 */
	int GRAMMAR_CONSTRAINT = 3;

	/**
	 * The number of structural features of the '<em>Grammar Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_CONSTRAINT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Grammar Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestGenerationApproachImpl <em>Test Generation Approach</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestGenerationApproachImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getTestGenerationApproach()
	 * @generated
	 */
	int TEST_GENERATION_APPROACH = 4;

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
	int RANDOM_TEST_GENERATION = 5;

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
	int EVOLUTIONARY_ALGORITHM = 6;

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
	int NSGA_EVOLUTIONARY_ALGORITHM = 7;

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
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.GrammarSpecificationImpl <em>Grammar Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.GrammarSpecificationImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getGrammarSpecification()
	 * @generated
	 */
	int GRAMMAR_SPECIFICATION = 8;

	/**
	 * The number of structural features of the '<em>Grammar Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Grammar Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_SPECIFICATION_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getGrammarSpecfication <em>Grammar Specfication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Grammar Specfication</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace#getGrammarSpecfication()
	 * @see #getTestingSpace()
	 * @generated
	 */
	EReference getTestingSpace_GrammarSpecfication();

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
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign#getConstraints()
	 * @see #getTestCampaign()
	 * @generated
	 */
	EReference getTestCampaign_Constraints();

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
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getAttacks <em>Attacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attacks</em>'.
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
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarConstraint <em>Grammar Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Constraint</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarConstraint
	 * @generated
	 */
	EClass getGrammarConstraint();

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
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpecification <em>Grammar Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Specification</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpecification
	 * @generated
	 */
	EClass getGrammarSpecification();

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
		 * The meta object literal for the '<em><b>Grammar Specfication</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESTING_SPACE__GRAMMAR_SPECFICATION = eINSTANCE.getTestingSpace_GrammarSpecfication();

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
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CAMPAIGN__CONSTRAINTS = eINSTANCE.getTestCampaign_Constraints();

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
		 * The meta object literal for the '<em><b>Attacks</b></em>' reference list feature.
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
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.GrammarConstraintImpl <em>Grammar Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.GrammarConstraintImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getGrammarConstraint()
		 * @generated
		 */
		EClass GRAMMAR_CONSTRAINT = eINSTANCE.getGrammarConstraint();

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
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.GrammarSpecificationImpl <em>Grammar Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.GrammarSpecificationImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl#getGrammarSpecification()
		 * @generated
		 */
		EClass GRAMMAR_SPECIFICATION = eINSTANCE.getGrammarSpecification();

	}

} //TestingPackagePackage
