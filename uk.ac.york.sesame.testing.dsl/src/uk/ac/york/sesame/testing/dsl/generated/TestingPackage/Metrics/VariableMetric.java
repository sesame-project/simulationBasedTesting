/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.VariableMetric#getChosenVariables <em>Chosen Variables</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getVariableMetric()
 * @model
 * @generated
 */
public interface VariableMetric extends Metric {
	/**
	 * Returns the value of the '<em><b>Chosen Variables</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Variables</em>' reference.
	 * @see #setChosenVariables(Variable)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getVariableMetric_ChosenVariables()
	 * @model required="true"
	 * @generated
	 */
	Variable getChosenVariables();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.VariableMetric#getChosenVariables <em>Chosen Variables</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Variables</em>' reference.
	 * @see #getChosenVariables()
	 * @generated
	 */
	void setChosenVariables(Variable value);

} // VariableMetric
