/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.ConditionsFactory
 * @model kind="package"
 * @generated
 */
public interface ConditionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Conditions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Conditions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConditionsPackage eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Elt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__ELT = 1;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Grammar Elt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GRAMMAR_ELT = 0;

	/**
	 * The feature id for the '<em><b>Sub Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SUB_NODES = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeValueImpl <em>Node Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeValueImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getNodeValue()
	 * @generated
	 */
	int NODE_VALUE = 2;

	/**
	 * The number of structural features of the '<em>Node Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Node Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.IntNodeValueImpl <em>Int Node Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.IntNodeValueImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getIntNodeValue()
	 * @generated
	 */
	int INT_NODE_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_NODE_VALUE__VALUE = NODE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Node Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_NODE_VALUE_FEATURE_COUNT = NODE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Node Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_NODE_VALUE_OPERATION_COUNT = NODE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.StringNodeValueImpl <em>String Node Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.StringNodeValueImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getStringNodeValue()
	 * @generated
	 */
	int STRING_NODE_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NODE_VALUE__VALUE = NODE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Node Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NODE_VALUE_FEATURE_COUNT = NODE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Node Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NODE_VALUE_OPERATION_COUNT = NODE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.DoubleNodeValueImpl <em>Double Node Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.DoubleNodeValueImpl
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getDoubleNodeValue()
	 * @generated
	 */
	int DOUBLE_NODE_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NODE_VALUE__VALUE = NODE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Node Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NODE_VALUE_FEATURE_COUNT = NODE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Double Node Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_NODE_VALUE_OPERATION_COUNT = NODE_VALUE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Condition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Condition#getName()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Name();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Condition#getElt <em>Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Elt</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Condition#getElt()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_Elt();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getGrammarElt <em>Grammar Elt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grammar Elt</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getGrammarElt()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_GrammarElt();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getSubNodes <em>Sub Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Nodes</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getSubNodes()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_SubNodes();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.Node#getValue()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Value();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.NodeValue <em>Node Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.NodeValue
	 * @generated
	 */
	EClass getNodeValue();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.IntNodeValue <em>Int Node Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Node Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.IntNodeValue
	 * @generated
	 */
	EClass getIntNodeValue();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.IntNodeValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.IntNodeValue#getValue()
	 * @see #getIntNodeValue()
	 * @generated
	 */
	EAttribute getIntNodeValue_Value();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.StringNodeValue <em>String Node Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Node Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.StringNodeValue
	 * @generated
	 */
	EClass getStringNodeValue();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.StringNodeValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.StringNodeValue#getValue()
	 * @see #getStringNodeValue()
	 * @generated
	 */
	EAttribute getStringNodeValue_Value();

	/**
	 * Returns the meta object for class '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.DoubleNodeValue <em>Double Node Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Node Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.DoubleNodeValue
	 * @generated
	 */
	EClass getDoubleNodeValue();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.DoubleNodeValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.DoubleNodeValue#getValue()
	 * @see #getDoubleNodeValue()
	 * @generated
	 */
	EAttribute getDoubleNodeValue_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConditionsFactory getConditionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__NAME = eINSTANCE.getCondition_Name();

		/**
		 * The meta object literal for the '<em><b>Elt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__ELT = eINSTANCE.getCondition_Elt();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Grammar Elt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__GRAMMAR_ELT = eINSTANCE.getNode_GrammarElt();

		/**
		 * The meta object literal for the '<em><b>Sub Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SUB_NODES = eINSTANCE.getNode_SubNodes();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__VALUE = eINSTANCE.getNode_Value();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeValueImpl <em>Node Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.NodeValueImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getNodeValue()
		 * @generated
		 */
		EClass NODE_VALUE = eINSTANCE.getNodeValue();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.IntNodeValueImpl <em>Int Node Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.IntNodeValueImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getIntNodeValue()
		 * @generated
		 */
		EClass INT_NODE_VALUE = eINSTANCE.getIntNodeValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_NODE_VALUE__VALUE = eINSTANCE.getIntNodeValue_Value();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.StringNodeValueImpl <em>String Node Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.StringNodeValueImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getStringNodeValue()
		 * @generated
		 */
		EClass STRING_NODE_VALUE = eINSTANCE.getStringNodeValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_NODE_VALUE__VALUE = eINSTANCE.getStringNodeValue_Value();

		/**
		 * The meta object literal for the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.DoubleNodeValueImpl <em>Double Node Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.DoubleNodeValueImpl
		 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Conditions.impl.ConditionsPackageImpl#getDoubleNodeValue()
		 * @generated
		 */
		EClass DOUBLE_NODE_VALUE = eINSTANCE.getDoubleNodeValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_NODE_VALUE__VALUE = eINSTANCE.getDoubleNodeValue_Value();

	}

} //ConditionsPackage
