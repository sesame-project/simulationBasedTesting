/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.ComponentProperty;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Type;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Sub Property Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack#getPropertyToAttack <em>Property To Attack</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack#getSubProperty <em>Sub Property</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getComponentSubPropertyAttack()
 * @model
 * @generated
 */
public interface ComponentSubPropertyAttack extends FuzzTestingAttack {

	/**
	 * Returns the value of the '<em><b>Property To Attack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property To Attack</em>' reference.
	 * @see #setPropertyToAttack(ComponentProperty)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getComponentSubPropertyAttack_PropertyToAttack()
	 * @model
	 * @generated
	 */
	ComponentProperty getPropertyToAttack();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack#getPropertyToAttack <em>Property To Attack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property To Attack</em>' reference.
	 * @see #getPropertyToAttack()
	 * @generated
	 */
	void setPropertyToAttack(ComponentProperty value);

	/**
	 * Returns the value of the '<em><b>Sub Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Property</em>' reference.
	 * @see #setSubProperty(Type)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getComponentSubPropertyAttack_SubProperty()
	 * @model
	 * @generated
	 */
	Type getSubProperty();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack#getSubProperty <em>Sub Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Property</em>' reference.
	 * @see #getSubProperty()
	 * @generated
	 */
	void setSubProperty(Type value);
} // ComponentSubPropertyAttack
