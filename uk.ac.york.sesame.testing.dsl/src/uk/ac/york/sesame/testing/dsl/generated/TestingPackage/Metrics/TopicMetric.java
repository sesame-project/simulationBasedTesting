/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topic Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.TopicMetric#getChosenTopics <em>Chosen Topics</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getTopicMetric()
 * @model
 * @generated
 */
public interface TopicMetric extends Metric {
	/**
	 * Returns the value of the '<em><b>Chosen Topics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Topics</em>' reference.
	 * @see #setChosenTopics(Variable)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getTopicMetric_ChosenTopics()
	 * @model required="true"
	 * @generated
	 */
	Variable getChosenTopics();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.TopicMetric#getChosenTopics <em>Chosen Topics</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Topics</em>' reference.
	 * @see #getChosenTopics()
	 * @generated
	 */
	void setChosenTopics(Variable value);

} // TopicMetric
