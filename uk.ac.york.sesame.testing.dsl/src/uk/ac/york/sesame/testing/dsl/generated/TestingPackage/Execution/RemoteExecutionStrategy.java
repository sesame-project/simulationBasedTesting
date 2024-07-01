/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Execution Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.RemoteExecutionStrategy#isAutomaticDetection <em>Automatic Detection</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.RemoteExecutionStrategy#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.RemoteExecutionStrategy#getExtraExecutionTargets <em>Extra Execution Targets</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionPackage#getRemoteExecutionStrategy()
 * @model
 * @generated
 */
public interface RemoteExecutionStrategy extends ExecutionStrategy {
	/**
	 * Returns the value of the '<em><b>Automatic Detection</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automatic Detection</em>' attribute.
	 * @see #setAutomaticDetection(boolean)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionPackage#getRemoteExecutionStrategy_AutomaticDetection()
	 * @model default="true"
	 * @generated
	 */
	boolean isAutomaticDetection();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.RemoteExecutionStrategy#isAutomaticDetection <em>Automatic Detection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Automatic Detection</em>' attribute.
	 * @see #isAutomaticDetection()
	 * @generated
	 */
	void setAutomaticDetection(boolean value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.Dependency}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionPackage#getRemoteExecutionStrategy_Dependencies()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Dependency> getDependencies();

	/**
	 * Returns the value of the '<em><b>Extra Execution Targets</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extra Execution Targets</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionPackage#getRemoteExecutionStrategy_ExtraExecutionTargets()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ExecutionTarget> getExtraExecutionTargets();

} // RemoteExecutionStrategy
