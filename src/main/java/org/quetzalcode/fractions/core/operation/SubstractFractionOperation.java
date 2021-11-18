package org.quetzalcode.fractions.core.operation;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.Operator;

/**
 * Substract operation implementation
 * @author OBarenque
 *
 */
public class SubstractFractionOperation extends AbstractFractionOperation{

	public SubstractFractionOperation() {
		super(Operator.SUBSTRACT);
	}

	public Fraction executeOperation(final Fraction term1, final Fraction term2) {
		if(term1.getDenominator()!=term2.getDenominator()) {
			changeFractionsToSameDenominator(term1, term2);
		}
		long numerator=term1.getSignedNumerator()-term2.getSignedNumerator();
		long denominator=0;
		if(numerator!=0) {
			denominator=term1.getDenominator()==0?term2.getDenominator():term1.getDenominator();
		}
		boolean negative=numerator<0;
		Fraction result=new Fraction(term1.getWholeNumber()-term2.getWholeNumber(),numerator,denominator,negative);
		simplifyAndconvertToMixedNumbers(result);
		return result;
	}

}
