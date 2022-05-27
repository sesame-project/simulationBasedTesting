/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage
 * @generated
 */
public interface TestingPackageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestingPackageFactory eINSTANCE = uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestingPackageFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Testing Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Testing Space</em>'.
	 * @generated
	 */
	TestingSpace createTestingSpace();

	/**
	 * Returns a new object of class '<em>Test Campaign</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Campaign</em>'.
	 * @generated
	 */
	TestCampaign createTestCampaign();

	/**
	 * Returns a new object of class '<em>Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test</em>'.
	 * @generated
	 */
	Test createTest();

	/**
	 * Returns a new object of class '<em>Grammar Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar Constraint</em>'.
	 * @generated
	 */
	GrammarConstraint createGrammarConstraint();

	/**
	 * Returns a new object of class '<em>Random Test Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Test Generation</em>'.
	 * @generated
	 */
	RandomTestGeneration createRandomTestGeneration();

	/**
	 * Returns a new object of class '<em>NSGA Evolutionary Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NSGA Evolutionary Algorithm</em>'.
	 * @generated
	 */
	NSGAEvolutionaryAlgorithm createNSGAEvolutionaryAlgorithm();

	/**
	 * Returns a new object of class '<em>Grammar Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar Specification</em>'.
	 * @generated
	 */
	GrammarSpecification createGrammarSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestingPackagePackage getTestingPackagePackage();

} //TestingPackageFactory
