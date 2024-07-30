/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionStrategy#getExptRunnerIP <em>Expt Runner IP</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionPackage#getExecutionStrategy()
 * @model abstract="true"
 * @generated
 */
public interface ExecutionStrategy extends EObject {

	/**
	 * Returns the value of the '<em><b>Expt Runner IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expt Runner IP</em>' attribute.
	 * @see #setExptRunnerIP(String)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionPackage#getExecutionStrategy_ExptRunnerIP()
	 * @model
	 * @generated
	 */
	String getExptRunnerIP();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Execution.ExecutionStrategy#getExptRunnerIP <em>Expt Runner IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expt Runner IP</em>' attribute.
	 * @see #getExptRunnerIP()
	 * @generated
	 */
	void setExptRunnerIP(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDistributed();
} // ExecutionStrategy
