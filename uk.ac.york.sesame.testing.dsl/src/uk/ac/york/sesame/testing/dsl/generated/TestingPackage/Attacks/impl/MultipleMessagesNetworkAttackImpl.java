/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.MultipleMessagesNetworkAttack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple Messages Network Attack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.MultipleMessagesNetworkAttackImpl#getHowManyClones <em>How Many Clones</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultipleMessagesNetworkAttackImpl extends NetworkAttackImpl implements MultipleMessagesNetworkAttack {
	/**
	 * The default value of the '{@link #getHowManyClones() <em>How Many Clones</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHowManyClones()
	 * @generated
	 * @ordered
	 */
	protected static final int HOW_MANY_CLONES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHowManyClones() <em>How Many Clones</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHowManyClones()
	 * @generated
	 * @ordered
	 */
	protected int howManyClones = HOW_MANY_CLONES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultipleMessagesNetworkAttackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttacksPackage.Literals.MULTIPLE_MESSAGES_NETWORK_ATTACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHowManyClones() {
		return howManyClones;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHowManyClones(int newHowManyClones) {
		int oldHowManyClones = howManyClones;
		howManyClones = newHowManyClones;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.MULTIPLE_MESSAGES_NETWORK_ATTACK__HOW_MANY_CLONES, oldHowManyClones, howManyClones));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AttacksPackage.MULTIPLE_MESSAGES_NETWORK_ATTACK__HOW_MANY_CLONES:
				return getHowManyClones();
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
			case AttacksPackage.MULTIPLE_MESSAGES_NETWORK_ATTACK__HOW_MANY_CLONES:
				setHowManyClones((Integer)newValue);
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
			case AttacksPackage.MULTIPLE_MESSAGES_NETWORK_ATTACK__HOW_MANY_CLONES:
				setHowManyClones(HOW_MANY_CLONES_EDEFAULT);
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
			case AttacksPackage.MULTIPLE_MESSAGES_NETWORK_ATTACK__HOW_MANY_CLONES:
				return howManyClones != HOW_MANY_CLONES_EDEFAULT;
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
		result.append(" (howManyClones: ");
		result.append(howManyClones);
		result.append(')');
		return result.toString();
	}

} //MultipleMessagesNetworkAttackImpl
