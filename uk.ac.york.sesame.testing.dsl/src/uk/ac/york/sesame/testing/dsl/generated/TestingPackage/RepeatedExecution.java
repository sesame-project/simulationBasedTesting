/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repeated Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.RepeatedExecution#getTestToRepeat <em>Test To Repeat</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.RepeatedExecution#getRepeatCount <em>Repeat Count</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage#getRepeatedExecution()
 * @model
 * @generated
 */
public interface RepeatedExecution extends TestGenerationApproach {
	/**
	 * Returns the value of the '<em><b>Test To Repeat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test To Repeat</em>' reference.
	 * @see #setTestToRepeat(Test)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage#getRepeatedExecution_TestToRepeat()
	 * @model required="true"
	 * @generated
	 */
	Test getTestToRepeat();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.RepeatedExecution#getTestToRepeat <em>Test To Repeat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test To Repeat</em>' reference.
	 * @see #getTestToRepeat()
	 * @generated
	 */
	void setTestToRepeat(Test value);

	/**
	 * Returns the value of the '<em><b>Repeat Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat Count</em>' attribute.
	 * @see #setRepeatCount(int)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage#getRepeatedExecution_RepeatCount()
	 * @model
	 * @generated
	 */
	int getRepeatCount();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.RepeatedExecution#getRepeatCount <em>Repeat Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat Count</em>' attribute.
	 * @see #getRepeatCount()
	 * @generated
	 */
	void setRepeatCount(int value);

} // RepeatedExecution
