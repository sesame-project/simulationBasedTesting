/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar;

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
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarFactory
 * @model kind="package"
 * @generated
 */
public interface StandardComparisonGrammarPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StandardComparisonGrammar";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "StandardComparisonGrammar";

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
	StandardComparisonGrammarPackage eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionElementImpl <em>Condition Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionElementImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getConditionElement()
	 * @generated
	 */
	int CONDITION_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Condition Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Condition Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.CompositeConditionImpl <em>Composite Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.CompositeConditionImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getCompositeCondition()
	 * @generated
	 */
	int COMPOSITE_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__LEFT = CONDITION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__BINOP = CONDITION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION__RIGHT = CONDITION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_FEATURE_COUNT = CONDITION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Composite Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_OPERATION_COUNT = CONDITION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.BasicConditionImpl <em>Basic Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.BasicConditionImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getBasicCondition()
	 * @generated
	 */
	int BASIC_CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONDITION__LEFT = CONDITION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bincomp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONDITION__BINCOMP = CONDITION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONDITION__RIGHT = CONDITION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Basic Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONDITION_FEATURE_COUNT = CONDITION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Basic Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONDITION_OPERATION_COUNT = CONDITION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.LiteralImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 3;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionIntegerImpl <em>Condition Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionIntegerImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getConditionInteger()
	 * @generated
	 */
	int CONDITION_INTEGER = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INTEGER__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Condition Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INTEGER_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Condition Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INTEGER_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.VariableImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__METRIC = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = LITERAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 6;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardConditionImpl <em>Standard Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardConditionImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getStandardCondition()
	 * @generated
	 */
	int STANDARD_CONDITION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_CONDITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>C</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_CONDITION__C = 1;

	/**
	 * The number of structural features of the '<em>Standard Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_CONDITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Standard Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryComparisonOperation <em>Binary Comparison Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryComparisonOperation
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getBinaryComparisonOperation()
	 * @generated
	 */
	int BINARY_COMPARISON_OPERATION = 8;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryLogicalOperation <em>Binary Logical Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryLogicalOperation
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getBinaryLogicalOperation()
	 * @generated
	 */
	int BINARY_LOGICAL_OPERATION = 9;


	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.ConditionElement <em>Condition Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Element</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.ConditionElement
	 * @generated
	 */
	EClass getConditionElement();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition <em>Composite Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Condition</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition
	 * @generated
	 */
	EClass getCompositeCondition();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition#getLeft()
	 * @see #getCompositeCondition()
	 * @generated
	 */
	EReference getCompositeCondition_Left();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition#getBinop <em>Binop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binop</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition#getBinop()
	 * @see #getCompositeCondition()
	 * @generated
	 */
	EAttribute getCompositeCondition_Binop();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.CompositeCondition#getRight()
	 * @see #getCompositeCondition()
	 * @generated
	 */
	EReference getCompositeCondition_Right();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition <em>Basic Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Condition</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition
	 * @generated
	 */
	EClass getBasicCondition();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition#getLeft()
	 * @see #getBasicCondition()
	 * @generated
	 */
	EReference getBasicCondition_Left();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition#getBincomp <em>Bincomp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bincomp</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition#getBincomp()
	 * @see #getBasicCondition()
	 * @generated
	 */
	EAttribute getBasicCondition_Bincomp();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BasicCondition#getRight()
	 * @see #getBasicCondition()
	 * @generated
	 */
	EReference getBasicCondition_Right();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.ConditionInteger <em>Condition Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Integer</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.ConditionInteger
	 * @generated
	 */
	EClass getConditionInteger();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.ConditionInteger#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.ConditionInteger#getValue()
	 * @see #getConditionInteger()
	 * @generated
	 */
	EAttribute getConditionInteger_Value();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Variable#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Variable#getMetric()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Metric();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition <em>Standard Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Standard Condition</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition
	 * @generated
	 */
	EClass getStandardCondition();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition#getName()
	 * @see #getStandardCondition()
	 * @generated
	 */
	EAttribute getStandardCondition_Name();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>C</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardCondition#getC()
	 * @see #getStandardCondition()
	 * @generated
	 */
	EReference getStandardCondition_C();

	/**
	 * Returns the meta object for enum '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryComparisonOperation <em>Binary Comparison Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Comparison Operation</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryComparisonOperation
	 * @generated
	 */
	EEnum getBinaryComparisonOperation();

	/**
	 * Returns the meta object for enum '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryLogicalOperation <em>Binary Logical Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binary Logical Operation</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryLogicalOperation
	 * @generated
	 */
	EEnum getBinaryLogicalOperation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StandardComparisonGrammarFactory getStandardComparisonGrammarFactory();

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
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionElementImpl <em>Condition Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionElementImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getConditionElement()
		 * @generated
		 */
		EClass CONDITION_ELEMENT = eINSTANCE.getConditionElement();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.CompositeConditionImpl <em>Composite Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.CompositeConditionImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getCompositeCondition()
		 * @generated
		 */
		EClass COMPOSITE_CONDITION = eINSTANCE.getCompositeCondition();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_CONDITION__LEFT = eINSTANCE.getCompositeCondition_Left();

		/**
		 * The meta object literal for the '<em><b>Binop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_CONDITION__BINOP = eINSTANCE.getCompositeCondition_Binop();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_CONDITION__RIGHT = eINSTANCE.getCompositeCondition_Right();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.BasicConditionImpl <em>Basic Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.BasicConditionImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getBasicCondition()
		 * @generated
		 */
		EClass BASIC_CONDITION = eINSTANCE.getBasicCondition();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_CONDITION__LEFT = eINSTANCE.getBasicCondition_Left();

		/**
		 * The meta object literal for the '<em><b>Bincomp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_CONDITION__BINCOMP = eINSTANCE.getBasicCondition_Bincomp();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_CONDITION__RIGHT = eINSTANCE.getBasicCondition_Right();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.LiteralImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionIntegerImpl <em>Condition Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionIntegerImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getConditionInteger()
		 * @generated
		 */
		EClass CONDITION_INTEGER = eINSTANCE.getConditionInteger();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_INTEGER__VALUE = eINSTANCE.getConditionInteger_Value();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.VariableImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Metric</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__METRIC = eINSTANCE.getVariable_Metric();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.ConditionImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardConditionImpl <em>Standard Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardConditionImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getStandardCondition()
		 * @generated
		 */
		EClass STANDARD_CONDITION = eINSTANCE.getStandardCondition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_CONDITION__NAME = eINSTANCE.getStandardCondition_Name();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_CONDITION__C = eINSTANCE.getStandardCondition_C();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryComparisonOperation <em>Binary Comparison Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryComparisonOperation
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getBinaryComparisonOperation()
		 * @generated
		 */
		EEnum BINARY_COMPARISON_OPERATION = eINSTANCE.getBinaryComparisonOperation();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryLogicalOperation <em>Binary Logical Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.BinaryLogicalOperation
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarPackageImpl#getBinaryLogicalOperation()
		 * @generated
		 */
		EEnum BINARY_LOGICAL_OPERATION = eINSTANCE.getBinaryLogicalOperation();

	}

} //StandardComparisonGrammarPackage
