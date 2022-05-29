/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl;

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

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Node;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Simulator;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MRS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSImpl#getTopics <em>Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSImpl#getLaunchFileLocation <em>Launch File Location</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSImpl#getSimulator <em>Simulator</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.MRSImpl#getPropertyType <em>Property Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MRSImpl extends MinimalEObjectImpl.Container implements MRS {
	/**
	 * The cached value of the '{@link #getTopics() <em>Topics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopics()
	 * @generated
	 * @ordered
	 */
	protected EList<Topic> topics;

	/**
	 * The default value of the '{@link #getLaunchFileLocation() <em>Launch File Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchFileLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LAUNCH_FILE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLaunchFileLocation() <em>Launch File Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaunchFileLocation()
	 * @generated
	 * @ordered
	 */
	protected String launchFileLocation = LAUNCH_FILE_LOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getSimulator() <em>Simulator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulator()
	 * @generated
	 * @ordered
	 */
	protected Simulator simulator;

	/**
	 * The cached value of the '{@link #getPropertyType() <em>Property Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyType()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> propertyType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MRSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MRSPackagePackage.Literals.MRS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Topic> getTopics() {
		if (topics == null) {
			topics = new EObjectContainmentEList<Topic>(Topic.class, this, MRSPackagePackage.MRS__TOPICS);
		}
		return topics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLaunchFileLocation() {
		return launchFileLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaunchFileLocation(String newLaunchFileLocation) {
		String oldLaunchFileLocation = launchFileLocation;
		launchFileLocation = newLaunchFileLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MRSPackagePackage.MRS__LAUNCH_FILE_LOCATION, oldLaunchFileLocation, launchFileLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, MRSPackagePackage.MRS__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simulator getSimulator() {
		return simulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimulator(Simulator newSimulator, NotificationChain msgs) {
		Simulator oldSimulator = simulator;
		simulator = newSimulator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MRSPackagePackage.MRS__SIMULATOR, oldSimulator, newSimulator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulator(Simulator newSimulator) {
		if (newSimulator != simulator) {
			NotificationChain msgs = null;
			if (simulator != null)
				msgs = ((InternalEObject)simulator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MRSPackagePackage.MRS__SIMULATOR, null, msgs);
			if (newSimulator != null)
				msgs = ((InternalEObject)newSimulator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MRSPackagePackage.MRS__SIMULATOR, null, msgs);
			msgs = basicSetSimulator(newSimulator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MRSPackagePackage.MRS__SIMULATOR, newSimulator, newSimulator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getPropertyType() {
		if (propertyType == null) {
			propertyType = new EObjectContainmentEList<Type>(Type.class, this, MRSPackagePackage.MRS__PROPERTY_TYPE);
		}
		return propertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MRSPackagePackage.MRS__TOPICS:
				return ((InternalEList<?>)getTopics()).basicRemove(otherEnd, msgs);
			case MRSPackagePackage.MRS__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case MRSPackagePackage.MRS__SIMULATOR:
				return basicSetSimulator(null, msgs);
			case MRSPackagePackage.MRS__PROPERTY_TYPE:
				return ((InternalEList<?>)getPropertyType()).basicRemove(otherEnd, msgs);
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
			case MRSPackagePackage.MRS__TOPICS:
				return getTopics();
			case MRSPackagePackage.MRS__LAUNCH_FILE_LOCATION:
				return getLaunchFileLocation();
			case MRSPackagePackage.MRS__NODES:
				return getNodes();
			case MRSPackagePackage.MRS__SIMULATOR:
				return getSimulator();
			case MRSPackagePackage.MRS__PROPERTY_TYPE:
				return getPropertyType();
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
			case MRSPackagePackage.MRS__TOPICS:
				getTopics().clear();
				getTopics().addAll((Collection<? extends Topic>)newValue);
				return;
			case MRSPackagePackage.MRS__LAUNCH_FILE_LOCATION:
				setLaunchFileLocation((String)newValue);
				return;
			case MRSPackagePackage.MRS__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case MRSPackagePackage.MRS__SIMULATOR:
				setSimulator((Simulator)newValue);
				return;
			case MRSPackagePackage.MRS__PROPERTY_TYPE:
				getPropertyType().clear();
				getPropertyType().addAll((Collection<? extends Type>)newValue);
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
			case MRSPackagePackage.MRS__TOPICS:
				getTopics().clear();
				return;
			case MRSPackagePackage.MRS__LAUNCH_FILE_LOCATION:
				setLaunchFileLocation(LAUNCH_FILE_LOCATION_EDEFAULT);
				return;
			case MRSPackagePackage.MRS__NODES:
				getNodes().clear();
				return;
			case MRSPackagePackage.MRS__SIMULATOR:
				setSimulator((Simulator)null);
				return;
			case MRSPackagePackage.MRS__PROPERTY_TYPE:
				getPropertyType().clear();
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
			case MRSPackagePackage.MRS__TOPICS:
				return topics != null && !topics.isEmpty();
			case MRSPackagePackage.MRS__LAUNCH_FILE_LOCATION:
				return LAUNCH_FILE_LOCATION_EDEFAULT == null ? launchFileLocation != null : !LAUNCH_FILE_LOCATION_EDEFAULT.equals(launchFileLocation);
			case MRSPackagePackage.MRS__NODES:
				return nodes != null && !nodes.isEmpty();
			case MRSPackagePackage.MRS__SIMULATOR:
				return simulator != null;
			case MRSPackagePackage.MRS__PROPERTY_TYPE:
				return propertyType != null && !propertyType.isEmpty();
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
		result.append(" (launchFileLocation: ");
		result.append(launchFileLocation);
		result.append(')');
		return result.toString();
	}

} //MRSImpl
