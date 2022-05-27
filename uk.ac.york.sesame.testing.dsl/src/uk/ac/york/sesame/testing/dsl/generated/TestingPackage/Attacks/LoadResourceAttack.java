/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Resource Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack#getLoadType <em>Load Type</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getLoadResourceAttack()
 * @model
 * @generated
 */
public interface LoadResourceAttack extends ResourceAttack {
	/**
	 * Returns the value of the '<em><b>Load Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Type</em>' reference.
	 * @see #setLoadType(LoadType)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getLoadResourceAttack_LoadType()
	 * @model required="true"
	 * @generated
	 */
	LoadType getLoadType();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LoadResourceAttack#getLoadType <em>Load Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Type</em>' reference.
	 * @see #getLoadType()
	 * @generated
	 */
	void setLoadType(LoadType value);

} // LoadResourceAttack
