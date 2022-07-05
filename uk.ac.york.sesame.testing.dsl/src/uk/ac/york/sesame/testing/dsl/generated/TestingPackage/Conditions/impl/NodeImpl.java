/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl;

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

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.ConditionsPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeImpl#getGrammarElt <em>Grammar Elt</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeImpl#getSubNode <em>Sub Node</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends MinimalEObjectImpl.Container implements Node {
	/**
	 * The cached value of the '{@link #getGrammarElt() <em>Grammar Elt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrammarElt()
	 * @generated
	 * @ordered
	 */
	protected GrammarElt grammarElt;

	/**
	 * The cached value of the '{@link #getSubNode() <em>Sub Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubNode()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> subNode;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionsPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarElt getGrammarElt() {
		if (grammarElt != null && grammarElt.eIsProxy()) {
			InternalEObject oldGrammarElt = (InternalEObject)grammarElt;
			grammarElt = (GrammarElt)eResolveProxy(oldGrammarElt);
			if (grammarElt != oldGrammarElt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConditionsPackage.NODE__GRAMMAR_ELT, oldGrammarElt, grammarElt));
			}
		}
		return grammarElt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarElt basicGetGrammarElt() {
		return grammarElt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrammarElt(GrammarElt newGrammarElt) {
		GrammarElt oldGrammarElt = grammarElt;
		grammarElt = newGrammarElt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionsPackage.NODE__GRAMMAR_ELT, oldGrammarElt, grammarElt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getSubNode() {
		if (subNode == null) {
			subNode = new EObjectContainmentEList<Node>(Node.class, this, ConditionsPackage.NODE__SUB_NODE);
		}
		return subNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionsPackage.NODE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConditionsPackage.NODE__SUB_NODE:
				return ((InternalEList<?>)getSubNode()).basicRemove(otherEnd, msgs);
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
			case ConditionsPackage.NODE__GRAMMAR_ELT:
				if (resolve) return getGrammarElt();
				return basicGetGrammarElt();
			case ConditionsPackage.NODE__SUB_NODE:
				return getSubNode();
			case ConditionsPackage.NODE__VALUE:
				return getValue();
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
			case ConditionsPackage.NODE__GRAMMAR_ELT:
				setGrammarElt((GrammarElt)newValue);
				return;
			case ConditionsPackage.NODE__SUB_NODE:
				getSubNode().clear();
				getSubNode().addAll((Collection<? extends Node>)newValue);
				return;
			case ConditionsPackage.NODE__VALUE:
				setValue(newValue);
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
			case ConditionsPackage.NODE__GRAMMAR_ELT:
				setGrammarElt((GrammarElt)null);
				return;
			case ConditionsPackage.NODE__SUB_NODE:
				getSubNode().clear();
				return;
			case ConditionsPackage.NODE__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ConditionsPackage.NODE__GRAMMAR_ELT:
				return grammarElt != null;
			case ConditionsPackage.NODE__SUB_NODE:
				return subNode != null && !subNode.isEmpty();
			case ConditionsPackage.NODE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
