/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricStateKeyedBy;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricImpl#getDir <em>Dir</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricImpl#getKeyedBy <em>Keyed By</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.MetricImpl#getRelatedTopics <em>Related Topics</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MetricImpl extends MinimalEObjectImpl.Container implements Metric {
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
	 * The default value of the '{@link #getDir() <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDir()
	 * @generated
	 * @ordered
	 */
	protected static final MetricOptimisationDirection DIR_EDEFAULT = MetricOptimisationDirection.HIGHEST;

	/**
	 * The cached value of the '{@link #getDir() <em>Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDir()
	 * @generated
	 * @ordered
	 */
	protected MetricOptimisationDirection dir = DIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyedBy() <em>Keyed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyedBy()
	 * @generated
	 * @ordered
	 */
	protected static final MetricStateKeyedBy KEYED_BY_EDEFAULT = MetricStateKeyedBy.TEST;

	/**
	 * The cached value of the '{@link #getKeyedBy() <em>Keyed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyedBy()
	 * @generated
	 * @ordered
	 */
	protected MetricStateKeyedBy keyedBy = KEYED_BY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRelatedTopics() <em>Related Topics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedTopics()
	 * @generated
	 * @ordered
	 */
	protected EList<Topic> relatedTopics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricOptimisationDirection getDir() {
		return dir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDir(MetricOptimisationDirection newDir) {
		MetricOptimisationDirection oldDir = dir;
		dir = newDir == null ? DIR_EDEFAULT : newDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__DIR, oldDir, dir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricStateKeyedBy getKeyedBy() {
		return keyedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyedBy(MetricStateKeyedBy newKeyedBy) {
		MetricStateKeyedBy oldKeyedBy = keyedBy;
		keyedBy = newKeyedBy == null ? KEYED_BY_EDEFAULT : newKeyedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.METRIC__KEYED_BY, oldKeyedBy, keyedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Topic> getRelatedTopics() {
		if (relatedTopics == null) {
			relatedTopics = new EObjectResolvingEList<Topic>(Topic.class, this, MetricsPackage.METRIC__RELATED_TOPICS);
		}
		return relatedTopics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.METRIC__NAME:
				return getName();
			case MetricsPackage.METRIC__DIR:
				return getDir();
			case MetricsPackage.METRIC__KEYED_BY:
				return getKeyedBy();
			case MetricsPackage.METRIC__RELATED_TOPICS:
				return getRelatedTopics();
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
			case MetricsPackage.METRIC__NAME:
				setName((String)newValue);
				return;
			case MetricsPackage.METRIC__DIR:
				setDir((MetricOptimisationDirection)newValue);
				return;
			case MetricsPackage.METRIC__KEYED_BY:
				setKeyedBy((MetricStateKeyedBy)newValue);
				return;
			case MetricsPackage.METRIC__RELATED_TOPICS:
				getRelatedTopics().clear();
				getRelatedTopics().addAll((Collection<? extends Topic>)newValue);
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
			case MetricsPackage.METRIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetricsPackage.METRIC__DIR:
				setDir(DIR_EDEFAULT);
				return;
			case MetricsPackage.METRIC__KEYED_BY:
				setKeyedBy(KEYED_BY_EDEFAULT);
				return;
			case MetricsPackage.METRIC__RELATED_TOPICS:
				getRelatedTopics().clear();
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
			case MetricsPackage.METRIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetricsPackage.METRIC__DIR:
				return dir != DIR_EDEFAULT;
			case MetricsPackage.METRIC__KEYED_BY:
				return keyedBy != KEYED_BY_EDEFAULT;
			case MetricsPackage.METRIC__RELATED_TOPICS:
				return relatedTopics != null && !relatedTopics.isEmpty();
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
		result.append(", dir: ");
		result.append(dir);
		result.append(", keyedBy: ");
		result.append(keyedBy);
		result.append(')');
		return result.toString();
	}

} //MetricImpl
