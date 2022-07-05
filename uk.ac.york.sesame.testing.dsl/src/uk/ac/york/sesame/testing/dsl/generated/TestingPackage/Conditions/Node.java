/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getGrammarElt <em>Grammar Elt</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getSubNode <em>Sub Node</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.ConditionsPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Grammar Elt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grammar Elt</em>' reference.
	 * @see #setGrammarElt(GrammarElt)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.ConditionsPackage#getNode_GrammarElt()
	 * @model required="true"
	 * @generated
	 */
	GrammarElt getGrammarElt();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getGrammarElt <em>Grammar Elt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammar Elt</em>' reference.
	 * @see #getGrammarElt()
	 * @generated
	 */
	void setGrammarElt(GrammarElt value);

	/**
	 * Returns the value of the '<em><b>Sub Node</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Node</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.ConditionsPackage#getNode_SubNode()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getSubNode();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.ConditionsPackage#getNode_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

} // Node
