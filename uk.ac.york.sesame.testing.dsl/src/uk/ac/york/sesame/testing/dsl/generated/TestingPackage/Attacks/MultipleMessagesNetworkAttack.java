/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiple Messages Network Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack#getHowManyClones <em>How Many Clones</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getMultipleMessagesNetworkAttack()
 * @model
 * @generated
 */
public interface MultipleMessagesNetworkAttack extends NetworkAttack {
	/**
	 * Returns the value of the '<em><b>How Many Clones</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>How Many Clones</em>' containment reference.
	 * @see #setHowManyClones(IntRange)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getMultipleMessagesNetworkAttack_HowManyClones()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntRange getHowManyClones();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack#getHowManyClones <em>How Many Clones</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>How Many Clones</em>' containment reference.
	 * @see #getHowManyClones()
	 * @generated
	 */
	void setHowManyClones(IntRange value);

} // MultipleMessagesNetworkAttack
