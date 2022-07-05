/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage
 * @generated
 */
public class GrammarSpecSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GrammarSpecPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarSpecSwitch() {
		if (modelPackage == null) {
			modelPackage = GrammarSpecPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION: {
				GrammarSpecification grammarSpecification = (GrammarSpecification)theEObject;
				T result = caseGrammarSpecification(grammarSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GrammarSpecPackage.GRAMMAR_TAG: {
				GrammarTag grammarTag = (GrammarTag)theEObject;
				T result = caseGrammarTag(grammarTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GrammarSpecPackage.GRAMMAR_ELT: {
				GrammarElt grammarElt = (GrammarElt)theEObject;
				T result = caseGrammarElt(grammarElt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GrammarSpecPackage.NONTERMINAL_GRAMMAR_ELT: {
				NonterminalGrammarElt nonterminalGrammarElt = (NonterminalGrammarElt)theEObject;
				T result = caseNonterminalGrammarElt(nonterminalGrammarElt);
				if (result == null) result = caseGrammarElt(nonterminalGrammarElt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GrammarSpecPackage.TERMINAL_GRAMMAR_ELT: {
				TerminalGrammarElt terminalGrammarElt = (TerminalGrammarElt)theEObject;
				T result = caseTerminalGrammarElt(terminalGrammarElt);
				if (result == null) result = caseGrammarElt(terminalGrammarElt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GrammarSpecPackage.GRAMMAR_VALUE: {
				GrammarValue grammarValue = (GrammarValue)theEObject;
				T result = caseGrammarValue(grammarValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GrammarSpecPackage.GRAMMAR_RHS_ELT: {
				GrammarRhsElt grammarRhsElt = (GrammarRhsElt)theEObject;
				T result = caseGrammarRhsElt(grammarRhsElt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GrammarSpecPackage.GRAMMAR_RULE: {
				GrammarRule grammarRule = (GrammarRule)theEObject;
				T result = caseGrammarRule(grammarRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GrammarSpecPackage.GRAMMAR_CONSTRAINT: {
				GrammarConstraint grammarConstraint = (GrammarConstraint)theEObject;
				T result = caseGrammarConstraint(grammarConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grammar Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grammar Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrammarSpecification(GrammarSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grammar Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grammar Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrammarTag(GrammarTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grammar Elt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grammar Elt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrammarElt(GrammarElt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nonterminal Grammar Elt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nonterminal Grammar Elt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonterminalGrammarElt(NonterminalGrammarElt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminal Grammar Elt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminal Grammar Elt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminalGrammarElt(TerminalGrammarElt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grammar Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grammar Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrammarValue(GrammarValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grammar Rhs Elt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grammar Rhs Elt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrammarRhsElt(GrammarRhsElt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grammar Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grammar Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrammarRule(GrammarRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grammar Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grammar Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrammarConstraint(GrammarConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GrammarSpecSwitch
