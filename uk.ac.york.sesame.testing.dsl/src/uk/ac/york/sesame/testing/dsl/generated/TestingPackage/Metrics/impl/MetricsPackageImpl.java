/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSPackagePackageImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.AttackTimesMetric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.ConditionalPropertyMetric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.FileStreamResult;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.InputStream;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricDefault;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.OutputStream;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.PropertyMetric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.SimStream;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamMetric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.StreamResult;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.TopicMetric;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.impl.ResultsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricsPackageImpl extends EPackageImpl implements MetricsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simStreamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputStreamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputStreamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricDefaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topicMetricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyMetricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalPropertyMetricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamMetricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attackTimesMetricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileStreamResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum metricOptimisationDirectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum metricStateKeyedByEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetricsPackageImpl() {
		super(eNS_URI, MetricsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MetricsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetricsPackage init() {
		if (isInited) return (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMetricsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MetricsPackageImpl theMetricsPackage = registeredMetricsPackage instanceof MetricsPackageImpl ? (MetricsPackageImpl)registeredMetricsPackage : new MetricsPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TestingPackagePackage.eNS_URI);
		TestingPackagePackageImpl theTestingPackagePackage = (TestingPackagePackageImpl)(registeredPackage instanceof TestingPackagePackageImpl ? registeredPackage : TestingPackagePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AttacksPackage.eNS_URI);
		AttacksPackageImpl theAttacksPackage = (AttacksPackageImpl)(registeredPackage instanceof AttacksPackageImpl ? registeredPackage : AttacksPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
		ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(registeredPackage instanceof ResultsPackageImpl ? registeredPackage : ResultsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(StandardComparisonGrammarPackage.eNS_URI);
		StandardComparisonGrammarPackageImpl theStandardComparisonGrammarPackage = (StandardComparisonGrammarPackageImpl)(registeredPackage instanceof StandardComparisonGrammarPackageImpl ? registeredPackage : StandardComparisonGrammarPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MRSPackagePackage.eNS_URI);
		MRSPackagePackageImpl theMRSPackagePackage = (MRSPackagePackageImpl)(registeredPackage instanceof MRSPackagePackageImpl ? registeredPackage : MRSPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theMetricsPackage.createPackageContents();
		theTestingPackagePackage.createPackageContents();
		theAttacksPackage.createPackageContents();
		theResultsPackage.createPackageContents();
		theStandardComparisonGrammarPackage.createPackageContents();
		theMRSPackagePackage.createPackageContents();

		// Initialize created meta-data
		theMetricsPackage.initializePackageContents();
		theTestingPackagePackage.initializePackageContents();
		theAttacksPackage.initializePackageContents();
		theResultsPackage.initializePackageContents();
		theStandardComparisonGrammarPackage.initializePackageContents();
		theMRSPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetricsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetricsPackage.eNS_URI, theMetricsPackage);
		return theMetricsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimStream() {
		return simStreamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputStream() {
		return inputStreamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputStream() {
		return outputStreamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetric() {
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Name() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Dir() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_KeyedBy() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_RelatedTopics() {
		return (EReference)metricEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_Default() {
		return (EReference)metricEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricDefault() {
		return metricDefaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricDefault_DefaultVal() {
		return (EAttribute)metricDefaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopicMetric() {
		return topicMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopicMetric_ChosenTopics() {
		return (EReference)topicMetricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricInstance() {
		return metricInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricInstance_Metric() {
		return (EReference)metricInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricInstance_Result() {
		return (EReference)metricInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyMetric() {
		return propertyMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyMetric_Property() {
		return (EReference)propertyMetricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalPropertyMetric() {
		return conditionalPropertyMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalPropertyMetric_Condition() {
		return (EAttribute)conditionalPropertyMetricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStreamMetric() {
		return streamMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStreamMetric_Streams() {
		return (EReference)streamMetricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStreamMetric_Res() {
		return (EReference)streamMetricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttackTimesMetric() {
		return attackTimesMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStreamResult() {
		return streamResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileStreamResult() {
		return fileStreamResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileStreamResult_Filename() {
		return (EAttribute)fileStreamResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMetricOptimisationDirection() {
		return metricOptimisationDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMetricStateKeyedBy() {
		return metricStateKeyedByEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsFactory getMetricsFactory() {
		return (MetricsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		simStreamEClass = createEClass(SIM_STREAM);

		inputStreamEClass = createEClass(INPUT_STREAM);

		outputStreamEClass = createEClass(OUTPUT_STREAM);

		metricEClass = createEClass(METRIC);
		createEAttribute(metricEClass, METRIC__NAME);
		createEAttribute(metricEClass, METRIC__DIR);
		createEAttribute(metricEClass, METRIC__KEYED_BY);
		createEReference(metricEClass, METRIC__RELATED_TOPICS);
		createEReference(metricEClass, METRIC__DEFAULT);

		metricDefaultEClass = createEClass(METRIC_DEFAULT);
		createEAttribute(metricDefaultEClass, METRIC_DEFAULT__DEFAULT_VAL);

		topicMetricEClass = createEClass(TOPIC_METRIC);
		createEReference(topicMetricEClass, TOPIC_METRIC__CHOSEN_TOPICS);

		metricInstanceEClass = createEClass(METRIC_INSTANCE);
		createEReference(metricInstanceEClass, METRIC_INSTANCE__METRIC);
		createEReference(metricInstanceEClass, METRIC_INSTANCE__RESULT);

		propertyMetricEClass = createEClass(PROPERTY_METRIC);
		createEReference(propertyMetricEClass, PROPERTY_METRIC__PROPERTY);

		conditionalPropertyMetricEClass = createEClass(CONDITIONAL_PROPERTY_METRIC);
		createEAttribute(conditionalPropertyMetricEClass, CONDITIONAL_PROPERTY_METRIC__CONDITION);

		streamMetricEClass = createEClass(STREAM_METRIC);
		createEReference(streamMetricEClass, STREAM_METRIC__STREAMS);
		createEReference(streamMetricEClass, STREAM_METRIC__RES);

		attackTimesMetricEClass = createEClass(ATTACK_TIMES_METRIC);

		streamResultEClass = createEClass(STREAM_RESULT);

		fileStreamResultEClass = createEClass(FILE_STREAM_RESULT);
		createEAttribute(fileStreamResultEClass, FILE_STREAM_RESULT__FILENAME);

		// Create enums
		metricOptimisationDirectionEEnum = createEEnum(METRIC_OPTIMISATION_DIRECTION);
		metricStateKeyedByEEnum = createEEnum(METRIC_STATE_KEYED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MRSPackagePackage theMRSPackagePackage = (MRSPackagePackage)EPackage.Registry.INSTANCE.getEPackage(MRSPackagePackage.eNS_URI);
		ResultsPackage theResultsPackage = (ResultsPackage)EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inputStreamEClass.getESuperTypes().add(this.getSimStream());
		outputStreamEClass.getESuperTypes().add(this.getSimStream());
		topicMetricEClass.getESuperTypes().add(this.getMetric());
		propertyMetricEClass.getESuperTypes().add(this.getMetric());
		conditionalPropertyMetricEClass.getESuperTypes().add(this.getPropertyMetric());
		streamMetricEClass.getESuperTypes().add(this.getMetric());
		attackTimesMetricEClass.getESuperTypes().add(this.getStreamMetric());
		fileStreamResultEClass.getESuperTypes().add(this.getStreamResult());

		// Initialize classes, features, and operations; add parameters
		initEClass(simStreamEClass, SimStream.class, "SimStream", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputStreamEClass, InputStream.class, "InputStream", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputStreamEClass, OutputStream.class, "OutputStream", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(metricEClass, Metric.class, "Metric", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetric_Name(), ecorePackage.getEString(), "name", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Dir(), this.getMetricOptimisationDirection(), "dir", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_KeyedBy(), this.getMetricStateKeyedBy(), "keyedBy", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_RelatedTopics(), theMRSPackagePackage.getTopic(), null, "relatedTopics", null, 0, -1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_Default(), this.getMetricDefault(), null, "default", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricDefaultEClass, MetricDefault.class, "MetricDefault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetricDefault_DefaultVal(), ecorePackage.getEDouble(), "defaultVal", null, 0, 1, MetricDefault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topicMetricEClass, TopicMetric.class, "TopicMetric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopicMetric_ChosenTopics(), theMRSPackagePackage.getTopic(), null, "chosenTopics", null, 1, 1, TopicMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricInstanceEClass, MetricInstance.class, "MetricInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricInstance_Metric(), this.getMetric(), null, "metric", null, 1, 1, MetricInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetricInstance_Result(), theResultsPackage.getResult(), null, "result", null, 1, 1, MetricInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyMetricEClass, PropertyMetric.class, "PropertyMetric", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyMetric_Property(), theMRSPackagePackage.getComponentProperty(), null, "property", null, 1, 1, PropertyMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalPropertyMetricEClass, ConditionalPropertyMetric.class, "ConditionalPropertyMetric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionalPropertyMetric_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, ConditionalPropertyMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(streamMetricEClass, StreamMetric.class, "StreamMetric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStreamMetric_Streams(), this.getSimStream(), null, "streams", null, 0, -1, StreamMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStreamMetric_Res(), this.getStreamResult(), null, "res", null, 0, 1, StreamMetric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attackTimesMetricEClass, AttackTimesMetric.class, "AttackTimesMetric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(streamResultEClass, StreamResult.class, "StreamResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileStreamResultEClass, FileStreamResult.class, "FileStreamResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileStreamResult_Filename(), ecorePackage.getEString(), "filename", null, 0, 1, FileStreamResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(metricOptimisationDirectionEEnum, MetricOptimisationDirection.class, "MetricOptimisationDirection");
		addEEnumLiteral(metricOptimisationDirectionEEnum, MetricOptimisationDirection.HIGHEST);
		addEEnumLiteral(metricOptimisationDirectionEEnum, MetricOptimisationDirection.LOWEST);

		initEEnum(metricStateKeyedByEEnum, MetricStateKeyedBy.class, "MetricStateKeyedBy");
		addEEnumLiteral(metricStateKeyedByEEnum, MetricStateKeyedBy.TEST);
		addEEnumLiteral(metricStateKeyedByEEnum, MetricStateKeyedBy.TOPIC);
	}

} //MetricsPackageImpl
