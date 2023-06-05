/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.DimensionCountRecord;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.DimensionID;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension Count Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.DimensionCountRecordImpl#getDimID <em>Dim ID</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.DimensionCountRecordImpl#getCount <em>Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DimensionCountRecordImpl extends MinimalEObjectImpl.Container implements DimensionCountRecord {
	/**
	 * The default value of the '{@link #getDimID() <em>Dim ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimID()
	 * @generated
	 * @ordered
	 */
	protected static final DimensionID DIM_ID_EDEFAULT = DimensionID.T1_TIME_MIDPOINT_MEAN;

	/**
	 * The cached value of the '{@link #getDimID() <em>Dim ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimID()
	 * @generated
	 * @ordered
	 */
	protected DimensionID dimID = DIM_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected int count = COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DimensionCountRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestingPackagePackage.Literals.DIMENSION_COUNT_RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DimensionID getDimID() {
		return dimID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimID(DimensionID newDimID) {
		DimensionID oldDimID = dimID;
		dimID = newDimID == null ? DIM_ID_EDEFAULT : newDimID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.DIMENSION_COUNT_RECORD__DIM_ID, oldDimID, dimID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(int newCount) {
		int oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.DIMENSION_COUNT_RECORD__COUNT, oldCount, count));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestingPackagePackage.DIMENSION_COUNT_RECORD__DIM_ID:
				return getDimID();
			case TestingPackagePackage.DIMENSION_COUNT_RECORD__COUNT:
				return getCount();
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
			case TestingPackagePackage.DIMENSION_COUNT_RECORD__DIM_ID:
				setDimID((DimensionID)newValue);
				return;
			case TestingPackagePackage.DIMENSION_COUNT_RECORD__COUNT:
				setCount((Integer)newValue);
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
			case TestingPackagePackage.DIMENSION_COUNT_RECORD__DIM_ID:
				setDimID(DIM_ID_EDEFAULT);
				return;
			case TestingPackagePackage.DIMENSION_COUNT_RECORD__COUNT:
				setCount(COUNT_EDEFAULT);
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
			case TestingPackagePackage.DIMENSION_COUNT_RECORD__DIM_ID:
				return dimID != DIM_ID_EDEFAULT;
			case TestingPackagePackage.DIMENSION_COUNT_RECORD__COUNT:
				return count != COUNT_EDEFAULT;
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
		result.append(" (dimID: ");
		result.append(dimID);
		result.append(", count: ");
		result.append(count);
		result.append(')');
		return result.toString();
	}

} //DimensionCountRecordImpl
