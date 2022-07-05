/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage
 * @generated
 */
public interface GrammarSpecFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GrammarSpecFactory eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Grammar Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar Specification</em>'.
	 * @generated
	 */
	GrammarSpecification createGrammarSpecification();

	/**
	 * Returns a new object of class '<em>Grammar Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar Tag</em>'.
	 * @generated
	 */
	GrammarTag createGrammarTag();

	/**
	 * Returns a new object of class '<em>Nonterminal Grammar Elt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nonterminal Grammar Elt</em>'.
	 * @generated
	 */
	NonterminalGrammarElt createNonterminalGrammarElt();

	/**
	 * Returns a new object of class '<em>Terminal Grammar Elt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminal Grammar Elt</em>'.
	 * @generated
	 */
	TerminalGrammarElt createTerminalGrammarElt();

	/**
	 * Returns a new object of class '<em>Grammar Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar Value</em>'.
	 * @generated
	 */
	GrammarValue createGrammarValue();

	/**
	 * Returns a new object of class '<em>Grammar Rhs Elt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar Rhs Elt</em>'.
	 * @generated
	 */
	GrammarRhsElt createGrammarRhsElt();

	/**
	 * Returns a new object of class '<em>Grammar Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar Rule</em>'.
	 * @generated
	 */
	GrammarRule createGrammarRule();

	/**
	 * Returns a new object of class '<em>Grammar Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar Constraint</em>'.
	 * @generated
	 */
	GrammarConstraint createGrammarConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GrammarSpecPackage getGrammarSpecPackage();

} //GrammarSpecFactory
