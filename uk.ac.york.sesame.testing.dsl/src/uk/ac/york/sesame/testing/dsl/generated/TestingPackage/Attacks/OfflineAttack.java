/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Offline Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack#getAttackTime <em>Attack Time</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getOfflineAttack()
 * @model
 * @generated
 */
public interface OfflineAttack extends Attack {
	/**
	 * Returns the value of the '<em><b>Attack Time</b></em>' attribute.
	 * The literals are from the enumeration {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attack Time</em>' attribute.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime
	 * @see #setAttackTime(OfflineAttackTime)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getOfflineAttack_AttackTime()
	 * @model
	 * @generated
	 */
	OfflineAttackTime getAttackTime();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack#getAttackTime <em>Attack Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attack Time</em>' attribute.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime
	 * @see #getAttackTime()
	 * @generated
	 */
	void setAttackTime(OfflineAttackTime value);

} // OfflineAttack
