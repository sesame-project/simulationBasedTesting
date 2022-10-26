/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl;

import java.util.Random;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import uk.ac.york.sesame.testing.architecture.utilities.RandomFunctions;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ReductionStrategy;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DoubleRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Point;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PointRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ValueSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Point Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl.PointRangeImpl#getMinPoint <em>Min Point</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.impl.PointRangeImpl#getMaxPoint <em>Max Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PointRangeImpl extends ValueRangeImpl implements PointRange {
	/**
	 * The cached value of the '{@link #getMinPoint() <em>Min Point</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinPoint()
	 * @generated
	 * @ordered
	 */
	protected Point minPoint;

	/**
	 * The cached value of the '{@link #getMaxPoint() <em>Max Point</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxPoint()
	 * @generated
	 * @ordered
	 */
	protected Point maxPoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PointRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FuzzingOperationsPackage.Literals.POINT_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getMinPoint() {
		return minPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinPoint(Point newMinPoint, NotificationChain msgs) {
		Point oldMinPoint = minPoint;
		minPoint = newMinPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FuzzingOperationsPackage.POINT_RANGE__MIN_POINT, oldMinPoint, newMinPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinPoint(Point newMinPoint) {
		if (newMinPoint != minPoint) {
			NotificationChain msgs = null;
			if (minPoint != null)
				msgs = ((InternalEObject)minPoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FuzzingOperationsPackage.POINT_RANGE__MIN_POINT, null, msgs);
			if (newMinPoint != null)
				msgs = ((InternalEObject)newMinPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FuzzingOperationsPackage.POINT_RANGE__MIN_POINT, null, msgs);
			msgs = basicSetMinPoint(newMinPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FuzzingOperationsPackage.POINT_RANGE__MIN_POINT, newMinPoint, newMinPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getMaxPoint() {
		return maxPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxPoint(Point newMaxPoint, NotificationChain msgs) {
		Point oldMaxPoint = maxPoint;
		maxPoint = newMaxPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FuzzingOperationsPackage.POINT_RANGE__MAX_POINT, oldMaxPoint, newMaxPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxPoint(Point newMaxPoint) {
		if (newMaxPoint != maxPoint) {
			NotificationChain msgs = null;
			if (maxPoint != null)
				msgs = ((InternalEObject)maxPoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FuzzingOperationsPackage.POINT_RANGE__MAX_POINT, null, msgs);
			if (newMaxPoint != null)
				msgs = ((InternalEObject)newMaxPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FuzzingOperationsPackage.POINT_RANGE__MAX_POINT, null, msgs);
			msgs = basicSetMaxPoint(newMaxPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FuzzingOperationsPackage.POINT_RANGE__MAX_POINT, newMaxPoint, newMaxPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FuzzingOperationsPackage.POINT_RANGE__MIN_POINT:
				return basicSetMinPoint(null, msgs);
			case FuzzingOperationsPackage.POINT_RANGE__MAX_POINT:
				return basicSetMaxPoint(null, msgs);
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
			case FuzzingOperationsPackage.POINT_RANGE__MIN_POINT:
				return getMinPoint();
			case FuzzingOperationsPackage.POINT_RANGE__MAX_POINT:
				return getMaxPoint();
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
			case FuzzingOperationsPackage.POINT_RANGE__MIN_POINT:
				setMinPoint((Point)newValue);
				return;
			case FuzzingOperationsPackage.POINT_RANGE__MAX_POINT:
				setMaxPoint((Point)newValue);
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
			case FuzzingOperationsPackage.POINT_RANGE__MIN_POINT:
				setMinPoint((Point)null);
				return;
			case FuzzingOperationsPackage.POINT_RANGE__MAX_POINT:
				setMaxPoint((Point)null);
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
			case FuzzingOperationsPackage.POINT_RANGE__MIN_POINT:
				return minPoint != null;
			case FuzzingOperationsPackage.POINT_RANGE__MAX_POINT:
				return maxPoint != null;
		}
		return super.eIsSet(featureID);
	}
	
	// CUSTOM FOR PointRange
	
	public Point randomPointInRange(Random rng, Point origLB, Point origUB) {
		FuzzingOperationsFactory af = FuzzingOperationsFactory.eINSTANCE;
		Point newPoint = af.createPoint();
		double x = RandomFunctions.randomDoubleInRange(rng, origLB.getX(), origUB.getX());
		double y = RandomFunctions.randomDoubleInRange(rng, origLB.getY(), origUB.getY());
		double z = RandomFunctions.randomDoubleInRange(rng, origLB.getZ(), origUB.getZ());
		newPoint.setX(x);
		newPoint.setY(y);
		newPoint.setZ(z);
		return newPoint;
	}

	@Override
	public ValueSet reduce(Random rng, ReductionStrategy rs) {
		// TODO: check the reduction strategy - this assumes it is 
		// applied 
		PointRange pr = new PointRangeImpl();
		super.reduce(rng, rs);
		Point origLB = this.getMinPoint();
		Point origUB = this.getMaxPoint();
		Point lp = randomPointInRange(rng, origLB, origUB);
		Point up = EcoreUtil.copy(lp);	
		pr.setMinPoint(lp);
		pr.setMaxPoint(up);
		return pr;
	}

} //PointRangeImpl
