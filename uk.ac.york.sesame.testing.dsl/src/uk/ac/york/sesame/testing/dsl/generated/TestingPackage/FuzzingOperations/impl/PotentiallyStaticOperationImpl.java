/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PotentiallyStaticOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.GenericVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Potentially Static Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl.PotentiallyStaticOperationImpl#getActivation <em>Activation</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl.PotentiallyStaticOperationImpl#getVariableToAffect <em>Variable To Affect</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PotentiallyStaticOperationImpl extends FuzzTestingOperationImpl implements PotentiallyStaticOperation {
	/**
	 * The cached value of the '{@link #getActivation() <em>Activation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivation()
	 * @generated
	 * @ordered
	 */
	protected Activation activation;

	/**
	 * The cached value of the '{@link #getVariableToAffect() <em>Variable To Affect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableToAffect()
	 * @generated
	 * @ordered
	 */
	protected GenericVariable variableToAffect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PotentiallyStaticOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FuzzingOperationsPackage.Literals.POTENTIALLY_STATIC_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activation getActivation() {
		return activation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActivation(Activation newActivation, NotificationChain msgs) {
		Activation oldActivation = activation;
		activation = newActivation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION, oldActivation, newActivation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivation(Activation newActivation) {
		if (newActivation != activation) {
			NotificationChain msgs = null;
			if (activation != null)
				msgs = ((InternalEObject)activation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION, null, msgs);
			if (newActivation != null)
				msgs = ((InternalEObject)newActivation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION, null, msgs);
			msgs = basicSetActivation(newActivation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION, newActivation, newActivation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericVariable getVariableToAffect() {
		if (variableToAffect != null && variableToAffect.eIsProxy()) {
			InternalEObject oldVariableToAffect = (InternalEObject)variableToAffect;
			variableToAffect = (GenericVariable)eResolveProxy(oldVariableToAffect);
			if (variableToAffect != oldVariableToAffect) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__VARIABLE_TO_AFFECT, oldVariableToAffect, variableToAffect));
			}
		}
		return variableToAffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericVariable basicGetVariableToAffect() {
		return variableToAffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableToAffect(GenericVariable newVariableToAffect) {
		GenericVariable oldVariableToAffect = variableToAffect;
		variableToAffect = newVariableToAffect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__VARIABLE_TO_AFFECT, oldVariableToAffect, variableToAffect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION:
				return basicSetActivation(null, msgs);
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
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION:
				return getActivation();
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__VARIABLE_TO_AFFECT:
				if (resolve) return getVariableToAffect();
				return basicGetVariableToAffect();
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
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION:
				setActivation((Activation)newValue);
				return;
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__VARIABLE_TO_AFFECT:
				setVariableToAffect((GenericVariable)newValue);
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
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION:
				setActivation((Activation)null);
				return;
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__VARIABLE_TO_AFFECT:
				setVariableToAffect((GenericVariable)null);
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
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__ACTIVATION:
				return activation != null;
			case FuzzingOperationsPackage.POTENTIALLY_STATIC_OPERATION__VARIABLE_TO_AFFECT:
				return variableToAffect != null;
		}
		return super.eIsSet(featureID);
	}

} //PotentiallyStaticOperationImpl
