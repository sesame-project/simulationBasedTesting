/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.TopicMetric;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topic Metric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.impl.TopicMetricImpl#getChosenTopics <em>Chosen Topics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopicMetricImpl extends MetricImpl implements TopicMetric {
	/**
	 * The cached value of the '{@link #getChosenTopics() <em>Chosen Topics</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenTopics()
	 * @generated
	 * @ordered
	 */
	protected Topic chosenTopics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopicMetricImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.TOPIC_METRIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Topic getChosenTopics() {
		if (chosenTopics != null && chosenTopics.eIsProxy()) {
			InternalEObject oldChosenTopics = (InternalEObject)chosenTopics;
			chosenTopics = (Topic)eResolveProxy(oldChosenTopics);
			if (chosenTopics != oldChosenTopics) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetricsPackage.TOPIC_METRIC__CHOSEN_TOPICS, oldChosenTopics, chosenTopics));
			}
		}
		return chosenTopics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Topic basicGetChosenTopics() {
		return chosenTopics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenTopics(Topic newChosenTopics) {
		Topic oldChosenTopics = chosenTopics;
		chosenTopics = newChosenTopics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.TOPIC_METRIC__CHOSEN_TOPICS, oldChosenTopics, chosenTopics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.TOPIC_METRIC__CHOSEN_TOPICS:
				if (resolve) return getChosenTopics();
				return basicGetChosenTopics();
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
			case MetricsPackage.TOPIC_METRIC__CHOSEN_TOPICS:
				setChosenTopics((Topic)newValue);
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
			case MetricsPackage.TOPIC_METRIC__CHOSEN_TOPICS:
				setChosenTopics((Topic)null);
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
			case MetricsPackage.TOPIC_METRIC__CHOSEN_TOPICS:
				return chosenTopics != null;
		}
		return super.eIsSet(featureID);
	}

} //TopicMetricImpl
