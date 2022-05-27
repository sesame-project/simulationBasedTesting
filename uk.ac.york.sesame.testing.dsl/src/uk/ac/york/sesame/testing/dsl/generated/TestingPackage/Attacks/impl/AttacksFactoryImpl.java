/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttacksFactoryImpl extends EFactoryImpl implements AttacksFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AttacksFactory init() {
		try {
			AttacksFactory theAttacksFactory = (AttacksFactory)EPackage.Registry.INSTANCE.getEFactory(AttacksPackage.eNS_URI);
			if (theAttacksFactory != null) {
				return theAttacksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AttacksFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttacksFactoryImpl() {
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
			case AttacksPackage.ATTACK: return createAttack();
			case AttacksPackage.OFFLINE_ATTACK: return createOfflineAttack();
			case AttacksPackage.CUSTOM_ATTACK: return createCustomAttack();
			case AttacksPackage.CUSTOM_OFFLINE_ATTACK: return createCustomOfflineAttack();
			case AttacksPackage.ATTACK_FIXED_TIME: return createAttackFixedTime();
			case AttacksPackage.CONDITION_BASED: return createConditionBased();
			case AttacksPackage.FUZZ_TESTING_ATTACK: return createFuzzTestingAttack();
			case AttacksPackage.COMPONENT_ATTACK: return createComponentAttack();
			case AttacksPackage.COMPONENT_PROPERTY_ATTACK: return createComponentPropertyAttack();
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK: return createComponentSubPropertyAttack();
			case AttacksPackage.TOPIC_ATTACK: return createTopicAttack();
			case AttacksPackage.RANDOM_VALUE_ATTACK: return createRandomValueAttack();
			case AttacksPackage.RANDOM_VALUE_FROM_SET_ATTACK: return createRandomValueFromSetAttack();
			case AttacksPackage.VALUE_SET: return createValueSet();
			case AttacksPackage.VALUE_RANGE: return createValueRange();
			case AttacksPackage.INT_RANGE: return createIntRange();
			case AttacksPackage.DOUBLE_RANGE: return createDoubleRange();
			case AttacksPackage.STRING_RANGE: return createStringRange();
			case AttacksPackage.EXTERNAL_RESOURCE_SET: return createExternalResourceSet();
			case AttacksPackage.RESOURCE_ATTACK: return createResourceAttack();
			case AttacksPackage.STATE_ATTACK: return createStateAttack();
			case AttacksPackage.NETWORK_ATTACK: return createNetworkAttack();
			case AttacksPackage.LOAD_RESOURCE_ATTACK: return createLoadResourceAttack();
			case AttacksPackage.LOAD_TYPE: return createLoadType();
			case AttacksPackage.CPU_LOAD_TYPE: return createCPULoadType();
			case AttacksPackage.MEMORY_LOAD_TYPE: return createMemoryLoadType();
			case AttacksPackage.IO_LOAD_TYPE: return createIOLoadType();
			case AttacksPackage.DISK_LOAD_TYPE: return createDiskLoadType();
			case AttacksPackage.SHUTDOWN_STATE_ATTACK: return createShutdownStateAttack();
			case AttacksPackage.TIME_TRAVEL_STATE_ATTACK: return createTimeTravelStateAttack();
			case AttacksPackage.PROCESS_KILLER_STATE_ATTACK: return createProcessKillerStateAttack();
			case AttacksPackage.BLACKHOLE_NETWORK_ATTACK: return createBlackholeNetworkAttack();
			case AttacksPackage.LATENCY_NETWORK_ATTACK: return createLatencyNetworkAttack();
			case AttacksPackage.PACKET_LOSS_NETWORK_ATTACK: return createPacketLossNetworkAttack();
			case AttacksPackage.MULTIPLE_MESSAGES_NETWORK_ATTACK: return createMultipleMessagesNetworkAttack();
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
			case AttacksPackage.OFFLINE_ATTACK_TIME:
				return createOfflineAttackTimeFromString(eDataType, initialValue);
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
			case AttacksPackage.OFFLINE_ATTACK_TIME:
				return convertOfflineAttackTimeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attack createAttack() {
		AttackImpl attack = new AttackImpl();
		return attack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OfflineAttack createOfflineAttack() {
		OfflineAttackImpl offlineAttack = new OfflineAttackImpl();
		return offlineAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomAttack createCustomAttack() {
		CustomAttackImpl customAttack = new CustomAttackImpl();
		return customAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomOfflineAttack createCustomOfflineAttack() {
		CustomOfflineAttackImpl customOfflineAttack = new CustomOfflineAttackImpl();
		return customOfflineAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackFixedTime createAttackFixedTime() {
		AttackFixedTimeImpl attackFixedTime = new AttackFixedTimeImpl();
		return attackFixedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionBased createConditionBased() {
		ConditionBasedImpl conditionBased = new ConditionBasedImpl();
		return conditionBased;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuzzTestingAttack createFuzzTestingAttack() {
		FuzzTestingAttackImpl fuzzTestingAttack = new FuzzTestingAttackImpl();
		return fuzzTestingAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentAttack createComponentAttack() {
		ComponentAttackImpl componentAttack = new ComponentAttackImpl();
		return componentAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPropertyAttack createComponentPropertyAttack() {
		ComponentPropertyAttackImpl componentPropertyAttack = new ComponentPropertyAttackImpl();
		return componentPropertyAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSubPropertyAttack createComponentSubPropertyAttack() {
		ComponentSubPropertyAttackImpl componentSubPropertyAttack = new ComponentSubPropertyAttackImpl();
		return componentSubPropertyAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopicAttack createTopicAttack() {
		TopicAttackImpl topicAttack = new TopicAttackImpl();
		return topicAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomValueAttack createRandomValueAttack() {
		RandomValueAttackImpl randomValueAttack = new RandomValueAttackImpl();
		return randomValueAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomValueFromSetAttack createRandomValueFromSetAttack() {
		RandomValueFromSetAttackImpl randomValueFromSetAttack = new RandomValueFromSetAttackImpl();
		return randomValueFromSetAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSet createValueSet() {
		ValueSetImpl valueSet = new ValueSetImpl();
		return valueSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueRange createValueRange() {
		ValueRangeImpl valueRange = new ValueRangeImpl();
		return valueRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntRange createIntRange() {
		IntRangeImpl intRange = new IntRangeImpl();
		return intRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleRange createDoubleRange() {
		DoubleRangeImpl doubleRange = new DoubleRangeImpl();
		return doubleRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringRange createStringRange() {
		StringRangeImpl stringRange = new StringRangeImpl();
		return stringRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalResourceSet createExternalResourceSet() {
		ExternalResourceSetImpl externalResourceSet = new ExternalResourceSetImpl();
		return externalResourceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAttack createResourceAttack() {
		ResourceAttackImpl resourceAttack = new ResourceAttackImpl();
		return resourceAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateAttack createStateAttack() {
		StateAttackImpl stateAttack = new StateAttackImpl();
		return stateAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetworkAttack createNetworkAttack() {
		NetworkAttackImpl networkAttack = new NetworkAttackImpl();
		return networkAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadResourceAttack createLoadResourceAttack() {
		LoadResourceAttackImpl loadResourceAttack = new LoadResourceAttackImpl();
		return loadResourceAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadType createLoadType() {
		LoadTypeImpl loadType = new LoadTypeImpl();
		return loadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CPULoadType createCPULoadType() {
		CPULoadTypeImpl cpuLoadType = new CPULoadTypeImpl();
		return cpuLoadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryLoadType createMemoryLoadType() {
		MemoryLoadTypeImpl memoryLoadType = new MemoryLoadTypeImpl();
		return memoryLoadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOLoadType createIOLoadType() {
		IOLoadTypeImpl ioLoadType = new IOLoadTypeImpl();
		return ioLoadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiskLoadType createDiskLoadType() {
		DiskLoadTypeImpl diskLoadType = new DiskLoadTypeImpl();
		return diskLoadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShutdownStateAttack createShutdownStateAttack() {
		ShutdownStateAttackImpl shutdownStateAttack = new ShutdownStateAttackImpl();
		return shutdownStateAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeTravelStateAttack createTimeTravelStateAttack() {
		TimeTravelStateAttackImpl timeTravelStateAttack = new TimeTravelStateAttackImpl();
		return timeTravelStateAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessKillerStateAttack createProcessKillerStateAttack() {
		ProcessKillerStateAttackImpl processKillerStateAttack = new ProcessKillerStateAttackImpl();
		return processKillerStateAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlackholeNetworkAttack createBlackholeNetworkAttack() {
		BlackholeNetworkAttackImpl blackholeNetworkAttack = new BlackholeNetworkAttackImpl();
		return blackholeNetworkAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LatencyNetworkAttack createLatencyNetworkAttack() {
		LatencyNetworkAttackImpl latencyNetworkAttack = new LatencyNetworkAttackImpl();
		return latencyNetworkAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketLossNetworkAttack createPacketLossNetworkAttack() {
		PacketLossNetworkAttackImpl packetLossNetworkAttack = new PacketLossNetworkAttackImpl();
		return packetLossNetworkAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleMessagesNetworkAttack createMultipleMessagesNetworkAttack() {
		MultipleMessagesNetworkAttackImpl multipleMessagesNetworkAttack = new MultipleMessagesNetworkAttackImpl();
		return multipleMessagesNetworkAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OfflineAttackTime createOfflineAttackTimeFromString(EDataType eDataType, String initialValue) {
		OfflineAttackTime result = OfflineAttackTime.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOfflineAttackTimeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttacksPackage getAttacksPackage() {
		return (AttacksPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AttacksPackage getPackage() {
		return AttacksPackage.eINSTANCE;
	}

} //AttacksFactoryImpl
