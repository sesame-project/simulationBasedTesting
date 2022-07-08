/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Variable;

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
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getRelatedVariables <em>Related Variables</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getDefault <em>Default</em>}</li>
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
	 * Returns the value of the '<em><b>Related Variables</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Variables</em>' reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getMetric_RelatedVariables()
	 * @model
	 * @generated
	 */
	EList<Variable> getRelatedVariables();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(MetricDefault)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#getMetric_Default()
	 * @model containment="true"
	 * @generated
	 */
	MetricDefault getDefault();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(MetricDefault value);

} // Metric
