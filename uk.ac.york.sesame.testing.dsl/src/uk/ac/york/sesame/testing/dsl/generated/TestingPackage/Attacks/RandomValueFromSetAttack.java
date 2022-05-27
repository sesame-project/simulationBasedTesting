/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Value From Set Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack#getValueSet <em>Value Set</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getRandomValueFromSetAttack()
 * @model
 * @generated
 */
public interface RandomValueFromSetAttack extends RandomValueAttack {
	/**
	 * Returns the value of the '<em><b>Value Set</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Set</em>' containment reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getRandomValueFromSetAttack_ValueSet()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueSet> getValueSet();

} // RandomValueFromSetAttack
