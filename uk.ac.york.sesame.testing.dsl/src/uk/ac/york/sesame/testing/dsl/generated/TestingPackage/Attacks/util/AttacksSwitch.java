/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.*;

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
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage
 * @generated
 */
public class AttacksSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AttacksPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttacksSwitch() {
		if (modelPackage == null) {
			modelPackage = AttacksPackage.eINSTANCE;
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
			case AttacksPackage.ATTACK: {
				Attack attack = (Attack)theEObject;
				T result = caseAttack(attack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.OFFLINE_ATTACK: {
				OfflineAttack offlineAttack = (OfflineAttack)theEObject;
				T result = caseOfflineAttack(offlineAttack);
				if (result == null) result = caseAttack(offlineAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.CUSTOM_ATTACK: {
				CustomAttack customAttack = (CustomAttack)theEObject;
				T result = caseCustomAttack(customAttack);
				if (result == null) result = caseAttack(customAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.CUSTOM_OFFLINE_ATTACK: {
				CustomOfflineAttack customOfflineAttack = (CustomOfflineAttack)theEObject;
				T result = caseCustomOfflineAttack(customOfflineAttack);
				if (result == null) result = caseOfflineAttack(customOfflineAttack);
				if (result == null) result = caseAttack(customOfflineAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.ATTACK_ACTIVATION: {
				AttackActivation attackActivation = (AttackActivation)theEObject;
				T result = caseAttackActivation(attackActivation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.ATTACK_FIXED_TIME: {
				AttackFixedTime attackFixedTime = (AttackFixedTime)theEObject;
				T result = caseAttackFixedTime(attackFixedTime);
				if (result == null) result = caseAttackActivation(attackFixedTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.CONDITION_BASED: {
				ConditionBased conditionBased = (ConditionBased)theEObject;
				T result = caseConditionBased(conditionBased);
				if (result == null) result = caseAttackActivation(conditionBased);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.FUZZ_TESTING_ATTACK: {
				FuzzTestingAttack fuzzTestingAttack = (FuzzTestingAttack)theEObject;
				T result = caseFuzzTestingAttack(fuzzTestingAttack);
				if (result == null) result = caseAttack(fuzzTestingAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.COMPONENT_ATTACK: {
				ComponentAttack componentAttack = (ComponentAttack)theEObject;
				T result = caseComponentAttack(componentAttack);
				if (result == null) result = caseFuzzTestingAttack(componentAttack);
				if (result == null) result = caseAttack(componentAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.COMPONENT_PROPERTY_ATTACK: {
				ComponentPropertyAttack componentPropertyAttack = (ComponentPropertyAttack)theEObject;
				T result = caseComponentPropertyAttack(componentPropertyAttack);
				if (result == null) result = caseFuzzTestingAttack(componentPropertyAttack);
				if (result == null) result = caseAttack(componentPropertyAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK: {
				ComponentSubPropertyAttack componentSubPropertyAttack = (ComponentSubPropertyAttack)theEObject;
				T result = caseComponentSubPropertyAttack(componentSubPropertyAttack);
				if (result == null) result = caseFuzzTestingAttack(componentSubPropertyAttack);
				if (result == null) result = caseAttack(componentSubPropertyAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.TOPIC_ATTACK: {
				TopicAttack topicAttack = (TopicAttack)theEObject;
				T result = caseTopicAttack(topicAttack);
				if (result == null) result = caseFuzzTestingAttack(topicAttack);
				if (result == null) result = caseAttack(topicAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.RANDOM_VALUE_ATTACK: {
				RandomValueAttack randomValueAttack = (RandomValueAttack)theEObject;
				T result = caseRandomValueAttack(randomValueAttack);
				if (result == null) result = caseComponentPropertyAttack(randomValueAttack);
				if (result == null) result = caseFuzzTestingAttack(randomValueAttack);
				if (result == null) result = caseAttack(randomValueAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.RANDOM_VALUE_FROM_SET_ATTACK: {
				RandomValueFromSetAttack randomValueFromSetAttack = (RandomValueFromSetAttack)theEObject;
				T result = caseRandomValueFromSetAttack(randomValueFromSetAttack);
				if (result == null) result = caseRandomValueAttack(randomValueFromSetAttack);
				if (result == null) result = caseComponentPropertyAttack(randomValueFromSetAttack);
				if (result == null) result = caseFuzzTestingAttack(randomValueFromSetAttack);
				if (result == null) result = caseAttack(randomValueFromSetAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.VALUE_SET: {
				ValueSet valueSet = (ValueSet)theEObject;
				T result = caseValueSet(valueSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.VALUE_RANGE: {
				ValueRange valueRange = (ValueRange)theEObject;
				T result = caseValueRange(valueRange);
				if (result == null) result = caseValueSet(valueRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.INT_RANGE: {
				IntRange intRange = (IntRange)theEObject;
				T result = caseIntRange(intRange);
				if (result == null) result = caseValueRange(intRange);
				if (result == null) result = caseValueSet(intRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.DOUBLE_RANGE: {
				DoubleRange doubleRange = (DoubleRange)theEObject;
				T result = caseDoubleRange(doubleRange);
				if (result == null) result = caseValueRange(doubleRange);
				if (result == null) result = caseValueSet(doubleRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.STRING_RANGE: {
				StringRange stringRange = (StringRange)theEObject;
				T result = caseStringRange(stringRange);
				if (result == null) result = caseValueRange(stringRange);
				if (result == null) result = caseValueSet(stringRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.EXTERNAL_RESOURCE_SET: {
				ExternalResourceSet externalResourceSet = (ExternalResourceSet)theEObject;
				T result = caseExternalResourceSet(externalResourceSet);
				if (result == null) result = caseValueSet(externalResourceSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.RESOURCE_ATTACK: {
				ResourceAttack resourceAttack = (ResourceAttack)theEObject;
				T result = caseResourceAttack(resourceAttack);
				if (result == null) result = caseAttack(resourceAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.STATE_ATTACK: {
				StateAttack stateAttack = (StateAttack)theEObject;
				T result = caseStateAttack(stateAttack);
				if (result == null) result = caseAttack(stateAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.NETWORK_ATTACK: {
				NetworkAttack networkAttack = (NetworkAttack)theEObject;
				T result = caseNetworkAttack(networkAttack);
				if (result == null) result = caseAttack(networkAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.LOAD_RESOURCE_ATTACK: {
				LoadResourceAttack loadResourceAttack = (LoadResourceAttack)theEObject;
				T result = caseLoadResourceAttack(loadResourceAttack);
				if (result == null) result = caseResourceAttack(loadResourceAttack);
				if (result == null) result = caseAttack(loadResourceAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.LOAD_TYPE: {
				LoadType loadType = (LoadType)theEObject;
				T result = caseLoadType(loadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.CPU_LOAD_TYPE: {
				CPULoadType cpuLoadType = (CPULoadType)theEObject;
				T result = caseCPULoadType(cpuLoadType);
				if (result == null) result = caseLoadType(cpuLoadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.MEMORY_LOAD_TYPE: {
				MemoryLoadType memoryLoadType = (MemoryLoadType)theEObject;
				T result = caseMemoryLoadType(memoryLoadType);
				if (result == null) result = caseLoadType(memoryLoadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.IO_LOAD_TYPE: {
				IOLoadType ioLoadType = (IOLoadType)theEObject;
				T result = caseIOLoadType(ioLoadType);
				if (result == null) result = caseLoadType(ioLoadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.DISK_LOAD_TYPE: {
				DiskLoadType diskLoadType = (DiskLoadType)theEObject;
				T result = caseDiskLoadType(diskLoadType);
				if (result == null) result = caseLoadType(diskLoadType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.SHUTDOWN_STATE_ATTACK: {
				ShutdownStateAttack shutdownStateAttack = (ShutdownStateAttack)theEObject;
				T result = caseShutdownStateAttack(shutdownStateAttack);
				if (result == null) result = caseStateAttack(shutdownStateAttack);
				if (result == null) result = caseAttack(shutdownStateAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.TIME_TRAVEL_STATE_ATTACK: {
				TimeTravelStateAttack timeTravelStateAttack = (TimeTravelStateAttack)theEObject;
				T result = caseTimeTravelStateAttack(timeTravelStateAttack);
				if (result == null) result = caseStateAttack(timeTravelStateAttack);
				if (result == null) result = caseAttack(timeTravelStateAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.PROCESS_KILLER_STATE_ATTACK: {
				ProcessKillerStateAttack processKillerStateAttack = (ProcessKillerStateAttack)theEObject;
				T result = caseProcessKillerStateAttack(processKillerStateAttack);
				if (result == null) result = caseStateAttack(processKillerStateAttack);
				if (result == null) result = caseAttack(processKillerStateAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.BLACKHOLE_NETWORK_ATTACK: {
				BlackholeNetworkAttack blackholeNetworkAttack = (BlackholeNetworkAttack)theEObject;
				T result = caseBlackholeNetworkAttack(blackholeNetworkAttack);
				if (result == null) result = caseNetworkAttack(blackholeNetworkAttack);
				if (result == null) result = caseAttack(blackholeNetworkAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.LATENCY_NETWORK_ATTACK: {
				LatencyNetworkAttack latencyNetworkAttack = (LatencyNetworkAttack)theEObject;
				T result = caseLatencyNetworkAttack(latencyNetworkAttack);
				if (result == null) result = caseNetworkAttack(latencyNetworkAttack);
				if (result == null) result = caseAttack(latencyNetworkAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.PACKET_LOSS_NETWORK_ATTACK: {
				PacketLossNetworkAttack packetLossNetworkAttack = (PacketLossNetworkAttack)theEObject;
				T result = casePacketLossNetworkAttack(packetLossNetworkAttack);
				if (result == null) result = caseNetworkAttack(packetLossNetworkAttack);
				if (result == null) result = caseAttack(packetLossNetworkAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AttacksPackage.MULTIPLE_MESSAGES_NETWORK_ATTACK: {
				MultipleMessagesNetworkAttack multipleMessagesNetworkAttack = (MultipleMessagesNetworkAttack)theEObject;
				T result = caseMultipleMessagesNetworkAttack(multipleMessagesNetworkAttack);
				if (result == null) result = caseNetworkAttack(multipleMessagesNetworkAttack);
				if (result == null) result = caseAttack(multipleMessagesNetworkAttack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttack(Attack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Offline Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Offline Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOfflineAttack(OfflineAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomAttack(CustomAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Offline Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Offline Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomOfflineAttack(CustomOfflineAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attack Activation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attack Activation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackActivation(AttackActivation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attack Fixed Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attack Fixed Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttackFixedTime(AttackFixedTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Based</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Based</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionBased(ConditionBased object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fuzz Testing Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fuzz Testing Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFuzzTestingAttack(FuzzTestingAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentAttack(ComponentAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Property Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Property Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentPropertyAttack(ComponentPropertyAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Sub Property Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Sub Property Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentSubPropertyAttack(ComponentSubPropertyAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Topic Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Topic Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopicAttack(TopicAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Value Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Value Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomValueAttack(RandomValueAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Value From Set Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Value From Set Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomValueFromSetAttack(RandomValueFromSetAttack object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Resource Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceAttack(ResourceAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateAttack(StateAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Network Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Network Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNetworkAttack(NetworkAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Resource Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Resource Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadResourceAttack(LoadResourceAttack object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Shutdown State Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shutdown State Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShutdownStateAttack(ShutdownStateAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Travel State Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Travel State Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeTravelStateAttack(TimeTravelStateAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Killer State Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Killer State Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessKillerStateAttack(ProcessKillerStateAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blackhole Network Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blackhole Network Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlackholeNetworkAttack(BlackholeNetworkAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Latency Network Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Latency Network Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLatencyNetworkAttack(LatencyNetworkAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Packet Loss Network Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Packet Loss Network Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePacketLossNetworkAttack(PacketLossNetworkAttack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple Messages Network Attack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple Messages Network Attack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleMessagesNetworkAttack(MultipleMessagesNetworkAttack object) {
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

} //AttacksSwitch
