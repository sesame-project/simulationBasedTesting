/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.OfflineAttackTime;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Offline Attack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.OfflineAttackImpl#getAttackTime <em>Attack Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OfflineAttackImpl extends AttackImpl implements OfflineAttack {
	/**
	 * The default value of the '{@link #getAttackTime() <em>Attack Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackTime()
	 * @generated
	 * @ordered
	 */
	protected static final OfflineAttackTime ATTACK_TIME_EDEFAULT = OfflineAttackTime.PRE;

	/**
	 * The cached value of the '{@link #getAttackTime() <em>Attack Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackTime()
	 * @generated
	 * @ordered
	 */
	protected OfflineAttackTime attackTime = ATTACK_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OfflineAttackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttacksPackage.Literals.OFFLINE_ATTACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OfflineAttackTime getAttackTime() {
		return attackTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttackTime(OfflineAttackTime newAttackTime) {
		OfflineAttackTime oldAttackTime = attackTime;
		attackTime = newAttackTime == null ? ATTACK_TIME_EDEFAULT : newAttackTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.OFFLINE_ATTACK__ATTACK_TIME, oldAttackTime, attackTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AttacksPackage.OFFLINE_ATTACK__ATTACK_TIME:
				return getAttackTime();
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
			case AttacksPackage.OFFLINE_ATTACK__ATTACK_TIME:
				setAttackTime((OfflineAttackTime)newValue);
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
			case AttacksPackage.OFFLINE_ATTACK__ATTACK_TIME:
				setAttackTime(ATTACK_TIME_EDEFAULT);
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
			case AttacksPackage.OFFLINE_ATTACK__ATTACK_TIME:
				return attackTime != ATTACK_TIME_EDEFAULT;
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
		result.append(" (attackTime: ");
		result.append(attackTime);
		result.append(')');
		return result.toString();
	}

} //OfflineAttackImpl
