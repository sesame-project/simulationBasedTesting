/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttacksPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.ConditionsPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSPackagePackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.impl.ResultsPackageImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryComparator;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryComparison;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryExpression;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalExpression;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Expression;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.SimulatorVariable;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Variable;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackagePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardGrammarPackageImpl extends EPackageImpl implements StandardGrammarPackage {
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
	private EClass simulatorVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryComparisonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryLogicalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum binaryComparatorEEnum = null;

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
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StandardGrammarPackageImpl() {
		super(eNS_URI, StandardGrammarFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StandardGrammarPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StandardGrammarPackage init() {
		if (isInited) return (StandardGrammarPackage)EPackage.Registry.INSTANCE.getEPackage(StandardGrammarPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredStandardGrammarPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		StandardGrammarPackageImpl theStandardGrammarPackage = registeredStandardGrammarPackage instanceof StandardGrammarPackageImpl ? (StandardGrammarPackageImpl)registeredStandardGrammarPackage : new StandardGrammarPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ConditionsPackage.eNS_URI);
		ConditionsPackageImpl theConditionsPackage = (ConditionsPackageImpl)(registeredPackage instanceof ConditionsPackageImpl ? registeredPackage : ConditionsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GrammarSpecPackage.eNS_URI);
		GrammarSpecPackageImpl theGrammarSpecPackage = (GrammarSpecPackageImpl)(registeredPackage instanceof GrammarSpecPackageImpl ? registeredPackage : GrammarSpecPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MRSPackagePackage.eNS_URI);
		MRSPackagePackageImpl theMRSPackagePackage = (MRSPackagePackageImpl)(registeredPackage instanceof MRSPackagePackageImpl ? registeredPackage : MRSPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theStandardGrammarPackage.createPackageContents();
		theTestingPackagePackage.createPackageContents();
		theAttacksPackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theResultsPackage.createPackageContents();
		theConditionsPackage.createPackageContents();
		theGrammarSpecPackage.createPackageContents();
		theMRSPackagePackage.createPackageContents();

		// Initialize created meta-data
		theStandardGrammarPackage.initializePackageContents();
		theTestingPackagePackage.initializePackageContents();
		theAttacksPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theResultsPackage.initializePackageContents();
		theConditionsPackage.initializePackageContents();
		theGrammarSpecPackage.initializePackageContents();
		theMRSPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStandardGrammarPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StandardGrammarPackage.eNS_URI, theStandardGrammarPackage);
		return theStandardGrammarPackage;
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
	public EClass getSimulatorVariable() {
		return simulatorVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulatorVariable_Name() {
		return (EAttribute)simulatorVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryExpression() {
		return binaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpression_Left() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpression_Right() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryComparison() {
		return binaryComparisonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryComparison_Comp() {
		return (EAttribute)binaryComparisonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryLogicalExpression() {
		return binaryLogicalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryLogicalExpression_BinOp() {
		return (EAttribute)binaryLogicalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBinaryComparator() {
		return binaryComparatorEEnum;
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
	public StandardGrammarFactory getStandardGrammarFactory() {
		return (StandardGrammarFactory)getEFactoryInstance();
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
		variableEClass = createEClass(VARIABLE);

		simulatorVariableEClass = createEClass(SIMULATOR_VARIABLE);
		createEAttribute(simulatorVariableEClass, SIMULATOR_VARIABLE__NAME);

		expressionEClass = createEClass(EXPRESSION);

		binaryExpressionEClass = createEClass(BINARY_EXPRESSION);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__LEFT);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__RIGHT);

		binaryComparisonEClass = createEClass(BINARY_COMPARISON);
		createEAttribute(binaryComparisonEClass, BINARY_COMPARISON__COMP);

		binaryLogicalExpressionEClass = createEClass(BINARY_LOGICAL_EXPRESSION);
		createEAttribute(binaryLogicalExpressionEClass, BINARY_LOGICAL_EXPRESSION__BIN_OP);

		// Create enums
		binaryComparatorEEnum = createEEnum(BINARY_COMPARATOR);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		simulatorVariableEClass.getESuperTypes().add(this.getVariable());
		binaryExpressionEClass.getESuperTypes().add(this.getExpression());
		binaryComparisonEClass.getESuperTypes().add(this.getBinaryExpression());
		binaryLogicalExpressionEClass.getESuperTypes().add(this.getBinaryExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(variableEClass, Variable.class, "Variable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simulatorVariableEClass, SimulatorVariable.class, "SimulatorVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimulatorVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, SimulatorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryExpressionEClass, BinaryExpression.class, "BinaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryExpression_Left(), this.getExpression(), null, "left", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExpression_Right(), this.getExpression(), null, "right", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryComparisonEClass, BinaryComparison.class, "BinaryComparison", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryComparison_Comp(), this.getBinaryComparator(), "comp", null, 0, 1, BinaryComparison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryLogicalExpressionEClass, BinaryLogicalExpression.class, "BinaryLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryLogicalExpression_BinOp(), this.getBinaryLogicalOperation(), "binOp", null, 0, 1, BinaryLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(binaryComparatorEEnum, BinaryComparator.class, "BinaryComparator");
		addEEnumLiteral(binaryComparatorEEnum, BinaryComparator.LESS_THAN);
		addEEnumLiteral(binaryComparatorEEnum, BinaryComparator.GREATER_THAN);

		initEEnum(binaryLogicalOperationEEnum, BinaryLogicalOperation.class, "BinaryLogicalOperation");
		addEEnumLiteral(binaryLogicalOperationEEnum, BinaryLogicalOperation.AND);
		addEEnumLiteral(binaryLogicalOperationEEnum, BinaryLogicalOperation.OR);
	}

} //StandardGrammarPackageImpl
