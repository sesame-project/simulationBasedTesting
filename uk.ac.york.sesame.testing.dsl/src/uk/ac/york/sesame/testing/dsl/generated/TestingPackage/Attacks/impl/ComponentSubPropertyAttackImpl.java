/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentSubPropertyAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.ComponentProperty;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Sub Property Attack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentSubPropertyAttackImpl#getPropertyToAttack <em>Property To Attack</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentSubPropertyAttackImpl#getSubProperty <em>Sub Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentSubPropertyAttackImpl extends FuzzTestingAttackImpl implements ComponentSubPropertyAttack {
	/**
	 * The cached value of the '{@link #getPropertyToAttack() <em>Property To Attack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyToAttack()
	 * @generated
	 * @ordered
	 */
	protected ComponentProperty propertyToAttack;
	/**
	 * The cached value of the '{@link #getSubProperty() <em>Sub Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProperty()
	 * @generated
	 * @ordered
	 */
	protected Type subProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentSubPropertyAttackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttacksPackage.Literals.COMPONENT_SUB_PROPERTY_ATTACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentProperty getPropertyToAttack() {
		if (propertyToAttack != null && propertyToAttack.eIsProxy()) {
			InternalEObject oldPropertyToAttack = (InternalEObject)propertyToAttack;
			propertyToAttack = (ComponentProperty)eResolveProxy(oldPropertyToAttack);
			if (propertyToAttack != oldPropertyToAttack) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__PROPERTY_TO_ATTACK, oldPropertyToAttack, propertyToAttack));
			}
		}
		return propertyToAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentProperty basicGetPropertyToAttack() {
		return propertyToAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyToAttack(ComponentProperty newPropertyToAttack) {
		ComponentProperty oldPropertyToAttack = propertyToAttack;
		propertyToAttack = newPropertyToAttack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__PROPERTY_TO_ATTACK, oldPropertyToAttack, propertyToAttack));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getSubProperty() {
		if (subProperty != null && subProperty.eIsProxy()) {
			InternalEObject oldSubProperty = (InternalEObject)subProperty;
			subProperty = (Type)eResolveProxy(oldSubProperty);
			if (subProperty != oldSubProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__SUB_PROPERTY, oldSubProperty, subProperty));
			}
		}
		return subProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetSubProperty() {
		return subProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubProperty(Type newSubProperty) {
		Type oldSubProperty = subProperty;
		subProperty = newSubProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__SUB_PROPERTY, oldSubProperty, subProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__PROPERTY_TO_ATTACK:
				if (resolve) return getPropertyToAttack();
				return basicGetPropertyToAttack();
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__SUB_PROPERTY:
				if (resolve) return getSubProperty();
				return basicGetSubProperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__PROPERTY_TO_ATTACK:
				setPropertyToAttack((ComponentProperty)newValue);
				return;
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__SUB_PROPERTY:
				setSubProperty((Type)newValue);
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
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__PROPERTY_TO_ATTACK:
				setPropertyToAttack((ComponentProperty)null);
				return;
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__SUB_PROPERTY:
				setSubProperty((Type)null);
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
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__PROPERTY_TO_ATTACK:
				return propertyToAttack != null;
			case AttacksPackage.COMPONENT_SUB_PROPERTY_ATTACK__SUB_PROPERTY:
				return subProperty != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentSubPropertyAttackImpl
