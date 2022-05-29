/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topic Attack</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.TopicAttackImpl#getSubParameters <em>Sub Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopicAttackImpl extends FuzzTestingAttackImpl implements TopicAttack {
	/**
	 * The cached value of the '{@link #getSubParameters() <em>Sub Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> subParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopicAttackImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttacksPackage.Literals.TOPIC_ATTACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getSubParameters() {
		if (subParameters == null) {
			subParameters = new EObjectResolvingEList<Parameter>(Parameter.class, this, AttacksPackage.TOPIC_ATTACK__SUB_PARAMETERS);
		}
		return subParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AttacksPackage.TOPIC_ATTACK__SUB_PARAMETERS:
				return getSubParameters();
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
			case AttacksPackage.TOPIC_ATTACK__SUB_PARAMETERS:
				getSubParameters().clear();
				getSubParameters().addAll((Collection<? extends Parameter>)newValue);
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
			case AttacksPackage.TOPIC_ATTACK__SUB_PARAMETERS:
				getSubParameters().clear();
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
			case AttacksPackage.TOPIC_ATTACK__SUB_PARAMETERS:
				return subParameters != null && !subParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TopicAttackImpl
