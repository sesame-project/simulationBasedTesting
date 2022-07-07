/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StandardComparisonGrammarFactoryImpl extends EFactoryImpl implements StandardComparisonGrammarFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StandardComparisonGrammarFactory init() {
		try {
			StandardComparisonGrammarFactory theStandardComparisonGrammarFactory = (StandardComparisonGrammarFactory)EPackage.Registry.INSTANCE.getEFactory(StandardComparisonGrammarPackage.eNS_URI);
			if (theStandardComparisonGrammarFactory != null) {
				return theStandardComparisonGrammarFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StandardComparisonGrammarFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardComparisonGrammarFactoryImpl() {
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
			case StandardComparisonGrammarPackage.COMPOSITE_CONDITION: return createCompositeCondition();
			case StandardComparisonGrammarPackage.BASIC_CONDITION: return createBasicCondition();
			case StandardComparisonGrammarPackage.CONDITION_INTEGER: return createConditionInteger();
			case StandardComparisonGrammarPackage.VARIABLE: return createVariable();
			case StandardComparisonGrammarPackage.STANDARD_CONDITION: return createStandardCondition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case StandardComparisonGrammarPackage.BINARY_COMPARISON_OPERATION:
				return createBinaryComparisonOperationFromString(eDataType, initialValue);
			case StandardComparisonGrammarPackage.BINARY_LOGICAL_OPERATION:
				return createBinaryLogicalOperationFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case StandardComparisonGrammarPackage.BINARY_COMPARISON_OPERATION:
				return convertBinaryComparisonOperationToString(eDataType, instanceValue);
			case StandardComparisonGrammarPackage.BINARY_LOGICAL_OPERATION:
				return convertBinaryLogicalOperationToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeCondition createCompositeCondition() {
		CompositeConditionImpl compositeCondition = new CompositeConditionImpl();
		return compositeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicCondition createBasicCondition() {
		BasicConditionImpl basicCondition = new BasicConditionImpl();
		return basicCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionInteger createConditionInteger() {
		ConditionIntegerImpl conditionInteger = new ConditionIntegerImpl();
		return conditionInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardCondition createStandardCondition() {
		StandardConditionImpl standardCondition = new StandardConditionImpl();
		return standardCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryComparisonOperation createBinaryComparisonOperationFromString(EDataType eDataType, String initialValue) {
		BinaryComparisonOperation result = BinaryComparisonOperation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryComparisonOperationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryLogicalOperation createBinaryLogicalOperationFromString(EDataType eDataType, String initialValue) {
		BinaryLogicalOperation result = BinaryLogicalOperation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBinaryLogicalOperationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardComparisonGrammarPackage getStandardComparisonGrammarPackage() {
		return (StandardComparisonGrammarPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StandardComparisonGrammarPackage getPackage() {
		return StandardComparisonGrammarPackage.eINSTANCE;
	}

} //StandardComparisonGrammarFactoryImpl
