/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TimeTravelStateAttack;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Travel State Attack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TimeTravelStateAttackImpl#getTimeTravelValue <em>Time Travel Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeTravelStateAttackImpl extends StateAttackImpl implements TimeTravelStateAttack {
	/**
	 * The default value of the '{@link #getTimeTravelValue() <em>Time Travel Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeTravelValue()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_TRAVEL_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimeTravelValue() <em>Time Travel Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeTravelValue()
	 * @generated
	 * @ordered
	 */
	protected int timeTravelValue = TIME_TRAVEL_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeTravelStateAttackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttacksPackage.Literals.TIME_TRAVEL_STATE_ATTACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeTravelValue() {
		return timeTravelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeTravelValue(int newTimeTravelValue) {
		int oldTimeTravelValue = timeTravelValue;
		timeTravelValue = newTimeTravelValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE, oldTimeTravelValue, timeTravelValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE:
				return getTimeTravelValue();
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
			case AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE:
				setTimeTravelValue((Integer)newValue);
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
			case AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE:
				setTimeTravelValue(TIME_TRAVEL_VALUE_EDEFAULT);
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
			case AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE:
				return timeTravelValue != TIME_TRAVEL_VALUE_EDEFAULT;
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
		result.append(" (timeTravelValue: ");
		result.append(timeTravelValue);
		result.append(')');
		return result.toString();
	}

} //TimeTravelStateAttackImpl
