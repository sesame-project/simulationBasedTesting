/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.DynamicVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.VariableOperation#getVariableToAffect <em>Variable To Affect</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getVariableOperation()
 * @model abstract="true"
 * @generated
 */
public interface VariableOperation extends PotentiallyStaticOperation {
	/**
	 * Returns the value of the '<em><b>Variable To Affect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable To Affect</em>' reference.
	 * @see #setVariableToAffect(DynamicVariable)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getVariableOperation_VariableToAffect()
	 * @model
	 * @generated
	 */
	DynamicVariable getVariableToAffect();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.VariableOperation#getVariableToAffect <em>Variable To Affect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable To Affect</em>' reference.
	 * @see #getVariableToAffect()
	 * @generated
	 */
	void setVariableToAffect(DynamicVariable value);

} // VariableOperation
