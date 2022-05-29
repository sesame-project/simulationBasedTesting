/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks;

import org.eclipse.emf.common.util.EList;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Parameter;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topic Attack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.TopicAttack#getSubParameters <em>Sub Parameters</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getTopicAttack()
 * @model
 * @generated
 */
public interface TopicAttack extends FuzzTestingAttack {

	/**
	 * Returns the value of the '<em><b>Sub Parameters</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Parameters</em>' reference list.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttacksPackage#getTopicAttack_SubParameters()
	 * @model
	 * @generated
	 */
	EList<Parameter> getSubParameters();
} // TopicAttack
