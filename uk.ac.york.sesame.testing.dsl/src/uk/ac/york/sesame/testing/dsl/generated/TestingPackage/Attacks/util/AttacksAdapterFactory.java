/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage
 * @generated
 */
public class AttacksAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AttacksPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttacksAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AttacksPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttacksSwitch<Adapter> modelSwitch =
		new AttacksSwitch<Adapter>() {
			@Override
			public Adapter caseAttack(Attack object) {
				return createAttackAdapter();
			}
			@Override
			public Adapter caseOfflineAttack(OfflineAttack object) {
				return createOfflineAttackAdapter();
			}
			@Override
			public Adapter caseCustomAttack(CustomAttack object) {
				return createCustomAttackAdapter();
			}
			@Override
			public Adapter caseCustomOfflineAttack(CustomOfflineAttack object) {
				return createCustomOfflineAttackAdapter();
			}
			@Override
			public Adapter caseAttackActivation(AttackActivation object) {
				return createAttackActivationAdapter();
			}
			@Override
			public Adapter caseAttackFixedTime(AttackFixedTime object) {
				return createAttackFixedTimeAdapter();
			}
			@Override
			public Adapter caseConditionBased(ConditionBased object) {
				return createConditionBasedAdapter();
			}
			@Override
			public Adapter caseFuzzTestingAttack(FuzzTestingAttack object) {
				return createFuzzTestingAttackAdapter();
			}
			@Override
			public Adapter caseComponentAttack(ComponentAttack object) {
				return createComponentAttackAdapter();
			}
			@Override
			public Adapter caseComponentPropertyAttack(ComponentPropertyAttack object) {
				return createComponentPropertyAttackAdapter();
			}
			@Override
			public Adapter caseComponentSubPropertyAttack(ComponentSubPropertyAttack object) {
				return createComponentSubPropertyAttackAdapter();
			}
			@Override
			public Adapter caseTopicAttack(TopicAttack object) {
				return createTopicAttackAdapter();
			}
			@Override
			public Adapter caseRandomValueAttack(RandomValueAttack object) {
				return createRandomValueAttackAdapter();
			}
			@Override
			public Adapter caseRandomValueFromSetAttack(RandomValueFromSetAttack object) {
				return createRandomValueFromSetAttackAdapter();
			}
			@Override
			public Adapter caseValueSet(ValueSet object) {
				return createValueSetAdapter();
			}
			@Override
			public Adapter caseValueRange(ValueRange object) {
				return createValueRangeAdapter();
			}
			@Override
			public Adapter caseIntRange(IntRange object) {
				return createIntRangeAdapter();
			}
			@Override
			public Adapter caseDoubleRange(DoubleRange object) {
				return createDoubleRangeAdapter();
			}
			@Override
			public Adapter caseStringRange(StringRange object) {
				return createStringRangeAdapter();
			}
			@Override
			public Adapter caseExternalResourceSet(ExternalResourceSet object) {
				return createExternalResourceSetAdapter();
			}
			@Override
			public Adapter caseResourceAttack(ResourceAttack object) {
				return createResourceAttackAdapter();
			}
			@Override
			public Adapter caseStateAttack(StateAttack object) {
				return createStateAttackAdapter();
			}
			@Override
			public Adapter caseNetworkAttack(NetworkAttack object) {
				return createNetworkAttackAdapter();
			}
			@Override
			public Adapter caseLoadResourceAttack(LoadResourceAttack object) {
				return createLoadResourceAttackAdapter();
			}
			@Override
			public Adapter caseLoadType(LoadType object) {
				return createLoadTypeAdapter();
			}
			@Override
			public Adapter caseCPULoadType(CPULoadType object) {
				return createCPULoadTypeAdapter();
			}
			@Override
			public Adapter caseMemoryLoadType(MemoryLoadType object) {
				return createMemoryLoadTypeAdapter();
			}
			@Override
			public Adapter caseIOLoadType(IOLoadType object) {
				return createIOLoadTypeAdapter();
			}
			@Override
			public Adapter caseDiskLoadType(DiskLoadType object) {
				return createDiskLoadTypeAdapter();
			}
			@Override
			public Adapter caseShutdownStateAttack(ShutdownStateAttack object) {
				return createShutdownStateAttackAdapter();
			}
			@Override
			public Adapter caseTimeTravelStateAttack(TimeTravelStateAttack object) {
				return createTimeTravelStateAttackAdapter();
			}
			@Override
			public Adapter caseProcessKillerStateAttack(ProcessKillerStateAttack object) {
				return createProcessKillerStateAttackAdapter();
			}
			@Override
			public Adapter caseBlackholeNetworkAttack(BlackholeNetworkAttack object) {
				return createBlackholeNetworkAttackAdapter();
			}
			@Override
			public Adapter caseLatencyNetworkAttack(LatencyNetworkAttack object) {
				return createLatencyNetworkAttackAdapter();
			}
			@Override
			public Adapter casePacketLossNetworkAttack(PacketLossNetworkAttack object) {
				return createPacketLossNetworkAttackAdapter();
			}
			@Override
			public Adapter caseMultipleMessagesNetworkAttack(MultipleMessagesNetworkAttack object) {
				return createMultipleMessagesNetworkAttackAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack <em>Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack
	 * @generated
	 */
	public Adapter createAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack <em>Offline Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack
	 * @generated
	 */
	public Adapter createOfflineAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomAttack <em>Custom Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomAttack
	 * @generated
	 */
	public Adapter createCustomAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomOfflineAttack <em>Custom Offline Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomOfflineAttack
	 * @generated
	 */
	public Adapter createCustomOfflineAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation <em>Attack Activation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation
	 * @generated
	 */
	public Adapter createAttackActivationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime <em>Attack Fixed Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime
	 * @generated
	 */
	public Adapter createAttackFixedTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased <em>Condition Based</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased
	 * @generated
	 */
	public Adapter createConditionBasedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.FuzzTestingAttack <em>Fuzz Testing Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.FuzzTestingAttack
	 * @generated
	 */
	public Adapter createFuzzTestingAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentAttack <em>Component Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentAttack
	 * @generated
	 */
	public Adapter createComponentAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack <em>Component Property Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack
	 * @generated
	 */
	public Adapter createComponentPropertyAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack <em>Component Sub Property Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack
	 * @generated
	 */
	public Adapter createComponentSubPropertyAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack <em>Topic Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack
	 * @generated
	 */
	public Adapter createTopicAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueAttack <em>Random Value Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueAttack
	 * @generated
	 */
	public Adapter createRandomValueAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack <em>Random Value From Set Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack
	 * @generated
	 */
	public Adapter createRandomValueFromSetAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueSet <em>Value Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueSet
	 * @generated
	 */
	public Adapter createValueSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueRange <em>Value Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueRange
	 * @generated
	 */
	public Adapter createValueRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange <em>Int Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange
	 * @generated
	 */
	public Adapter createIntRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange <em>Double Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange
	 * @generated
	 */
	public Adapter createDoubleRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange <em>String Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange
	 * @generated
	 */
	public Adapter createStringRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ExternalResourceSet <em>External Resource Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ExternalResourceSet
	 * @generated
	 */
	public Adapter createExternalResourceSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ResourceAttack <em>Resource Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ResourceAttack
	 * @generated
	 */
	public Adapter createResourceAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StateAttack <em>State Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StateAttack
	 * @generated
	 */
	public Adapter createStateAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.NetworkAttack <em>Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.NetworkAttack
	 * @generated
	 */
	public Adapter createNetworkAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack <em>Load Resource Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack
	 * @generated
	 */
	public Adapter createLoadResourceAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType <em>Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType
	 * @generated
	 */
	public Adapter createLoadTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CPULoadType <em>CPU Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CPULoadType
	 * @generated
	 */
	public Adapter createCPULoadTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MemoryLoadType <em>Memory Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MemoryLoadType
	 * @generated
	 */
	public Adapter createMemoryLoadTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IOLoadType <em>IO Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IOLoadType
	 * @generated
	 */
	public Adapter createIOLoadTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DiskLoadType <em>Disk Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DiskLoadType
	 * @generated
	 */
	public Adapter createDiskLoadTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ShutdownStateAttack <em>Shutdown State Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ShutdownStateAttack
	 * @generated
	 */
	public Adapter createShutdownStateAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TimeTravelStateAttack <em>Time Travel State Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TimeTravelStateAttack
	 * @generated
	 */
	public Adapter createTimeTravelStateAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ProcessKillerStateAttack <em>Process Killer State Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ProcessKillerStateAttack
	 * @generated
	 */
	public Adapter createProcessKillerStateAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.BlackholeNetworkAttack <em>Blackhole Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.BlackholeNetworkAttack
	 * @generated
	 */
	public Adapter createBlackholeNetworkAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack <em>Latency Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack
	 * @generated
	 */
	public Adapter createLatencyNetworkAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack <em>Packet Loss Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack
	 * @generated
	 */
	public Adapter createPacketLossNetworkAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack <em>Multiple Messages Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack
	 * @generated
	 */
	public Adapter createMultipleMessagesNetworkAttackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AttacksAdapterFactory
