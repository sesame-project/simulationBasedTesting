/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage
 * @generated
 */
public class GrammarSpecAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GrammarSpecPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarSpecAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GrammarSpecPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrammarSpecSwitch<Adapter> modelSwitch =
		new GrammarSpecSwitch<Adapter>() {
			@Override
			public Adapter caseGrammarSpecification(GrammarSpecification object) {
				return createGrammarSpecificationAdapter();
			}
			@Override
			public Adapter caseGrammarTag(GrammarTag object) {
				return createGrammarTagAdapter();
			}
			@Override
			public Adapter caseGrammarElt(GrammarElt object) {
				return createGrammarEltAdapter();
			}
			@Override
			public Adapter caseNonterminalGrammarElt(NonterminalGrammarElt object) {
				return createNonterminalGrammarEltAdapter();
			}
			@Override
			public Adapter caseTerminalGrammarElt(TerminalGrammarElt object) {
				return createTerminalGrammarEltAdapter();
			}
			@Override
			public Adapter caseGrammarValue(GrammarValue object) {
				return createGrammarValueAdapter();
			}
			@Override
			public Adapter caseGrammarRhsElt(GrammarRhsElt object) {
				return createGrammarRhsEltAdapter();
			}
			@Override
			public Adapter caseGrammarRule(GrammarRule object) {
				return createGrammarRuleAdapter();
			}
			@Override
			public Adapter caseGrammarConstraint(GrammarConstraint object) {
				return createGrammarConstraintAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification <em>Grammar Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification
	 * @generated
	 */
	public Adapter createGrammarSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarTag <em>Grammar Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarTag
	 * @generated
	 */
	public Adapter createGrammarTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt <em>Grammar Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt
	 * @generated
	 */
	public Adapter createGrammarEltAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.NonterminalGrammarElt <em>Nonterminal Grammar Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.NonterminalGrammarElt
	 * @generated
	 */
	public Adapter createNonterminalGrammarEltAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.TerminalGrammarElt <em>Terminal Grammar Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.TerminalGrammarElt
	 * @generated
	 */
	public Adapter createTerminalGrammarEltAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarValue <em>Grammar Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarValue
	 * @generated
	 */
	public Adapter createGrammarValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt <em>Grammar Rhs Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt
	 * @generated
	 */
	public Adapter createGrammarRhsEltAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule <em>Grammar Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule
	 * @generated
	 */
	public Adapter createGrammarRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarConstraint <em>Grammar Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarConstraint
	 * @generated
	 */
	public Adapter createGrammarConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GrammarSpecAdapterFactory
