/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Based</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased#getStarting <em>Starting</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased#getEnding <em>Ending</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getConditionBased()
 * @model
 * @generated
 */
public interface ConditionBased extends AttackActivation {

	/**
	 * Returns the value of the '<em><b>Starting</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starting</em>' containment reference.
	 * @see #setStarting(StandardCondition)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getConditionBased_Starting()
	 * @model containment="true"
	 * @generated
	 */
	StandardCondition getStarting();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased#getStarting <em>Starting</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting</em>' containment reference.
	 * @see #getStarting()
	 * @generated
	 */
	void setStarting(StandardCondition value);

	/**
	 * Returns the value of the '<em><b>Ending</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ending</em>' containment reference.
	 * @see #setEnding(StandardCondition)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getConditionBased_Ending()
	 * @model containment="true"
	 * @generated
	 */
	StandardCondition getEnding();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased#getEnding <em>Ending</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ending</em>' containment reference.
	 * @see #getEnding()
	 * @generated
	 */
	void setEnding(StandardCondition value);
} // ConditionBased
