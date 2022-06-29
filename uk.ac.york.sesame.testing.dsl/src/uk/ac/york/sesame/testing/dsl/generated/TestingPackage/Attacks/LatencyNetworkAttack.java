/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Latency Network Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack#getLatency <em>Latency</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getLatencyNetworkAttack()
 * @model
 * @generated
 */
public interface LatencyNetworkAttack extends NetworkAttack {
	/**
	 * Returns the value of the '<em><b>Latency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latency</em>' containment reference.
	 * @see #setLatency(DoubleRange)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getLatencyNetworkAttack_Latency()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DoubleRange getLatency();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.LatencyNetworkAttack#getLatency <em>Latency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latency</em>' containment reference.
	 * @see #getLatency()
	 * @generated
	 */
	void setLatency(DoubleRange value);

} // LatencyNetworkAttack