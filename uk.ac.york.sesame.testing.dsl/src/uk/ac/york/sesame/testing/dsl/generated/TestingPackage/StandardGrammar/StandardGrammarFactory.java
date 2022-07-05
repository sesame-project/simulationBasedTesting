/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarPackage
 * @generated
 */
public interface StandardGrammarFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StandardGrammarFactory eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.impl.StandardGrammarFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simulator Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulator Variable</em>'.
	 * @generated
	 */
	SimulatorVariable createSimulatorVariable();

	/**
	 * Returns a new object of class '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Expression</em>'.
	 * @generated
	 */
	BinaryExpression createBinaryExpression();

	/**
	 * Returns a new object of class '<em>Binary Comparison</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Comparison</em>'.
	 * @generated
	 */
	BinaryComparison createBinaryComparison();

	/**
	 * Returns a new object of class '<em>Binary Logical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Logical Expression</em>'.
	 * @generated
	 */
	BinaryLogicalExpression createBinaryLogicalExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StandardGrammarPackage getStandardGrammarPackage();

} //StandardGrammarFactory
