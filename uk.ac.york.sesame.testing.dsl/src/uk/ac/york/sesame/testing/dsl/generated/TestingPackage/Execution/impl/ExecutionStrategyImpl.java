/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionStrategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.impl.ExecutionStrategyImpl#getExptRunnerIP <em>Expt Runner IP</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ExecutionStrategyImpl extends MinimalEObjectImpl.Container implements ExecutionStrategy {
	/**
	 * The default value of the '{@link #getExptRunnerIP() <em>Expt Runner IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExptRunnerIP()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPT_RUNNER_IP_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExptRunnerIP() <em>Expt Runner IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExptRunnerIP()
	 * @generated
	 * @ordered
	 */
	protected String exptRunnerIP = EXPT_RUNNER_IP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.EXECUTION_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExptRunnerIP() {
		return exptRunnerIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExptRunnerIP(String newExptRunnerIP) {
		String oldExptRunnerIP = exptRunnerIP;
		exptRunnerIP = newExptRunnerIP;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.EXECUTION_STRATEGY__EXPT_RUNNER_IP, oldExptRunnerIP, exptRunnerIP));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistributed() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionPackage.EXECUTION_STRATEGY__EXPT_RUNNER_IP:
				return getExptRunnerIP();
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
			case ExecutionPackage.EXECUTION_STRATEGY__EXPT_RUNNER_IP:
				setExptRunnerIP((String)newValue);
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
			case ExecutionPackage.EXECUTION_STRATEGY__EXPT_RUNNER_IP:
				setExptRunnerIP(EXPT_RUNNER_IP_EDEFAULT);
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
			case ExecutionPackage.EXECUTION_STRATEGY__EXPT_RUNNER_IP:
				return EXPT_RUNNER_IP_EDEFAULT == null ? exptRunnerIP != null : !EXPT_RUNNER_IP_EDEFAULT.equals(exptRunnerIP);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ExecutionPackage.EXECUTION_STRATEGY___IS_DISTRIBUTED:
				return isDistributed();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (exptRunnerIP: ");
		result.append(exptRunnerIP);
		result.append(')');
		return result.toString();
	}

} //ExecutionStrategyImpl
