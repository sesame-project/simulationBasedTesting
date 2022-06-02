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
import org.eclipse.emf.ecore.util.InternalEList;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.GrammarSpecification;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Testing Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl#getPossibleAttacks <em>Possible Attacks</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl#getGrammarSpecfication <em>Grammar Specfication</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl#getCampaigns <em>Campaigns</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingSpaceImpl#getMrs <em>Mrs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestingSpaceImpl extends MinimalEObjectImpl.Container implements TestingSpace {
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
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;

	/**
	 * The cached value of the '{@link #getPossibleAttacks() <em>Possible Attacks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossibleAttacks()
	 * @generated
	 * @ordered
	 */
	protected EList<Attack> possibleAttacks;

	/**
	 * The cached value of the '{@link #getGrammarSpecfication() <em>Grammar Specfication</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrammarSpecfication()
	 * @generated
	 * @ordered
	 */
	protected GrammarSpecification grammarSpecfication;

	/**
	 * The cached value of the '{@link #getCampaigns() <em>Campaigns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCampaigns()
	 * @generated
	 * @ordered
	 */
	protected EList<TestCampaign> campaigns;

	/**
	 * The cached value of the '{@link #getMrs() <em>Mrs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMrs()
	 * @generated
	 * @ordered
	 */
	protected MRS mrs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestingSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestingPackagePackage.Literals.TESTING_SPACE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TESTING_SPACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getMetrics() {
		if (metrics == null) {
			metrics = new EObjectContainmentEList<Metric>(Metric.class, this, TestingPackagePackage.TESTING_SPACE__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attack> getPossibleAttacks() {
		if (possibleAttacks == null) {
			possibleAttacks = new EObjectContainmentEList<Attack>(Attack.class, this, TestingPackagePackage.TESTING_SPACE__POSSIBLE_ATTACKS);
		}
		return possibleAttacks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrammarSpecification getGrammarSpecfication() {
		return grammarSpecfication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGrammarSpecfication(GrammarSpecification newGrammarSpecfication, NotificationChain msgs) {
		GrammarSpecification oldGrammarSpecfication = grammarSpecfication;
		grammarSpecfication = newGrammarSpecfication;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION, oldGrammarSpecfication, newGrammarSpecfication);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrammarSpecfication(GrammarSpecification newGrammarSpecfication) {
		if (newGrammarSpecfication != grammarSpecfication) {
			NotificationChain msgs = null;
			if (grammarSpecfication != null)
				msgs = ((InternalEObject)grammarSpecfication).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION, null, msgs);
			if (newGrammarSpecfication != null)
				msgs = ((InternalEObject)newGrammarSpecfication).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION, null, msgs);
			msgs = basicSetGrammarSpecfication(newGrammarSpecfication, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION, newGrammarSpecfication, newGrammarSpecfication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestCampaign> getCampaigns() {
		if (campaigns == null) {
			campaigns = new EObjectContainmentEList<TestCampaign>(TestCampaign.class, this, TestingPackagePackage.TESTING_SPACE__CAMPAIGNS);
		}
		return campaigns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MRS getMrs() {
		return mrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMrs(MRS newMrs, NotificationChain msgs) {
		MRS oldMrs = mrs;
		mrs = newMrs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TESTING_SPACE__MRS, oldMrs, newMrs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMrs(MRS newMrs) {
		if (newMrs != mrs) {
			NotificationChain msgs = null;
			if (mrs != null)
				msgs = ((InternalEObject)mrs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestingPackagePackage.TESTING_SPACE__MRS, null, msgs);
			if (newMrs != null)
				msgs = ((InternalEObject)newMrs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestingPackagePackage.TESTING_SPACE__MRS, null, msgs);
			msgs = basicSetMrs(newMrs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.TESTING_SPACE__MRS, newMrs, newMrs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestingPackagePackage.TESTING_SPACE__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
			case TestingPackagePackage.TESTING_SPACE__POSSIBLE_ATTACKS:
				return ((InternalEList<?>)getPossibleAttacks()).basicRemove(otherEnd, msgs);
			case TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION:
				return basicSetGrammarSpecfication(null, msgs);
			case TestingPackagePackage.TESTING_SPACE__CAMPAIGNS:
				return ((InternalEList<?>)getCampaigns()).basicRemove(otherEnd, msgs);
			case TestingPackagePackage.TESTING_SPACE__MRS:
				return basicSetMrs(null, msgs);
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
			case TestingPackagePackage.TESTING_SPACE__NAME:
				return getName();
			case TestingPackagePackage.TESTING_SPACE__METRICS:
				return getMetrics();
			case TestingPackagePackage.TESTING_SPACE__POSSIBLE_ATTACKS:
				return getPossibleAttacks();
			case TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION:
				return getGrammarSpecfication();
			case TestingPackagePackage.TESTING_SPACE__CAMPAIGNS:
				return getCampaigns();
			case TestingPackagePackage.TESTING_SPACE__MRS:
				return getMrs();
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
			case TestingPackagePackage.TESTING_SPACE__NAME:
				setName((String)newValue);
				return;
			case TestingPackagePackage.TESTING_SPACE__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
				return;
			case TestingPackagePackage.TESTING_SPACE__POSSIBLE_ATTACKS:
				getPossibleAttacks().clear();
				getPossibleAttacks().addAll((Collection<? extends Attack>)newValue);
				return;
			case TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION:
				setGrammarSpecfication((GrammarSpecification)newValue);
				return;
			case TestingPackagePackage.TESTING_SPACE__CAMPAIGNS:
				getCampaigns().clear();
				getCampaigns().addAll((Collection<? extends TestCampaign>)newValue);
				return;
			case TestingPackagePackage.TESTING_SPACE__MRS:
				setMrs((MRS)newValue);
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
			case TestingPackagePackage.TESTING_SPACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TestingPackagePackage.TESTING_SPACE__METRICS:
				getMetrics().clear();
				return;
			case TestingPackagePackage.TESTING_SPACE__POSSIBLE_ATTACKS:
				getPossibleAttacks().clear();
				return;
			case TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION:
				setGrammarSpecfication((GrammarSpecification)null);
				return;
			case TestingPackagePackage.TESTING_SPACE__CAMPAIGNS:
				getCampaigns().clear();
				return;
			case TestingPackagePackage.TESTING_SPACE__MRS:
				setMrs((MRS)null);
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
			case TestingPackagePackage.TESTING_SPACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TestingPackagePackage.TESTING_SPACE__METRICS:
				return metrics != null && !metrics.isEmpty();
			case TestingPackagePackage.TESTING_SPACE__POSSIBLE_ATTACKS:
				return possibleAttacks != null && !possibleAttacks.isEmpty();
			case TestingPackagePackage.TESTING_SPACE__GRAMMAR_SPECFICATION:
				return grammarSpecfication != null;
			case TestingPackagePackage.TESTING_SPACE__CAMPAIGNS:
				return campaigns != null && !campaigns.isEmpty();
			case TestingPackagePackage.TESTING_SPACE__MRS:
				return mrs != null;
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

} //TestingSpaceImpl
