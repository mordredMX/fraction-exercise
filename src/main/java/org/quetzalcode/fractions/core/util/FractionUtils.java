package org.quetzalcode.fractions.core.util;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.FractionException;
import org.quetzalcode.fractions.core.Operator;

/**
 * Class that contains some methods to help managing fractions
 * @author OBarenque
 *
 */
public class FractionUtils {
	/**
	 * validates if a fraction is valid to be processed inside an operation
	 * @param fraction
	 */
	public static void validateFraction(final Fraction fraction) {
		if (fraction.getDenominator() == 0 && fraction.getNumerator() != 0) {
			throw new FractionException("Denominator cannot be 0:" + fraction.toString());
		}

		if (fraction.getDenominator() != 0 && fraction.getNumerator() == 0) {
			throw new FractionException("Numerator cannot be 0:" + fraction.toString());
		}
		
	}
	
	/**
	 * converts to string representation of the operation based fraction objects and operator
	 * @param term1
	 * @param term2
	 * @param operator
	 * @return
	 */
	public static String convertToStringOperation(final Fraction term1, final Fraction term2,final Operator operator) {
		return String.format("%s %s %s", term1.toString(),operator.getOperatorString() ,term2.toString());
	}
}
