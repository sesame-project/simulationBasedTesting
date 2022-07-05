/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.NonterminalGrammarElt;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRuleImpl#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRuleImpl#getLhs <em>Lhs</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRuleImpl#getRhsElts <em>Rhs Elts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GrammarRuleImpl extends MinimalEObjectImpl.Container implements GrammarRule {
	/**
	 * The default value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleName()
	 * @generated
	 * @ordered
	 */
	protected String ruleName = RULE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLhs() <em>Lhs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLhs()
	 * @generated
	 * @ordered
	 */
	protected NonterminalGrammarElt lhs;

	/**
	 * The cached value of the '{@link #getRhsElts() <em>Rhs Elts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhsElts()
	 * @generated
	 * @ordered
	 */
	protected EList<GrammarRhsElt> rhsElts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrammarRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GrammarSpecPackage.Literals.GRAMMAR_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleName(String newRuleName) {
		String oldRuleName = ruleName;
		ruleName = newRuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GrammarSpecPackage.GRAMMAR_RULE__RULE_NAME, oldRuleName, ruleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonterminalGrammarElt getLhs() {
		if (lhs != null && lhs.eIsProxy()) {
			InternalEObject oldLhs = (InternalEObject)lhs;
			lhs = (NonterminalGrammarElt)eResolveProxy(oldLhs);
			if (lhs != oldLhs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GrammarSpecPackage.GRAMMAR_RULE__LHS, oldLhs, lhs));
			}
		}
		return lhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonterminalGrammarElt basicGetLhs() {
		return lhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLhs(NonterminalGrammarElt newLhs) {
		NonterminalGrammarElt oldLhs = lhs;
		lhs = newLhs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GrammarSpecPackage.GRAMMAR_RULE__LHS, oldLhs, lhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GrammarRhsElt> getRhsElts() {
		if (rhsElts == null) {
			rhsElts = new EObjectContainmentEList<GrammarRhsElt>(GrammarRhsElt.class, this, GrammarSpecPackage.GRAMMAR_RULE__RHS_ELTS);
		}
		return rhsElts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GrammarSpecPackage.GRAMMAR_RULE__RHS_ELTS:
				return ((InternalEList<?>)getRhsElts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GrammarSpecPackage.GRAMMAR_RULE__RULE_NAME:
				return getRuleName();
			case GrammarSpecPackage.GRAMMAR_RULE__LHS:
				if (resolve) return getLhs();
				return basicGetLhs();
			case GrammarSpecPackage.GRAMMAR_RULE__RHS_ELTS:
				return getRhsElts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GrammarSpecPackage.GRAMMAR_RULE__RULE_NAME:
				setRuleName((String)newValue);
				return;
			case GrammarSpecPackage.GRAMMAR_RULE__LHS:
				setLhs((NonterminalGrammarElt)newValue);
				return;
			case GrammarSpecPackage.GRAMMAR_RULE__RHS_ELTS:
				getRhsElts().clear();
				getRhsElts().addAll((Collection<? extends GrammarRhsElt>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GrammarSpecPackage.GRAMMAR_RULE__RULE_NAME:
				setRuleName(RULE_NAME_EDEFAULT);
				return;
			case GrammarSpecPackage.GRAMMAR_RULE__LHS:
				setLhs((NonterminalGrammarElt)null);
				return;
			case GrammarSpecPackage.GRAMMAR_RULE__RHS_ELTS:
				getRhsElts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GrammarSpecPackage.GRAMMAR_RULE__RULE_NAME:
				return RULE_NAME_EDEFAULT == null ? ruleName != null : !RULE_NAME_EDEFAULT.equals(ruleName);
			case GrammarSpecPackage.GRAMMAR_RULE__LHS:
				return lhs != null;
			case GrammarSpecPackage.GRAMMAR_RULE__RHS_ELTS:
				return rhsElts != null && !rhsElts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (ruleName: ");
		result.append(ruleName);
		result.append(')');
		return result.toString();
	}

} //GrammarRuleImpl
