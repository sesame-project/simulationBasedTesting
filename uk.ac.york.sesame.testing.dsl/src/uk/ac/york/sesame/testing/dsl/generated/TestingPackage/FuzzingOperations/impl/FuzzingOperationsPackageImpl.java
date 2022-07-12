/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.BlackholeNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.CPULoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ComponentOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ComponentPropertyOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ComponentSubPropertyOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ConditionBasedActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.CustomFuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.CustomOfflineFuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DiskLoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DoubleRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ExternalResourceSet;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzTestingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.IOLoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.IntRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.LatencyNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.LoadResourceOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.LoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.MemoryLoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.MultipleMessagesNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.NetworkFuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.OfflineFuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.OfflineOperationTime;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PacketLossNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ProcessKillerStateOperaton;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.RandomValueFromSetOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.RandomValueFuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ResourceFuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ShutdownStateOperaton;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.StateFuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.StringRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.TimeTravelStateOperaton;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ValueRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ValueSet;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.VariableOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSPackagePackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.impl.ResultsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.impl.StandardGrammarPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FuzzingOperationsPackageImpl extends EPackageImpl implements FuzzingOperationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fuzzingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass offlineFuzzingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customFuzzingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customOfflineFuzzingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedTimeActivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionBasedActivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fuzzTestingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentPropertyOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentSubPropertyOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomValueFuzzingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomValueFromSetOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalResourceSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceFuzzingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateFuzzingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass networkFuzzingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadResourceOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpuLoadTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryLoadTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ioLoadTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diskLoadTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shutdownStateOperatonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeTravelStateOperatonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processKillerStateOperatonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blackholeNetworkOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass latencyNetworkOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packetLossNetworkOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleMessagesNetworkOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum offlineOperationTimeEEnum = null;

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
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FuzzingOperationsPackageImpl() {
		super(eNS_URI, FuzzingOperationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FuzzingOperationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FuzzingOperationsPackage init() {
		if (isInited) return (FuzzingOperationsPackage)EPackage.Registry.INSTANCE.getEPackage(FuzzingOperationsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFuzzingOperationsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FuzzingOperationsPackageImpl theFuzzingOperationsPackage = registeredFuzzingOperationsPackage instanceof FuzzingOperationsPackageImpl ? (FuzzingOperationsPackageImpl)registeredFuzzingOperationsPackage : new FuzzingOperationsPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TestingPackagePackage.eNS_URI);
		TestingPackagePackageImpl theTestingPackagePackage = (TestingPackagePackageImpl)(registeredPackage instanceof TestingPackagePackageImpl ? registeredPackage : TestingPackagePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(registeredPackage instanceof MetricsPackageImpl ? registeredPackage : MetricsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
		ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(registeredPackage instanceof ResultsPackageImpl ? registeredPackage : ResultsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(StandardGrammarPackage.eNS_URI);
		StandardGrammarPackageImpl theStandardGrammarPackage = (StandardGrammarPackageImpl)(registeredPackage instanceof StandardGrammarPackageImpl ? registeredPackage : StandardGrammarPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MRSPackagePackage.eNS_URI);
		MRSPackagePackageImpl theMRSPackagePackage = (MRSPackagePackageImpl)(registeredPackage instanceof MRSPackagePackageImpl ? registeredPackage : MRSPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theFuzzingOperationsPackage.createPackageContents();
		theTestingPackagePackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theResultsPackage.createPackageContents();
		theStandardGrammarPackage.createPackageContents();
		theMRSPackagePackage.createPackageContents();

		// Initialize created meta-data
		theFuzzingOperationsPackage.initializePackageContents();
		theTestingPackagePackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theResultsPackage.initializePackageContents();
		theStandardGrammarPackage.initializePackageContents();
		theMRSPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFuzzingOperationsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FuzzingOperationsPackage.eNS_URI, theFuzzingOperationsPackage);
		return theFuzzingOperationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuzzingOperation() {
		return fuzzingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzingOperation_Name() {
		return (EAttribute)fuzzingOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzingOperation_Priority() {
		return (EAttribute)fuzzingOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_Activation() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_VariableToAffect() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzingOperation_MessagesFromAllComponenents() {
		return (EAttribute)fuzzingOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_FromNodes() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzingOperation_MessagesToAllComponenents() {
		return (EAttribute)fuzzingOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_ToNodes() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_NodeToFuzz() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzingOperation_AllPublishingVars() {
		return (EAttribute)fuzzingOperationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_PublishingVars() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFuzzingOperation_AllSubscribingVars() {
		return (EAttribute)fuzzingOperationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_SubscribingVars() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_FromTemplate() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuzzingOperation_ContainingTest() {
		return (EReference)fuzzingOperationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOfflineFuzzingOperation() {
		return offlineFuzzingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOfflineFuzzingOperation_OperationTime() {
		return (EAttribute)offlineFuzzingOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomFuzzingOperation() {
		return customFuzzingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomOfflineFuzzingOperation() {
		return customOfflineFuzzingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivation() {
		return activationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedTimeActivation() {
		return fixedTimeActivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedTimeActivation_StartTime() {
		return (EAttribute)fixedTimeActivationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedTimeActivation_EndTime() {
		return (EAttribute)fixedTimeActivationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionBasedActivation() {
		return conditionBasedActivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionBasedActivation_Starting() {
		return (EReference)conditionBasedActivationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionBasedActivation_Ending() {
		return (EReference)conditionBasedActivationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionBasedActivation_MaximumActivations() {
		return (EAttribute)conditionBasedActivationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuzzTestingOperation() {
		return fuzzTestingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentOperation() {
		return componentOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentPropertyOperation() {
		return componentPropertyOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentPropertyOperation_PropertyToAffect() {
		return (EReference)componentPropertyOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentSubPropertyOperation() {
		return componentSubPropertyOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentSubPropertyOperation_PropertyToAffect() {
		return (EReference)componentSubPropertyOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentSubPropertyOperation_SubProperty() {
		return (EReference)componentSubPropertyOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableOperation() {
		return variableOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableOperation_SubParameters() {
		return (EReference)variableOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomValueFuzzingOperation() {
		return randomValueFuzzingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomValueFuzzingOperation_Seed() {
		return (EAttribute)randomValueFuzzingOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomValueFromSetOperation() {
		return randomValueFromSetOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRandomValueFromSetOperation_ValueSet() {
		return (EReference)randomValueFromSetOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueSet() {
		return valueSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueRange() {
		return valueRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueRange_PropertyName() {
		return (EAttribute)valueRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntRange() {
		return intRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntRange_LowerBound() {
		return (EAttribute)intRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntRange_UpperBound() {
		return (EAttribute)intRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleRange() {
		return doubleRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRange_LowerBound() {
		return (EAttribute)doubleRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRange_UpperBound() {
		return (EAttribute)doubleRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringRange() {
		return stringRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringRange_LowerBound() {
		return (EAttribute)stringRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringRange_UpperBound() {
		return (EAttribute)stringRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalResourceSet() {
		return externalResourceSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalResourceSet_Location() {
		return (EAttribute)externalResourceSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceFuzzingOperation() {
		return resourceFuzzingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateFuzzingOperation() {
		return stateFuzzingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNetworkFuzzingOperation() {
		return networkFuzzingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadResourceOperation() {
		return loadResourceOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadResourceOperation_LoadType() {
		return (EReference)loadResourceOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadType() {
		return loadTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadType_Min() {
		return (EAttribute)loadTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadType_Max() {
		return (EAttribute)loadTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPULoadType() {
		return cpuLoadTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryLoadType() {
		return memoryLoadTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIOLoadType() {
		return ioLoadTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiskLoadType() {
		return diskLoadTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShutdownStateOperaton() {
		return shutdownStateOperatonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeTravelStateOperaton() {
		return timeTravelStateOperatonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeTravelStateOperaton_TimeTravelValue() {
		return (EReference)timeTravelStateOperatonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessKillerStateOperaton() {
		return processKillerStateOperatonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessKillerStateOperaton_ProcessId() {
		return (EAttribute)processKillerStateOperatonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlackholeNetworkOperation() {
		return blackholeNetworkOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLatencyNetworkOperation() {
		return latencyNetworkOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLatencyNetworkOperation_Latency() {
		return (EReference)latencyNetworkOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPacketLossNetworkOperation() {
		return packetLossNetworkOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPacketLossNetworkOperation_Frequency() {
		return (EReference)packetLossNetworkOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleMessagesNetworkOperation() {
		return multipleMessagesNetworkOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultipleMessagesNetworkOperation_HowManyClones() {
		return (EReference)multipleMessagesNetworkOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOfflineOperationTime() {
		return offlineOperationTimeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuzzingOperationsFactory getFuzzingOperationsFactory() {
		return (FuzzingOperationsFactory)getEFactoryInstance();
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
		fuzzingOperationEClass = createEClass(FUZZING_OPERATION);
		createEAttribute(fuzzingOperationEClass, FUZZING_OPERATION__NAME);
		createEAttribute(fuzzingOperationEClass, FUZZING_OPERATION__PRIORITY);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__ACTIVATION);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__VARIABLE_TO_AFFECT);
		createEAttribute(fuzzingOperationEClass, FUZZING_OPERATION__MESSAGES_FROM_ALL_COMPONENENTS);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__FROM_NODES);
		createEAttribute(fuzzingOperationEClass, FUZZING_OPERATION__MESSAGES_TO_ALL_COMPONENENTS);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__TO_NODES);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__NODE_TO_FUZZ);
		createEAttribute(fuzzingOperationEClass, FUZZING_OPERATION__ALL_PUBLISHING_VARS);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__PUBLISHING_VARS);
		createEAttribute(fuzzingOperationEClass, FUZZING_OPERATION__ALL_SUBSCRIBING_VARS);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__SUBSCRIBING_VARS);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__FROM_TEMPLATE);
		createEReference(fuzzingOperationEClass, FUZZING_OPERATION__CONTAINING_TEST);

		offlineFuzzingOperationEClass = createEClass(OFFLINE_FUZZING_OPERATION);
		createEAttribute(offlineFuzzingOperationEClass, OFFLINE_FUZZING_OPERATION__OPERATION_TIME);

		customFuzzingOperationEClass = createEClass(CUSTOM_FUZZING_OPERATION);

		customOfflineFuzzingOperationEClass = createEClass(CUSTOM_OFFLINE_FUZZING_OPERATION);

		activationEClass = createEClass(ACTIVATION);

		fixedTimeActivationEClass = createEClass(FIXED_TIME_ACTIVATION);
		createEAttribute(fixedTimeActivationEClass, FIXED_TIME_ACTIVATION__START_TIME);
		createEAttribute(fixedTimeActivationEClass, FIXED_TIME_ACTIVATION__END_TIME);

		conditionBasedActivationEClass = createEClass(CONDITION_BASED_ACTIVATION);
		createEReference(conditionBasedActivationEClass, CONDITION_BASED_ACTIVATION__STARTING);
		createEReference(conditionBasedActivationEClass, CONDITION_BASED_ACTIVATION__ENDING);
		createEAttribute(conditionBasedActivationEClass, CONDITION_BASED_ACTIVATION__MAXIMUM_ACTIVATIONS);

		fuzzTestingOperationEClass = createEClass(FUZZ_TESTING_OPERATION);

		componentOperationEClass = createEClass(COMPONENT_OPERATION);

		componentPropertyOperationEClass = createEClass(COMPONENT_PROPERTY_OPERATION);
		createEReference(componentPropertyOperationEClass, COMPONENT_PROPERTY_OPERATION__PROPERTY_TO_AFFECT);

		componentSubPropertyOperationEClass = createEClass(COMPONENT_SUB_PROPERTY_OPERATION);
		createEReference(componentSubPropertyOperationEClass, COMPONENT_SUB_PROPERTY_OPERATION__PROPERTY_TO_AFFECT);
		createEReference(componentSubPropertyOperationEClass, COMPONENT_SUB_PROPERTY_OPERATION__SUB_PROPERTY);

		variableOperationEClass = createEClass(VARIABLE_OPERATION);
		createEReference(variableOperationEClass, VARIABLE_OPERATION__SUB_PARAMETERS);

		randomValueFuzzingOperationEClass = createEClass(RANDOM_VALUE_FUZZING_OPERATION);
		createEAttribute(randomValueFuzzingOperationEClass, RANDOM_VALUE_FUZZING_OPERATION__SEED);

		randomValueFromSetOperationEClass = createEClass(RANDOM_VALUE_FROM_SET_OPERATION);
		createEReference(randomValueFromSetOperationEClass, RANDOM_VALUE_FROM_SET_OPERATION__VALUE_SET);

		valueSetEClass = createEClass(VALUE_SET);

		valueRangeEClass = createEClass(VALUE_RANGE);
		createEAttribute(valueRangeEClass, VALUE_RANGE__PROPERTY_NAME);

		intRangeEClass = createEClass(INT_RANGE);
		createEAttribute(intRangeEClass, INT_RANGE__LOWER_BOUND);
		createEAttribute(intRangeEClass, INT_RANGE__UPPER_BOUND);

		doubleRangeEClass = createEClass(DOUBLE_RANGE);
		createEAttribute(doubleRangeEClass, DOUBLE_RANGE__LOWER_BOUND);
		createEAttribute(doubleRangeEClass, DOUBLE_RANGE__UPPER_BOUND);

		stringRangeEClass = createEClass(STRING_RANGE);
		createEAttribute(stringRangeEClass, STRING_RANGE__LOWER_BOUND);
		createEAttribute(stringRangeEClass, STRING_RANGE__UPPER_BOUND);

		externalResourceSetEClass = createEClass(EXTERNAL_RESOURCE_SET);
		createEAttribute(externalResourceSetEClass, EXTERNAL_RESOURCE_SET__LOCATION);

		resourceFuzzingOperationEClass = createEClass(RESOURCE_FUZZING_OPERATION);

		stateFuzzingOperationEClass = createEClass(STATE_FUZZING_OPERATION);

		networkFuzzingOperationEClass = createEClass(NETWORK_FUZZING_OPERATION);

		loadResourceOperationEClass = createEClass(LOAD_RESOURCE_OPERATION);
		createEReference(loadResourceOperationEClass, LOAD_RESOURCE_OPERATION__LOAD_TYPE);

		loadTypeEClass = createEClass(LOAD_TYPE);
		createEAttribute(loadTypeEClass, LOAD_TYPE__MIN);
		createEAttribute(loadTypeEClass, LOAD_TYPE__MAX);

		cpuLoadTypeEClass = createEClass(CPU_LOAD_TYPE);

		memoryLoadTypeEClass = createEClass(MEMORY_LOAD_TYPE);

		ioLoadTypeEClass = createEClass(IO_LOAD_TYPE);

		diskLoadTypeEClass = createEClass(DISK_LOAD_TYPE);

		shutdownStateOperatonEClass = createEClass(SHUTDOWN_STATE_OPERATON);

		timeTravelStateOperatonEClass = createEClass(TIME_TRAVEL_STATE_OPERATON);
		createEReference(timeTravelStateOperatonEClass, TIME_TRAVEL_STATE_OPERATON__TIME_TRAVEL_VALUE);

		processKillerStateOperatonEClass = createEClass(PROCESS_KILLER_STATE_OPERATON);
		createEAttribute(processKillerStateOperatonEClass, PROCESS_KILLER_STATE_OPERATON__PROCESS_ID);

		blackholeNetworkOperationEClass = createEClass(BLACKHOLE_NETWORK_OPERATION);

		latencyNetworkOperationEClass = createEClass(LATENCY_NETWORK_OPERATION);
		createEReference(latencyNetworkOperationEClass, LATENCY_NETWORK_OPERATION__LATENCY);

		packetLossNetworkOperationEClass = createEClass(PACKET_LOSS_NETWORK_OPERATION);
		createEReference(packetLossNetworkOperationEClass, PACKET_LOSS_NETWORK_OPERATION__FREQUENCY);

		multipleMessagesNetworkOperationEClass = createEClass(MULTIPLE_MESSAGES_NETWORK_OPERATION);
		createEReference(multipleMessagesNetworkOperationEClass, MULTIPLE_MESSAGES_NETWORK_OPERATION__HOW_MANY_CLONES);

		// Create enums
		offlineOperationTimeEEnum = createEEnum(OFFLINE_OPERATION_TIME);
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
		MRSPackagePackage theMRSPackagePackage = (MRSPackagePackage)EPackage.Registry.INSTANCE.getEPackage(MRSPackagePackage.eNS_URI);
		TestingPackagePackage theTestingPackagePackage = (TestingPackagePackage)EPackage.Registry.INSTANCE.getEPackage(TestingPackagePackage.eNS_URI);
		StandardGrammarPackage theStandardGrammarPackage = (StandardGrammarPackage)EPackage.Registry.INSTANCE.getEPackage(StandardGrammarPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		offlineFuzzingOperationEClass.getESuperTypes().add(this.getFuzzingOperation());
		customFuzzingOperationEClass.getESuperTypes().add(this.getFuzzingOperation());
		customOfflineFuzzingOperationEClass.getESuperTypes().add(this.getOfflineFuzzingOperation());
		fixedTimeActivationEClass.getESuperTypes().add(this.getActivation());
		conditionBasedActivationEClass.getESuperTypes().add(this.getActivation());
		fuzzTestingOperationEClass.getESuperTypes().add(this.getFuzzingOperation());
		componentOperationEClass.getESuperTypes().add(this.getFuzzTestingOperation());
		componentPropertyOperationEClass.getESuperTypes().add(this.getFuzzTestingOperation());
		componentSubPropertyOperationEClass.getESuperTypes().add(this.getFuzzTestingOperation());
		variableOperationEClass.getESuperTypes().add(this.getFuzzTestingOperation());
		randomValueFuzzingOperationEClass.getESuperTypes().add(this.getComponentOperation());
		randomValueFromSetOperationEClass.getESuperTypes().add(this.getRandomValueFuzzingOperation());
		valueRangeEClass.getESuperTypes().add(this.getValueSet());
		intRangeEClass.getESuperTypes().add(this.getValueRange());
		doubleRangeEClass.getESuperTypes().add(this.getValueRange());
		stringRangeEClass.getESuperTypes().add(this.getValueRange());
		externalResourceSetEClass.getESuperTypes().add(this.getValueSet());
		resourceFuzzingOperationEClass.getESuperTypes().add(this.getFuzzingOperation());
		stateFuzzingOperationEClass.getESuperTypes().add(this.getFuzzingOperation());
		networkFuzzingOperationEClass.getESuperTypes().add(this.getFuzzingOperation());
		loadResourceOperationEClass.getESuperTypes().add(this.getResourceFuzzingOperation());
		cpuLoadTypeEClass.getESuperTypes().add(this.getLoadType());
		memoryLoadTypeEClass.getESuperTypes().add(this.getLoadType());
		ioLoadTypeEClass.getESuperTypes().add(this.getLoadType());
		diskLoadTypeEClass.getESuperTypes().add(this.getLoadType());
		shutdownStateOperatonEClass.getESuperTypes().add(this.getStateFuzzingOperation());
		timeTravelStateOperatonEClass.getESuperTypes().add(this.getStateFuzzingOperation());
		processKillerStateOperatonEClass.getESuperTypes().add(this.getStateFuzzingOperation());
		blackholeNetworkOperationEClass.getESuperTypes().add(this.getNetworkFuzzingOperation());
		latencyNetworkOperationEClass.getESuperTypes().add(this.getNetworkFuzzingOperation());
		packetLossNetworkOperationEClass.getESuperTypes().add(this.getNetworkFuzzingOperation());
		multipleMessagesNetworkOperationEClass.getESuperTypes().add(this.getNetworkFuzzingOperation());

		// Initialize classes, features, and operations; add parameters
		initEClass(fuzzingOperationEClass, FuzzingOperation.class, "FuzzingOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFuzzingOperation_Name(), ecorePackage.getEString(), "name", null, 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzingOperation_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_Activation(), this.getActivation(), null, "activation", null, 1, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_VariableToAffect(), theMRSPackagePackage.getVariable(), null, "variableToAffect", null, 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzingOperation_MessagesFromAllComponenents(), ecorePackage.getEBoolean(), "messagesFromAllComponenents", "true", 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_FromNodes(), theMRSPackagePackage.getNode(), null, "fromNodes", null, 0, -1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzingOperation_MessagesToAllComponenents(), ecorePackage.getEBoolean(), "messagesToAllComponenents", "true", 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_ToNodes(), theMRSPackagePackage.getNode(), null, "toNodes", null, 0, -1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_NodeToFuzz(), theMRSPackagePackage.getNode(), null, "nodeToFuzz", null, 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzingOperation_AllPublishingVars(), ecorePackage.getEBoolean(), "allPublishingVars", "false", 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_PublishingVars(), theMRSPackagePackage.getVariable(), null, "publishingVars", null, 0, -1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFuzzingOperation_AllSubscribingVars(), ecorePackage.getEBoolean(), "allSubscribingVars", "false", 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_SubscribingVars(), theMRSPackagePackage.getVariable(), null, "subscribingVars", null, 0, -1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_FromTemplate(), this.getFuzzingOperation(), null, "fromTemplate", null, 0, 1, FuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuzzingOperation_ContainingTest(), theTestingPackagePackage.getTest(), theTestingPackagePackage.getTest_Operations(), "containingTest", null, 0, 1, FuzzingOperation.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(offlineFuzzingOperationEClass, OfflineFuzzingOperation.class, "OfflineFuzzingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOfflineFuzzingOperation_OperationTime(), this.getOfflineOperationTime(), "operationTime", null, 0, 1, OfflineFuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customFuzzingOperationEClass, CustomFuzzingOperation.class, "CustomFuzzingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(customOfflineFuzzingOperationEClass, CustomOfflineFuzzingOperation.class, "CustomOfflineFuzzingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activationEClass, Activation.class, "Activation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fixedTimeActivationEClass, FixedTimeActivation.class, "FixedTimeActivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedTimeActivation_StartTime(), ecorePackage.getEDouble(), "startTime", null, 0, 1, FixedTimeActivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFixedTimeActivation_EndTime(), ecorePackage.getEDouble(), "endTime", null, 0, 1, FixedTimeActivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionBasedActivationEClass, ConditionBasedActivation.class, "ConditionBasedActivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionBasedActivation_Starting(), theStandardGrammarPackage.getCondition(), null, "starting", null, 0, 1, ConditionBasedActivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionBasedActivation_Ending(), theStandardGrammarPackage.getCondition(), null, "ending", null, 0, 1, ConditionBasedActivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionBasedActivation_MaximumActivations(), ecorePackage.getEInt(), "maximumActivations", "1", 0, 1, ConditionBasedActivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fuzzTestingOperationEClass, FuzzTestingOperation.class, "FuzzTestingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentOperationEClass, ComponentOperation.class, "ComponentOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentPropertyOperationEClass, ComponentPropertyOperation.class, "ComponentPropertyOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentPropertyOperation_PropertyToAffect(), theMRSPackagePackage.getComponentProperty(), null, "propertyToAffect", null, 0, 1, ComponentPropertyOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentSubPropertyOperationEClass, ComponentSubPropertyOperation.class, "ComponentSubPropertyOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentSubPropertyOperation_PropertyToAffect(), theMRSPackagePackage.getComponentProperty(), null, "propertyToAffect", null, 0, 1, ComponentSubPropertyOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentSubPropertyOperation_SubProperty(), theMRSPackagePackage.getType(), null, "subProperty", null, 0, 1, ComponentSubPropertyOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableOperationEClass, VariableOperation.class, "VariableOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableOperation_SubParameters(), theMRSPackagePackage.getParameter(), null, "subParameters", null, 0, -1, VariableOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomValueFuzzingOperationEClass, RandomValueFuzzingOperation.class, "RandomValueFuzzingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomValueFuzzingOperation_Seed(), ecorePackage.getEInt(), "seed", null, 0, 1, RandomValueFuzzingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomValueFromSetOperationEClass, RandomValueFromSetOperation.class, "RandomValueFromSetOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRandomValueFromSetOperation_ValueSet(), this.getValueSet(), null, "valueSet", null, 0, -1, RandomValueFromSetOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueSetEClass, ValueSet.class, "ValueSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueRangeEClass, ValueRange.class, "ValueRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueRange_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, ValueRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intRangeEClass, IntRange.class, "IntRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntRange_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 0, 1, IntRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntRange_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 0, 1, IntRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleRangeEClass, DoubleRange.class, "DoubleRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleRange_LowerBound(), ecorePackage.getEDouble(), "lowerBound", null, 0, 1, DoubleRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDoubleRange_UpperBound(), ecorePackage.getEDouble(), "upperBound", null, 0, 1, DoubleRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringRangeEClass, StringRange.class, "StringRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringRange_LowerBound(), ecorePackage.getEString(), "lowerBound", null, 0, 1, StringRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringRange_UpperBound(), ecorePackage.getEString(), "upperBound", null, 0, 1, StringRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalResourceSetEClass, ExternalResourceSet.class, "ExternalResourceSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalResourceSet_Location(), ecorePackage.getEString(), "location", null, 0, 1, ExternalResourceSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceFuzzingOperationEClass, ResourceFuzzingOperation.class, "ResourceFuzzingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateFuzzingOperationEClass, StateFuzzingOperation.class, "StateFuzzingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(networkFuzzingOperationEClass, NetworkFuzzingOperation.class, "NetworkFuzzingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadResourceOperationEClass, LoadResourceOperation.class, "LoadResourceOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoadResourceOperation_LoadType(), this.getLoadType(), null, "loadType", null, 1, 1, LoadResourceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadTypeEClass, LoadType.class, "LoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoadType_Min(), ecorePackage.getEInt(), "min", null, 0, 1, LoadType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadType_Max(), ecorePackage.getEInt(), "max", null, 0, 1, LoadType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpuLoadTypeEClass, CPULoadType.class, "CPULoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryLoadTypeEClass, MemoryLoadType.class, "MemoryLoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ioLoadTypeEClass, IOLoadType.class, "IOLoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diskLoadTypeEClass, DiskLoadType.class, "DiskLoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shutdownStateOperatonEClass, ShutdownStateOperaton.class, "ShutdownStateOperaton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timeTravelStateOperatonEClass, TimeTravelStateOperaton.class, "TimeTravelStateOperaton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeTravelStateOperaton_TimeTravelValue(), this.getDoubleRange(), null, "timeTravelValue", null, 1, 1, TimeTravelStateOperaton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processKillerStateOperatonEClass, ProcessKillerStateOperaton.class, "ProcessKillerStateOperaton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessKillerStateOperaton_ProcessId(), ecorePackage.getEInt(), "processId", null, 0, 1, ProcessKillerStateOperaton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blackholeNetworkOperationEClass, BlackholeNetworkOperation.class, "BlackholeNetworkOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(latencyNetworkOperationEClass, LatencyNetworkOperation.class, "LatencyNetworkOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLatencyNetworkOperation_Latency(), this.getDoubleRange(), null, "latency", null, 1, 1, LatencyNetworkOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packetLossNetworkOperationEClass, PacketLossNetworkOperation.class, "PacketLossNetworkOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPacketLossNetworkOperation_Frequency(), this.getDoubleRange(), null, "frequency", null, 1, 1, PacketLossNetworkOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleMessagesNetworkOperationEClass, MultipleMessagesNetworkOperation.class, "MultipleMessagesNetworkOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultipleMessagesNetworkOperation_HowManyClones(), this.getIntRange(), null, "howManyClones", null, 1, 1, MultipleMessagesNetworkOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(offlineOperationTimeEEnum, OfflineOperationTime.class, "OfflineOperationTime");
		addEEnumLiteral(offlineOperationTimeEEnum, OfflineOperationTime.PRE);
		addEEnumLiteral(offlineOperationTimeEEnum, OfflineOperationTime.POST);
	}

} //FuzzingOperationsPackageImpl
