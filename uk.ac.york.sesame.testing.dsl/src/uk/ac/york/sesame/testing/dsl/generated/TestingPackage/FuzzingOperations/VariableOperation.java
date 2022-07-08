/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations;

import org.eclipse.emf.common.util.EList;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.VariableOperation#getSubParameters <em>Sub Parameters</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getVariableOperation()
 * @model
 * @generated
 */
public interface VariableOperation extends FuzzTestingOperation {
	/**
	 * Returns the value of the '<em><b>Sub Parameters</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Parameters</em>' reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getVariableOperation_SubParameters()
	 * @model
	 * @generated
	 */
	EList<Parameter> getSubParameters();

} // VariableOperation
