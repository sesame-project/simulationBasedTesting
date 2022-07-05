/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalExpression#getBinOp <em>Bin Op</em>}</li>
 * </ul>
 *
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarPackage#getBinaryLogicalExpression()
 * @model
 * @generated
 */
public interface BinaryLogicalExpression extends BinaryExpression {
	/**
	 * Returns the value of the '<em><b>Bin Op</b></em>' attribute.
	 * The literals are from the enumeration {@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bin Op</em>' attribute.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalOperation
	 * @see #setBinOp(BinaryLogicalOperation)
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarPackage#getBinaryLogicalExpression_BinOp()
	 * @model
	 * @generated
	 */
	BinaryLogicalOperation getBinOp();

	/**
	 * Sets the value of the '{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalExpression#getBinOp <em>Bin Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bin Op</em>' attribute.
	 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalOperation
	 * @see #getBinOp()
	 * @generated
	 */
	void setBinOp(BinaryLogicalOperation value);

} // BinaryLogicalExpression
