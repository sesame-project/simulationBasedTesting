/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage
 * @generated
 */
public class TestingPackageSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TestingPackagePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestingPackageSwitch() {
		if (modelPackage == null) {
			modelPackage = TestingPackagePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TestingPackagePackage.TESTING_SPACE: {
				TestingSpace testingSpace = (TestingSpace)theEObject;
				T result = caseTestingSpace(testingSpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.TEST_CAMPAIGN: {
				TestCampaign testCampaign = (TestCampaign)theEObject;
				T result = caseTestCampaign(testCampaign);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.TEST: {
				Test test = (Test)theEObject;
				T result = caseTest(test);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.CAMPAIGN_RESULT_SET: {
				CampaignResultSet campaignResultSet = (CampaignResultSet)theEObject;
				T result = caseCampaignResultSet(campaignResultSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.EXECUTION_END_TRIGGER: {
				ExecutionEndTrigger executionEndTrigger = (ExecutionEndTrigger)theEObject;
				T result = caseExecutionEndTrigger(executionEndTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.TIME_BASED_END: {
				TimeBasedEnd timeBasedEnd = (TimeBasedEnd)theEObject;
				T result = caseTimeBasedEnd(timeBasedEnd);
				if (result == null) result = caseExecutionEndTrigger(timeBasedEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.TEST_GENERATION_APPROACH: {
				TestGenerationApproach testGenerationApproach = (TestGenerationApproach)theEObject;
				T result = caseTestGenerationApproach(testGenerationApproach);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.RANDOM_TEST_GENERATION: {
				RandomTestGeneration randomTestGeneration = (RandomTestGeneration)theEObject;
				T result = caseRandomTestGeneration(randomTestGeneration);
				if (result == null) result = caseTestGenerationApproach(randomTestGeneration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.EVOLUTIONARY_ALGORITHM: {
				EvolutionaryAlgorithm evolutionaryAlgorithm = (EvolutionaryAlgorithm)theEObject;
				T result = caseEvolutionaryAlgorithm(evolutionaryAlgorithm);
				if (result == null) result = caseTestGenerationApproach(evolutionaryAlgorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TestingPackagePackage.NSGA_EVOLUTIONARY_ALGORITHM: {
				NSGAEvolutionaryAlgorithm nsgaEvolutionaryAlgorithm = (NSGAEvolutionaryAlgorithm)theEObject;
				T result = caseNSGAEvolutionaryAlgorithm(nsgaEvolutionaryAlgorithm);
				if (result == null) result = caseEvolutionaryAlgorithm(nsgaEvolutionaryAlgorithm);
				if (result == null) result = caseTestGenerationApproach(nsgaEvolutionaryAlgorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Testing Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Testing Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestingSpace(TestingSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Campaign</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Campaign</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestCampaign(TestCampaign object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTest(Test object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Campaign Result Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Campaign Result Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCampaignResultSet(CampaignResultSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution End Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution End Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionEndTrigger(ExecutionEndTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Based End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Based End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeBasedEnd(TimeBasedEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Generation Approach</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Generation Approach</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestGenerationApproach(TestGenerationApproach object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Test Generation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Test Generation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomTestGeneration(RandomTestGeneration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evolutionary Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evolutionary Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvolutionaryAlgorithm(EvolutionaryAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NSGA Evolutionary Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NSGA Evolutionary Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNSGAEvolutionaryAlgorithm(NSGAEvolutionaryAlgorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TestingPackageSwitch
