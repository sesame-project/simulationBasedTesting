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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarConstraint;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestGenerationApproach;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Campaign</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl#getIncludedAttacks <em>Included Attacks</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl#getApproach <em>Approach</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestCampaignImpl#getPerformedTests <em>Performed Tests</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestCampaignImpl extends MinimalEObjectImpl.Container implements TestCampaign {
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
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;

	/**
	 * The cached value of the '{@link #getIncludedAttacks() <em>Included Attacks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedAttacks()
	 * @generated
	 * @ordered
	 */
	protected EList<Attack> includedAttacks;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<GrammarConstraint> constraints;

	/**
	 * The cached value of the '{@link #getApproach() <em>Approach</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApproach()
	 * @generated
	 * @ordered
	 */
	protected TestGenerationApproach approach;

	/**
	 * The cached value of the '{@link #getPerformedTests() <em>Performed Tests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformedTests()
	 * @generated
	 * @ordered
	 */
	protected EList<Test> performedTests;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCampaignImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestingPackagePackage.Literals.TEST_CAMPAIGN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TEST_CAMPAIGN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectResolvingEList<Metric>(Metric.class, this, TestingPackagePackage.TEST_CAMPAIGN__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attack> getIncludedAttacks() {
		if (includedAttacks == null) {
			includedAttacks = new EObjectResolvingEList<Attack>(Attack.class, this, TestingPackagePackage.TEST_CAMPAIGN__INCLUDED_ATTACKS);
		}
		return includedAttacks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GrammarConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<GrammarConstraint>(GrammarConstraint.class, this, TestingPackagePackage.TEST_CAMPAIGN__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestGenerationApproach getApproach() {
		return approach;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApproach(TestGenerationApproach newApproach, NotificationChain msgs) {
		TestGenerationApproach oldApproach = approach;
		approach = newApproach;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TEST_CAMPAIGN__APPROACH, oldApproach, newApproach);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApproach(TestGenerationApproach newApproach) {
		if (newApproach != approach) {
			NotificationChain msgs = null;
			if (approach != null)
				msgs = ((InternalEObject)approach).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestingPackagePackage.TEST_CAMPAIGN__APPROACH, null, msgs);
			if (newApproach != null)
				msgs = ((InternalEObject)newApproach).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestingPackagePackage.TEST_CAMPAIGN__APPROACH, null, msgs);
			msgs = basicSetApproach(newApproach, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TEST_CAMPAIGN__APPROACH, newApproach, newApproach));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Test> getPerformedTests() {
		if (performedTests == null) {
			performedTests = new EObjectContainmentEList<Test>(Test.class, this, TestingPackagePackage.TEST_CAMPAIGN__PERFORMED_TESTS);
		}
		return performedTests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestingPackagePackage.TEST_CAMPAIGN__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case TestingPackagePackage.TEST_CAMPAIGN__APPROACH:
				return basicSetApproach(null, msgs);
			case TestingPackagePackage.TEST_CAMPAIGN__PERFORMED_TESTS:
				return ((InternalEList<?>)getPerformedTests()).basicRemove(otherEnd, msgs);
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
			case TestingPackagePackage.TEST_CAMPAIGN__NAME:
				return getName();
			case TestingPackagePackage.TEST_CAMPAIGN__METRICS:
				return getMetrics();
			case TestingPackagePackage.TEST_CAMPAIGN__INCLUDED_ATTACKS:
				return getIncludedAttacks();
			case TestingPackagePackage.TEST_CAMPAIGN__CONSTRAINTS:
				return getConstraints();
			case TestingPackagePackage.TEST_CAMPAIGN__APPROACH:
				return getApproach();
			case TestingPackagePackage.TEST_CAMPAIGN__PERFORMED_TESTS:
				return getPerformedTests();
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
			case TestingPackagePackage.TEST_CAMPAIGN__NAME:
				setName((String)newValue);
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__INCLUDED_ATTACKS:
				getIncludedAttacks().clear();
				getIncludedAttacks().addAll((Collection<? extends Attack>)newValue);
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends GrammarConstraint>)newValue);
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__APPROACH:
				setApproach((TestGenerationApproach)newValue);
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__PERFORMED_TESTS:
				getPerformedTests().clear();
				getPerformedTests().addAll((Collection<? extends Test>)newValue);
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
			case TestingPackagePackage.TEST_CAMPAIGN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__METRICS:
				getMetrics().clear();
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__INCLUDED_ATTACKS:
				getIncludedAttacks().clear();
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__CONSTRAINTS:
				getConstraints().clear();
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__APPROACH:
				setApproach((TestGenerationApproach)null);
				return;
			case TestingPackagePackage.TEST_CAMPAIGN__PERFORMED_TESTS:
				getPerformedTests().clear();
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
			case TestingPackagePackage.TEST_CAMPAIGN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TestingPackagePackage.TEST_CAMPAIGN__METRICS:
				return metrics != null && !metrics.isEmpty();
			case TestingPackagePackage.TEST_CAMPAIGN__INCLUDED_ATTACKS:
				return includedAttacks != null && !includedAttacks.isEmpty();
			case TestingPackagePackage.TEST_CAMPAIGN__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case TestingPackagePackage.TEST_CAMPAIGN__APPROACH:
				return approach != null;
			case TestingPackagePackage.TEST_CAMPAIGN__PERFORMED_TESTS:
				return performedTests != null && !performedTests.isEmpty();
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

} //TestCampaignImpl
