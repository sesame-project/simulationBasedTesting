/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packet Loss Network Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack#getFrequency <em>Frequency</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getPacketLossNetworkAttack()
 * @model
 * @generated
 */
public interface PacketLossNetworkAttack extends NetworkAttack {
	/**
	 * Returns the value of the '<em><b>Frequency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frequency</em>' containment reference.
	 * @see #setFrequency(DoubleRange)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getPacketLossNetworkAttack_Frequency()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DoubleRange getFrequency();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.PacketLossNetworkAttack#getFrequency <em>Frequency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frequency</em>' containment reference.
	 * @see #getFrequency()
	 * @generated
	 */
	void setFrequency(DoubleRange value);

} // PacketLossNetworkAttack
