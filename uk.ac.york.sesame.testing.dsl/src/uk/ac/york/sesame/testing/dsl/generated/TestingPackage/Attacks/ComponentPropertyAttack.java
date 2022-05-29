/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.ComponentProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Property Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack#getPropertyToAttack <em>Property To Attack</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getComponentPropertyAttack()
 * @model
 * @generated
 */
public interface ComponentPropertyAttack extends FuzzTestingAttack {

	/**
	 * Returns the value of the '<em><b>Property To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property To Attack</em>' reference.
	 * @see #setPropertyToAttack(ComponentProperty)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getComponentPropertyAttack_PropertyToAttack()
	 * @model
	 * @generated
	 */
	ComponentProperty getPropertyToAttack();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack#getPropertyToAttack <em>Property To Attack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property To Attack</em>' reference.
	 * @see #getPropertyToAttack()
	 * @generated
	 */
	void setPropertyToAttack(ComponentProperty value);
} // ComponentPropertyAttack
