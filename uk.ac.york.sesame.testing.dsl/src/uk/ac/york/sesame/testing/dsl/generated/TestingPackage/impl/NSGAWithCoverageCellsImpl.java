/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.DimensionInterval;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAWithCoverageCells;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NSGA With Coverage Cells</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.NSGAWithCoverageCellsImpl#getCoveragePerCell <em>Coverage Per Cell</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.NSGAWithCoverageCellsImpl#getDimensionRecords <em>Dimension Records</em>}</li>
 *   <li>{@link uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.NSGAWithCoverageCellsImpl#isUseMutationEnhancingCoverage <em>Use Mutation Enhancing Coverage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NSGAWithCoverageCellsImpl extends NSGAEvolutionaryAlgorithmImpl implements NSGAWithCoverageCells {
	/**
	 * The default value of the '{@link #getCoveragePerCell() <em>Coverage Per Cell</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoveragePerCell()
	 * @generated
	 * @ordered
	 */
	protected static final int COVERAGE_PER_CELL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCoveragePerCell() <em>Coverage Per Cell</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoveragePerCell()
	 * @generated
	 * @ordered
	 */
	protected int coveragePerCell = COVERAGE_PER_CELL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDimensionRecords() <em>Dimension Records</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensionRecords()
	 * @generated
	 * @ordered
	 */
	protected EList<DimensionInterval> dimensionRecords;

	/**
	 * The default value of the '{@link #isUseMutationEnhancingCoverage() <em>Use Mutation Enhancing Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseMutationEnhancingCoverage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_MUTATION_ENHANCING_COVERAGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseMutationEnhancingCoverage() <em>Use Mutation Enhancing Coverage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseMutationEnhancingCoverage()
	 * @generated
	 * @ordered
	 */
	protected boolean useMutationEnhancingCoverage = USE_MUTATION_ENHANCING_COVERAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NSGAWithCoverageCellsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestingPackagePackage.Literals.NSGA_WITH_COVERAGE_CELLS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCoveragePerCell() {
		return coveragePerCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoveragePerCell(int newCoveragePerCell) {
		int oldCoveragePerCell = coveragePerCell;
		coveragePerCell = newCoveragePerCell;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__COVERAGE_PER_CELL, oldCoveragePerCell, coveragePerCell));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DimensionInterval> getDimensionRecords() {
		if (dimensionRecords == null) {
			dimensionRecords = new EObjectContainmentEList<DimensionInterval>(DimensionInterval.class, this, TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__DIMENSION_RECORDS);
		}
		return dimensionRecords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseMutationEnhancingCoverage() {
		return useMutationEnhancingCoverage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseMutationEnhancingCoverage(boolean newUseMutationEnhancingCoverage) {
		boolean oldUseMutationEnhancingCoverage = useMutationEnhancingCoverage;
		useMutationEnhancingCoverage = newUseMutationEnhancingCoverage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__USE_MUTATION_ENHANCING_COVERAGE, oldUseMutationEnhancingCoverage, useMutationEnhancingCoverage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__DIMENSION_RECORDS:
				return ((InternalEList<?>)getDimensionRecords()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__COVERAGE_PER_CELL:
				return getCoveragePerCell();
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__DIMENSION_RECORDS:
				return getDimensionRecords();
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__USE_MUTATION_ENHANCING_COVERAGE:
				return isUseMutationEnhancingCoverage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__COVERAGE_PER_CELL:
				setCoveragePerCell((Integer)newValue);
				return;
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__DIMENSION_RECORDS:
				getDimensionRecords().clear();
				getDimensionRecords().addAll((Collection<? extends DimensionInterval>)newValue);
				return;
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__USE_MUTATION_ENHANCING_COVERAGE:
				setUseMutationEnhancingCoverage((Boolean)newValue);
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
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__COVERAGE_PER_CELL:
				setCoveragePerCell(COVERAGE_PER_CELL_EDEFAULT);
				return;
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__DIMENSION_RECORDS:
				getDimensionRecords().clear();
				return;
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__USE_MUTATION_ENHANCING_COVERAGE:
				setUseMutationEnhancingCoverage(USE_MUTATION_ENHANCING_COVERAGE_EDEFAULT);
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
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__COVERAGE_PER_CELL:
				return coveragePerCell != COVERAGE_PER_CELL_EDEFAULT;
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__DIMENSION_RECORDS:
				return dimensionRecords != null && !dimensionRecords.isEmpty();
			case TestingPackagePackage.NSGA_WITH_COVERAGE_CELLS__USE_MUTATION_ENHANCING_COVERAGE:
				return useMutationEnhancingCoverage != USE_MUTATION_ENHANCING_COVERAGE_EDEFAULT;
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
		result.append(" (coveragePerCell: ");
		result.append(coveragePerCell);
		result.append(", useMutationEnhancingCoverage: ");
		result.append(useMutationEnhancingCoverage);
		result.append(')');
		return result.toString();
	}

} //NSGAWithCoverageCellsImpl
