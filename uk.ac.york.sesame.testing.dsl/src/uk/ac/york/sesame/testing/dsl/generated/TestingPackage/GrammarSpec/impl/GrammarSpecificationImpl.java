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
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarElt;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarRule;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.GrammarSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecificationImpl#getRootElement <em>Root Element</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecificationImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpec.impl.GrammarSpecificationImpl#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GrammarSpecificationImpl extends MinimalEObjectImpl.Container implements GrammarSpecification {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getRootElement() <em>Root Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootElement()
	 * @generated
	 * @ordered
	 */
	protected GrammarElt rootElement;
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<GrammarElt> elements;
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<GrammarRule> rules;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrammarSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GrammarSpecPackage.Literals.GRAMMAR_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GrammarSpecPackage.GRAMMAR_SPECIFICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarElt getRootElement() {
		if (rootElement != null && rootElement.eIsProxy()) {
			InternalEObject oldRootElement = (InternalEObject)rootElement;
			rootElement = (GrammarElt)eResolveProxy(oldRootElement);
			if (rootElement != oldRootElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GrammarSpecPackage.GRAMMAR_SPECIFICATION__ROOT_ELEMENT, oldRootElement, rootElement));
			}
		}
		return rootElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarElt basicGetRootElement() {
		return rootElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootElement(GrammarElt newRootElement) {
		GrammarElt oldRootElement = rootElement;
		rootElement = newRootElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GrammarSpecPackage.GRAMMAR_SPECIFICATION__ROOT_ELEMENT, oldRootElement, rootElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GrammarElt> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<GrammarElt>(GrammarElt.class, this, GrammarSpecPackage.GRAMMAR_SPECIFICATION__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GrammarRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<GrammarRule>(GrammarRule.class, this, GrammarSpecPackage.GRAMMAR_SPECIFICATION__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
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
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__NAME:
				return getName();
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ROOT_ELEMENT:
				if (resolve) return getRootElement();
				return basicGetRootElement();
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ELEMENTS:
				return getElements();
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__RULES:
				return getRules();
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
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__NAME:
				setName((String)newValue);
				return;
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ROOT_ELEMENT:
				setRootElement((GrammarElt)newValue);
				return;
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends GrammarElt>)newValue);
				return;
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends GrammarRule>)newValue);
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
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ROOT_ELEMENT:
				setRootElement((GrammarElt)null);
				return;
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ELEMENTS:
				getElements().clear();
				return;
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__RULES:
				getRules().clear();
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
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ROOT_ELEMENT:
				return rootElement != null;
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case GrammarSpecPackage.GRAMMAR_SPECIFICATION__RULES:
				return rules != null && !rules.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //GrammarSpecificationImpl
