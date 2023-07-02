/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.ComponentProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Property Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ComponentPropertyOperation#getPropertyToAffect <em>Property To Affect</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getComponentPropertyOperation()
 * @model
 * @generated
 */
public interface ComponentPropertyOperation extends FuzzTestingOperation {
	/**
	 * Returns the value of the '<em><b>Property To Affect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property To Affect</em>' reference.
	 * @see #setPropertyToAffect(ComponentProperty)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getComponentPropertyOperation_PropertyToAffect()
	 * @model
	 * @generated
	 */
	ComponentProperty getPropertyToAffect();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ComponentPropertyOperation#getPropertyToAffect <em>Property To Affect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property To Affect</em>' reference.
	 * @see #getPropertyToAffect()
	 * @generated
	 */
	void setPropertyToAffect(ComponentProperty value);

} // ComponentPropertyOperation
