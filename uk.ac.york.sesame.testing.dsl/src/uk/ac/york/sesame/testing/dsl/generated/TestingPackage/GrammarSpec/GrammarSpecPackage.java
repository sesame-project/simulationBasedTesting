/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecFactory
 * @model kind="package"
 * @generated
 */
public interface GrammarSpecPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "GrammarSpec";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "GrammarSpec";

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
	GrammarSpecPackage eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecificationImpl <em>Grammar Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecificationImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarSpecification()
	 * @generated
	 */
	int GRAMMAR_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_SPECIFICATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Root Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_SPECIFICATION__ROOT_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_SPECIFICATION__ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_SPECIFICATION__RULES = 3;

	/**
	 * The number of structural features of the '<em>Grammar Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_SPECIFICATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Grammar Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarTagImpl <em>Grammar Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarTagImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarTag()
	 * @generated
	 */
	int GRAMMAR_TAG = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_TAG__NAME = 0;

	/**
	 * The number of structural features of the '<em>Grammar Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_TAG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Grammar Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_TAG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarEltImpl <em>Grammar Elt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarEltImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarElt()
	 * @generated
	 */
	int GRAMMAR_ELT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_ELT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parent Grammar</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_ELT__PARENT_GRAMMAR = 1;

	/**
	 * The number of structural features of the '<em>Grammar Elt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_ELT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Grammar Elt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_ELT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.NonterminalGrammarEltImpl <em>Nonterminal Grammar Elt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.NonterminalGrammarEltImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getNonterminalGrammarElt()
	 * @generated
	 */
	int NONTERMINAL_GRAMMAR_ELT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NONTERMINAL_GRAMMAR_ELT__NAME = GRAMMAR_ELT__NAME;

	/**
	 * The feature id for the '<em><b>Parent Grammar</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NONTERMINAL_GRAMMAR_ELT__PARENT_GRAMMAR = GRAMMAR_ELT__PARENT_GRAMMAR;

	/**
	 * The number of structural features of the '<em>Nonterminal Grammar Elt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NONTERMINAL_GRAMMAR_ELT_FEATURE_COUNT = GRAMMAR_ELT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Nonterminal Grammar Elt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NONTERMINAL_GRAMMAR_ELT_OPERATION_COUNT = GRAMMAR_ELT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.TerminalGrammarEltImpl <em>Terminal Grammar Elt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.TerminalGrammarEltImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getTerminalGrammarElt()
	 * @generated
	 */
	int TERMINAL_GRAMMAR_ELT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_GRAMMAR_ELT__NAME = GRAMMAR_ELT__NAME;

	/**
	 * The feature id for the '<em><b>Parent Grammar</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_GRAMMAR_ELT__PARENT_GRAMMAR = GRAMMAR_ELT__PARENT_GRAMMAR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_GRAMMAR_ELT__VALUE = GRAMMAR_ELT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminal Grammar Elt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_GRAMMAR_ELT_FEATURE_COUNT = GRAMMAR_ELT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Terminal Grammar Elt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_GRAMMAR_ELT_OPERATION_COUNT = GRAMMAR_ELT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarValueImpl <em>Grammar Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarValueImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarValue()
	 * @generated
	 */
	int GRAMMAR_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_VALUE__OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Grammar Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Grammar Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRhsEltImpl <em>Grammar Rhs Elt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRhsEltImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarRhsElt()
	 * @generated
	 */
	int GRAMMAR_RHS_ELT = 6;

	/**
	 * The feature id for the '<em><b>Elt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_RHS_ELT__ELT = 0;

	/**
	 * The number of structural features of the '<em>Grammar Rhs Elt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_RHS_ELT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Grammar Rhs Elt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_RHS_ELT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRuleImpl <em>Grammar Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRuleImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarRule()
	 * @generated
	 */
	int GRAMMAR_RULE = 7;

	/**
	 * The feature id for the '<em><b>Rule Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_RULE__RULE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_RULE__LHS = 1;

	/**
	 * The feature id for the '<em><b>Rhs Elts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_RULE__RHS_ELTS = 2;

	/**
	 * The number of structural features of the '<em>Grammar Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_RULE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Grammar Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_RULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarConstraintImpl <em>Grammar Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarConstraintImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarConstraint()
	 * @generated
	 */
	int GRAMMAR_CONSTRAINT = 8;

	/**
	 * The number of structural features of the '<em>Grammar Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_CONSTRAINT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Grammar Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_CONSTRAINT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification <em>Grammar Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Specification</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification
	 * @generated
	 */
	EClass getGrammarSpecification();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification#getName()
	 * @see #getGrammarSpecification()
	 * @generated
	 */
	EAttribute getGrammarSpecification_Name();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification#getRootElement <em>Root Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root Element</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification#getRootElement()
	 * @see #getGrammarSpecification()
	 * @generated
	 */
	EReference getGrammarSpecification_RootElement();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification#getElements()
	 * @see #getGrammarSpecification()
	 * @generated
	 */
	EReference getGrammarSpecification_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification#getRules()
	 * @see #getGrammarSpecification()
	 * @generated
	 */
	EReference getGrammarSpecification_Rules();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarTag <em>Grammar Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Tag</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarTag
	 * @generated
	 */
	EClass getGrammarTag();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarTag#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarTag#getName()
	 * @see #getGrammarTag()
	 * @generated
	 */
	EAttribute getGrammarTag_Name();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt <em>Grammar Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Elt</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt
	 * @generated
	 */
	EClass getGrammarElt();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt#getName()
	 * @see #getGrammarElt()
	 * @generated
	 */
	EAttribute getGrammarElt_Name();

	/**
	 * Returns the meta object for the container reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt#getParentGrammar <em>Parent Grammar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Grammar</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt#getParentGrammar()
	 * @see #getGrammarElt()
	 * @generated
	 */
	EReference getGrammarElt_ParentGrammar();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.NonterminalGrammarElt <em>Nonterminal Grammar Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nonterminal Grammar Elt</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.NonterminalGrammarElt
	 * @generated
	 */
	EClass getNonterminalGrammarElt();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.TerminalGrammarElt <em>Terminal Grammar Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal Grammar Elt</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.TerminalGrammarElt
	 * @generated
	 */
	EClass getTerminalGrammarElt();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.TerminalGrammarElt#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.TerminalGrammarElt#getValue()
	 * @see #getTerminalGrammarElt()
	 * @generated
	 */
	EReference getTerminalGrammarElt_Value();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarValue <em>Grammar Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarValue
	 * @generated
	 */
	EClass getGrammarValue();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarValue#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarValue#getObject()
	 * @see #getGrammarValue()
	 * @generated
	 */
	EAttribute getGrammarValue_Object();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt <em>Grammar Rhs Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Rhs Elt</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt
	 * @generated
	 */
	EClass getGrammarRhsElt();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt#getElt <em>Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Elt</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt#getElt()
	 * @see #getGrammarRhsElt()
	 * @generated
	 */
	EReference getGrammarRhsElt_Elt();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule <em>Grammar Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Rule</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule
	 * @generated
	 */
	EClass getGrammarRule();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getRuleName <em>Rule Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getRuleName()
	 * @see #getGrammarRule()
	 * @generated
	 */
	EAttribute getGrammarRule_RuleName();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lhs</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getLhs()
	 * @see #getGrammarRule()
	 * @generated
	 */
	EReference getGrammarRule_Lhs();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getRhsElts <em>Rhs Elts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rhs Elts</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getRhsElts()
	 * @see #getGrammarRule()
	 * @generated
	 */
	EReference getGrammarRule_RhsElts();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarConstraint <em>Grammar Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar Constraint</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarConstraint
	 * @generated
	 */
	EClass getGrammarConstraint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GrammarSpecFactory getGrammarSpecFactory();

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
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecificationImpl <em>Grammar Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecificationImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarSpecification()
		 * @generated
		 */
		EClass GRAMMAR_SPECIFICATION = eINSTANCE.getGrammarSpecification();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR_SPECIFICATION__NAME = eINSTANCE.getGrammarSpecification_Name();

		/**
		 * The meta object literal for the '<em><b>Root Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMAR_SPECIFICATION__ROOT_ELEMENT = eINSTANCE.getGrammarSpecification_RootElement();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMAR_SPECIFICATION__ELEMENTS = eINSTANCE.getGrammarSpecification_Elements();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMAR_SPECIFICATION__RULES = eINSTANCE.getGrammarSpecification_Rules();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarTagImpl <em>Grammar Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarTagImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarTag()
		 * @generated
		 */
		EClass GRAMMAR_TAG = eINSTANCE.getGrammarTag();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR_TAG__NAME = eINSTANCE.getGrammarTag_Name();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarEltImpl <em>Grammar Elt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarEltImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarElt()
		 * @generated
		 */
		EClass GRAMMAR_ELT = eINSTANCE.getGrammarElt();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR_ELT__NAME = eINSTANCE.getGrammarElt_Name();

		/**
		 * The meta object literal for the '<em><b>Parent Grammar</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMAR_ELT__PARENT_GRAMMAR = eINSTANCE.getGrammarElt_ParentGrammar();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.NonterminalGrammarEltImpl <em>Nonterminal Grammar Elt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.NonterminalGrammarEltImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getNonterminalGrammarElt()
		 * @generated
		 */
		EClass NONTERMINAL_GRAMMAR_ELT = eINSTANCE.getNonterminalGrammarElt();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.TerminalGrammarEltImpl <em>Terminal Grammar Elt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.TerminalGrammarEltImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getTerminalGrammarElt()
		 * @generated
		 */
		EClass TERMINAL_GRAMMAR_ELT = eINSTANCE.getTerminalGrammarElt();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINAL_GRAMMAR_ELT__VALUE = eINSTANCE.getTerminalGrammarElt_Value();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarValueImpl <em>Grammar Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarValueImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarValue()
		 * @generated
		 */
		EClass GRAMMAR_VALUE = eINSTANCE.getGrammarValue();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR_VALUE__OBJECT = eINSTANCE.getGrammarValue_Object();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRhsEltImpl <em>Grammar Rhs Elt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRhsEltImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarRhsElt()
		 * @generated
		 */
		EClass GRAMMAR_RHS_ELT = eINSTANCE.getGrammarRhsElt();

		/**
		 * The meta object literal for the '<em><b>Elt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMAR_RHS_ELT__ELT = eINSTANCE.getGrammarRhsElt_Elt();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRuleImpl <em>Grammar Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRuleImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarRule()
		 * @generated
		 */
		EClass GRAMMAR_RULE = eINSTANCE.getGrammarRule();

		/**
		 * The meta object literal for the '<em><b>Rule Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR_RULE__RULE_NAME = eINSTANCE.getGrammarRule_RuleName();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMAR_RULE__LHS = eINSTANCE.getGrammarRule_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs Elts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMAR_RULE__RHS_ELTS = eINSTANCE.getGrammarRule_RhsElts();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarConstraintImpl <em>Grammar Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarConstraintImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecPackageImpl#getGrammarConstraint()
		 * @generated
		 */
		EClass GRAMMAR_CONSTRAINT = eINSTANCE.getGrammarConstraint();

	}

} //GrammarSpecPackage
