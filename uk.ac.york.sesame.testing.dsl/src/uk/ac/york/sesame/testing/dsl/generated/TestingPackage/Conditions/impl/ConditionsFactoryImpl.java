/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConditionsFactoryImpl extends EFactoryImpl implements ConditionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConditionsFactory init() {
		try {
			ConditionsFactory theConditionsFactory = (ConditionsFactory)EPackage.Registry.INSTANCE.getEFactory(ConditionsPackage.eNS_URI);
			if (theConditionsFactory != null) {
				return theConditionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConditionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConditionsPackage.CONDITION: return createCondition();
			case ConditionsPackage.NODE: return createNode();
			case ConditionsPackage.INT_NODE_VALUE: return createIntNodeValue();
			case ConditionsPackage.STRING_NODE_VALUE: return createStringNodeValue();
			case ConditionsPackage.DOUBLE_NODE_VALUE: return createDoubleNodeValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntNodeValue createIntNodeValue() {
		IntNodeValueImpl intNodeValue = new IntNodeValueImpl();
		return intNodeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringNodeValue createStringNodeValue() {
		StringNodeValueImpl stringNodeValue = new StringNodeValueImpl();
		return stringNodeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleNodeValue createDoubleNodeValue() {
		DoubleNodeValueImpl doubleNodeValue = new DoubleNodeValueImpl();
		return doubleNodeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionsPackage getConditionsPackage() {
		return (ConditionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConditionsPackage getPackage() {
		return ConditionsPackage.eINSTANCE;
	}

} //ConditionsFactoryImpl
