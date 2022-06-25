/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsFactory
 * @model kind="package"
 * @generated
 */
public interface MetricsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Metrics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Metrics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetricsPackage eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.SimStreamImpl <em>Sim Stream</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.SimStreamImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getSimStream()
	 * @generated
	 */
	int SIM_STREAM = 0;

	/**
	 * The number of structural features of the '<em>Sim Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_STREAM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Sim Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIM_STREAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.InputStreamImpl <em>Input Stream</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.InputStreamImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getInputStream()
	 * @generated
	 */
	int INPUT_STREAM = 1;

	/**
	 * The number of structural features of the '<em>Input Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STREAM_FEATURE_COUNT = SIM_STREAM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Input Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STREAM_OPERATION_COUNT = SIM_STREAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.OutputStreamImpl <em>Output Stream</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.OutputStreamImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getOutputStream()
	 * @generated
	 */
	int OUTPUT_STREAM = 2;

	/**
	 * The number of structural features of the '<em>Output Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_STREAM_FEATURE_COUNT = SIM_STREAM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Output Stream</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_STREAM_OPERATION_COUNT = SIM_STREAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DIR = 1;

	/**
	 * The feature id for the '<em><b>Keyed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__KEYED_BY = 2;

	/**
	 * The feature id for the '<em><b>Related Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__RELATED_TOPICS = 3;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.TopicMetricImpl <em>Topic Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.TopicMetricImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getTopicMetric()
	 * @generated
	 */
	int TOPIC_METRIC = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_METRIC__DIR = METRIC__DIR;

	/**
	 * The feature id for the '<em><b>Keyed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_METRIC__KEYED_BY = METRIC__KEYED_BY;

	/**
	 * The feature id for the '<em><b>Related Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_METRIC__RELATED_TOPICS = METRIC__RELATED_TOPICS;

	/**
	 * The feature id for the '<em><b>Chosen Topics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_METRIC__CHOSEN_TOPICS = METRIC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Topic Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Topic Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPIC_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricInstanceImpl <em>Metric Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricInstanceImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getMetricInstance()
	 * @generated
	 */
	int METRIC_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__METRIC = 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE__RESULT = 1;

	/**
	 * The number of structural features of the '<em>Metric Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Metric Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_INSTANCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.PropertyMetricImpl <em>Property Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.PropertyMetricImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getPropertyMetric()
	 * @generated
	 */
	int PROPERTY_METRIC = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_METRIC__DIR = METRIC__DIR;

	/**
	 * The feature id for the '<em><b>Keyed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_METRIC__KEYED_BY = METRIC__KEYED_BY;

	/**
	 * The feature id for the '<em><b>Related Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_METRIC__RELATED_TOPICS = METRIC__RELATED_TOPICS;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_METRIC__PROPERTY = METRIC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.ConditionalPropertyMetricImpl <em>Conditional Property Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.ConditionalPropertyMetricImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getConditionalPropertyMetric()
	 * @generated
	 */
	int CONDITIONAL_PROPERTY_METRIC = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROPERTY_METRIC__NAME = PROPERTY_METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROPERTY_METRIC__DIR = PROPERTY_METRIC__DIR;

	/**
	 * The feature id for the '<em><b>Keyed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROPERTY_METRIC__KEYED_BY = PROPERTY_METRIC__KEYED_BY;

	/**
	 * The feature id for the '<em><b>Related Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROPERTY_METRIC__RELATED_TOPICS = PROPERTY_METRIC__RELATED_TOPICS;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROPERTY_METRIC__PROPERTY = PROPERTY_METRIC__PROPERTY;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROPERTY_METRIC__CONDITION = PROPERTY_METRIC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Conditional Property Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROPERTY_METRIC_FEATURE_COUNT = PROPERTY_METRIC_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Conditional Property Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROPERTY_METRIC_OPERATION_COUNT = PROPERTY_METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.StreamMetricImpl <em>Stream Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.StreamMetricImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getStreamMetric()
	 * @generated
	 */
	int STREAM_METRIC = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_METRIC__NAME = METRIC__NAME;

	/**
	 * The feature id for the '<em><b>Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_METRIC__DIR = METRIC__DIR;

	/**
	 * The feature id for the '<em><b>Keyed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_METRIC__KEYED_BY = METRIC__KEYED_BY;

	/**
	 * The feature id for the '<em><b>Related Topics</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_METRIC__RELATED_TOPICS = METRIC__RELATED_TOPICS;

	/**
	 * The feature id for the '<em><b>Streams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_METRIC__STREAMS = METRIC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Res</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_METRIC__RES = METRIC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Stream Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_METRIC_FEATURE_COUNT = METRIC_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Stream Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_METRIC_OPERATION_COUNT = METRIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.StreamResultImpl <em>Stream Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.StreamResultImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getStreamResult()
	 * @generated
	 */
	int STREAM_RESULT = 9;

	/**
	 * The number of structural features of the '<em>Stream Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_RESULT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Stream Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.FileStreamResultImpl <em>File Stream Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.FileStreamResultImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getFileStreamResult()
	 * @generated
	 */
	int FILE_STREAM_RESULT = 10;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STREAM_RESULT__FILENAME = STREAM_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Stream Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STREAM_RESULT_FEATURE_COUNT = STREAM_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>File Stream Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STREAM_RESULT_OPERATION_COUNT = STREAM_RESULT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection <em>Metric Optimisation Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getMetricOptimisationDirection()
	 * @generated
	 */
	int METRIC_OPTIMISATION_DIRECTION = 11;


	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy <em>Metric State Keyed By</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getMetricStateKeyedBy()
	 * @generated
	 */
	int METRIC_STATE_KEYED_BY = 12;


	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.SimStream <em>Sim Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sim Stream</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.SimStream
	 * @generated
	 */
	EClass getSimStream();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.InputStream <em>Input Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Stream</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.InputStream
	 * @generated
	 */
	EClass getInputStream();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.OutputStream <em>Output Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Stream</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.OutputStream
	 * @generated
	 */
	EClass getOutputStream();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getDir <em>Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dir</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getDir()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Dir();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getKeyedBy <em>Keyed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keyed By</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getKeyedBy()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_KeyedBy();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getRelatedTopics <em>Related Topics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Related Topics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric#getRelatedTopics()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_RelatedTopics();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.TopicMetric <em>Topic Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Topic Metric</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.TopicMetric
	 * @generated
	 */
	EClass getTopicMetric();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.TopicMetric#getChosenTopics <em>Chosen Topics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Chosen Topics</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.TopicMetric#getChosenTopics()
	 * @see #getTopicMetric()
	 * @generated
	 */
	EReference getTopicMetric_ChosenTopics();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance <em>Metric Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Instance</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance
	 * @generated
	 */
	EClass getMetricInstance();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance#getMetric()
	 * @see #getMetricInstance()
	 * @generated
	 */
	EReference getMetricInstance_Metric();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance#getResult()
	 * @see #getMetricInstance()
	 * @generated
	 */
	EReference getMetricInstance_Result();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.PropertyMetric <em>Property Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Metric</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.PropertyMetric
	 * @generated
	 */
	EClass getPropertyMetric();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.PropertyMetric#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.PropertyMetric#getProperty()
	 * @see #getPropertyMetric()
	 * @generated
	 */
	EReference getPropertyMetric_Property();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.ConditionalPropertyMetric <em>Conditional Property Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Property Metric</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.ConditionalPropertyMetric
	 * @generated
	 */
	EClass getConditionalPropertyMetric();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.ConditionalPropertyMetric#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.ConditionalPropertyMetric#getCondition()
	 * @see #getConditionalPropertyMetric()
	 * @generated
	 */
	EAttribute getConditionalPropertyMetric_Condition();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric <em>Stream Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream Metric</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric
	 * @generated
	 */
	EClass getStreamMetric();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric#getStreams <em>Streams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Streams</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric#getStreams()
	 * @see #getStreamMetric()
	 * @generated
	 */
	EReference getStreamMetric_Streams();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric#getRes <em>Res</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Res</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric#getRes()
	 * @see #getStreamMetric()
	 * @generated
	 */
	EReference getStreamMetric_Res();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamResult <em>Stream Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream Result</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamResult
	 * @generated
	 */
	EClass getStreamResult();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FileStreamResult <em>File Stream Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Stream Result</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FileStreamResult
	 * @generated
	 */
	EClass getFileStreamResult();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FileStreamResult#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FileStreamResult#getFilename()
	 * @see #getFileStreamResult()
	 * @generated
	 */
	EAttribute getFileStreamResult_Filename();

	/**
	 * Returns the meta object for enum '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection <em>Metric Optimisation Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metric Optimisation Direction</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection
	 * @generated
	 */
	EEnum getMetricOptimisationDirection();

	/**
	 * Returns the meta object for enum '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy <em>Metric State Keyed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metric State Keyed By</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy
	 * @generated
	 */
	EEnum getMetricStateKeyedBy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetricsFactory getMetricsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.SimStreamImpl <em>Sim Stream</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.SimStreamImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getSimStream()
		 * @generated
		 */
		EClass SIM_STREAM = eINSTANCE.getSimStream();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.InputStreamImpl <em>Input Stream</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.InputStreamImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getInputStream()
		 * @generated
		 */
		EClass INPUT_STREAM = eINSTANCE.getInputStream();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.OutputStreamImpl <em>Output Stream</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.OutputStreamImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getOutputStream()
		 * @generated
		 */
		EClass OUTPUT_STREAM = eINSTANCE.getOutputStream();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '<em><b>Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__DIR = eINSTANCE.getMetric_Dir();

		/**
		 * The meta object literal for the '<em><b>Keyed By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__KEYED_BY = eINSTANCE.getMetric_KeyedBy();

		/**
		 * The meta object literal for the '<em><b>Related Topics</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__RELATED_TOPICS = eINSTANCE.getMetric_RelatedTopics();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.TopicMetricImpl <em>Topic Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.TopicMetricImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getTopicMetric()
		 * @generated
		 */
		EClass TOPIC_METRIC = eINSTANCE.getTopicMetric();

		/**
		 * The meta object literal for the '<em><b>Chosen Topics</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPIC_METRIC__CHOSEN_TOPICS = eINSTANCE.getTopicMetric_ChosenTopics();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricInstanceImpl <em>Metric Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricInstanceImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getMetricInstance()
		 * @generated
		 */
		EClass METRIC_INSTANCE = eINSTANCE.getMetricInstance();

		/**
		 * The meta object literal for the '<em><b>Metric</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_INSTANCE__METRIC = eINSTANCE.getMetricInstance_Metric();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_INSTANCE__RESULT = eINSTANCE.getMetricInstance_Result();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.PropertyMetricImpl <em>Property Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.PropertyMetricImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getPropertyMetric()
		 * @generated
		 */
		EClass PROPERTY_METRIC = eINSTANCE.getPropertyMetric();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_METRIC__PROPERTY = eINSTANCE.getPropertyMetric_Property();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.ConditionalPropertyMetricImpl <em>Conditional Property Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.ConditionalPropertyMetricImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getConditionalPropertyMetric()
		 * @generated
		 */
		EClass CONDITIONAL_PROPERTY_METRIC = eINSTANCE.getConditionalPropertyMetric();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_PROPERTY_METRIC__CONDITION = eINSTANCE.getConditionalPropertyMetric_Condition();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.StreamMetricImpl <em>Stream Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.StreamMetricImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getStreamMetric()
		 * @generated
		 */
		EClass STREAM_METRIC = eINSTANCE.getStreamMetric();

		/**
		 * The meta object literal for the '<em><b>Streams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_METRIC__STREAMS = eINSTANCE.getStreamMetric_Streams();

		/**
		 * The meta object literal for the '<em><b>Res</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STREAM_METRIC__RES = eINSTANCE.getStreamMetric_Res();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.StreamResultImpl <em>Stream Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.StreamResultImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getStreamResult()
		 * @generated
		 */
		EClass STREAM_RESULT = eINSTANCE.getStreamResult();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.FileStreamResultImpl <em>File Stream Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.FileStreamResultImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getFileStreamResult()
		 * @generated
		 */
		EClass FILE_STREAM_RESULT = eINSTANCE.getFileStreamResult();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_STREAM_RESULT__FILENAME = eINSTANCE.getFileStreamResult_Filename();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection <em>Metric Optimisation Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getMetricOptimisationDirection()
		 * @generated
		 */
		EEnum METRIC_OPTIMISATION_DIRECTION = eINSTANCE.getMetricOptimisationDirection();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy <em>Metric State Keyed By</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl#getMetricStateKeyedBy()
		 * @generated
		 */
		EEnum METRIC_STATE_KEYED_BY = eINSTANCE.getMetricStateKeyedBy();

	}

} //MetricsPackage
