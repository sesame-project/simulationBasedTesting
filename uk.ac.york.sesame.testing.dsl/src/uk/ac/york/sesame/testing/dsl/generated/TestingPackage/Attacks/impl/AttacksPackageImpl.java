/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.BlackholeNetworkAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CPULoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomOfflineAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DiskLoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ExternalResourceSet;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.FuzzTestingAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IOLoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MemoryLoadType;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.NetworkAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ProcessKillerStateAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ResourceAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ShutdownStateAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StateAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TimeTravelStateAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueSet;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.impl.ResultsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttacksPackageImpl extends EPackageImpl implements AttacksPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass offlineAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customOfflineAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackActivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackFixedTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionBasedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fuzzTestingAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentPropertyAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentSubPropertyAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topicAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomValueAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomValueFromSetAttackEClass = null;

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
	private EClass resourceAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass networkAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadResourceAttackEClass = null;

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
	private EClass shutdownStateAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeTravelStateAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processKillerStateAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blackholeNetworkAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass latencyNetworkAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packetLossNetworkAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleMessagesNetworkAttackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum offlineAttackTimeEEnum = null;

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
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AttacksPackageImpl() {
		super(eNS_URI, AttacksFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AttacksPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AttacksPackage init() {
		if (isInited) return (AttacksPackage)EPackage.Registry.INSTANCE.getEPackage(AttacksPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAttacksPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AttacksPackageImpl theAttacksPackage = registeredAttacksPackage instanceof AttacksPackageImpl ? (AttacksPackageImpl)registeredAttacksPackage : new AttacksPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TestingPackagePackage.eNS_URI);
		TestingPackagePackageImpl theTestingPackagePackage = (TestingPackagePackageImpl)(registeredPackage instanceof TestingPackagePackageImpl ? registeredPackage : TestingPackagePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(registeredPackage instanceof MetricsPackageImpl ? registeredPackage : MetricsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
		ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(registeredPackage instanceof ResultsPackageImpl ? registeredPackage : ResultsPackage.eINSTANCE);

		// Create package meta-data objects
		theAttacksPackage.createPackageContents();
		theTestingPackagePackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theResultsPackage.createPackageContents();

		// Initialize created meta-data
		theAttacksPackage.initializePackageContents();
		theTestingPackagePackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theResultsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAttacksPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AttacksPackage.eNS_URI, theAttacksPackage);
		return theAttacksPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttack() {
		return attackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttack_Name() {
		return (EAttribute)attackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttack_Priority() {
		return (EAttribute)attackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttack_AttackActivation() {
		return (EReference)attackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttack_MessagesFromAllComponenents() {
		return (EAttribute)attackEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttack_MessagesToAllComponenents() {
		return (EAttribute)attackEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttack_AllPublishingTopics() {
		return (EAttribute)attackEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttack_AllSubscribingTopics() {
		return (EAttribute)attackEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOfflineAttack() {
		return offlineAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOfflineAttack_AttackTime() {
		return (EAttribute)offlineAttackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomAttack() {
		return customAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomOfflineAttack() {
		return customOfflineAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackActivation() {
		return attackActivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackFixedTime() {
		return attackFixedTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackFixedTime_StartTime() {
		return (EAttribute)attackFixedTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttackFixedTime_EndTime() {
		return (EAttribute)attackFixedTimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionBased() {
		return conditionBasedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuzzTestingAttack() {
		return fuzzTestingAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentAttack() {
		return componentAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentPropertyAttack() {
		return componentPropertyAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentSubPropertyAttack() {
		return componentSubPropertyAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopicAttack() {
		return topicAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomValueAttack() {
		return randomValueAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomValueAttack_Seed() {
		return (EAttribute)randomValueAttackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomValueFromSetAttack() {
		return randomValueFromSetAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRandomValueFromSetAttack_ValueSet() {
		return (EReference)randomValueFromSetAttackEClass.getEStructuralFeatures().get(0);
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
	public EClass getResourceAttack() {
		return resourceAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateAttack() {
		return stateAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNetworkAttack() {
		return networkAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadResourceAttack() {
		return loadResourceAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoadResourceAttack_LoadType() {
		return (EReference)loadResourceAttackEClass.getEStructuralFeatures().get(0);
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
	public EClass getShutdownStateAttack() {
		return shutdownStateAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeTravelStateAttack() {
		return timeTravelStateAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeTravelStateAttack_TimeTravelValue() {
		return (EAttribute)timeTravelStateAttackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessKillerStateAttack() {
		return processKillerStateAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessKillerStateAttack_ProcessId() {
		return (EAttribute)processKillerStateAttackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlackholeNetworkAttack() {
		return blackholeNetworkAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLatencyNetworkAttack() {
		return latencyNetworkAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLatencyNetworkAttack_Latency() {
		return (EAttribute)latencyNetworkAttackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPacketLossNetworkAttack() {
		return packetLossNetworkAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPacketLossNetworkAttack_Frequency() {
		return (EAttribute)packetLossNetworkAttackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleMessagesNetworkAttack() {
		return multipleMessagesNetworkAttackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultipleMessagesNetworkAttack_HowManyClones() {
		return (EAttribute)multipleMessagesNetworkAttackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOfflineAttackTime() {
		return offlineAttackTimeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttacksFactory getAttacksFactory() {
		return (AttacksFactory)getEFactoryInstance();
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
		attackEClass = createEClass(ATTACK);
		createEAttribute(attackEClass, ATTACK__NAME);
		createEAttribute(attackEClass, ATTACK__PRIORITY);
		createEReference(attackEClass, ATTACK__ATTACK_ACTIVATION);
		createEAttribute(attackEClass, ATTACK__MESSAGES_FROM_ALL_COMPONENENTS);
		createEAttribute(attackEClass, ATTACK__MESSAGES_TO_ALL_COMPONENENTS);
		createEAttribute(attackEClass, ATTACK__ALL_PUBLISHING_TOPICS);
		createEAttribute(attackEClass, ATTACK__ALL_SUBSCRIBING_TOPICS);

		offlineAttackEClass = createEClass(OFFLINE_ATTACK);
		createEAttribute(offlineAttackEClass, OFFLINE_ATTACK__ATTACK_TIME);

		customAttackEClass = createEClass(CUSTOM_ATTACK);

		customOfflineAttackEClass = createEClass(CUSTOM_OFFLINE_ATTACK);

		attackActivationEClass = createEClass(ATTACK_ACTIVATION);

		attackFixedTimeEClass = createEClass(ATTACK_FIXED_TIME);
		createEAttribute(attackFixedTimeEClass, ATTACK_FIXED_TIME__START_TIME);
		createEAttribute(attackFixedTimeEClass, ATTACK_FIXED_TIME__END_TIME);

		conditionBasedEClass = createEClass(CONDITION_BASED);

		fuzzTestingAttackEClass = createEClass(FUZZ_TESTING_ATTACK);

		componentAttackEClass = createEClass(COMPONENT_ATTACK);

		componentPropertyAttackEClass = createEClass(COMPONENT_PROPERTY_ATTACK);

		componentSubPropertyAttackEClass = createEClass(COMPONENT_SUB_PROPERTY_ATTACK);

		topicAttackEClass = createEClass(TOPIC_ATTACK);

		randomValueAttackEClass = createEClass(RANDOM_VALUE_ATTACK);
		createEAttribute(randomValueAttackEClass, RANDOM_VALUE_ATTACK__SEED);

		randomValueFromSetAttackEClass = createEClass(RANDOM_VALUE_FROM_SET_ATTACK);
		createEReference(randomValueFromSetAttackEClass, RANDOM_VALUE_FROM_SET_ATTACK__VALUE_SET);

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

		resourceAttackEClass = createEClass(RESOURCE_ATTACK);

		stateAttackEClass = createEClass(STATE_ATTACK);

		networkAttackEClass = createEClass(NETWORK_ATTACK);

		loadResourceAttackEClass = createEClass(LOAD_RESOURCE_ATTACK);
		createEReference(loadResourceAttackEClass, LOAD_RESOURCE_ATTACK__LOAD_TYPE);

		loadTypeEClass = createEClass(LOAD_TYPE);
		createEAttribute(loadTypeEClass, LOAD_TYPE__MIN);
		createEAttribute(loadTypeEClass, LOAD_TYPE__MAX);

		cpuLoadTypeEClass = createEClass(CPU_LOAD_TYPE);

		memoryLoadTypeEClass = createEClass(MEMORY_LOAD_TYPE);

		ioLoadTypeEClass = createEClass(IO_LOAD_TYPE);

		diskLoadTypeEClass = createEClass(DISK_LOAD_TYPE);

		shutdownStateAttackEClass = createEClass(SHUTDOWN_STATE_ATTACK);

		timeTravelStateAttackEClass = createEClass(TIME_TRAVEL_STATE_ATTACK);
		createEAttribute(timeTravelStateAttackEClass, TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE);

		processKillerStateAttackEClass = createEClass(PROCESS_KILLER_STATE_ATTACK);
		createEAttribute(processKillerStateAttackEClass, PROCESS_KILLER_STATE_ATTACK__PROCESS_ID);

		blackholeNetworkAttackEClass = createEClass(BLACKHOLE_NETWORK_ATTACK);

		latencyNetworkAttackEClass = createEClass(LATENCY_NETWORK_ATTACK);
		createEAttribute(latencyNetworkAttackEClass, LATENCY_NETWORK_ATTACK__LATENCY);

		packetLossNetworkAttackEClass = createEClass(PACKET_LOSS_NETWORK_ATTACK);
		createEAttribute(packetLossNetworkAttackEClass, PACKET_LOSS_NETWORK_ATTACK__FREQUENCY);

		multipleMessagesNetworkAttackEClass = createEClass(MULTIPLE_MESSAGES_NETWORK_ATTACK);
		createEAttribute(multipleMessagesNetworkAttackEClass, MULTIPLE_MESSAGES_NETWORK_ATTACK__HOW_MANY_CLONES);

		// Create enums
		offlineAttackTimeEEnum = createEEnum(OFFLINE_ATTACK_TIME);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		offlineAttackEClass.getESuperTypes().add(this.getAttack());
		customAttackEClass.getESuperTypes().add(this.getAttack());
		customOfflineAttackEClass.getESuperTypes().add(this.getOfflineAttack());
		attackFixedTimeEClass.getESuperTypes().add(this.getAttackActivation());
		conditionBasedEClass.getESuperTypes().add(this.getAttackActivation());
		fuzzTestingAttackEClass.getESuperTypes().add(this.getAttack());
		componentAttackEClass.getESuperTypes().add(this.getFuzzTestingAttack());
		componentPropertyAttackEClass.getESuperTypes().add(this.getFuzzTestingAttack());
		componentSubPropertyAttackEClass.getESuperTypes().add(this.getFuzzTestingAttack());
		topicAttackEClass.getESuperTypes().add(this.getFuzzTestingAttack());
		randomValueAttackEClass.getESuperTypes().add(this.getComponentPropertyAttack());
		randomValueFromSetAttackEClass.getESuperTypes().add(this.getRandomValueAttack());
		valueRangeEClass.getESuperTypes().add(this.getValueSet());
		intRangeEClass.getESuperTypes().add(this.getValueRange());
		doubleRangeEClass.getESuperTypes().add(this.getValueRange());
		stringRangeEClass.getESuperTypes().add(this.getValueRange());
		externalResourceSetEClass.getESuperTypes().add(this.getValueSet());
		resourceAttackEClass.getESuperTypes().add(this.getAttack());
		stateAttackEClass.getESuperTypes().add(this.getAttack());
		networkAttackEClass.getESuperTypes().add(this.getAttack());
		loadResourceAttackEClass.getESuperTypes().add(this.getResourceAttack());
		cpuLoadTypeEClass.getESuperTypes().add(this.getLoadType());
		memoryLoadTypeEClass.getESuperTypes().add(this.getLoadType());
		ioLoadTypeEClass.getESuperTypes().add(this.getLoadType());
		diskLoadTypeEClass.getESuperTypes().add(this.getLoadType());
		shutdownStateAttackEClass.getESuperTypes().add(this.getStateAttack());
		timeTravelStateAttackEClass.getESuperTypes().add(this.getStateAttack());
		processKillerStateAttackEClass.getESuperTypes().add(this.getStateAttack());
		blackholeNetworkAttackEClass.getESuperTypes().add(this.getNetworkAttack());
		latencyNetworkAttackEClass.getESuperTypes().add(this.getNetworkAttack());
		packetLossNetworkAttackEClass.getESuperTypes().add(this.getNetworkAttack());
		multipleMessagesNetworkAttackEClass.getESuperTypes().add(this.getNetworkAttack());

		// Initialize classes, features, and operations; add parameters
		initEClass(attackEClass, Attack.class, "Attack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttack_Name(), ecorePackage.getEString(), "name", null, 0, 1, Attack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttack_Priority(), ecorePackage.getEInt(), "priority", null, 0, 1, Attack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttack_AttackActivation(), this.getAttackActivation(), null, "attackActivation", null, 0, -1, Attack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttack_MessagesFromAllComponenents(), ecorePackage.getEBoolean(), "messagesFromAllComponenents", "true", 0, 1, Attack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttack_MessagesToAllComponenents(), ecorePackage.getEBoolean(), "messagesToAllComponenents", "true", 0, 1, Attack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttack_AllPublishingTopics(), ecorePackage.getEBoolean(), "allPublishingTopics", "false", 0, 1, Attack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttack_AllSubscribingTopics(), ecorePackage.getEBoolean(), "allSubscribingTopics", "false", 0, 1, Attack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(offlineAttackEClass, OfflineAttack.class, "OfflineAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOfflineAttack_AttackTime(), this.getOfflineAttackTime(), "attackTime", null, 0, 1, OfflineAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customAttackEClass, CustomAttack.class, "CustomAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(customOfflineAttackEClass, CustomOfflineAttack.class, "CustomOfflineAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attackActivationEClass, AttackActivation.class, "AttackActivation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attackFixedTimeEClass, AttackFixedTime.class, "AttackFixedTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttackFixedTime_StartTime(), ecorePackage.getEDouble(), "startTime", null, 0, 1, AttackFixedTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttackFixedTime_EndTime(), ecorePackage.getEDouble(), "endTime", null, 0, 1, AttackFixedTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionBasedEClass, ConditionBased.class, "ConditionBased", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fuzzTestingAttackEClass, FuzzTestingAttack.class, "FuzzTestingAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentAttackEClass, ComponentAttack.class, "ComponentAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentPropertyAttackEClass, ComponentPropertyAttack.class, "ComponentPropertyAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentSubPropertyAttackEClass, ComponentSubPropertyAttack.class, "ComponentSubPropertyAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(topicAttackEClass, TopicAttack.class, "TopicAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(randomValueAttackEClass, RandomValueAttack.class, "RandomValueAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomValueAttack_Seed(), ecorePackage.getEInt(), "seed", null, 0, 1, RandomValueAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomValueFromSetAttackEClass, RandomValueFromSetAttack.class, "RandomValueFromSetAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRandomValueFromSetAttack_ValueSet(), this.getValueSet(), null, "valueSet", null, 0, -1, RandomValueFromSetAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(resourceAttackEClass, ResourceAttack.class, "ResourceAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateAttackEClass, StateAttack.class, "StateAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(networkAttackEClass, NetworkAttack.class, "NetworkAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadResourceAttackEClass, LoadResourceAttack.class, "LoadResourceAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoadResourceAttack_LoadType(), this.getLoadType(), null, "loadType", null, 1, 1, LoadResourceAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadTypeEClass, LoadType.class, "LoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoadType_Min(), ecorePackage.getEInt(), "min", null, 0, 1, LoadType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoadType_Max(), ecorePackage.getEInt(), "max", null, 0, 1, LoadType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpuLoadTypeEClass, CPULoadType.class, "CPULoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryLoadTypeEClass, MemoryLoadType.class, "MemoryLoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ioLoadTypeEClass, IOLoadType.class, "IOLoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(diskLoadTypeEClass, DiskLoadType.class, "DiskLoadType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shutdownStateAttackEClass, ShutdownStateAttack.class, "ShutdownStateAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timeTravelStateAttackEClass, TimeTravelStateAttack.class, "TimeTravelStateAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeTravelStateAttack_TimeTravelValue(), ecorePackage.getEInt(), "timeTravelValue", null, 0, 1, TimeTravelStateAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processKillerStateAttackEClass, ProcessKillerStateAttack.class, "ProcessKillerStateAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessKillerStateAttack_ProcessId(), ecorePackage.getEInt(), "processId", null, 0, 1, ProcessKillerStateAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blackholeNetworkAttackEClass, BlackholeNetworkAttack.class, "BlackholeNetworkAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(latencyNetworkAttackEClass, LatencyNetworkAttack.class, "LatencyNetworkAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLatencyNetworkAttack_Latency(), ecorePackage.getEDouble(), "latency", null, 0, 1, LatencyNetworkAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packetLossNetworkAttackEClass, PacketLossNetworkAttack.class, "PacketLossNetworkAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPacketLossNetworkAttack_Frequency(), ecorePackage.getEDouble(), "frequency", null, 0, 1, PacketLossNetworkAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleMessagesNetworkAttackEClass, MultipleMessagesNetworkAttack.class, "MultipleMessagesNetworkAttack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultipleMessagesNetworkAttack_HowManyClones(), ecorePackage.getEInt(), "howManyClones", null, 0, 1, MultipleMessagesNetworkAttack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(offlineAttackTimeEEnum, OfflineAttackTime.class, "OfflineAttackTime");
		addEEnumLiteral(offlineAttackTimeEEnum, OfflineAttackTime.PRE);
		addEEnumLiteral(offlineAttackTimeEEnum, OfflineAttackTime.POST);
	}

} //AttacksPackageImpl
