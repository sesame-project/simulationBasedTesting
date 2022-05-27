/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

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
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getAttackActivation <em>Attack Activation</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#isMessagesFromAllComponenents <em>Messages From All Componenents</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#isMessagesToAllComponenents <em>Messages To All Componenents</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#isAllPublishingTopics <em>All Publishing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#isAllSubscribingTopics <em>All Subscribing Topics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackImpl extends MinimalEObjectImpl.Container implements Attack {
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
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttackActivation() <em>Attack Activation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackActivation()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackActivation> attackActivation;

	/**
	 * The default value of the '{@link #isMessagesFromAllComponenents() <em>Messages From All Componenents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMessagesFromAllComponenents()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MESSAGES_FROM_ALL_COMPONENENTS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMessagesFromAllComponenents() <em>Messages From All Componenents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMessagesFromAllComponenents()
	 * @generated
	 * @ordered
	 */
	protected boolean messagesFromAllComponenents = MESSAGES_FROM_ALL_COMPONENENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isMessagesToAllComponenents() <em>Messages To All Componenents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMessagesToAllComponenents()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MESSAGES_TO_ALL_COMPONENENTS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMessagesToAllComponenents() <em>Messages To All Componenents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMessagesToAllComponenents()
	 * @generated
	 * @ordered
	 */
	protected boolean messagesToAllComponenents = MESSAGES_TO_ALL_COMPONENENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllPublishingTopics() <em>All Publishing Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllPublishingTopics()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_PUBLISHING_TOPICS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllPublishingTopics() <em>All Publishing Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllPublishingTopics()
	 * @generated
	 * @ordered
	 */
	protected boolean allPublishingTopics = ALL_PUBLISHING_TOPICS_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllSubscribingTopics() <em>All Subscribing Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllSubscribingTopics()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_SUBSCRIBING_TOPICS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllSubscribingTopics() <em>All Subscribing Topics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllSubscribingTopics()
	 * @generated
	 * @ordered
	 */
	protected boolean allSubscribingTopics = ALL_SUBSCRIBING_TOPICS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttacksPackage.Literals.ATTACK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackActivation> getAttackActivation() {
		if (attackActivation == null) {
			attackActivation = new EObjectContainmentEList<AttackActivation>(AttackActivation.class, this, AttacksPackage.ATTACK__ATTACK_ACTIVATION);
		}
		return attackActivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMessagesFromAllComponenents() {
		return messagesFromAllComponenents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessagesFromAllComponenents(boolean newMessagesFromAllComponenents) {
		boolean oldMessagesFromAllComponenents = messagesFromAllComponenents;
		messagesFromAllComponenents = newMessagesFromAllComponenents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS, oldMessagesFromAllComponenents, messagesFromAllComponenents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMessagesToAllComponenents() {
		return messagesToAllComponenents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessagesToAllComponenents(boolean newMessagesToAllComponenents) {
		boolean oldMessagesToAllComponenents = messagesToAllComponenents;
		messagesToAllComponenents = newMessagesToAllComponenents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS, oldMessagesToAllComponenents, messagesToAllComponenents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllPublishingTopics() {
		return allPublishingTopics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllPublishingTopics(boolean newAllPublishingTopics) {
		boolean oldAllPublishingTopics = allPublishingTopics;
		allPublishingTopics = newAllPublishingTopics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS, oldAllPublishingTopics, allPublishingTopics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllSubscribingTopics() {
		return allSubscribingTopics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllSubscribingTopics(boolean newAllSubscribingTopics) {
		boolean oldAllSubscribingTopics = allSubscribingTopics;
		allSubscribingTopics = newAllSubscribingTopics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS, oldAllSubscribingTopics, allSubscribingTopics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AttacksPackage.ATTACK__ATTACK_ACTIVATION:
				return ((InternalEList<?>)getAttackActivation()).basicRemove(otherEnd, msgs);
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
			case AttacksPackage.ATTACK__NAME:
				return getName();
			case AttacksPackage.ATTACK__PRIORITY:
				return getPriority();
			case AttacksPackage.ATTACK__ATTACK_ACTIVATION:
				return getAttackActivation();
			case AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS:
				return isMessagesFromAllComponenents();
			case AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS:
				return isMessagesToAllComponenents();
			case AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS:
				return isAllPublishingTopics();
			case AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS:
				return isAllSubscribingTopics();
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
			case AttacksPackage.ATTACK__NAME:
				setName((String)newValue);
				return;
			case AttacksPackage.ATTACK__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case AttacksPackage.ATTACK__ATTACK_ACTIVATION:
				getAttackActivation().clear();
				getAttackActivation().addAll((Collection<? extends AttackActivation>)newValue);
				return;
			case AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS:
				setMessagesFromAllComponenents((Boolean)newValue);
				return;
			case AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS:
				setMessagesToAllComponenents((Boolean)newValue);
				return;
			case AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS:
				setAllPublishingTopics((Boolean)newValue);
				return;
			case AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS:
				setAllSubscribingTopics((Boolean)newValue);
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
			case AttacksPackage.ATTACK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__ATTACK_ACTIVATION:
				getAttackActivation().clear();
				return;
			case AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS:
				setMessagesFromAllComponenents(MESSAGES_FROM_ALL_COMPONENENTS_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS:
				setMessagesToAllComponenents(MESSAGES_TO_ALL_COMPONENENTS_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS:
				setAllPublishingTopics(ALL_PUBLISHING_TOPICS_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS:
				setAllSubscribingTopics(ALL_SUBSCRIBING_TOPICS_EDEFAULT);
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
			case AttacksPackage.ATTACK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AttacksPackage.ATTACK__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case AttacksPackage.ATTACK__ATTACK_ACTIVATION:
				return attackActivation != null && !attackActivation.isEmpty();
			case AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS:
				return messagesFromAllComponenents != MESSAGES_FROM_ALL_COMPONENENTS_EDEFAULT;
			case AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS:
				return messagesToAllComponenents != MESSAGES_TO_ALL_COMPONENENTS_EDEFAULT;
			case AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS:
				return allPublishingTopics != ALL_PUBLISHING_TOPICS_EDEFAULT;
			case AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS:
				return allSubscribingTopics != ALL_SUBSCRIBING_TOPICS_EDEFAULT;
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
		result.append(", priority: ");
		result.append(priority);
		result.append(", messagesFromAllComponenents: ");
		result.append(messagesFromAllComponenents);
		result.append(", messagesToAllComponenents: ");
		result.append(messagesToAllComponenents);
		result.append(", allPublishingTopics: ");
		result.append(allPublishingTopics);
		result.append(", allSubscribingTopics: ");
		result.append(allSubscribingTopics);
		result.append(')');
		return result.toString();
	}

} //AttackImpl
