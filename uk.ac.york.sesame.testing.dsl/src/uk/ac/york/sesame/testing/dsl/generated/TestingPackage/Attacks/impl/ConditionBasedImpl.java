/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ConditionBased;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Condition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Based</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ConditionBasedImpl#getStarting <em>Starting</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.ConditionBasedImpl#getEnding <em>Ending</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionBasedImpl extends AttackActivationImpl implements ConditionBased {
	/**
	 * The cached value of the '{@link #getStarting() <em>Starting</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarting()
	 * @generated
	 * @ordered
	 */
	protected Condition starting;
	/**
	 * The cached value of the '{@link #getEnding() <em>Ending</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnding()
	 * @generated
	 * @ordered
	 */
	protected Condition ending;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionBasedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttacksPackage.Literals.CONDITION_BASED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getStarting() {
		return starting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStarting(Condition newStarting, NotificationChain msgs) {
		Condition oldStarting = starting;
		starting = newStarting;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AttacksPackage.CONDITION_BASED__STARTING, oldStarting, newStarting);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarting(Condition newStarting) {
		if (newStarting != starting) {
			NotificationChain msgs = null;
			if (starting != null)
				msgs = ((InternalEObject)starting).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AttacksPackage.CONDITION_BASED__STARTING, null, msgs);
			if (newStarting != null)
				msgs = ((InternalEObject)newStarting).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AttacksPackage.CONDITION_BASED__STARTING, null, msgs);
			msgs = basicSetStarting(newStarting, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.CONDITION_BASED__STARTING, newStarting, newStarting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getEnding() {
		return ending;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnding(Condition newEnding, NotificationChain msgs) {
		Condition oldEnding = ending;
		ending = newEnding;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AttacksPackage.CONDITION_BASED__ENDING, oldEnding, newEnding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnding(Condition newEnding) {
		if (newEnding != ending) {
			NotificationChain msgs = null;
			if (ending != null)
				msgs = ((InternalEObject)ending).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AttacksPackage.CONDITION_BASED__ENDING, null, msgs);
			if (newEnding != null)
				msgs = ((InternalEObject)newEnding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AttacksPackage.CONDITION_BASED__ENDING, null, msgs);
			msgs = basicSetEnding(newEnding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.CONDITION_BASED__ENDING, newEnding, newEnding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AttacksPackage.CONDITION_BASED__STARTING:
				return basicSetStarting(null, msgs);
			case AttacksPackage.CONDITION_BASED__ENDING:
				return basicSetEnding(null, msgs);
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
			case AttacksPackage.CONDITION_BASED__STARTING:
				return getStarting();
			case AttacksPackage.CONDITION_BASED__ENDING:
				return getEnding();
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
			case AttacksPackage.CONDITION_BASED__STARTING:
				setStarting((Condition)newValue);
				return;
			case AttacksPackage.CONDITION_BASED__ENDING:
				setEnding((Condition)newValue);
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
			case AttacksPackage.CONDITION_BASED__STARTING:
				setStarting((Condition)null);
				return;
			case AttacksPackage.CONDITION_BASED__ENDING:
				setEnding((Condition)null);
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
			case AttacksPackage.CONDITION_BASED__STARTING:
				return starting != null;
			case AttacksPackage.CONDITION_BASED__ENDING:
				return ending != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionBasedImpl
