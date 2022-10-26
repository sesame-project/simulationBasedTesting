/**
 */
package uk.ac.york.sesame.testing.dsl.generated.TestingPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Reduction Strategy</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackagePackage#getReductionStrategy()
 * @model
 * @generated
 */
public enum ReductionStrategy implements Enumerator {
	/**
	 * The '<em><b>NO REDUCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_REDUCTION_VALUE
	 * @generated
	 * @ordered
	 */
	NO_REDUCTION(1, "NO_REDUCTION", "NO_REDUCTION"),

	/**
	 * The '<em><b>PARTIAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTIAL_VALUE
	 * @generated
	 * @ordered
	 */
	PARTIAL(2, "PARTIAL", "PARTIAL"),

	/**
	 * The '<em><b>SINGLE POINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_POINT_VALUE
	 * @generated
	 * @ordered
	 */
	SINGLE_POINT(3, "SINGLE_POINT", "SINGLE_POINT");

	/**
	 * The '<em><b>NO REDUCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_REDUCTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NO_REDUCTION_VALUE = 1;

	/**
	 * The '<em><b>PARTIAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTIAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARTIAL_VALUE = 2;

	/**
	 * The '<em><b>SINGLE POINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_POINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_POINT_VALUE = 3;

	/**
	 * An array of all the '<em><b>Reduction Strategy</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ReductionStrategy[] VALUES_ARRAY =
		new ReductionStrategy[] {
			NO_REDUCTION,
			PARTIAL,
			SINGLE_POINT,
		};

	/**
	 * A public read-only list of all the '<em><b>Reduction Strategy</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ReductionStrategy> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Reduction Strategy</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReductionStrategy get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReductionStrategy result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reduction Strategy</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReductionStrategy getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReductionStrategy result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reduction Strategy</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ReductionStrategy get(int value) {
		switch (value) {
			case NO_REDUCTION_VALUE: return NO_REDUCTION;
			case PARTIAL_VALUE: return PARTIAL;
			case SINGLE_POINT_VALUE: return SINGLE_POINT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ReductionStrategy(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ReductionStrategy
