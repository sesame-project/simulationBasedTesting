/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.LoadResourceOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.LoadType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Resource Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl.LoadResourceOperationImpl#getLoadType <em>Load Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadResourceOperationImpl extends ResourceFuzzingOperationImpl implements LoadResourceOperation {
	/**
	 * The cached value of the '{@link #getLoadType() <em>Load Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadType()
	 * @generated
	 * @ordered
	 */
	protected LoadType loadType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadResourceOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FuzzingOperationsPackage.Literals.LOAD_RESOURCE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadType getLoadType() {
		if (loadType != null && loadType.eIsProxy()) {
			InternalEObject oldLoadType = (InternalEObject)loadType;
			loadType = (LoadType)eResolveProxy(oldLoadType);
			if (loadType != oldLoadType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FuzzingOperationsPackage.LOAD_RESOURCE_OPERATION__LOAD_TYPE, oldLoadType, loadType));
			}
		}
		return loadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadType basicGetLoadType() {
		return loadType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoadType(LoadType newLoadType) {
		LoadType oldLoadType = loadType;
		loadType = newLoadType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FuzzingOperationsPackage.LOAD_RESOURCE_OPERATION__LOAD_TYPE, oldLoadType, loadType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FuzzingOperationsPackage.LOAD_RESOURCE_OPERATION__LOAD_TYPE:
				if (resolve) return getLoadType();
				return basicGetLoadType();
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
			case FuzzingOperationsPackage.LOAD_RESOURCE_OPERATION__LOAD_TYPE:
				setLoadType((LoadType)newValue);
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
			case FuzzingOperationsPackage.LOAD_RESOURCE_OPERATION__LOAD_TYPE:
				setLoadType((LoadType)null);
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
			case FuzzingOperationsPackage.LOAD_RESOURCE_OPERATION__LOAD_TYPE:
				return loadType != null;
		}
		return super.eIsSet(featureID);
	}

} //LoadResourceOperationImpl
