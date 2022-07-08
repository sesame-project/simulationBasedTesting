/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MRS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS#getVariables <em>Variables</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS#getLaunchFileLocation <em>Launch File Location</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS#getNodes <em>Nodes</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS#getSimulator <em>Simulator</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS#getPropertyType <em>Property Type</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage#getMRS()
 * @model
 * @generated
 */
public interface MRS extends EObject {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage#getMRS_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Launch File Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Launch File Location</em>' attribute.
	 * @see #setLaunchFileLocation(String)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage#getMRS_LaunchFileLocation()
	 * @model
	 * @generated
	 */
	String getLaunchFileLocation();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS#getLaunchFileLocation <em>Launch File Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Launch File Location</em>' attribute.
	 * @see #getLaunchFileLocation()
	 * @generated
	 */
	void setLaunchFileLocation(String value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage#getMRS_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Simulator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulator</em>' containment reference.
	 * @see #setSimulator(Simulator)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage#getMRS_Simulator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Simulator getSimulator();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS#getSimulator <em>Simulator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulator</em>' containment reference.
	 * @see #getSimulator()
	 * @generated
	 */
	void setSimulator(Simulator value);

	/**
	 * Returns the value of the '<em><b>Property Type</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Type</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage#getMRS_PropertyType()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getPropertyType();

} // MRS
