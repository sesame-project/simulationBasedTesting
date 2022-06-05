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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Node;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Topic;

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
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getTopicToAttack <em>Topic To Attack</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#isMessagesFromAllComponenents <em>Messages From All Componenents</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getFromNodes <em>From Nodes</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#isMessagesToAllComponenents <em>Messages To All Componenents</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getToNodes <em>To Nodes</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getNodeToAttack <em>Node To Attack</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#isAllPublishingTopics <em>All Publishing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getPublishingTopics <em>Publishing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#isAllSubscribingTopics <em>All Subscribing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getSubscribingTopics <em>Subscribing Topics</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl#getBasedUpon <em>Based Upon</em>}</li>
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
	 * The cached value of the '{@link #getTopicToAttack() <em>Topic To Attack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopicToAttack()
	 * @generated
	 * @ordered
	 */
	protected Topic topicToAttack;

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
	 * The cached value of the '{@link #getFromNodes() <em>From Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> fromNodes;

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
	 * The cached value of the '{@link #getToNodes() <em>To Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> toNodes;

	/**
	 * The cached value of the '{@link #getNodeToAttack() <em>Node To Attack</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeToAttack()
	 * @generated
	 * @ordered
	 */
	protected Node nodeToAttack;

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
	 * The cached value of the '{@link #getPublishingTopics() <em>Publishing Topics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishingTopics()
	 * @generated
	 * @ordered
	 */
	protected EList<Topic> publishingTopics;

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
	 * The cached value of the '{@link #getSubscribingTopics() <em>Subscribing Topics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscribingTopics()
	 * @generated
	 * @ordered
	 */
	protected EList<Topic> subscribingTopics;

	/**
	 * The cached value of the '{@link #getBasedUpon() <em>Based Upon</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasedUpon()
	 * @generated
	 * @ordered
	 */
	protected Attack basedUpon;

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
	public Topic getTopicToAttack() {
		if (topicToAttack != null && topicToAttack.eIsProxy()) {
			InternalEObject oldTopicToAttack = (InternalEObject)topicToAttack;
			topicToAttack = (Topic)eResolveProxy(oldTopicToAttack);
			if (topicToAttack != oldTopicToAttack) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttacksPackage.ATTACK__TOPIC_TO_ATTACK, oldTopicToAttack, topicToAttack));
			}
		}
		return topicToAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Topic basicGetTopicToAttack() {
		return topicToAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopicToAttack(Topic newTopicToAttack) {
		Topic oldTopicToAttack = topicToAttack;
		topicToAttack = newTopicToAttack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__TOPIC_TO_ATTACK, oldTopicToAttack, topicToAttack));
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
	public EList<Node> getFromNodes() {
		if (fromNodes == null) {
			fromNodes = new EObjectResolvingEList<Node>(Node.class, this, AttacksPackage.ATTACK__FROM_NODES);
		}
		return fromNodes;
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
	public EList<Node> getToNodes() {
		if (toNodes == null) {
			toNodes = new EObjectResolvingEList<Node>(Node.class, this, AttacksPackage.ATTACK__TO_NODES);
		}
		return toNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNodeToAttack() {
		if (nodeToAttack != null && nodeToAttack.eIsProxy()) {
			InternalEObject oldNodeToAttack = (InternalEObject)nodeToAttack;
			nodeToAttack = (Node)eResolveProxy(oldNodeToAttack);
			if (nodeToAttack != oldNodeToAttack) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttacksPackage.ATTACK__NODE_TO_ATTACK, oldNodeToAttack, nodeToAttack));
			}
		}
		return nodeToAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNodeToAttack() {
		return nodeToAttack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeToAttack(Node newNodeToAttack) {
		Node oldNodeToAttack = nodeToAttack;
		nodeToAttack = newNodeToAttack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__NODE_TO_ATTACK, oldNodeToAttack, nodeToAttack));
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
	public EList<Topic> getPublishingTopics() {
		if (publishingTopics == null) {
			publishingTopics = new EObjectResolvingEList<Topic>(Topic.class, this, AttacksPackage.ATTACK__PUBLISHING_TOPICS);
		}
		return publishingTopics;
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
	public EList<Topic> getSubscribingTopics() {
		if (subscribingTopics == null) {
			subscribingTopics = new EObjectResolvingEList<Topic>(Topic.class, this, AttacksPackage.ATTACK__SUBSCRIBING_TOPICS);
		}
		return subscribingTopics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attack getBasedUpon() {
		if (basedUpon != null && basedUpon.eIsProxy()) {
			InternalEObject oldBasedUpon = (InternalEObject)basedUpon;
			basedUpon = (Attack)eResolveProxy(oldBasedUpon);
			if (basedUpon != oldBasedUpon) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttacksPackage.ATTACK__BASED_UPON, oldBasedUpon, basedUpon));
			}
		}
		return basedUpon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attack basicGetBasedUpon() {
		return basedUpon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasedUpon(Attack newBasedUpon) {
		Attack oldBasedUpon = basedUpon;
		basedUpon = newBasedUpon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttacksPackage.ATTACK__BASED_UPON, oldBasedUpon, basedUpon));
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
			case AttacksPackage.ATTACK__TOPIC_TO_ATTACK:
				if (resolve) return getTopicToAttack();
				return basicGetTopicToAttack();
			case AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS:
				return isMessagesFromAllComponenents();
			case AttacksPackage.ATTACK__FROM_NODES:
				return getFromNodes();
			case AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS:
				return isMessagesToAllComponenents();
			case AttacksPackage.ATTACK__TO_NODES:
				return getToNodes();
			case AttacksPackage.ATTACK__NODE_TO_ATTACK:
				if (resolve) return getNodeToAttack();
				return basicGetNodeToAttack();
			case AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS:
				return isAllPublishingTopics();
			case AttacksPackage.ATTACK__PUBLISHING_TOPICS:
				return getPublishingTopics();
			case AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS:
				return isAllSubscribingTopics();
			case AttacksPackage.ATTACK__SUBSCRIBING_TOPICS:
				return getSubscribingTopics();
			case AttacksPackage.ATTACK__BASED_UPON:
				if (resolve) return getBasedUpon();
				return basicGetBasedUpon();
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
			case AttacksPackage.ATTACK__TOPIC_TO_ATTACK:
				setTopicToAttack((Topic)newValue);
				return;
			case AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS:
				setMessagesFromAllComponenents((Boolean)newValue);
				return;
			case AttacksPackage.ATTACK__FROM_NODES:
				getFromNodes().clear();
				getFromNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS:
				setMessagesToAllComponenents((Boolean)newValue);
				return;
			case AttacksPackage.ATTACK__TO_NODES:
				getToNodes().clear();
				getToNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case AttacksPackage.ATTACK__NODE_TO_ATTACK:
				setNodeToAttack((Node)newValue);
				return;
			case AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS:
				setAllPublishingTopics((Boolean)newValue);
				return;
			case AttacksPackage.ATTACK__PUBLISHING_TOPICS:
				getPublishingTopics().clear();
				getPublishingTopics().addAll((Collection<? extends Topic>)newValue);
				return;
			case AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS:
				setAllSubscribingTopics((Boolean)newValue);
				return;
			case AttacksPackage.ATTACK__SUBSCRIBING_TOPICS:
				getSubscribingTopics().clear();
				getSubscribingTopics().addAll((Collection<? extends Topic>)newValue);
				return;
			case AttacksPackage.ATTACK__BASED_UPON:
				setBasedUpon((Attack)newValue);
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
			case AttacksPackage.ATTACK__TOPIC_TO_ATTACK:
				setTopicToAttack((Topic)null);
				return;
			case AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS:
				setMessagesFromAllComponenents(MESSAGES_FROM_ALL_COMPONENENTS_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__FROM_NODES:
				getFromNodes().clear();
				return;
			case AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS:
				setMessagesToAllComponenents(MESSAGES_TO_ALL_COMPONENENTS_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__TO_NODES:
				getToNodes().clear();
				return;
			case AttacksPackage.ATTACK__NODE_TO_ATTACK:
				setNodeToAttack((Node)null);
				return;
			case AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS:
				setAllPublishingTopics(ALL_PUBLISHING_TOPICS_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__PUBLISHING_TOPICS:
				getPublishingTopics().clear();
				return;
			case AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS:
				setAllSubscribingTopics(ALL_SUBSCRIBING_TOPICS_EDEFAULT);
				return;
			case AttacksPackage.ATTACK__SUBSCRIBING_TOPICS:
				getSubscribingTopics().clear();
				return;
			case AttacksPackage.ATTACK__BASED_UPON:
				setBasedUpon((Attack)null);
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
			case AttacksPackage.ATTACK__TOPIC_TO_ATTACK:
				return topicToAttack != null;
			case AttacksPackage.ATTACK__MESSAGES_FROM_ALL_COMPONENENTS:
				return messagesFromAllComponenents != MESSAGES_FROM_ALL_COMPONENENTS_EDEFAULT;
			case AttacksPackage.ATTACK__FROM_NODES:
				return fromNodes != null && !fromNodes.isEmpty();
			case AttacksPackage.ATTACK__MESSAGES_TO_ALL_COMPONENENTS:
				return messagesToAllComponenents != MESSAGES_TO_ALL_COMPONENENTS_EDEFAULT;
			case AttacksPackage.ATTACK__TO_NODES:
				return toNodes != null && !toNodes.isEmpty();
			case AttacksPackage.ATTACK__NODE_TO_ATTACK:
				return nodeToAttack != null;
			case AttacksPackage.ATTACK__ALL_PUBLISHING_TOPICS:
				return allPublishingTopics != ALL_PUBLISHING_TOPICS_EDEFAULT;
			case AttacksPackage.ATTACK__PUBLISHING_TOPICS:
				return publishingTopics != null && !publishingTopics.isEmpty();
			case AttacksPackage.ATTACK__ALL_SUBSCRIBING_TOPICS:
				return allSubscribingTopics != ALL_SUBSCRIBING_TOPICS_EDEFAULT;
			case AttacksPackage.ATTACK__SUBSCRIBING_TOPICS:
				return subscribingTopics != null && !subscribingTopics.isEmpty();
			case AttacksPackage.ATTACK__BASED_UPON:
				return basedUpon != null;
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
