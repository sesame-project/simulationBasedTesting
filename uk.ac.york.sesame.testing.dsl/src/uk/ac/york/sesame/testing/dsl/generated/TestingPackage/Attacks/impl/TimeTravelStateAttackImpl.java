/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange;
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
	 * The cached value of the '{@link #getTimeTravelValue() <em>Time Travel Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeTravelValue()
	 * @generated
	 * @ordered
	 */
	protected DoubleRange timeTravelValue;

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
	public DoubleRange getTimeTravelValue() {
		return timeTravelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeTravelValue(DoubleRange newTimeTravelValue, NotificationChain msgs) {
		DoubleRange oldTimeTravelValue = timeTravelValue;
		timeTravelValue = newTimeTravelValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE, oldTimeTravelValue, newTimeTravelValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeTravelValue(DoubleRange newTimeTravelValue) {
		if (newTimeTravelValue != timeTravelValue) {
			NotificationChain msgs = null;
			if (timeTravelValue != null)
				msgs = ((InternalEObject)timeTravelValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE, null, msgs);
			if (newTimeTravelValue != null)
				msgs = ((InternalEObject)newTimeTravelValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE, null, msgs);
			msgs = basicSetTimeTravelValue(newTimeTravelValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE, newTimeTravelValue, newTimeTravelValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AttacksPackage.TIME_TRAVEL_STATE_ATTACK__TIME_TRAVEL_VALUE:
				return basicSetTimeTravelValue(null, msgs);
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
				setTimeTravelValue((DoubleRange)newValue);
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
				setTimeTravelValue((DoubleRange)null);
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
				return timeTravelValue != null;
		}
		return super.eIsSet(featureID);
	}

} //TimeTravelStateAttackImpl
