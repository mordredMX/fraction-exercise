package com.ol.fractions.core.util;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.FractionException;
import com.ol.fractions.core.Operator;

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
		
		if(!fraction.hasFraction() && !fraction.hasWholeNumber()) {
			throw new FractionException("Zero is not supported as fraction");
		}
		
		if(fraction.getDenominator()<0 || fraction.getNumerator()<0 || fraction.getWholeNumber()<0) {
			throw new FractionException("No negative values soported as inputs."+fraction.toString());
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
