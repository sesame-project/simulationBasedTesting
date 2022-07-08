/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage
 * @generated
 */
public class MetricsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetricsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetricsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricsSwitch<Adapter> modelSwitch =
		new MetricsSwitch<Adapter>() {
			@Override
			public Adapter caseSimStream(SimStream object) {
				return createSimStreamAdapter();
			}
			@Override
			public Adapter caseInputStream(InputStream object) {
				return createInputStreamAdapter();
			}
			@Override
			public Adapter caseOutputStream(OutputStream object) {
				return createOutputStreamAdapter();
			}
			@Override
			public Adapter caseMetric(Metric object) {
				return createMetricAdapter();
			}
			@Override
			public Adapter caseMetricDefault(MetricDefault object) {
				return createMetricDefaultAdapter();
			}
			@Override
			public Adapter caseVariableMetric(VariableMetric object) {
				return createVariableMetricAdapter();
			}
			@Override
			public Adapter caseMetricInstance(MetricInstance object) {
				return createMetricInstanceAdapter();
			}
			@Override
			public Adapter casePropertyMetric(PropertyMetric object) {
				return createPropertyMetricAdapter();
			}
			@Override
			public Adapter caseConditionalPropertyMetric(ConditionalPropertyMetric object) {
				return createConditionalPropertyMetricAdapter();
			}
			@Override
			public Adapter caseStreamMetric(StreamMetric object) {
				return createStreamMetricAdapter();
			}
			@Override
			public Adapter caseFuzzingOperationTimesMetric(FuzzingOperationTimesMetric object) {
				return createFuzzingOperationTimesMetricAdapter();
			}
			@Override
			public Adapter caseStreamResult(StreamResult object) {
				return createStreamResultAdapter();
			}
			@Override
			public Adapter caseFileStreamResult(FileStreamResult object) {
				return createFileStreamResultAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.SimStream <em>Sim Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.SimStream
	 * @generated
	 */
	public Adapter createSimStreamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.InputStream <em>Input Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.InputStream
	 * @generated
	 */
	public Adapter createInputStreamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.OutputStream <em>Output Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.OutputStream
	 * @generated
	 */
	public Adapter createOutputStreamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric
	 * @generated
	 */
	public Adapter createMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricDefault <em>Metric Default</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricDefault
	 * @generated
	 */
	public Adapter createMetricDefaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.VariableMetric <em>Variable Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.VariableMetric
	 * @generated
	 */
	public Adapter createVariableMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance <em>Metric Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance
	 * @generated
	 */
	public Adapter createMetricInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.PropertyMetric <em>Property Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.PropertyMetric
	 * @generated
	 */
	public Adapter createPropertyMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.ConditionalPropertyMetric <em>Conditional Property Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.ConditionalPropertyMetric
	 * @generated
	 */
	public Adapter createConditionalPropertyMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric <em>Stream Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric
	 * @generated
	 */
	public Adapter createStreamMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FuzzingOperationTimesMetric <em>Fuzzing Operation Times Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FuzzingOperationTimesMetric
	 * @generated
	 */
	public Adapter createFuzzingOperationTimesMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamResult <em>Stream Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamResult
	 * @generated
	 */
	public Adapter createStreamResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FileStreamResult <em>File Stream Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FileStreamResult
	 * @generated
	 */
	public Adapter createFileStreamResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MetricsAdapterFactory
