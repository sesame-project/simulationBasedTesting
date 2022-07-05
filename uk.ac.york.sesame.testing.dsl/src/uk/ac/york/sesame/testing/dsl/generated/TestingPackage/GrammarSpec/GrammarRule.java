/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grammar Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getLhs <em>Lhs</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getRhsElts <em>Rhs Elts</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage#getGrammarRule()
 * @model
 * @generated
 */
public interface GrammarRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Name</em>' attribute.
	 * @see #setRuleName(String)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage#getGrammarRule_RuleName()
	 * @model
	 * @generated
	 */
	String getRuleName();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getRuleName <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Name</em>' attribute.
	 * @see #getRuleName()
	 * @generated
	 */
	void setRuleName(String value);

	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' reference.
	 * @see #setLhs(NonterminalGrammarElt)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage#getGrammarRule_Lhs()
	 * @model required="true"
	 * @generated
	 */
	NonterminalGrammarElt getLhs();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule#getLhs <em>Lhs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(NonterminalGrammarElt value);

	/**
	 * Returns the value of the '<em><b>Rhs Elts</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs Elts</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage#getGrammarRule_RhsElts()
	 * @model containment="true"
	 * @generated
	 */
	EList<GrammarRhsElt> getRhsElts();

} // GrammarRule
