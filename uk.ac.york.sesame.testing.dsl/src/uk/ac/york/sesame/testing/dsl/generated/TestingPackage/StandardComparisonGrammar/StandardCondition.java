/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition#getC <em>C</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarPackage#getStandardCondition()
 * @model
 * @generated
 */
public interface StandardCondition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarPackage#getStandardCondition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>C</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C</em>' containment reference.
	 * @see #setC(ConditionElement)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarPackage#getStandardCondition_C()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConditionElement getC();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition#getC <em>C</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>C</em>' containment reference.
	 * @see #getC()
	 * @generated
	 */
	void setC(ConditionElement value);

} // StandardCondition
