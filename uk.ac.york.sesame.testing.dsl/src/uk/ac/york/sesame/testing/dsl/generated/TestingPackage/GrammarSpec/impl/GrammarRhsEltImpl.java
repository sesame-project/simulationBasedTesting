/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRhsElt;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar Rhs Elt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarRhsEltImpl#getElt <em>Elt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GrammarRhsEltImpl extends MinimalEObjectImpl.Container implements GrammarRhsElt {
	/**
	 * The cached value of the '{@link #getElt() <em>Elt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElt()
	 * @generated
	 * @ordered
	 */
	protected GrammarElt elt;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrammarRhsEltImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GrammarSpecPackage.Literals.GRAMMAR_RHS_ELT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarElt getElt() {
		if (elt != null && elt.eIsProxy()) {
			InternalEObject oldElt = (InternalEObject)elt;
			elt = (GrammarElt)eResolveProxy(oldElt);
			if (elt != oldElt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GrammarSpecPackage.GRAMMAR_RHS_ELT__ELT, oldElt, elt));
			}
		}
		return elt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarElt basicGetElt() {
		return elt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElt(GrammarElt newElt) {
		GrammarElt oldElt = elt;
		elt = newElt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GrammarSpecPackage.GRAMMAR_RHS_ELT__ELT, oldElt, elt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GrammarSpecPackage.GRAMMAR_RHS_ELT__ELT:
				if (resolve) return getElt();
				return basicGetElt();
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
			case GrammarSpecPackage.GRAMMAR_RHS_ELT__ELT:
				setElt((GrammarElt)newValue);
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
			case GrammarSpecPackage.GRAMMAR_RHS_ELT__ELT:
				setElt((GrammarElt)null);
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
			case GrammarSpecPackage.GRAMMAR_RHS_ELT__ELT:
				return elt != null;
		}
		return super.eIsSet(featureID);
	}

} //GrammarRhsEltImpl
