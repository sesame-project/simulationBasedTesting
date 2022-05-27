/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricsFactoryImpl extends EFactoryImpl implements MetricsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetricsFactory init() {
		try {
			MetricsFactory theMetricsFactory = (MetricsFactory)EPackage.Registry.INSTANCE.getEFactory(MetricsPackage.eNS_URI);
			if (theMetricsFactory != null) {
				return theMetricsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetricsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MetricsPackage.INPUT_STREAM: return createInputStream();
			case MetricsPackage.OUTPUT_STREAM: return createOutputStream();
			case MetricsPackage.TOPIC_METRIC: return createTopicMetric();
			case MetricsPackage.METRIC_INSTANCE: return createMetricInstance();
			case MetricsPackage.CONDITIONAL_PROPERTY_METRIC: return createConditionalPropertyMetric();
			case MetricsPackage.STREAM_METRIC: return createStreamMetric();
			case MetricsPackage.FILE_STREAM_RESULT: return createFileStreamResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputStream createInputStream() {
		InputStreamImpl inputStream = new InputStreamImpl();
		return inputStream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputStream createOutputStream() {
		OutputStreamImpl outputStream = new OutputStreamImpl();
		return outputStream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopicMetric createTopicMetric() {
		TopicMetricImpl topicMetric = new TopicMetricImpl();
		return topicMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricInstance createMetricInstance() {
		MetricInstanceImpl metricInstance = new MetricInstanceImpl();
		return metricInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalPropertyMetric createConditionalPropertyMetric() {
		ConditionalPropertyMetricImpl conditionalPropertyMetric = new ConditionalPropertyMetricImpl();
		return conditionalPropertyMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StreamMetric createStreamMetric() {
		StreamMetricImpl streamMetric = new StreamMetricImpl();
		return streamMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileStreamResult createFileStreamResult() {
		FileStreamResultImpl fileStreamResult = new FileStreamResultImpl();
		return fileStreamResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsPackage getMetricsPackage() {
		return (MetricsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetricsPackage getPackage() {
		return MetricsPackage.eINSTANCE;
	}

} //MetricsFactoryImpl
