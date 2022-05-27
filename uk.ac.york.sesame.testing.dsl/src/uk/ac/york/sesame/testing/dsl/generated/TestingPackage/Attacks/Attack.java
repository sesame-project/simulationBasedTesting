/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

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
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesFromAllComponenents <em>Messages From All Componenents</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isMessagesToAllComponenents <em>Messages To All Componenents</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllPublishingTopics <em>All Publishing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack#isAllSubscribingTopics <em>All Subscribing Topics</em>}</li>
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

} // Attack
