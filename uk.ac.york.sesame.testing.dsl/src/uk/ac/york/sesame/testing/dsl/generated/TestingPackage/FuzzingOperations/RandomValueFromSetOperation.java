/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Value From Set Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.RandomValueFromSetOperation#getValueSet <em>Value Set</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getRandomValueFromSetOperation()
 * @model
 * @generated
 */
public interface RandomValueFromSetOperation extends RandomValueFuzzingOperation {
	/**
	 * Returns the value of the '<em><b>Value Set</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ValueSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Set</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getRandomValueFromSetOperation_ValueSet()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueSet> getValueSet();

} // RandomValueFromSetOperation
