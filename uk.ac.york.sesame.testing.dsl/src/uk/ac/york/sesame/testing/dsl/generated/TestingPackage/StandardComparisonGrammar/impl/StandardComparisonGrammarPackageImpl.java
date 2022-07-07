/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl;

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

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.impl.ResultsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryComparisonOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryLogicalOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Condition;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.ConditionElement;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.ConditionInteger;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Literal;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Variable;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardComparisonGrammarPackageImpl extends EPackageImpl implements StandardComparisonGrammarPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionIntegerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryComparisonOperationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryLogicalOperationEEnum = null;

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
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StandardComparisonGrammarPackageImpl() {
		super(eNS_URI, StandardComparisonGrammarFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StandardComparisonGrammarPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StandardComparisonGrammarPackage init() {
		if (isInited) return (StandardComparisonGrammarPackage)EPackage.Registry.INSTANCE.getEPackage(StandardComparisonGrammarPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredStandardComparisonGrammarPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		StandardComparisonGrammarPackageImpl theStandardComparisonGrammarPackage = registeredStandardComparisonGrammarPackage instanceof StandardComparisonGrammarPackageImpl ? (StandardComparisonGrammarPackageImpl)registeredStandardComparisonGrammarPackage : new StandardComparisonGrammarPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TestingPackagePackage.eNS_URI);
		TestingPackagePackageImpl theTestingPackagePackage = (TestingPackagePackageImpl)(registeredPackage instanceof TestingPackagePackageImpl ? registeredPackage : TestingPackagePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(AttacksPackage.eNS_URI);
		AttacksPackageImpl theAttacksPackage = (AttacksPackageImpl)(registeredPackage instanceof AttacksPackageImpl ? registeredPackage : AttacksPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(registeredPackage instanceof MetricsPackageImpl ? registeredPackage : MetricsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
		ResultsPackageImpl theResultsPackage = (ResultsPackageImpl)(registeredPackage instanceof ResultsPackageImpl ? registeredPackage : ResultsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MRSPackagePackage.eNS_URI);
		MRSPackagePackageImpl theMRSPackagePackage = (MRSPackagePackageImpl)(registeredPackage instanceof MRSPackagePackageImpl ? registeredPackage : MRSPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theStandardComparisonGrammarPackage.createPackageContents();
		theTestingPackagePackage.createPackageContents();
		theAttacksPackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theResultsPackage.createPackageContents();
		theMRSPackagePackage.createPackageContents();

		// Initialize created meta-data
		theStandardComparisonGrammarPackage.initializePackageContents();
		theTestingPackagePackage.initializePackageContents();
		theAttacksPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theResultsPackage.initializePackageContents();
		theMRSPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStandardComparisonGrammarPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StandardComparisonGrammarPackage.eNS_URI, theStandardComparisonGrammarPackage);
		return theStandardComparisonGrammarPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionElement() {
		return conditionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeCondition() {
		return compositeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeCondition_Left() {
		return (EReference)compositeConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeCondition_Binop() {
		return (EAttribute)compositeConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeCondition_Right() {
		return (EReference)compositeConditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicCondition() {
		return basicConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicCondition_Left() {
		return (EReference)basicConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicCondition_Bincomp() {
		return (EAttribute)basicConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicCondition_Right() {
		return (EReference)basicConditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionInteger() {
		return conditionIntegerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionInteger_Value() {
		return (EAttribute)conditionIntegerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Metric() {
		return (EReference)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardCondition() {
		return standardConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardCondition_Name() {
		return (EAttribute)standardConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardCondition_C() {
		return (EReference)standardConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryComparisonOperation() {
		return binaryComparisonOperationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryLogicalOperation() {
		return binaryLogicalOperationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardComparisonGrammarFactory getStandardComparisonGrammarFactory() {
		return (StandardComparisonGrammarFactory)getEFactoryInstance();
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
		conditionElementEClass = createEClass(CONDITION_ELEMENT);

		compositeConditionEClass = createEClass(COMPOSITE_CONDITION);
		createEReference(compositeConditionEClass, COMPOSITE_CONDITION__LEFT);
		createEAttribute(compositeConditionEClass, COMPOSITE_CONDITION__BINOP);
		createEReference(compositeConditionEClass, COMPOSITE_CONDITION__RIGHT);

		basicConditionEClass = createEClass(BASIC_CONDITION);
		createEReference(basicConditionEClass, BASIC_CONDITION__LEFT);
		createEAttribute(basicConditionEClass, BASIC_CONDITION__BINCOMP);
		createEReference(basicConditionEClass, BASIC_CONDITION__RIGHT);

		literalEClass = createEClass(LITERAL);

		conditionIntegerEClass = createEClass(CONDITION_INTEGER);
		createEAttribute(conditionIntegerEClass, CONDITION_INTEGER__VALUE);

		variableEClass = createEClass(VARIABLE);
		createEReference(variableEClass, VARIABLE__METRIC);

		conditionEClass = createEClass(CONDITION);

		standardConditionEClass = createEClass(STANDARD_CONDITION);
		createEAttribute(standardConditionEClass, STANDARD_CONDITION__NAME);
		createEReference(standardConditionEClass, STANDARD_CONDITION__C);

		// Create enums
		binaryComparisonOperationEEnum = createEEnum(BINARY_COMPARISON_OPERATION);
		binaryLogicalOperationEEnum = createEEnum(BINARY_LOGICAL_OPERATION);
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
		MetricsPackage theMetricsPackage = (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compositeConditionEClass.getESuperTypes().add(this.getConditionElement());
		basicConditionEClass.getESuperTypes().add(this.getConditionElement());
		conditionIntegerEClass.getESuperTypes().add(this.getLiteral());
		variableEClass.getESuperTypes().add(this.getLiteral());

		// Initialize classes, features, and operations; add parameters
		initEClass(conditionElementEClass, ConditionElement.class, "ConditionElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeConditionEClass, CompositeCondition.class, "CompositeCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeCondition_Left(), this.getConditionElement(), null, "left", null, 1, 1, CompositeCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeCondition_Binop(), this.getBinaryLogicalOperation(), "binop", null, 1, 1, CompositeCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeCondition_Right(), this.getConditionElement(), null, "right", null, 1, 1, CompositeCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicConditionEClass, BasicCondition.class, "BasicCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicCondition_Left(), this.getVariable(), null, "left", null, 1, 1, BasicCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicCondition_Bincomp(), this.getBinaryComparisonOperation(), "bincomp", null, 1, 1, BasicCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicCondition_Right(), this.getLiteral(), null, "right", null, 1, 1, BasicCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionIntegerEClass, ConditionInteger.class, "ConditionInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionInteger_Value(), ecorePackage.getEInt(), "value", null, 0, 1, ConditionInteger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariable_Metric(), theMetricsPackage.getMetric(), null, "metric", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionEClass, Condition.class, "Condition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(standardConditionEClass, StandardCondition.class, "StandardCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStandardCondition_Name(), ecorePackage.getEString(), "name", null, 0, 1, StandardCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStandardCondition_C(), this.getConditionElement(), null, "c", null, 1, 1, StandardCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(binaryComparisonOperationEEnum, BinaryComparisonOperation.class, "BinaryComparisonOperation");
		addEEnumLiteral(binaryComparisonOperationEEnum, BinaryComparisonOperation.LESS_THAN);
		addEEnumLiteral(binaryComparisonOperationEEnum, BinaryComparisonOperation.GREATER_THAN);

		initEEnum(binaryLogicalOperationEEnum, BinaryLogicalOperation.class, "BinaryLogicalOperation");
		addEEnumLiteral(binaryLogicalOperationEEnum, BinaryLogicalOperation.AND);
		addEEnumLiteral(binaryLogicalOperationEEnum, BinaryLogicalOperation.OR);
	}

} //StandardComparisonGrammarPackageImpl
