/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Travel State Operaton</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.TimeTravelStateOperaton#getTimeTravelValue <em>Time Travel Value</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getTimeTravelStateOperaton()
 * @model
 * @generated
 */
public interface TimeTravelStateOperaton extends StateFuzzingOperation {
	/**
	 * Returns the value of the '<em><b>Time Travel Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Travel Value</em>' containment reference.
	 * @see #setTimeTravelValue(DoubleRange)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getTimeTravelStateOperaton_TimeTravelValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DoubleRange getTimeTravelValue();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.TimeTravelStateOperaton#getTimeTravelValue <em>Time Travel Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Travel Value</em>' containment reference.
	 * @see #getTimeTravelValue()
	 * @generated
	 */
	void setTimeTravelValue(DoubleRange value);

} // TimeTravelStateOperaton
