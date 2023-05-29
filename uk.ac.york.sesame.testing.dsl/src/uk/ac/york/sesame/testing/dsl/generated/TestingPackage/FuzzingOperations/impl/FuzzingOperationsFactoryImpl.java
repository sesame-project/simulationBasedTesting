/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FuzzingOperationsFactoryImpl extends EFactoryImpl implements FuzzingOperationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FuzzingOperationsFactory init() {
		try {
			FuzzingOperationsFactory theFuzzingOperationsFactory = (FuzzingOperationsFactory)EPackage.Registry.INSTANCE.getEFactory(FuzzingOperationsPackage.eNS_URI);
			if (theFuzzingOperationsFactory != null) {
				return theFuzzingOperationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FuzzingOperationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuzzingOperationsFactoryImpl() {
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
			case FuzzingOperationsPackage.OFFLINE_FUZZING_OPERATION: return createOfflineFuzzingOperation();
			case FuzzingOperationsPackage.CUSTOM_FUZZING_OPERATION: return createCustomFuzzingOperation();
			case FuzzingOperationsPackage.CUSTOM_OFFLINE_FUZZING_OPERATION: return createCustomOfflineFuzzingOperation();
			case FuzzingOperationsPackage.FIXED_TIME_ACTIVATION: return createFixedTimeActivation();
			case FuzzingOperationsPackage.CONDITION_BASED_ACTIVATION: return createConditionBasedActivation();
			case FuzzingOperationsPackage.CONDITION_BASED_TIME_LIMITED: return createConditionBasedTimeLimited();
			case FuzzingOperationsPackage.FUZZ_TESTING_OPERATION: return createFuzzTestingOperation();
			case FuzzingOperationsPackage.COMPONENT_OPERATION: return createComponentOperation();
			case FuzzingOperationsPackage.COMPONENT_PROPERTY_OPERATION: return createComponentPropertyOperation();
			case FuzzingOperationsPackage.COMPONENT_SUB_PROPERTY_OPERATION: return createComponentSubPropertyOperation();
			case FuzzingOperationsPackage.VARIABLE_OPERATION: return createVariableOperation();
			case FuzzingOperationsPackage.RANDOM_VALUE_FUZZING_OPERATION: return createRandomValueFuzzingOperation();
			case FuzzingOperationsPackage.RANDOM_VALUE_FROM_SET_OPERATION: return createRandomValueFromSetOperation();
			case FuzzingOperationsPackage.VALUE_SET: return createValueSet();
			case FuzzingOperationsPackage.INT_RANGE: return createIntRange();
			case FuzzingOperationsPackage.DOUBLE_RANGE: return createDoubleRange();
			case FuzzingOperationsPackage.POINT: return createPoint();
			case FuzzingOperationsPackage.POINT_RANGE: return createPointRange();
			case FuzzingOperationsPackage.STRING_SET: return createStringSet();
			case FuzzingOperationsPackage.EXTERNAL_RESOURCE_SET: return createExternalResourceSet();
			case FuzzingOperationsPackage.RESOURCE_FUZZING_OPERATION: return createResourceFuzzingOperation();
			case FuzzingOperationsPackage.STATE_FUZZING_OPERATION: return createStateFuzzingOperation();
			case FuzzingOperationsPackage.NETWORK_FUZZING_OPERATION: return createNetworkFuzzingOperation();
			case FuzzingOperationsPackage.LOAD_RESOURCE_OPERATION: return createLoadResourceOperation();
			case FuzzingOperationsPackage.LOAD_TYPE: return createLoadType();
			case FuzzingOperationsPackage.CPU_LOAD_TYPE: return createCPULoadType();
			case FuzzingOperationsPackage.MEMORY_LOAD_TYPE: return createMemoryLoadType();
			case FuzzingOperationsPackage.IO_LOAD_TYPE: return createIOLoadType();
			case FuzzingOperationsPackage.DISK_LOAD_TYPE: return createDiskLoadType();
			case FuzzingOperationsPackage.SHUTDOWN_STATE_OPERATON: return createShutdownStateOperaton();
			case FuzzingOperationsPackage.TIME_TRAVEL_STATE_OPERATON: return createTimeTravelStateOperaton();
			case FuzzingOperationsPackage.PROCESS_KILLER_STATE_OPERATON: return createProcessKillerStateOperaton();
			case FuzzingOperationsPackage.BLACKHOLE_NETWORK_OPERATION: return createBlackholeNetworkOperation();
			case FuzzingOperationsPackage.LATENCY_NETWORK_OPERATION: return createLatencyNetworkOperation();
			case FuzzingOperationsPackage.PACKET_LOSS_NETWORK_OPERATION: return createPacketLossNetworkOperation();
			case FuzzingOperationsPackage.MULTIPLE_MESSAGES_NETWORK_OPERATION: return createMultipleMessagesNetworkOperation();
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
			case FuzzingOperationsPackage.OFFLINE_OPERATION_TIME:
				return createOfflineOperationTimeFromString(eDataType, initialValue);
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
			case FuzzingOperationsPackage.OFFLINE_OPERATION_TIME:
				return convertOfflineOperationTimeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OfflineFuzzingOperation createOfflineFuzzingOperation() {
		OfflineFuzzingOperationImpl offlineFuzzingOperation = new OfflineFuzzingOperationImpl();
		return offlineFuzzingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomFuzzingOperation createCustomFuzzingOperation() {
		CustomFuzzingOperationImpl customFuzzingOperation = new CustomFuzzingOperationImpl();
		return customFuzzingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomOfflineFuzzingOperation createCustomOfflineFuzzingOperation() {
		CustomOfflineFuzzingOperationImpl customOfflineFuzzingOperation = new CustomOfflineFuzzingOperationImpl();
		return customOfflineFuzzingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedTimeActivation createFixedTimeActivation() {
		FixedTimeActivationImpl fixedTimeActivation = new FixedTimeActivationImpl();
		return fixedTimeActivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionBasedActivation createConditionBasedActivation() {
		ConditionBasedActivationImpl conditionBasedActivation = new ConditionBasedActivationImpl();
		return conditionBasedActivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionBasedTimeLimited createConditionBasedTimeLimited() {
		ConditionBasedTimeLimitedImpl conditionBasedTimeLimited = new ConditionBasedTimeLimitedImpl();
		return conditionBasedTimeLimited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuzzTestingOperation createFuzzTestingOperation() {
		FuzzTestingOperationImpl fuzzTestingOperation = new FuzzTestingOperationImpl();
		return fuzzTestingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentOperation createComponentOperation() {
		ComponentOperationImpl componentOperation = new ComponentOperationImpl();
		return componentOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentPropertyOperation createComponentPropertyOperation() {
		ComponentPropertyOperationImpl componentPropertyOperation = new ComponentPropertyOperationImpl();
		return componentPropertyOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSubPropertyOperation createComponentSubPropertyOperation() {
		ComponentSubPropertyOperationImpl componentSubPropertyOperation = new ComponentSubPropertyOperationImpl();
		return componentSubPropertyOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableOperation createVariableOperation() {
		VariableOperationImpl variableOperation = new VariableOperationImpl();
		return variableOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomValueFuzzingOperation createRandomValueFuzzingOperation() {
		RandomValueFuzzingOperationImpl randomValueFuzzingOperation = new RandomValueFuzzingOperationImpl();
		return randomValueFuzzingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomValueFromSetOperation createRandomValueFromSetOperation() {
		RandomValueFromSetOperationImpl randomValueFromSetOperation = new RandomValueFromSetOperationImpl();
		return randomValueFromSetOperation;
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
	public Point createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointRange createPointRange() {
		PointRangeImpl pointRange = new PointRangeImpl();
		return pointRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringSet createStringSet() {
		StringSetImpl stringSet = new StringSetImpl();
		return stringSet;
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
	public ResourceFuzzingOperation createResourceFuzzingOperation() {
		ResourceFuzzingOperationImpl resourceFuzzingOperation = new ResourceFuzzingOperationImpl();
		return resourceFuzzingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateFuzzingOperation createStateFuzzingOperation() {
		StateFuzzingOperationImpl stateFuzzingOperation = new StateFuzzingOperationImpl();
		return stateFuzzingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetworkFuzzingOperation createNetworkFuzzingOperation() {
		NetworkFuzzingOperationImpl networkFuzzingOperation = new NetworkFuzzingOperationImpl();
		return networkFuzzingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadResourceOperation createLoadResourceOperation() {
		LoadResourceOperationImpl loadResourceOperation = new LoadResourceOperationImpl();
		return loadResourceOperation;
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
	public ShutdownStateOperaton createShutdownStateOperaton() {
		ShutdownStateOperatonImpl shutdownStateOperaton = new ShutdownStateOperatonImpl();
		return shutdownStateOperaton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeTravelStateOperaton createTimeTravelStateOperaton() {
		TimeTravelStateOperatonImpl timeTravelStateOperaton = new TimeTravelStateOperatonImpl();
		return timeTravelStateOperaton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessKillerStateOperaton createProcessKillerStateOperaton() {
		ProcessKillerStateOperatonImpl processKillerStateOperaton = new ProcessKillerStateOperatonImpl();
		return processKillerStateOperaton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlackholeNetworkOperation createBlackholeNetworkOperation() {
		BlackholeNetworkOperationImpl blackholeNetworkOperation = new BlackholeNetworkOperationImpl();
		return blackholeNetworkOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LatencyNetworkOperation createLatencyNetworkOperation() {
		LatencyNetworkOperationImpl latencyNetworkOperation = new LatencyNetworkOperationImpl();
		return latencyNetworkOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketLossNetworkOperation createPacketLossNetworkOperation() {
		PacketLossNetworkOperationImpl packetLossNetworkOperation = new PacketLossNetworkOperationImpl();
		return packetLossNetworkOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleMessagesNetworkOperation createMultipleMessagesNetworkOperation() {
		MultipleMessagesNetworkOperationImpl multipleMessagesNetworkOperation = new MultipleMessagesNetworkOperationImpl();
		return multipleMessagesNetworkOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OfflineOperationTime createOfflineOperationTimeFromString(EDataType eDataType, String initialValue) {
		OfflineOperationTime result = OfflineOperationTime.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOfflineOperationTimeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuzzingOperationsPackage getFuzzingOperationsPackage() {
		return (FuzzingOperationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FuzzingOperationsPackage getPackage() {
		return FuzzingOperationsPackage.eINSTANCE;
	}

} //FuzzingOperationsFactoryImpl
