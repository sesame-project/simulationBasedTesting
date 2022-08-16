/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage
 * @generated
 */
public class FuzzingOperationsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FuzzingOperationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuzzingOperationsSwitch() {
		if (modelPackage == null) {
			modelPackage = FuzzingOperationsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FuzzingOperationsPackage.FUZZING_OPERATION: {
				FuzzingOperation fuzzingOperation = (FuzzingOperation)theEObject;
				T result = caseFuzzingOperation(fuzzingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.OFFLINE_FUZZING_OPERATION: {
				OfflineFuzzingOperation offlineFuzzingOperation = (OfflineFuzzingOperation)theEObject;
				T result = caseOfflineFuzzingOperation(offlineFuzzingOperation);
				if (result == null) result = caseFuzzingOperation(offlineFuzzingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.CUSTOM_FUZZING_OPERATION: {
				CustomFuzzingOperation customFuzzingOperation = (CustomFuzzingOperation)theEObject;
				T result = caseCustomFuzzingOperation(customFuzzingOperation);
				if (result == null) result = caseFuzzingOperation(customFuzzingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.CUSTOM_OFFLINE_FUZZING_OPERATION: {
				CustomOfflineFuzzingOperation customOfflineFuzzingOperation = (CustomOfflineFuzzingOperation)theEObject;
				T result = caseCustomOfflineFuzzingOperation(customOfflineFuzzingOperation);
				if (result == null) result = caseOfflineFuzzingOperation(customOfflineFuzzingOperation);
				if (result == null) result = caseFuzzingOperation(customOfflineFuzzingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.ACTIVATION: {
				Activation activation = (Activation)theEObject;
				T result = caseActivation(activation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.FIXED_TIME_ACTIVATION: {
				FixedTimeActivation fixedTimeActivation = (FixedTimeActivation)theEObject;
				T result = caseFixedTimeActivation(fixedTimeActivation);
				if (result == null) result = caseActivation(fixedTimeActivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.CONDITION_BASED_ACTIVATION: {
				ConditionBasedActivation conditionBasedActivation = (ConditionBasedActivation)theEObject;
				T result = caseConditionBasedActivation(conditionBasedActivation);
				if (result == null) result = caseActivation(conditionBasedActivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.FUZZ_TESTING_OPERATION: {
				FuzzTestingOperation fuzzTestingOperation = (FuzzTestingOperation)theEObject;
				T result = caseFuzzTestingOperation(fuzzTestingOperation);
				if (result == null) result = caseFuzzingOperation(fuzzTestingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.COMPONENT_OPERATION: {
				ComponentOperation componentOperation = (ComponentOperation)theEObject;
				T result = caseComponentOperation(componentOperation);
				if (result == null) result = caseFuzzTestingOperation(componentOperation);
				if (result == null) result = caseFuzzingOperation(componentOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.COMPONENT_PROPERTY_OPERATION: {
				ComponentPropertyOperation componentPropertyOperation = (ComponentPropertyOperation)theEObject;
				T result = caseComponentPropertyOperation(componentPropertyOperation);
				if (result == null) result = caseFuzzTestingOperation(componentPropertyOperation);
				if (result == null) result = caseFuzzingOperation(componentPropertyOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.COMPONENT_SUB_PROPERTY_OPERATION: {
				ComponentSubPropertyOperation componentSubPropertyOperation = (ComponentSubPropertyOperation)theEObject;
				T result = caseComponentSubPropertyOperation(componentSubPropertyOperation);
				if (result == null) result = caseFuzzTestingOperation(componentSubPropertyOperation);
				if (result == null) result = caseFuzzingOperation(componentSubPropertyOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.VARIABLE_OPERATION: {
				VariableOperation variableOperation = (VariableOperation)theEObject;
				T result = caseVariableOperation(variableOperation);
				if (result == null) result = caseFuzzTestingOperation(variableOperation);
				if (result == null) result = caseFuzzingOperation(variableOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.RANDOM_VALUE_FUZZING_OPERATION: {
				RandomValueFuzzingOperation randomValueFuzzingOperation = (RandomValueFuzzingOperation)theEObject;
				T result = caseRandomValueFuzzingOperation(randomValueFuzzingOperation);
				if (result == null) result = caseComponentOperation(randomValueFuzzingOperation);
				if (result == null) result = caseFuzzTestingOperation(randomValueFuzzingOperation);
				if (result == null) result = caseFuzzingOperation(randomValueFuzzingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.RANDOM_VALUE_FROM_SET_OPERATION: {
				RandomValueFromSetOperation randomValueFromSetOperation = (RandomValueFromSetOperation)theEObject;
				T result = caseRandomValueFromSetOperation(randomValueFromSetOperation);
				if (result == null) result = caseRandomValueFuzzingOperation(randomValueFromSetOperation);
				if (result == null) result = caseComponentOperation(randomValueFromSetOperation);
				if (result == null) result = caseFuzzTestingOperation(randomValueFromSetOperation);
				if (result == null) result = caseFuzzingOperation(randomValueFromSetOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.VALUE_SET: {
				ValueSet valueSet = (ValueSet)theEObject;
				T result = caseValueSet(valueSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.VALUE_RANGE: {
				ValueRange valueRange = (ValueRange)theEObject;
				T result = caseValueRange(valueRange);
				if (result == null) result = caseValueSet(valueRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.INT_RANGE: {
				IntRange intRange = (IntRange)theEObject;
				T result = caseIntRange(intRange);
				if (result == null) result = caseValueRange(intRange);
				if (result == null) result = caseValueSet(intRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.DOUBLE_RANGE: {
				DoubleRange doubleRange = (DoubleRange)theEObject;
				T result = caseDoubleRange(doubleRange);
				if (result == null) result = caseValueRange(doubleRange);
				if (result == null) result = caseValueSet(doubleRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.POINT: {
				Point point = (Point)theEObject;
				T result = casePoint(point);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.POINT_RANGE: {
				PointRange pointRange = (PointRange)theEObject;
				T result = casePointRange(pointRange);
				if (result == null) result = caseValueRange(pointRange);
				if (result == null) result = caseValueSet(pointRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.STRING_RANGE: {
				StringRange stringRange = (StringRange)theEObject;
				T result = caseStringRange(stringRange);
				if (result == null) result = caseValueSet(stringRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.EXTERNAL_RESOURCE_SET: {
				ExternalResourceSet externalResourceSet = (ExternalResourceSet)theEObject;
				T result = caseExternalResourceSet(externalResourceSet);
				if (result == null) result = caseValueSet(externalResourceSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.RESOURCE_FUZZING_OPERATION: {
				ResourceFuzzingOperation resourceFuzzingOperation = (ResourceFuzzingOperation)theEObject;
				T result = caseResourceFuzzingOperation(resourceFuzzingOperation);
				if (result == null) result = caseFuzzingOperation(resourceFuzzingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.STATE_FUZZING_OPERATION: {
				StateFuzzingOperation stateFuzzingOperation = (StateFuzzingOperation)theEObject;
				T result = caseStateFuzzingOperation(stateFuzzingOperation);
				if (result == null) result = caseFuzzingOperation(stateFuzzingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.NETWORK_FUZZING_OPERATION: {
				NetworkFuzzingOperation networkFuzzingOperation = (NetworkFuzzingOperation)theEObject;
				T result = caseNetworkFuzzingOperation(networkFuzzingOperation);
				if (result == null) result = caseFuzzingOperation(networkFuzzingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.LOAD_RESOURCE_OPERATION: {
				LoadResourceOperation loadResourceOperation = (LoadResourceOperation)theEObject;
				T result = caseLoadResourceOperation(loadResourceOperation);
				if (result == null) result = caseResourceFuzzingOperation(loadResourceOperation);
				if (result == null) result = caseFuzzingOperation(loadResourceOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.LOAD_TYPE: {
				LoadType loadType = (LoadType)theEObject;
				T result = caseLoadType(loadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.CPU_LOAD_TYPE: {
				CPULoadType cpuLoadType = (CPULoadType)theEObject;
				T result = caseCPULoadType(cpuLoadType);
				if (result == null) result = caseLoadType(cpuLoadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.MEMORY_LOAD_TYPE: {
				MemoryLoadType memoryLoadType = (MemoryLoadType)theEObject;
				T result = caseMemoryLoadType(memoryLoadType);
				if (result == null) result = caseLoadType(memoryLoadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.IO_LOAD_TYPE: {
				IOLoadType ioLoadType = (IOLoadType)theEObject;
				T result = caseIOLoadType(ioLoadType);
				if (result == null) result = caseLoadType(ioLoadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.DISK_LOAD_TYPE: {
				DiskLoadType diskLoadType = (DiskLoadType)theEObject;
				T result = caseDiskLoadType(diskLoadType);
				if (result == null) result = caseLoadType(diskLoadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.SHUTDOWN_STATE_OPERATON: {
				ShutdownStateOperaton shutdownStateOperaton = (ShutdownStateOperaton)theEObject;
				T result = caseShutdownStateOperaton(shutdownStateOperaton);
				if (result == null) result = caseStateFuzzingOperation(shutdownStateOperaton);
				if (result == null) result = caseFuzzingOperation(shutdownStateOperaton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.TIME_TRAVEL_STATE_OPERATON: {
				TimeTravelStateOperaton timeTravelStateOperaton = (TimeTravelStateOperaton)theEObject;
				T result = caseTimeTravelStateOperaton(timeTravelStateOperaton);
				if (result == null) result = caseStateFuzzingOperation(timeTravelStateOperaton);
				if (result == null) result = caseFuzzingOperation(timeTravelStateOperaton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.PROCESS_KILLER_STATE_OPERATON: {
				ProcessKillerStateOperaton processKillerStateOperaton = (ProcessKillerStateOperaton)theEObject;
				T result = caseProcessKillerStateOperaton(processKillerStateOperaton);
				if (result == null) result = caseStateFuzzingOperation(processKillerStateOperaton);
				if (result == null) result = caseFuzzingOperation(processKillerStateOperaton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.BLACKHOLE_NETWORK_OPERATION: {
				BlackholeNetworkOperation blackholeNetworkOperation = (BlackholeNetworkOperation)theEObject;
				T result = caseBlackholeNetworkOperation(blackholeNetworkOperation);
				if (result == null) result = caseNetworkFuzzingOperation(blackholeNetworkOperation);
				if (result == null) result = caseFuzzingOperation(blackholeNetworkOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.LATENCY_NETWORK_OPERATION: {
				LatencyNetworkOperation latencyNetworkOperation = (LatencyNetworkOperation)theEObject;
				T result = caseLatencyNetworkOperation(latencyNetworkOperation);
				if (result == null) result = caseNetworkFuzzingOperation(latencyNetworkOperation);
				if (result == null) result = caseFuzzingOperation(latencyNetworkOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.PACKET_LOSS_NETWORK_OPERATION: {
				PacketLossNetworkOperation packetLossNetworkOperation = (PacketLossNetworkOperation)theEObject;
				T result = casePacketLossNetworkOperation(packetLossNetworkOperation);
				if (result == null) result = caseNetworkFuzzingOperation(packetLossNetworkOperation);
				if (result == null) result = caseFuzzingOperation(packetLossNetworkOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FuzzingOperationsPackage.MULTIPLE_MESSAGES_NETWORK_OPERATION: {
				MultipleMessagesNetworkOperation multipleMessagesNetworkOperation = (MultipleMessagesNetworkOperation)theEObject;
				T result = caseMultipleMessagesNetworkOperation(multipleMessagesNetworkOperation);
				if (result == null) result = caseNetworkFuzzingOperation(multipleMessagesNetworkOperation);
				if (result == null) result = caseFuzzingOperation(multipleMessagesNetworkOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fuzzing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fuzzing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFuzzingOperation(FuzzingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Offline Fuzzing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Offline Fuzzing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOfflineFuzzingOperation(OfflineFuzzingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Fuzzing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Fuzzing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomFuzzingOperation(CustomFuzzingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Offline Fuzzing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Offline Fuzzing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomOfflineFuzzingOperation(CustomOfflineFuzzingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivation(Activation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Time Activation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Time Activation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedTimeActivation(FixedTimeActivation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Based Activation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Based Activation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionBasedActivation(ConditionBasedActivation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fuzz Testing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fuzz Testing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFuzzTestingOperation(FuzzTestingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentOperation(ComponentOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Property Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Property Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentPropertyOperation(ComponentPropertyOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Sub Property Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Sub Property Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentSubPropertyOperation(ComponentSubPropertyOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableOperation(VariableOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Value Fuzzing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Value Fuzzing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomValueFuzzingOperation(RandomValueFuzzingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Value From Set Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Value From Set Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomValueFromSetOperation(RandomValueFromSetOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueSet(ValueSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueRange(ValueRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntRange(IntRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleRange(DoubleRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoint(Point object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointRange(PointRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringRange(StringRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Resource Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Resource Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalResourceSet(ExternalResourceSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Fuzzing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Fuzzing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceFuzzingOperation(ResourceFuzzingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Fuzzing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Fuzzing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateFuzzingOperation(StateFuzzingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Network Fuzzing Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Network Fuzzing Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNetworkFuzzingOperation(NetworkFuzzingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Resource Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Resource Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadResourceOperation(LoadResourceOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadType(LoadType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPU Load Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPU Load Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPULoadType(CPULoadType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Load Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Load Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryLoadType(MemoryLoadType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IO Load Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IO Load Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIOLoadType(IOLoadType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disk Load Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disk Load Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiskLoadType(DiskLoadType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shutdown State Operaton</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shutdown State Operaton</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShutdownStateOperaton(ShutdownStateOperaton object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Travel State Operaton</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Travel State Operaton</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeTravelStateOperaton(TimeTravelStateOperaton object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Killer State Operaton</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Killer State Operaton</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessKillerStateOperaton(ProcessKillerStateOperaton object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blackhole Network Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blackhole Network Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlackholeNetworkOperation(BlackholeNetworkOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Latency Network Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Latency Network Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLatencyNetworkOperation(LatencyNetworkOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packet Loss Network Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packet Loss Network Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePacketLossNetworkOperation(PacketLossNetworkOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple Messages Network Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple Messages Network Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleMessagesNetworkOperation(MultipleMessagesNetworkOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //FuzzingOperationsSwitch
