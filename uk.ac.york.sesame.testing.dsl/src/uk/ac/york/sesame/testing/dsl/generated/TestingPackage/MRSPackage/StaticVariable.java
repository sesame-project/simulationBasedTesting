/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.StaticVariable#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage#getStaticVariable()
 * @model
 * @generated
 */
public interface StaticVariable extends GenericVariable {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(ConfigLocation)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage#getStaticVariable_Location()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConfigLocation getLocation();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.StaticVariable#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(ConfigLocation value);

} // StaticVariable
