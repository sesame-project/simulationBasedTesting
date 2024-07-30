/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.GenericVariable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Potentially Static Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PotentiallyStaticOperation#getActivation <em>Activation</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PotentiallyStaticOperation#getVariableToAffect <em>Variable To Affect</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getPotentiallyStaticOperation()
 * @model abstract="true"
 * @generated
 */
public interface PotentiallyStaticOperation extends FuzzTestingOperation {
	/**
	 * Returns the value of the '<em><b>Activation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activation</em>' containment reference.
	 * @see #setActivation(Activation)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getPotentiallyStaticOperation_Activation()
	 * @model containment="true"
	 * @generated
	 */
	Activation getActivation();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PotentiallyStaticOperation#getActivation <em>Activation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activation</em>' containment reference.
	 * @see #getActivation()
	 * @generated
	 */
	void setActivation(Activation value);

	/**
	 * Returns the value of the '<em><b>Variable To Affect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable To Affect</em>' reference.
	 * @see #setVariableToAffect(GenericVariable)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage#getPotentiallyStaticOperation_VariableToAffect()
	 * @model
	 * @generated
	 */
	GenericVariable getVariableToAffect();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PotentiallyStaticOperation#getVariableToAffect <em>Variable To Affect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable To Affect</em>' reference.
	 * @see #getVariableToAffect()
	 * @generated
	 */
	void setVariableToAffect(GenericVariable value);

} // PotentiallyStaticOperation
