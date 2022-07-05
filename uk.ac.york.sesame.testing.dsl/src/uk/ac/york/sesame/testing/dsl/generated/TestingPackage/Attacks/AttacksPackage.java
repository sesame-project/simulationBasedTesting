/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;

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
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksFactory
 * @model kind="package"
 * @generated
 */
public interface AttacksPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Attacks";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Attacks";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AttacksPackage eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl <em>Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getAttack()
	 * @generated
	 */
	int ATTACK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__PRIORITY = 1;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__ATTACK_ACTIVATION = 2;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__TOPIC_TO_ATTACK = 3;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = 4;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__FROM_NODES = 5;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__MESSAGES_TO_ALL_COMPONENENTS = 6;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__TO_NODES = 7;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__NODE_TO_ATTACK = 8;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__ALL_PUBLISHING_TOPICS = 9;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__PUBLISHING_TOPICS = 10;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__ALL_SUBSCRIBING_TOPICS = 11;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__SUBSCRIBING_TOPICS = 12;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__FROM_TEMPLATE = 13;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK__CONTAINING_TEST = 14;

	/**
	 * The number of structural features of the '<em>Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.OfflineAttackImpl <em>Offline Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.OfflineAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getOfflineAttack()
	 * @generated
	 */
	int OFFLINE_ATTACK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__NAME = ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__PRIORITY = ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__ATTACK_ACTIVATION = ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__TOPIC_TO_ATTACK = ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__FROM_NODES = ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__TO_NODES = ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__NODE_TO_ATTACK = ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__ALL_PUBLISHING_TOPICS = ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__PUBLISHING_TOPICS = ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__ALL_SUBSCRIBING_TOPICS = ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__SUBSCRIBING_TOPICS = ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__FROM_TEMPLATE = ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__CONTAINING_TEST = ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Attack Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK__ATTACK_TIME = ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Offline Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK_FEATURE_COUNT = ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Offline Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OFFLINE_ATTACK_OPERATION_COUNT = ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CustomAttackImpl <em>Custom Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CustomAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getCustomAttack()
	 * @generated
	 */
	int CUSTOM_ATTACK = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__NAME = ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__PRIORITY = ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__ATTACK_ACTIVATION = ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__TOPIC_TO_ATTACK = ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__FROM_NODES = ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__TO_NODES = ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__NODE_TO_ATTACK = ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__ALL_PUBLISHING_TOPICS = ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__PUBLISHING_TOPICS = ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__ALL_SUBSCRIBING_TOPICS = ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__SUBSCRIBING_TOPICS = ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__FROM_TEMPLATE = ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK__CONTAINING_TEST = ATTACK__CONTAINING_TEST;

	/**
	 * The number of structural features of the '<em>Custom Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK_FEATURE_COUNT = ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Custom Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_ATTACK_OPERATION_COUNT = ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CustomOfflineAttackImpl <em>Custom Offline Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CustomOfflineAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getCustomOfflineAttack()
	 * @generated
	 */
	int CUSTOM_OFFLINE_ATTACK = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__NAME = OFFLINE_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__PRIORITY = OFFLINE_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__ATTACK_ACTIVATION = OFFLINE_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__TOPIC_TO_ATTACK = OFFLINE_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = OFFLINE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__FROM_NODES = OFFLINE_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = OFFLINE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__TO_NODES = OFFLINE_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__NODE_TO_ATTACK = OFFLINE_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__ALL_PUBLISHING_TOPICS = OFFLINE_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__PUBLISHING_TOPICS = OFFLINE_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__ALL_SUBSCRIBING_TOPICS = OFFLINE_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__SUBSCRIBING_TOPICS = OFFLINE_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__FROM_TEMPLATE = OFFLINE_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__CONTAINING_TEST = OFFLINE_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Attack Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK__ATTACK_TIME = OFFLINE_ATTACK__ATTACK_TIME;

	/**
	 * The number of structural features of the '<em>Custom Offline Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK_FEATURE_COUNT = OFFLINE_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Custom Offline Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_OFFLINE_ATTACK_OPERATION_COUNT = OFFLINE_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackActivationImpl <em>Attack Activation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackActivationImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getAttackActivation()
	 * @generated
	 */
	int ATTACK_ACTIVATION = 4;

	/**
	 * The number of structural features of the '<em>Attack Activation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_ACTIVATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Attack Activation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_ACTIVATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackFixedTimeImpl <em>Attack Fixed Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackFixedTimeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getAttackFixedTime()
	 * @generated
	 */
	int ATTACK_FIXED_TIME = 5;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_FIXED_TIME__START_TIME = ATTACK_ACTIVATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_FIXED_TIME__END_TIME = ATTACK_ACTIVATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attack Fixed Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_FIXED_TIME_FEATURE_COUNT = ATTACK_ACTIVATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attack Fixed Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACK_FIXED_TIME_OPERATION_COUNT = ATTACK_ACTIVATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ConditionBasedImpl <em>Condition Based</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ConditionBasedImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getConditionBased()
	 * @generated
	 */
	int CONDITION_BASED = 6;

	/**
	 * The feature id for the '<em><b>Starting</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_BASED__STARTING = ATTACK_ACTIVATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ending</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_BASED__ENDING = ATTACK_ACTIVATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Condition Based</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_BASED_FEATURE_COUNT = ATTACK_ACTIVATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Condition Based</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_BASED_OPERATION_COUNT = ATTACK_ACTIVATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.FuzzTestingAttackImpl <em>Fuzz Testing Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.FuzzTestingAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getFuzzTestingAttack()
	 * @generated
	 */
	int FUZZ_TESTING_ATTACK = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__NAME = ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__PRIORITY = ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__ATTACK_ACTIVATION = ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__TOPIC_TO_ATTACK = ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__FROM_NODES = ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__TO_NODES = ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__NODE_TO_ATTACK = ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__ALL_PUBLISHING_TOPICS = ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__PUBLISHING_TOPICS = ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__ALL_SUBSCRIBING_TOPICS = ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__SUBSCRIBING_TOPICS = ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__FROM_TEMPLATE = ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK__CONTAINING_TEST = ATTACK__CONTAINING_TEST;

	/**
	 * The number of structural features of the '<em>Fuzz Testing Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK_FEATURE_COUNT = ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fuzz Testing Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUZZ_TESTING_ATTACK_OPERATION_COUNT = ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentAttackImpl <em>Component Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getComponentAttack()
	 * @generated
	 */
	int COMPONENT_ATTACK = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__NAME = FUZZ_TESTING_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__PRIORITY = FUZZ_TESTING_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__ATTACK_ACTIVATION = FUZZ_TESTING_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__TOPIC_TO_ATTACK = FUZZ_TESTING_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = FUZZ_TESTING_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__FROM_NODES = FUZZ_TESTING_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = FUZZ_TESTING_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__TO_NODES = FUZZ_TESTING_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__NODE_TO_ATTACK = FUZZ_TESTING_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__ALL_PUBLISHING_TOPICS = FUZZ_TESTING_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__PUBLISHING_TOPICS = FUZZ_TESTING_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__ALL_SUBSCRIBING_TOPICS = FUZZ_TESTING_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__SUBSCRIBING_TOPICS = FUZZ_TESTING_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__FROM_TEMPLATE = FUZZ_TESTING_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK__CONTAINING_TEST = FUZZ_TESTING_ATTACK__CONTAINING_TEST;

	/**
	 * The number of structural features of the '<em>Component Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK_FEATURE_COUNT = FUZZ_TESTING_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Component Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_ATTACK_OPERATION_COUNT = FUZZ_TESTING_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentPropertyAttackImpl <em>Component Property Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentPropertyAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getComponentPropertyAttack()
	 * @generated
	 */
	int COMPONENT_PROPERTY_ATTACK = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__NAME = FUZZ_TESTING_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__PRIORITY = FUZZ_TESTING_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__ATTACK_ACTIVATION = FUZZ_TESTING_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__TOPIC_TO_ATTACK = FUZZ_TESTING_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = FUZZ_TESTING_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__FROM_NODES = FUZZ_TESTING_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = FUZZ_TESTING_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__TO_NODES = FUZZ_TESTING_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__NODE_TO_ATTACK = FUZZ_TESTING_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__ALL_PUBLISHING_TOPICS = FUZZ_TESTING_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__PUBLISHING_TOPICS = FUZZ_TESTING_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__ALL_SUBSCRIBING_TOPICS = FUZZ_TESTING_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__SUBSCRIBING_TOPICS = FUZZ_TESTING_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__FROM_TEMPLATE = FUZZ_TESTING_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__CONTAINING_TEST = FUZZ_TESTING_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Property To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK = FUZZ_TESTING_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Property Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK_FEATURE_COUNT = FUZZ_TESTING_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component Property Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PROPERTY_ATTACK_OPERATION_COUNT = FUZZ_TESTING_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentSubPropertyAttackImpl <em>Component Sub Property Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentSubPropertyAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getComponentSubPropertyAttack()
	 * @generated
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__NAME = FUZZ_TESTING_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__PRIORITY = FUZZ_TESTING_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__ATTACK_ACTIVATION = FUZZ_TESTING_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__TOPIC_TO_ATTACK = FUZZ_TESTING_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = FUZZ_TESTING_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__FROM_NODES = FUZZ_TESTING_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = FUZZ_TESTING_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__TO_NODES = FUZZ_TESTING_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__NODE_TO_ATTACK = FUZZ_TESTING_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__ALL_PUBLISHING_TOPICS = FUZZ_TESTING_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__PUBLISHING_TOPICS = FUZZ_TESTING_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__ALL_SUBSCRIBING_TOPICS = FUZZ_TESTING_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__SUBSCRIBING_TOPICS = FUZZ_TESTING_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__FROM_TEMPLATE = FUZZ_TESTING_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__CONTAINING_TEST = FUZZ_TESTING_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Property To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__PROPERTY_TO_ATTACK = FUZZ_TESTING_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK__SUB_PROPERTY = FUZZ_TESTING_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Sub Property Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK_FEATURE_COUNT = FUZZ_TESTING_ATTACK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Component Sub Property Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SUB_PROPERTY_ATTACK_OPERATION_COUNT = FUZZ_TESTING_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TopicAttackImpl <em>Topic Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TopicAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getTopicAttack()
	 * @generated
	 */
	int TOPIC_ATTACK = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__NAME = FUZZ_TESTING_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__PRIORITY = FUZZ_TESTING_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__ATTACK_ACTIVATION = FUZZ_TESTING_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__TOPIC_TO_ATTACK = FUZZ_TESTING_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = FUZZ_TESTING_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__FROM_NODES = FUZZ_TESTING_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = FUZZ_TESTING_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__TO_NODES = FUZZ_TESTING_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__NODE_TO_ATTACK = FUZZ_TESTING_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__ALL_PUBLISHING_TOPICS = FUZZ_TESTING_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__PUBLISHING_TOPICS = FUZZ_TESTING_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__ALL_SUBSCRIBING_TOPICS = FUZZ_TESTING_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__SUBSCRIBING_TOPICS = FUZZ_TESTING_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__FROM_TEMPLATE = FUZZ_TESTING_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__CONTAINING_TEST = FUZZ_TESTING_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Sub Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK__SUB_PARAMETERS = FUZZ_TESTING_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Topic Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK_FEATURE_COUNT = FUZZ_TESTING_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Topic Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_ATTACK_OPERATION_COUNT = FUZZ_TESTING_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.RandomValueAttackImpl <em>Random Value Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.RandomValueAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getRandomValueAttack()
	 * @generated
	 */
	int RANDOM_VALUE_ATTACK = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__NAME = COMPONENT_PROPERTY_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__PRIORITY = COMPONENT_PROPERTY_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__ATTACK_ACTIVATION = COMPONENT_PROPERTY_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__TOPIC_TO_ATTACK = COMPONENT_PROPERTY_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = COMPONENT_PROPERTY_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__FROM_NODES = COMPONENT_PROPERTY_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = COMPONENT_PROPERTY_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__TO_NODES = COMPONENT_PROPERTY_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__NODE_TO_ATTACK = COMPONENT_PROPERTY_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__ALL_PUBLISHING_TOPICS = COMPONENT_PROPERTY_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__PUBLISHING_TOPICS = COMPONENT_PROPERTY_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__ALL_SUBSCRIBING_TOPICS = COMPONENT_PROPERTY_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__SUBSCRIBING_TOPICS = COMPONENT_PROPERTY_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__FROM_TEMPLATE = COMPONENT_PROPERTY_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__CONTAINING_TEST = COMPONENT_PROPERTY_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Property To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__PROPERTY_TO_ATTACK = COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK__SEED = COMPONENT_PROPERTY_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Random Value Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK_FEATURE_COUNT = COMPONENT_PROPERTY_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Random Value Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_ATTACK_OPERATION_COUNT = COMPONENT_PROPERTY_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.RandomValueFromSetAttackImpl <em>Random Value From Set Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.RandomValueFromSetAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getRandomValueFromSetAttack()
	 * @generated
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__NAME = RANDOM_VALUE_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__PRIORITY = RANDOM_VALUE_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__ATTACK_ACTIVATION = RANDOM_VALUE_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__TOPIC_TO_ATTACK = RANDOM_VALUE_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = RANDOM_VALUE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__FROM_NODES = RANDOM_VALUE_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = RANDOM_VALUE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__TO_NODES = RANDOM_VALUE_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__NODE_TO_ATTACK = RANDOM_VALUE_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__ALL_PUBLISHING_TOPICS = RANDOM_VALUE_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__PUBLISHING_TOPICS = RANDOM_VALUE_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__ALL_SUBSCRIBING_TOPICS = RANDOM_VALUE_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__SUBSCRIBING_TOPICS = RANDOM_VALUE_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__FROM_TEMPLATE = RANDOM_VALUE_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__CONTAINING_TEST = RANDOM_VALUE_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Property To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__PROPERTY_TO_ATTACK = RANDOM_VALUE_ATTACK__PROPERTY_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__SEED = RANDOM_VALUE_ATTACK__SEED;

	/**
	 * The feature id for the '<em><b>Value Set</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK__VALUE_SET = RANDOM_VALUE_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Random Value From Set Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK_FEATURE_COUNT = RANDOM_VALUE_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Random Value From Set Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_VALUE_FROM_SET_ATTACK_OPERATION_COUNT = RANDOM_VALUE_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ValueSetImpl <em>Value Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ValueSetImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getValueSet()
	 * @generated
	 */
	int VALUE_SET = 14;

	/**
	 * The number of structural features of the '<em>Value Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SET_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Value Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ValueRangeImpl <em>Value Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ValueRangeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getValueRange()
	 * @generated
	 */
	int VALUE_RANGE = 15;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE__PROPERTY_NAME = VALUE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_FEATURE_COUNT = VALUE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Value Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_OPERATION_COUNT = VALUE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.IntRangeImpl <em>Int Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.IntRangeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getIntRange()
	 * @generated
	 */
	int INT_RANGE = 16;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RANGE__PROPERTY_NAME = VALUE_RANGE__PROPERTY_NAME;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RANGE__LOWER_BOUND = VALUE_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RANGE__UPPER_BOUND = VALUE_RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Int Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RANGE_FEATURE_COUNT = VALUE_RANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Int Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RANGE_OPERATION_COUNT = VALUE_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.DoubleRangeImpl <em>Double Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.DoubleRangeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getDoubleRange()
	 * @generated
	 */
	int DOUBLE_RANGE = 17;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE__PROPERTY_NAME = VALUE_RANGE__PROPERTY_NAME;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE__LOWER_BOUND = VALUE_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE__UPPER_BOUND = VALUE_RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Double Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_FEATURE_COUNT = VALUE_RANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Double Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_OPERATION_COUNT = VALUE_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.StringRangeImpl <em>String Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.StringRangeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getStringRange()
	 * @generated
	 */
	int STRING_RANGE = 18;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RANGE__PROPERTY_NAME = VALUE_RANGE__PROPERTY_NAME;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RANGE__LOWER_BOUND = VALUE_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RANGE__UPPER_BOUND = VALUE_RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>String Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RANGE_FEATURE_COUNT = VALUE_RANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>String Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RANGE_OPERATION_COUNT = VALUE_RANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ExternalResourceSetImpl <em>External Resource Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ExternalResourceSetImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getExternalResourceSet()
	 * @generated
	 */
	int EXTERNAL_RESOURCE_SET = 19;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_RESOURCE_SET__LOCATION = VALUE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Resource Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_RESOURCE_SET_FEATURE_COUNT = VALUE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>External Resource Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_RESOURCE_SET_OPERATION_COUNT = VALUE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ResourceAttackImpl <em>Resource Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ResourceAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getResourceAttack()
	 * @generated
	 */
	int RESOURCE_ATTACK = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__NAME = ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__PRIORITY = ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__ATTACK_ACTIVATION = ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__TOPIC_TO_ATTACK = ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__FROM_NODES = ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__TO_NODES = ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__NODE_TO_ATTACK = ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__ALL_PUBLISHING_TOPICS = ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__PUBLISHING_TOPICS = ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__ALL_SUBSCRIBING_TOPICS = ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__SUBSCRIBING_TOPICS = ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__FROM_TEMPLATE = ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK__CONTAINING_TEST = ATTACK__CONTAINING_TEST;

	/**
	 * The number of structural features of the '<em>Resource Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK_FEATURE_COUNT = ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ATTACK_OPERATION_COUNT = ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.StateAttackImpl <em>State Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.StateAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getStateAttack()
	 * @generated
	 */
	int STATE_ATTACK = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__NAME = ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__PRIORITY = ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__ATTACK_ACTIVATION = ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__TOPIC_TO_ATTACK = ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__FROM_NODES = ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__TO_NODES = ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__NODE_TO_ATTACK = ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__ALL_PUBLISHING_TOPICS = ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__PUBLISHING_TOPICS = ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__ALL_SUBSCRIBING_TOPICS = ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__SUBSCRIBING_TOPICS = ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__FROM_TEMPLATE = ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK__CONTAINING_TEST = ATTACK__CONTAINING_TEST;

	/**
	 * The number of structural features of the '<em>State Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK_FEATURE_COUNT = ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>State Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_ATTACK_OPERATION_COUNT = ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.NetworkAttackImpl <em>Network Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.NetworkAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getNetworkAttack()
	 * @generated
	 */
	int NETWORK_ATTACK = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__NAME = ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__PRIORITY = ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__ATTACK_ACTIVATION = ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__TOPIC_TO_ATTACK = ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__FROM_NODES = ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__TO_NODES = ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__NODE_TO_ATTACK = ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__ALL_PUBLISHING_TOPICS = ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__PUBLISHING_TOPICS = ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS = ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__SUBSCRIBING_TOPICS = ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__FROM_TEMPLATE = ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK__CONTAINING_TEST = ATTACK__CONTAINING_TEST;

	/**
	 * The number of structural features of the '<em>Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK_FEATURE_COUNT = ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_ATTACK_OPERATION_COUNT = ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LoadResourceAttackImpl <em>Load Resource Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LoadResourceAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getLoadResourceAttack()
	 * @generated
	 */
	int LOAD_RESOURCE_ATTACK = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__NAME = RESOURCE_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__PRIORITY = RESOURCE_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__ATTACK_ACTIVATION = RESOURCE_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__TOPIC_TO_ATTACK = RESOURCE_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = RESOURCE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__FROM_NODES = RESOURCE_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = RESOURCE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__TO_NODES = RESOURCE_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__NODE_TO_ATTACK = RESOURCE_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__ALL_PUBLISHING_TOPICS = RESOURCE_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__PUBLISHING_TOPICS = RESOURCE_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__ALL_SUBSCRIBING_TOPICS = RESOURCE_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__SUBSCRIBING_TOPICS = RESOURCE_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__FROM_TEMPLATE = RESOURCE_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__CONTAINING_TEST = RESOURCE_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Load Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK__LOAD_TYPE = RESOURCE_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Load Resource Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK_FEATURE_COUNT = RESOURCE_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Load Resource Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_RESOURCE_ATTACK_OPERATION_COUNT = RESOURCE_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LoadTypeImpl <em>Load Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LoadTypeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getLoadType()
	 * @generated
	 */
	int LOAD_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_TYPE__MIN = 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_TYPE__MAX = 1;

	/**
	 * The number of structural features of the '<em>Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CPULoadTypeImpl <em>CPU Load Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CPULoadTypeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getCPULoadType()
	 * @generated
	 */
	int CPU_LOAD_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_LOAD_TYPE__MIN = LOAD_TYPE__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_LOAD_TYPE__MAX = LOAD_TYPE__MAX;

	/**
	 * The number of structural features of the '<em>CPU Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_LOAD_TYPE_FEATURE_COUNT = LOAD_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CPU Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_LOAD_TYPE_OPERATION_COUNT = LOAD_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MemoryLoadTypeImpl <em>Memory Load Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MemoryLoadTypeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getMemoryLoadType()
	 * @generated
	 */
	int MEMORY_LOAD_TYPE = 26;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_LOAD_TYPE__MIN = LOAD_TYPE__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_LOAD_TYPE__MAX = LOAD_TYPE__MAX;

	/**
	 * The number of structural features of the '<em>Memory Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_LOAD_TYPE_FEATURE_COUNT = LOAD_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Memory Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_LOAD_TYPE_OPERATION_COUNT = LOAD_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.IOLoadTypeImpl <em>IO Load Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.IOLoadTypeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getIOLoadType()
	 * @generated
	 */
	int IO_LOAD_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_LOAD_TYPE__MIN = LOAD_TYPE__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_LOAD_TYPE__MAX = LOAD_TYPE__MAX;

	/**
	 * The number of structural features of the '<em>IO Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_LOAD_TYPE_FEATURE_COUNT = LOAD_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IO Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_LOAD_TYPE_OPERATION_COUNT = LOAD_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.DiskLoadTypeImpl <em>Disk Load Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.DiskLoadTypeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getDiskLoadType()
	 * @generated
	 */
	int DISK_LOAD_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISK_LOAD_TYPE__MIN = LOAD_TYPE__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISK_LOAD_TYPE__MAX = LOAD_TYPE__MAX;

	/**
	 * The number of structural features of the '<em>Disk Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISK_LOAD_TYPE_FEATURE_COUNT = LOAD_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Disk Load Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISK_LOAD_TYPE_OPERATION_COUNT = LOAD_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ShutdownStateAttackImpl <em>Shutdown State Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ShutdownStateAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getShutdownStateAttack()
	 * @generated
	 */
	int SHUTDOWN_STATE_ATTACK = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__NAME = STATE_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__PRIORITY = STATE_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__ATTACK_ACTIVATION = STATE_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__TOPIC_TO_ATTACK = STATE_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = STATE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__FROM_NODES = STATE_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = STATE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__TO_NODES = STATE_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__NODE_TO_ATTACK = STATE_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__ALL_PUBLISHING_TOPICS = STATE_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__PUBLISHING_TOPICS = STATE_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__ALL_SUBSCRIBING_TOPICS = STATE_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__SUBSCRIBING_TOPICS = STATE_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__FROM_TEMPLATE = STATE_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK__CONTAINING_TEST = STATE_ATTACK__CONTAINING_TEST;

	/**
	 * The number of structural features of the '<em>Shutdown State Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK_FEATURE_COUNT = STATE_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Shutdown State Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_STATE_ATTACK_OPERATION_COUNT = STATE_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TimeTravelStateAttackImpl <em>Time Travel State Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TimeTravelStateAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getTimeTravelStateAttack()
	 * @generated
	 */
	int TIME_TRAVEL_STATE_ATTACK = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__NAME = STATE_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__PRIORITY = STATE_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__ATTACK_ACTIVATION = STATE_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__TOPIC_TO_ATTACK = STATE_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = STATE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__FROM_NODES = STATE_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = STATE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__TO_NODES = STATE_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__NODE_TO_ATTACK = STATE_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__ALL_PUBLISHING_TOPICS = STATE_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__PUBLISHING_TOPICS = STATE_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__ALL_SUBSCRIBING_TOPICS = STATE_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__SUBSCRIBING_TOPICS = STATE_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__FROM_TEMPLATE = STATE_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__CONTAINING_TEST = STATE_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Time Travel Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE = STATE_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Time Travel State Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK_FEATURE_COUNT = STATE_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Time Travel State Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRAVEL_STATE_ATTACK_OPERATION_COUNT = STATE_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ProcessKillerStateAttackImpl <em>Process Killer State Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ProcessKillerStateAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getProcessKillerStateAttack()
	 * @generated
	 */
	int PROCESS_KILLER_STATE_ATTACK = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__NAME = STATE_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__PRIORITY = STATE_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__ATTACK_ACTIVATION = STATE_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__TOPIC_TO_ATTACK = STATE_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = STATE_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__FROM_NODES = STATE_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = STATE_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__TO_NODES = STATE_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__NODE_TO_ATTACK = STATE_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__ALL_PUBLISHING_TOPICS = STATE_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__PUBLISHING_TOPICS = STATE_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__ALL_SUBSCRIBING_TOPICS = STATE_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__SUBSCRIBING_TOPICS = STATE_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__FROM_TEMPLATE = STATE_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__CONTAINING_TEST = STATE_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK__PROCESS_ID = STATE_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Process Killer State Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK_FEATURE_COUNT = STATE_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Process Killer State Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_KILLER_STATE_ATTACK_OPERATION_COUNT = STATE_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.BlackholeNetworkAttackImpl <em>Blackhole Network Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.BlackholeNetworkAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getBlackholeNetworkAttack()
	 * @generated
	 */
	int BLACKHOLE_NETWORK_ATTACK = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__NAME = NETWORK_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__PRIORITY = NETWORK_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__ATTACK_ACTIVATION = NETWORK_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__TOPIC_TO_ATTACK = NETWORK_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__FROM_NODES = NETWORK_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__TO_NODES = NETWORK_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__NODE_TO_ATTACK = NETWORK_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__ALL_PUBLISHING_TOPICS = NETWORK_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__PUBLISHING_TOPICS = NETWORK_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS = NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__SUBSCRIBING_TOPICS = NETWORK_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__FROM_TEMPLATE = NETWORK_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK__CONTAINING_TEST = NETWORK_ATTACK__CONTAINING_TEST;

	/**
	 * The number of structural features of the '<em>Blackhole Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK_FEATURE_COUNT = NETWORK_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Blackhole Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLACKHOLE_NETWORK_ATTACK_OPERATION_COUNT = NETWORK_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LatencyNetworkAttackImpl <em>Latency Network Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LatencyNetworkAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getLatencyNetworkAttack()
	 * @generated
	 */
	int LATENCY_NETWORK_ATTACK = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__NAME = NETWORK_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__PRIORITY = NETWORK_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__ATTACK_ACTIVATION = NETWORK_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__TOPIC_TO_ATTACK = NETWORK_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__FROM_NODES = NETWORK_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__TO_NODES = NETWORK_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__NODE_TO_ATTACK = NETWORK_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__ALL_PUBLISHING_TOPICS = NETWORK_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__PUBLISHING_TOPICS = NETWORK_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS = NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__SUBSCRIBING_TOPICS = NETWORK_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__FROM_TEMPLATE = NETWORK_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__CONTAINING_TEST = NETWORK_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Latency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK__LATENCY = NETWORK_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Latency Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK_FEATURE_COUNT = NETWORK_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Latency Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATENCY_NETWORK_ATTACK_OPERATION_COUNT = NETWORK_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.PacketLossNetworkAttackImpl <em>Packet Loss Network Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.PacketLossNetworkAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getPacketLossNetworkAttack()
	 * @generated
	 */
	int PACKET_LOSS_NETWORK_ATTACK = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__NAME = NETWORK_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__PRIORITY = NETWORK_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__ATTACK_ACTIVATION = NETWORK_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__TOPIC_TO_ATTACK = NETWORK_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__FROM_NODES = NETWORK_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__TO_NODES = NETWORK_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__NODE_TO_ATTACK = NETWORK_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__ALL_PUBLISHING_TOPICS = NETWORK_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__PUBLISHING_TOPICS = NETWORK_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS = NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__SUBSCRIBING_TOPICS = NETWORK_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__FROM_TEMPLATE = NETWORK_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__CONTAINING_TEST = NETWORK_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK__FREQUENCY = NETWORK_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Packet Loss Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK_FEATURE_COUNT = NETWORK_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Packet Loss Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_LOSS_NETWORK_ATTACK_OPERATION_COUNT = NETWORK_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MultipleMessagesNetworkAttackImpl <em>Multiple Messages Network Attack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MultipleMessagesNetworkAttackImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getMultipleMessagesNetworkAttack()
	 * @generated
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__NAME = NETWORK_ATTACK__NAME;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__PRIORITY = NETWORK_ATTACK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Attack Activation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__ATTACK_ACTIVATION = NETWORK_ATTACK__ATTACK_ACTIVATION;

	/**
	 * The feature id for the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__TOPIC_TO_ATTACK = NETWORK_ATTACK__TOPIC_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = NETWORK_ATTACK__MESSAGES_FROM_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>From Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__FROM_NODES = NETWORK_ATTACK__FROM_NODES;

	/**
	 * The feature id for the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS = NETWORK_ATTACK__MESSAGES_TO_ALL_COMPONENENTS;

	/**
	 * The feature id for the '<em><b>To Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__TO_NODES = NETWORK_ATTACK__TO_NODES;

	/**
	 * The feature id for the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__NODE_TO_ATTACK = NETWORK_ATTACK__NODE_TO_ATTACK;

	/**
	 * The feature id for the '<em><b>All Publishing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__ALL_PUBLISHING_TOPICS = NETWORK_ATTACK__ALL_PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>Publishing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__PUBLISHING_TOPICS = NETWORK_ATTACK__PUBLISHING_TOPICS;

	/**
	 * The feature id for the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS = NETWORK_ATTACK__ALL_SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>Subscribing Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__SUBSCRIBING_TOPICS = NETWORK_ATTACK__SUBSCRIBING_TOPICS;

	/**
	 * The feature id for the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__FROM_TEMPLATE = NETWORK_ATTACK__FROM_TEMPLATE;

	/**
	 * The feature id for the '<em><b>Containing Test</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__CONTAINING_TEST = NETWORK_ATTACK__CONTAINING_TEST;

	/**
	 * The feature id for the '<em><b>How Many Clones</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK__HOW_MANY_CLONES = NETWORK_ATTACK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multiple Messages Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK_FEATURE_COUNT = NETWORK_ATTACK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Multiple Messages Network Attack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_MESSAGES_NETWORK_ATTACK_OPERATION_COUNT = NETWORK_ATTACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime <em>Offline Attack Time</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getOfflineAttackTime()
	 * @generated
	 */
	int OFFLINE_ATTACK_TIME = 36;


	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack <em>Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack
	 * @generated
	 */
	EClass getAttack();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getName()
	 * @see #getAttack()
	 * @generated
	 */
	EAttribute getAttack_Name();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getPriority()
	 * @see #getAttack()
	 * @generated
	 */
	EAttribute getAttack_Priority();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getAttackActivation <em>Attack Activation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attack Activation</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getAttackActivation()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_AttackActivation();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getTopicToAttack <em>Topic To Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Topic To Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getTopicToAttack()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_TopicToAttack();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesFromAllComponenents <em>Messages From All Componenents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Messages From All Componenents</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesFromAllComponenents()
	 * @see #getAttack()
	 * @generated
	 */
	EAttribute getAttack_MessagesFromAllComponenents();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getFromNodes <em>From Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From Nodes</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getFromNodes()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_FromNodes();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesToAllComponenents <em>Messages To All Componenents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Messages To All Componenents</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesToAllComponenents()
	 * @see #getAttack()
	 * @generated
	 */
	EAttribute getAttack_MessagesToAllComponenents();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getToNodes <em>To Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To Nodes</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getToNodes()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_ToNodes();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getNodeToAttack <em>Node To Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node To Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getNodeToAttack()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_NodeToAttack();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllPublishingTopics <em>All Publishing Topics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All Publishing Topics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllPublishingTopics()
	 * @see #getAttack()
	 * @generated
	 */
	EAttribute getAttack_AllPublishingTopics();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getPublishingTopics <em>Publishing Topics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Publishing Topics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getPublishingTopics()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_PublishingTopics();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllSubscribingTopics <em>All Subscribing Topics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All Subscribing Topics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllSubscribingTopics()
	 * @see #getAttack()
	 * @generated
	 */
	EAttribute getAttack_AllSubscribingTopics();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getSubscribingTopics <em>Subscribing Topics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subscribing Topics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getSubscribingTopics()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_SubscribingTopics();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getFromTemplate <em>From Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Template</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getFromTemplate()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_FromTemplate();

	/**
	 * Returns the meta object for the container reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getContainingTest <em>Containing Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Test</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getContainingTest()
	 * @see #getAttack()
	 * @generated
	 */
	EReference getAttack_ContainingTest();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack <em>Offline Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Offline Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack
	 * @generated
	 */
	EClass getOfflineAttack();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack#getAttackTime <em>Attack Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attack Time</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack#getAttackTime()
	 * @see #getOfflineAttack()
	 * @generated
	 */
	EAttribute getOfflineAttack_AttackTime();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomAttack <em>Custom Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomAttack
	 * @generated
	 */
	EClass getCustomAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomOfflineAttack <em>Custom Offline Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Offline Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CustomOfflineAttack
	 * @generated
	 */
	EClass getCustomOfflineAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation <em>Attack Activation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attack Activation</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation
	 * @generated
	 */
	EClass getAttackActivation();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime <em>Attack Fixed Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attack Fixed Time</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime
	 * @generated
	 */
	EClass getAttackFixedTime();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime#getStartTime()
	 * @see #getAttackFixedTime()
	 * @generated
	 */
	EAttribute getAttackFixedTime_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime#getEndTime()
	 * @see #getAttackFixedTime()
	 * @generated
	 */
	EAttribute getAttackFixedTime_EndTime();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased <em>Condition Based</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Based</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased
	 * @generated
	 */
	EClass getConditionBased();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased#getStarting <em>Starting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Starting</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased#getStarting()
	 * @see #getConditionBased()
	 * @generated
	 */
	EReference getConditionBased_Starting();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased#getEnding <em>Ending</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ending</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased#getEnding()
	 * @see #getConditionBased()
	 * @generated
	 */
	EReference getConditionBased_Ending();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.FuzzTestingAttack <em>Fuzz Testing Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fuzz Testing Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.FuzzTestingAttack
	 * @generated
	 */
	EClass getFuzzTestingAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentAttack <em>Component Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentAttack
	 * @generated
	 */
	EClass getComponentAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack <em>Component Property Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Property Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack
	 * @generated
	 */
	EClass getComponentPropertyAttack();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack#getPropertyToAttack <em>Property To Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property To Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack#getPropertyToAttack()
	 * @see #getComponentPropertyAttack()
	 * @generated
	 */
	EReference getComponentPropertyAttack_PropertyToAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack <em>Component Sub Property Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Sub Property Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack
	 * @generated
	 */
	EClass getComponentSubPropertyAttack();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack#getPropertyToAttack <em>Property To Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property To Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack#getPropertyToAttack()
	 * @see #getComponentSubPropertyAttack()
	 * @generated
	 */
	EReference getComponentSubPropertyAttack_PropertyToAttack();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack#getSubProperty <em>Sub Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub Property</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack#getSubProperty()
	 * @see #getComponentSubPropertyAttack()
	 * @generated
	 */
	EReference getComponentSubPropertyAttack_SubProperty();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack <em>Topic Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topic Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack
	 * @generated
	 */
	EClass getTopicAttack();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack#getSubParameters <em>Sub Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Parameters</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack#getSubParameters()
	 * @see #getTopicAttack()
	 * @generated
	 */
	EReference getTopicAttack_SubParameters();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueAttack <em>Random Value Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Value Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueAttack
	 * @generated
	 */
	EClass getRandomValueAttack();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueAttack#getSeed <em>Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seed</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueAttack#getSeed()
	 * @see #getRandomValueAttack()
	 * @generated
	 */
	EAttribute getRandomValueAttack_Seed();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack <em>Random Value From Set Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Value From Set Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack
	 * @generated
	 */
	EClass getRandomValueFromSetAttack();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack#getValueSet <em>Value Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value Set</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack#getValueSet()
	 * @see #getRandomValueFromSetAttack()
	 * @generated
	 */
	EReference getRandomValueFromSetAttack_ValueSet();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueSet <em>Value Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Set</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueSet
	 * @generated
	 */
	EClass getValueSet();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueRange <em>Value Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Range</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueRange
	 * @generated
	 */
	EClass getValueRange();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueRange#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueRange#getPropertyName()
	 * @see #getValueRange()
	 * @generated
	 */
	EAttribute getValueRange_PropertyName();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange <em>Int Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Range</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange
	 * @generated
	 */
	EClass getIntRange();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange#getLowerBound()
	 * @see #getIntRange()
	 * @generated
	 */
	EAttribute getIntRange_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IntRange#getUpperBound()
	 * @see #getIntRange()
	 * @generated
	 */
	EAttribute getIntRange_UpperBound();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange <em>Double Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Range</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange
	 * @generated
	 */
	EClass getDoubleRange();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange#getLowerBound()
	 * @see #getDoubleRange()
	 * @generated
	 */
	EAttribute getDoubleRange_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange#getUpperBound()
	 * @see #getDoubleRange()
	 * @generated
	 */
	EAttribute getDoubleRange_UpperBound();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange <em>String Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Range</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange
	 * @generated
	 */
	EClass getStringRange();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange#getLowerBound()
	 * @see #getStringRange()
	 * @generated
	 */
	EAttribute getStringRange_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StringRange#getUpperBound()
	 * @see #getStringRange()
	 * @generated
	 */
	EAttribute getStringRange_UpperBound();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ExternalResourceSet <em>External Resource Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Resource Set</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ExternalResourceSet
	 * @generated
	 */
	EClass getExternalResourceSet();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ExternalResourceSet#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ExternalResourceSet#getLocation()
	 * @see #getExternalResourceSet()
	 * @generated
	 */
	EAttribute getExternalResourceSet_Location();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ResourceAttack <em>Resource Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ResourceAttack
	 * @generated
	 */
	EClass getResourceAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StateAttack <em>State Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.StateAttack
	 * @generated
	 */
	EClass getStateAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.NetworkAttack <em>Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.NetworkAttack
	 * @generated
	 */
	EClass getNetworkAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack <em>Load Resource Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Load Resource Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack
	 * @generated
	 */
	EClass getLoadResourceAttack();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack#getLoadType <em>Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Load Type</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack#getLoadType()
	 * @see #getLoadResourceAttack()
	 * @generated
	 */
	EReference getLoadResourceAttack_LoadType();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType <em>Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Load Type</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType
	 * @generated
	 */
	EClass getLoadType();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType#getMin()
	 * @see #getLoadType()
	 * @generated
	 */
	EAttribute getLoadType_Min();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadType#getMax()
	 * @see #getLoadType()
	 * @generated
	 */
	EAttribute getLoadType_Max();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CPULoadType <em>CPU Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPU Load Type</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.CPULoadType
	 * @generated
	 */
	EClass getCPULoadType();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MemoryLoadType <em>Memory Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Load Type</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MemoryLoadType
	 * @generated
	 */
	EClass getMemoryLoadType();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IOLoadType <em>IO Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IO Load Type</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.IOLoadType
	 * @generated
	 */
	EClass getIOLoadType();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DiskLoadType <em>Disk Load Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disk Load Type</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DiskLoadType
	 * @generated
	 */
	EClass getDiskLoadType();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ShutdownStateAttack <em>Shutdown State Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shutdown State Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ShutdownStateAttack
	 * @generated
	 */
	EClass getShutdownStateAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TimeTravelStateAttack <em>Time Travel State Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Travel State Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TimeTravelStateAttack
	 * @generated
	 */
	EClass getTimeTravelStateAttack();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TimeTravelStateAttack#getTimeTravelValue <em>Time Travel Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Travel Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TimeTravelStateAttack#getTimeTravelValue()
	 * @see #getTimeTravelStateAttack()
	 * @generated
	 */
	EReference getTimeTravelStateAttack_TimeTravelValue();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ProcessKillerStateAttack <em>Process Killer State Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Killer State Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ProcessKillerStateAttack
	 * @generated
	 */
	EClass getProcessKillerStateAttack();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ProcessKillerStateAttack#getProcessId <em>Process Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Id</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ProcessKillerStateAttack#getProcessId()
	 * @see #getProcessKillerStateAttack()
	 * @generated
	 */
	EAttribute getProcessKillerStateAttack_ProcessId();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.BlackholeNetworkAttack <em>Blackhole Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blackhole Network Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.BlackholeNetworkAttack
	 * @generated
	 */
	EClass getBlackholeNetworkAttack();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack <em>Latency Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Latency Network Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack
	 * @generated
	 */
	EClass getLatencyNetworkAttack();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack#getLatency <em>Latency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Latency</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack#getLatency()
	 * @see #getLatencyNetworkAttack()
	 * @generated
	 */
	EReference getLatencyNetworkAttack_Latency();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack <em>Packet Loss Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packet Loss Network Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack
	 * @generated
	 */
	EClass getPacketLossNetworkAttack();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Frequency</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack#getFrequency()
	 * @see #getPacketLossNetworkAttack()
	 * @generated
	 */
	EReference getPacketLossNetworkAttack_Frequency();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack <em>Multiple Messages Network Attack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple Messages Network Attack</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack
	 * @generated
	 */
	EClass getMultipleMessagesNetworkAttack();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack#getHowManyClones <em>How Many Clones</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>How Many Clones</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack#getHowManyClones()
	 * @see #getMultipleMessagesNetworkAttack()
	 * @generated
	 */
	EReference getMultipleMessagesNetworkAttack_HowManyClones();

	/**
	 * Returns the meta object for enum '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime <em>Offline Attack Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Offline Attack Time</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime
	 * @generated
	 */
	EEnum getOfflineAttackTime();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AttacksFactory getAttacksFactory();

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
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl <em>Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getAttack()
		 * @generated
		 */
		EClass ATTACK = eINSTANCE.getAttack();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK__NAME = eINSTANCE.getAttack_Name();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK__PRIORITY = eINSTANCE.getAttack_Priority();

		/**
		 * The meta object literal for the '<em><b>Attack Activation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__ATTACK_ACTIVATION = eINSTANCE.getAttack_AttackActivation();

		/**
		 * The meta object literal for the '<em><b>Topic To Attack</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__TOPIC_TO_ATTACK = eINSTANCE.getAttack_TopicToAttack();

		/**
		 * The meta object literal for the '<em><b>Messages From All Componenents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK__MESSAGES_FROM_ALL_COMPONENENTS = eINSTANCE.getAttack_MessagesFromAllComponenents();

		/**
		 * The meta object literal for the '<em><b>From Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__FROM_NODES = eINSTANCE.getAttack_FromNodes();

		/**
		 * The meta object literal for the '<em><b>Messages To All Componenents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK__MESSAGES_TO_ALL_COMPONENENTS = eINSTANCE.getAttack_MessagesToAllComponenents();

		/**
		 * The meta object literal for the '<em><b>To Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__TO_NODES = eINSTANCE.getAttack_ToNodes();

		/**
		 * The meta object literal for the '<em><b>Node To Attack</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__NODE_TO_ATTACK = eINSTANCE.getAttack_NodeToAttack();

		/**
		 * The meta object literal for the '<em><b>All Publishing Topics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK__ALL_PUBLISHING_TOPICS = eINSTANCE.getAttack_AllPublishingTopics();

		/**
		 * The meta object literal for the '<em><b>Publishing Topics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__PUBLISHING_TOPICS = eINSTANCE.getAttack_PublishingTopics();

		/**
		 * The meta object literal for the '<em><b>All Subscribing Topics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK__ALL_SUBSCRIBING_TOPICS = eINSTANCE.getAttack_AllSubscribingTopics();

		/**
		 * The meta object literal for the '<em><b>Subscribing Topics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__SUBSCRIBING_TOPICS = eINSTANCE.getAttack_SubscribingTopics();

		/**
		 * The meta object literal for the '<em><b>From Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__FROM_TEMPLATE = eINSTANCE.getAttack_FromTemplate();

		/**
		 * The meta object literal for the '<em><b>Containing Test</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACK__CONTAINING_TEST = eINSTANCE.getAttack_ContainingTest();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.OfflineAttackImpl <em>Offline Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.OfflineAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getOfflineAttack()
		 * @generated
		 */
		EClass OFFLINE_ATTACK = eINSTANCE.getOfflineAttack();

		/**
		 * The meta object literal for the '<em><b>Attack Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OFFLINE_ATTACK__ATTACK_TIME = eINSTANCE.getOfflineAttack_AttackTime();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CustomAttackImpl <em>Custom Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CustomAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getCustomAttack()
		 * @generated
		 */
		EClass CUSTOM_ATTACK = eINSTANCE.getCustomAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CustomOfflineAttackImpl <em>Custom Offline Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CustomOfflineAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getCustomOfflineAttack()
		 * @generated
		 */
		EClass CUSTOM_OFFLINE_ATTACK = eINSTANCE.getCustomOfflineAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackActivationImpl <em>Attack Activation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackActivationImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getAttackActivation()
		 * @generated
		 */
		EClass ATTACK_ACTIVATION = eINSTANCE.getAttackActivation();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackFixedTimeImpl <em>Attack Fixed Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackFixedTimeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getAttackFixedTime()
		 * @generated
		 */
		EClass ATTACK_FIXED_TIME = eINSTANCE.getAttackFixedTime();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_FIXED_TIME__START_TIME = eINSTANCE.getAttackFixedTime_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACK_FIXED_TIME__END_TIME = eINSTANCE.getAttackFixedTime_EndTime();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ConditionBasedImpl <em>Condition Based</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ConditionBasedImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getConditionBased()
		 * @generated
		 */
		EClass CONDITION_BASED = eINSTANCE.getConditionBased();

		/**
		 * The meta object literal for the '<em><b>Starting</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_BASED__STARTING = eINSTANCE.getConditionBased_Starting();

		/**
		 * The meta object literal for the '<em><b>Ending</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_BASED__ENDING = eINSTANCE.getConditionBased_Ending();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.FuzzTestingAttackImpl <em>Fuzz Testing Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.FuzzTestingAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getFuzzTestingAttack()
		 * @generated
		 */
		EClass FUZZ_TESTING_ATTACK = eINSTANCE.getFuzzTestingAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentAttackImpl <em>Component Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getComponentAttack()
		 * @generated
		 */
		EClass COMPONENT_ATTACK = eINSTANCE.getComponentAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentPropertyAttackImpl <em>Component Property Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentPropertyAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getComponentPropertyAttack()
		 * @generated
		 */
		EClass COMPONENT_PROPERTY_ATTACK = eINSTANCE.getComponentPropertyAttack();

		/**
		 * The meta object literal for the '<em><b>Property To Attack</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK = eINSTANCE.getComponentPropertyAttack_PropertyToAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentSubPropertyAttackImpl <em>Component Sub Property Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentSubPropertyAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getComponentSubPropertyAttack()
		 * @generated
		 */
		EClass COMPONENT_SUB_PROPERTY_ATTACK = eINSTANCE.getComponentSubPropertyAttack();

		/**
		 * The meta object literal for the '<em><b>Property To Attack</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_SUB_PROPERTY_ATTACK__PROPERTY_TO_ATTACK = eINSTANCE.getComponentSubPropertyAttack_PropertyToAttack();

		/**
		 * The meta object literal for the '<em><b>Sub Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_SUB_PROPERTY_ATTACK__SUB_PROPERTY = eINSTANCE.getComponentSubPropertyAttack_SubProperty();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TopicAttackImpl <em>Topic Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TopicAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getTopicAttack()
		 * @generated
		 */
		EClass TOPIC_ATTACK = eINSTANCE.getTopicAttack();

		/**
		 * The meta object literal for the '<em><b>Sub Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPIC_ATTACK__SUB_PARAMETERS = eINSTANCE.getTopicAttack_SubParameters();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.RandomValueAttackImpl <em>Random Value Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.RandomValueAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getRandomValueAttack()
		 * @generated
		 */
		EClass RANDOM_VALUE_ATTACK = eINSTANCE.getRandomValueAttack();

		/**
		 * The meta object literal for the '<em><b>Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_VALUE_ATTACK__SEED = eINSTANCE.getRandomValueAttack_Seed();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.RandomValueFromSetAttackImpl <em>Random Value From Set Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.RandomValueFromSetAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getRandomValueFromSetAttack()
		 * @generated
		 */
		EClass RANDOM_VALUE_FROM_SET_ATTACK = eINSTANCE.getRandomValueFromSetAttack();

		/**
		 * The meta object literal for the '<em><b>Value Set</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANDOM_VALUE_FROM_SET_ATTACK__VALUE_SET = eINSTANCE.getRandomValueFromSetAttack_ValueSet();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ValueSetImpl <em>Value Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ValueSetImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getValueSet()
		 * @generated
		 */
		EClass VALUE_SET = eINSTANCE.getValueSet();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ValueRangeImpl <em>Value Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ValueRangeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getValueRange()
		 * @generated
		 */
		EClass VALUE_RANGE = eINSTANCE.getValueRange();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_RANGE__PROPERTY_NAME = eINSTANCE.getValueRange_PropertyName();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.IntRangeImpl <em>Int Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.IntRangeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getIntRange()
		 * @generated
		 */
		EClass INT_RANGE = eINSTANCE.getIntRange();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_RANGE__LOWER_BOUND = eINSTANCE.getIntRange_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_RANGE__UPPER_BOUND = eINSTANCE.getIntRange_UpperBound();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.DoubleRangeImpl <em>Double Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.DoubleRangeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getDoubleRange()
		 * @generated
		 */
		EClass DOUBLE_RANGE = eINSTANCE.getDoubleRange();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE__LOWER_BOUND = eINSTANCE.getDoubleRange_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE__UPPER_BOUND = eINSTANCE.getDoubleRange_UpperBound();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.StringRangeImpl <em>String Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.StringRangeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getStringRange()
		 * @generated
		 */
		EClass STRING_RANGE = eINSTANCE.getStringRange();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_RANGE__LOWER_BOUND = eINSTANCE.getStringRange_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_RANGE__UPPER_BOUND = eINSTANCE.getStringRange_UpperBound();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ExternalResourceSetImpl <em>External Resource Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ExternalResourceSetImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getExternalResourceSet()
		 * @generated
		 */
		EClass EXTERNAL_RESOURCE_SET = eINSTANCE.getExternalResourceSet();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_RESOURCE_SET__LOCATION = eINSTANCE.getExternalResourceSet_Location();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ResourceAttackImpl <em>Resource Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ResourceAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getResourceAttack()
		 * @generated
		 */
		EClass RESOURCE_ATTACK = eINSTANCE.getResourceAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.StateAttackImpl <em>State Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.StateAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getStateAttack()
		 * @generated
		 */
		EClass STATE_ATTACK = eINSTANCE.getStateAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.NetworkAttackImpl <em>Network Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.NetworkAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getNetworkAttack()
		 * @generated
		 */
		EClass NETWORK_ATTACK = eINSTANCE.getNetworkAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LoadResourceAttackImpl <em>Load Resource Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LoadResourceAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getLoadResourceAttack()
		 * @generated
		 */
		EClass LOAD_RESOURCE_ATTACK = eINSTANCE.getLoadResourceAttack();

		/**
		 * The meta object literal for the '<em><b>Load Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOAD_RESOURCE_ATTACK__LOAD_TYPE = eINSTANCE.getLoadResourceAttack_LoadType();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LoadTypeImpl <em>Load Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LoadTypeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getLoadType()
		 * @generated
		 */
		EClass LOAD_TYPE = eINSTANCE.getLoadType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_TYPE__MIN = eINSTANCE.getLoadType_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_TYPE__MAX = eINSTANCE.getLoadType_Max();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CPULoadTypeImpl <em>CPU Load Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.CPULoadTypeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getCPULoadType()
		 * @generated
		 */
		EClass CPU_LOAD_TYPE = eINSTANCE.getCPULoadType();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MemoryLoadTypeImpl <em>Memory Load Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MemoryLoadTypeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getMemoryLoadType()
		 * @generated
		 */
		EClass MEMORY_LOAD_TYPE = eINSTANCE.getMemoryLoadType();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.IOLoadTypeImpl <em>IO Load Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.IOLoadTypeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getIOLoadType()
		 * @generated
		 */
		EClass IO_LOAD_TYPE = eINSTANCE.getIOLoadType();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.DiskLoadTypeImpl <em>Disk Load Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.DiskLoadTypeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getDiskLoadType()
		 * @generated
		 */
		EClass DISK_LOAD_TYPE = eINSTANCE.getDiskLoadType();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ShutdownStateAttackImpl <em>Shutdown State Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ShutdownStateAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getShutdownStateAttack()
		 * @generated
		 */
		EClass SHUTDOWN_STATE_ATTACK = eINSTANCE.getShutdownStateAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TimeTravelStateAttackImpl <em>Time Travel State Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TimeTravelStateAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getTimeTravelStateAttack()
		 * @generated
		 */
		EClass TIME_TRAVEL_STATE_ATTACK = eINSTANCE.getTimeTravelStateAttack();

		/**
		 * The meta object literal for the '<em><b>Time Travel Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE = eINSTANCE.getTimeTravelStateAttack_TimeTravelValue();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ProcessKillerStateAttackImpl <em>Process Killer State Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ProcessKillerStateAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getProcessKillerStateAttack()
		 * @generated
		 */
		EClass PROCESS_KILLER_STATE_ATTACK = eINSTANCE.getProcessKillerStateAttack();

		/**
		 * The meta object literal for the '<em><b>Process Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_KILLER_STATE_ATTACK__PROCESS_ID = eINSTANCE.getProcessKillerStateAttack_ProcessId();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.BlackholeNetworkAttackImpl <em>Blackhole Network Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.BlackholeNetworkAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getBlackholeNetworkAttack()
		 * @generated
		 */
		EClass BLACKHOLE_NETWORK_ATTACK = eINSTANCE.getBlackholeNetworkAttack();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LatencyNetworkAttackImpl <em>Latency Network Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.LatencyNetworkAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getLatencyNetworkAttack()
		 * @generated
		 */
		EClass LATENCY_NETWORK_ATTACK = eINSTANCE.getLatencyNetworkAttack();

		/**
		 * The meta object literal for the '<em><b>Latency</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LATENCY_NETWORK_ATTACK__LATENCY = eINSTANCE.getLatencyNetworkAttack_Latency();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.PacketLossNetworkAttackImpl <em>Packet Loss Network Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.PacketLossNetworkAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getPacketLossNetworkAttack()
		 * @generated
		 */
		EClass PACKET_LOSS_NETWORK_ATTACK = eINSTANCE.getPacketLossNetworkAttack();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKET_LOSS_NETWORK_ATTACK__FREQUENCY = eINSTANCE.getPacketLossNetworkAttack_Frequency();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MultipleMessagesNetworkAttackImpl <em>Multiple Messages Network Attack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MultipleMessagesNetworkAttackImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getMultipleMessagesNetworkAttack()
		 * @generated
		 */
		EClass MULTIPLE_MESSAGES_NETWORK_ATTACK = eINSTANCE.getMultipleMessagesNetworkAttack();

		/**
		 * The meta object literal for the '<em><b>How Many Clones</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLE_MESSAGES_NETWORK_ATTACK__HOW_MANY_CLONES = eINSTANCE.getMultipleMessagesNetworkAttack_HowManyClones();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime <em>Offline Attack Time</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl#getOfflineAttackTime()
		 * @generated
		 */
		EEnum OFFLINE_ATTACK_TIME = eINSTANCE.getOfflineAttackTime();

	}

} //AttacksPackage
