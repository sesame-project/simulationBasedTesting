/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ExecutionEndTrigger;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsPackage;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl#getEndTrigger <em>End Trigger</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl#getDevelopedFrom <em>Developed From</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl#getParentCampaign <em>Parent Campaign</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestImpl extends MinimalEObjectImpl.Container implements Test {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<FuzzingOperation> operations;

	/**
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricInstance> metrics;

	/**
	 * The cached value of the '{@link #getEndTrigger() <em>End Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTrigger()
	 * @generated
	 * @ordered
	 */
	protected ExecutionEndTrigger endTrigger;

	/**
	 * The cached value of the '{@link #getDevelopedFrom() <em>Developed From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevelopedFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<Test> developedFrom;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestingPackagePackage.Literals.TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TEST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FuzzingOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentWithInverseEList<FuzzingOperation>(FuzzingOperation.class, this, TestingPackagePackage.TEST__OPERATIONS, FuzzingOperationsPackage.FUZZING_OPERATION__CONTAINING_TEST);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MetricInstance> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectContainmentEList<MetricInstance>(MetricInstance.class, this, TestingPackagePackage.TEST__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionEndTrigger getEndTrigger() {
		return endTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndTrigger(ExecutionEndTrigger newEndTrigger, NotificationChain msgs) {
		ExecutionEndTrigger oldEndTrigger = endTrigger;
		endTrigger = newEndTrigger;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TEST__END_TRIGGER, oldEndTrigger, newEndTrigger);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTrigger(ExecutionEndTrigger newEndTrigger) {
		if (newEndTrigger != endTrigger) {
			NotificationChain msgs = null;
			if (endTrigger != null)
				msgs = ((InternalEObject)endTrigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestingPackagePackage.TEST__END_TRIGGER, null, msgs);
			if (newEndTrigger != null)
				msgs = ((InternalEObject)newEndTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestingPackagePackage.TEST__END_TRIGGER, null, msgs);
			msgs = basicSetEndTrigger(newEndTrigger, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TEST__END_TRIGGER, newEndTrigger, newEndTrigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Test> getDevelopedFrom() {
		if (developedFrom == null) {
			developedFrom = new EObjectResolvingEList<Test>(Test.class, this, TestingPackagePackage.TEST__DEVELOPED_FROM);
		}
		return developedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCampaign getParentCampaign() {
		if (eContainerFeatureID() != TestingPackagePackage.TEST__PARENT_CAMPAIGN) return null;
		return (TestCampaign)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestingPackagePackage.TEST__OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
			case TestingPackagePackage.TEST__PARENT_CAMPAIGN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, TestingPackagePackage.TEST__PARENT_CAMPAIGN, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestingPackagePackage.TEST__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case TestingPackagePackage.TEST__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
			case TestingPackagePackage.TEST__END_TRIGGER:
				return basicSetEndTrigger(null, msgs);
			case TestingPackagePackage.TEST__PARENT_CAMPAIGN:
				return eBasicSetContainer(null, TestingPackagePackage.TEST__PARENT_CAMPAIGN, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TestingPackagePackage.TEST__PARENT_CAMPAIGN:
				return eInternalContainer().eInverseRemove(this, TestingPackagePackage.TEST_CAMPAIGN__PERFORMED_TESTS, TestCampaign.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestingPackagePackage.TEST__NAME:
				return getName();
			case TestingPackagePackage.TEST__OPERATIONS:
				return getOperations();
			case TestingPackagePackage.TEST__METRICS:
				return getMetrics();
			case TestingPackagePackage.TEST__END_TRIGGER:
				return getEndTrigger();
			case TestingPackagePackage.TEST__DEVELOPED_FROM:
				return getDevelopedFrom();
			case TestingPackagePackage.TEST__PARENT_CAMPAIGN:
				return getParentCampaign();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestingPackagePackage.TEST__NAME:
				setName((String)newValue);
				return;
			case TestingPackagePackage.TEST__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends FuzzingOperation>)newValue);
				return;
			case TestingPackagePackage.TEST__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends MetricInstance>)newValue);
				return;
			case TestingPackagePackage.TEST__END_TRIGGER:
				setEndTrigger((ExecutionEndTrigger)newValue);
				return;
			case TestingPackagePackage.TEST__DEVELOPED_FROM:
				getDevelopedFrom().clear();
				getDevelopedFrom().addAll((Collection<? extends Test>)newValue);
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
			case TestingPackagePackage.TEST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TestingPackagePackage.TEST__OPERATIONS:
				getOperations().clear();
				return;
			case TestingPackagePackage.TEST__METRICS:
				getMetrics().clear();
				return;
			case TestingPackagePackage.TEST__END_TRIGGER:
				setEndTrigger((ExecutionEndTrigger)null);
				return;
			case TestingPackagePackage.TEST__DEVELOPED_FROM:
				getDevelopedFrom().clear();
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
			case TestingPackagePackage.TEST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TestingPackagePackage.TEST__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case TestingPackagePackage.TEST__METRICS:
				return metrics != null && !metrics.isEmpty();
			case TestingPackagePackage.TEST__END_TRIGGER:
				return endTrigger != null;
			case TestingPackagePackage.TEST__DEVELOPED_FROM:
				return developedFrom != null && !developedFrom.isEmpty();
			case TestingPackagePackage.TEST__PARENT_CAMPAIGN:
				return getParentCampaign() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TestImpl
