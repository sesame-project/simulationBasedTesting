/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalExpression;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.BinaryLogicalOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.impl.BinaryLogicalExpressionImpl#getBinOp <em>Bin Op</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryLogicalExpressionImpl extends BinaryExpressionImpl implements BinaryLogicalExpression {
	/**
	 * The default value of the '{@link #getBinOp() <em>Bin Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinOp()
	 * @generated
	 * @ordered
	 */
	protected static final BinaryLogicalOperation BIN_OP_EDEFAULT = BinaryLogicalOperation.AND;

	/**
	 * The cached value of the '{@link #getBinOp() <em>Bin Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinOp()
	 * @generated
	 * @ordered
	 */
	protected BinaryLogicalOperation binOp = BIN_OP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryLogicalExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardGrammarPackage.Literals.BINARY_LOGICAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryLogicalOperation getBinOp() {
		return binOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinOp(BinaryLogicalOperation newBinOp) {
		BinaryLogicalOperation oldBinOp = binOp;
		binOp = newBinOp == null ? BIN_OP_EDEFAULT : newBinOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardGrammarPackage.BINARY_LOGICAL_EXPRESSION__BIN_OP, oldBinOp, binOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardGrammarPackage.BINARY_LOGICAL_EXPRESSION__BIN_OP:
				return getBinOp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StandardGrammarPackage.BINARY_LOGICAL_EXPRESSION__BIN_OP:
				setBinOp((BinaryLogicalOperation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StandardGrammarPackage.BINARY_LOGICAL_EXPRESSION__BIN_OP:
				setBinOp(BIN_OP_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StandardGrammarPackage.BINARY_LOGICAL_EXPRESSION__BIN_OP:
				return binOp != BIN_OP_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (binOp: ");
		result.append(binOp);
		result.append(')');
		return result.toString();
	}

} //BinaryLogicalExpressionImpl
