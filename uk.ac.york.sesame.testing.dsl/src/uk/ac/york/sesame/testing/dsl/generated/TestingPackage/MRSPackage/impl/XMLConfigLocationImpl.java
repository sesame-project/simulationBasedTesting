/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRSPackagePackage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.XMLConfigLocation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XML Config Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.impl.XMLConfigLocationImpl#getXpathExpression <em>Xpath Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XMLConfigLocationImpl extends FileLocationImpl implements XMLConfigLocation {
	/**
	 * The default value of the '{@link #getXpathExpression() <em>Xpath Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpathExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String XPATH_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXpathExpression() <em>Xpath Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXpathExpression()
	 * @generated
	 * @ordered
	 */
	protected String xpathExpression = XPATH_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLConfigLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MRSPackagePackage.Literals.XML_CONFIG_LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXpathExpression() {
		return xpathExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXpathExpression(String newXpathExpression) {
		String oldXpathExpression = xpathExpression;
		xpathExpression = newXpathExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MRSPackagePackage.XML_CONFIG_LOCATION__XPATH_EXPRESSION, oldXpathExpression, xpathExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MRSPackagePackage.XML_CONFIG_LOCATION__XPATH_EXPRESSION:
				return getXpathExpression();
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
			case MRSPackagePackage.XML_CONFIG_LOCATION__XPATH_EXPRESSION:
				setXpathExpression((String)newValue);
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
			case MRSPackagePackage.XML_CONFIG_LOCATION__XPATH_EXPRESSION:
				setXpathExpression(XPATH_EXPRESSION_EDEFAULT);
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
			case MRSPackagePackage.XML_CONFIG_LOCATION__XPATH_EXPRESSION:
				return XPATH_EXPRESSION_EDEFAULT == null ? xpathExpression != null : !XPATH_EXPRESSION_EDEFAULT.equals(xpathExpression);
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
		result.append(" (xpathExpression: ");
		result.append(xpathExpression);
		result.append(')');
		return result.toString();
	}

} //XMLConfigLocationImpl
