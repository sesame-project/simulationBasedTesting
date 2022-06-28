/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Node;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getPriority <em>Priority</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getAttackActivation <em>Attack Activation</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getTopicToAttack <em>Topic To Attack</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesFromAllComponenents <em>Messages From All Componenents</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getFromNodes <em>From Nodes</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesToAllComponenents <em>Messages To All Componenents</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getToNodes <em>To Nodes</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getNodeToAttack <em>Node To Attack</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllPublishingTopics <em>All Publishing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getPublishingTopics <em>Publishing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllSubscribingTopics <em>All Subscribing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getSubscribingTopics <em>Subscribing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getFromTemplate <em>From Template</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getContainingTest <em>Containing Test</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack()
 * @model
 * @generated
 */
public interface Attack extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Attack Activation</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attack Activation</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_AttackActivation()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackActivation> getAttackActivation();

	/**
	 * Returns the value of the '<em><b>Topic To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topic To Attack</em>' reference.
	 * @see #setTopicToAttack(Topic)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_TopicToAttack()
	 * @model
	 * @generated
	 */
	Topic getTopicToAttack();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getTopicToAttack <em>Topic To Attack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topic To Attack</em>' reference.
	 * @see #getTopicToAttack()
	 * @generated
	 */
	void setTopicToAttack(Topic value);

	/**
	 * Returns the value of the '<em><b>Messages From All Componenents</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages From All Componenents</em>' attribute.
	 * @see #setMessagesFromAllComponenents(boolean)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_MessagesFromAllComponenents()
	 * @model default="true"
	 * @generated
	 */
	boolean isMessagesFromAllComponenents();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesFromAllComponenents <em>Messages From All Componenents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Messages From All Componenents</em>' attribute.
	 * @see #isMessagesFromAllComponenents()
	 * @generated
	 */
	void setMessagesFromAllComponenents(boolean value);

	/**
	 * Returns the value of the '<em><b>From Nodes</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Nodes</em>' reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_FromNodes()
	 * @model
	 * @generated
	 */
	EList<Node> getFromNodes();

	/**
	 * Returns the value of the '<em><b>Messages To All Componenents</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages To All Componenents</em>' attribute.
	 * @see #setMessagesToAllComponenents(boolean)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_MessagesToAllComponenents()
	 * @model default="true"
	 * @generated
	 */
	boolean isMessagesToAllComponenents();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesToAllComponenents <em>Messages To All Componenents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Messages To All Componenents</em>' attribute.
	 * @see #isMessagesToAllComponenents()
	 * @generated
	 */
	void setMessagesToAllComponenents(boolean value);

	/**
	 * Returns the value of the '<em><b>To Nodes</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Nodes</em>' reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_ToNodes()
	 * @model
	 * @generated
	 */
	EList<Node> getToNodes();

	/**
	 * Returns the value of the '<em><b>Node To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node To Attack</em>' reference.
	 * @see #setNodeToAttack(Node)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_NodeToAttack()
	 * @model
	 * @generated
	 */
	Node getNodeToAttack();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getNodeToAttack <em>Node To Attack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node To Attack</em>' reference.
	 * @see #getNodeToAttack()
	 * @generated
	 */
	void setNodeToAttack(Node value);

	/**
	 * Returns the value of the '<em><b>All Publishing Topics</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Publishing Topics</em>' attribute.
	 * @see #setAllPublishingTopics(boolean)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_AllPublishingTopics()
	 * @model default="false"
	 * @generated
	 */
	boolean isAllPublishingTopics();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllPublishingTopics <em>All Publishing Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All Publishing Topics</em>' attribute.
	 * @see #isAllPublishingTopics()
	 * @generated
	 */
	void setAllPublishingTopics(boolean value);

	/**
	 * Returns the value of the '<em><b>Publishing Topics</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publishing Topics</em>' reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_PublishingTopics()
	 * @model
	 * @generated
	 */
	EList<Topic> getPublishingTopics();

	/**
	 * Returns the value of the '<em><b>All Subscribing Topics</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Subscribing Topics</em>' attribute.
	 * @see #setAllSubscribingTopics(boolean)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_AllSubscribingTopics()
	 * @model default="false"
	 * @generated
	 */
	boolean isAllSubscribingTopics();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllSubscribingTopics <em>All Subscribing Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All Subscribing Topics</em>' attribute.
	 * @see #isAllSubscribingTopics()
	 * @generated
	 */
	void setAllSubscribingTopics(boolean value);

	/**
	 * Returns the value of the '<em><b>Subscribing Topics</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscribing Topics</em>' reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_SubscribingTopics()
	 * @model
	 * @generated
	 */
	EList<Topic> getSubscribingTopics();

	/**
	 * Returns the value of the '<em><b>From Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Template</em>' reference.
	 * @see #setFromTemplate(Attack)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_FromTemplate()
	 * @model
	 * @generated
	 */
	Attack getFromTemplate();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#getFromTemplate <em>From Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Template</em>' reference.
	 * @see #getFromTemplate()
	 * @generated
	 */
	void setFromTemplate(Attack value);

	/**
	 * Returns the value of the '<em><b>Containing Test</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getAttacks <em>Attacks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Test</em>' container reference.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getAttack_ContainingTest()
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test#getAttacks
	 * @model opposite="attacks" changeable="false"
	 * @generated
	 */
	Test getContainingTest();

} // Attack
