/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GrammarSpecFactoryImpl extends EFactoryImpl implements GrammarSpecFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GrammarSpecFactory init() {
		try {
			GrammarSpecFactory theGrammarSpecFactory = (GrammarSpecFactory)EPackage.Registry.INSTANCE.getEFactory(GrammarSpecPackage.eNS_URI);
			if (theGrammarSpecFactory != null) {
				return theGrammarSpecFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GrammarSpecFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarSpecFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION: return createGrammarSpecification();
			case GrammarSpecPackage.GRAMMAR_TAG: return createGrammarTag();
			case GrammarSpecPackage.NONTERMINAL_GRAMMAR_ELT: return createNonterminalGrammarElt();
			case GrammarSpecPackage.TERMINAL_GRAMMAR_ELT: return createTerminalGrammarElt();
			case GrammarSpecPackage.GRAMMAR_VALUE: return createGrammarValue();
			case GrammarSpecPackage.GRAMMAR_RHS_ELT: return createGrammarRhsElt();
			case GrammarSpecPackage.GRAMMAR_RULE: return createGrammarRule();
			case GrammarSpecPackage.GRAMMAR_CONSTRAINT: return createGrammarConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarSpecification createGrammarSpecification() {
		GrammarSpecificationImpl grammarSpecification = new GrammarSpecificationImpl();
		return grammarSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarTag createGrammarTag() {
		GrammarTagImpl grammarTag = new GrammarTagImpl();
		return grammarTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonterminalGrammarElt createNonterminalGrammarElt() {
		NonterminalGrammarEltImpl nonterminalGrammarElt = new NonterminalGrammarEltImpl();
		return nonterminalGrammarElt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalGrammarElt createTerminalGrammarElt() {
		TerminalGrammarEltImpl terminalGrammarElt = new TerminalGrammarEltImpl();
		return terminalGrammarElt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarValue createGrammarValue() {
		GrammarValueImpl grammarValue = new GrammarValueImpl();
		return grammarValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarRhsElt createGrammarRhsElt() {
		GrammarRhsEltImpl grammarRhsElt = new GrammarRhsEltImpl();
		return grammarRhsElt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarRule createGrammarRule() {
		GrammarRuleImpl grammarRule = new GrammarRuleImpl();
		return grammarRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarConstraint createGrammarConstraint() {
		GrammarConstraintImpl grammarConstraint = new GrammarConstraintImpl();
		return grammarConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarSpecPackage getGrammarSpecPackage() {
		return (GrammarSpecPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GrammarSpecPackage getPackage() {
		return GrammarSpecPackage.eINSTANCE;
	}

} //GrammarSpecFactoryImpl
