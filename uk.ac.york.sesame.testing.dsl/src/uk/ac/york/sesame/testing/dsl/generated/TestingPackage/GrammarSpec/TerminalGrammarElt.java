/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal Grammar Elt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.TerminalGrammarElt#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage#getTerminalGrammarElt()
 * @model
 * @generated
 */
public interface TerminalGrammarElt extends GrammarElt {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(GrammarValue)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage#getTerminalGrammarElt_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GrammarValue getValue();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.TerminalGrammarElt#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(GrammarValue value);

} // TerminalGrammarElt
