/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getDir <em>Dir</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getKeyedBy <em>Keyed By</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getRelatedTopics <em>Related Topics</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getMetric()
 * @model abstract="true"
 * @generated
 */
public interface Metric extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getMetric_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Dir</b></em>' attribute.
	 * The literals are from the enumeration {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dir</em>' attribute.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection
	 * @see #setDir(MetricOptimisationDirection)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getMetric_Dir()
	 * @model
	 * @generated
	 */
	MetricOptimisationDirection getDir();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getDir <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dir</em>' attribute.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection
	 * @see #getDir()
	 * @generated
	 */
	void setDir(MetricOptimisationDirection value);

	/**
	 * Returns the value of the '<em><b>Keyed By</b></em>' attribute.
	 * The literals are from the enumeration {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keyed By</em>' attribute.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy
	 * @see #setKeyedBy(MetricStateKeyedBy)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getMetric_KeyedBy()
	 * @model
	 * @generated
	 */
	MetricStateKeyedBy getKeyedBy();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getKeyedBy <em>Keyed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keyed By</em>' attribute.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy
	 * @see #getKeyedBy()
	 * @generated
	 */
	void setKeyedBy(MetricStateKeyedBy value);

	/**
	 * Returns the value of the '<em><b>Related Topics</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Topics</em>' reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getMetric_RelatedTopics()
	 * @model
	 * @generated
	 */
	EList<Topic> getRelatedTopics();

} // Metric
