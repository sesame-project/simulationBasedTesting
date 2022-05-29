/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ComponentPropertyAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.ComponentProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Property Attack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ComponentPropertyAttackImpl#getPropertyToAttack <em>Property To Attack</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentPropertyAttackImpl extends FuzzTestingAttackImpl implements ComponentPropertyAttack {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentPropertyAttackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttacksPackage.Literals.COMPONENT_PROPERTY_ATTACK;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttacksPackage.COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK, oldPropertyToAttack, propertyToAttack));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK, oldPropertyToAttack, propertyToAttack));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AttacksPackage.COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK:
				if (resolve) return getPropertyToAttack();
				return basicGetPropertyToAttack();
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
			case AttacksPackage.COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK:
				setPropertyToAttack((ComponentProperty)newValue);
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
			case AttacksPackage.COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK:
				setPropertyToAttack((ComponentProperty)null);
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
			case AttacksPackage.COMPONENT_PROPERTY_ATTACK__PROPERTY_TO_ATTACK:
				return propertyToAttack != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentPropertyAttackImpl
