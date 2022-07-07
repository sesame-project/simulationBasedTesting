/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.StandardComparisonGrammarPackage
 * @generated
 */
public interface StandardComparisonGrammarFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StandardComparisonGrammarFactory eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardComparisonGrammar.impl.StandardComparisonGrammarFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Condition</em>'.
	 * @generated
	 */
	CompositeCondition createCompositeCondition();

	/**
	 * Returns a new object of class '<em>Basic Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Condition</em>'.
	 * @generated
	 */
	BasicCondition createBasicCondition();

	/**
	 * Returns a new object of class '<em>Condition Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Integer</em>'.
	 * @generated
	 */
	ConditionInteger createConditionInteger();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Standard Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Standard Condition</em>'.
	 * @generated
	 */
	StandardCondition createStandardCondition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StandardComparisonGrammarPackage getStandardComparisonGrammarPackage();

} //StandardComparisonGrammarFactory
