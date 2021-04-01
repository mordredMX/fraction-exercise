package com.ol.fractions.core.operation;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.Operator;

/**
 * Add operation implementation
 * @author OBarenque
 *
 */
public class AddFractionOperation extends AbstractFractionOperation {

	public AddFractionOperation() {
		super(Operator.ADD);
	}

	public Fraction executeOperation(final Fraction term1,final  Fraction term2) {
		if(term1.getDenominator()!=term2.getDenominator()) {
			changeFractionsToSameDenominator(term1, term2);
		}
		long numerator=term1.getSignedNumerator()+term2.getSignedNumerator();
		long denominator=0;
		if(numerator!=0) {
			denominator=term1.getDenominator()==0?term2.getDenominator():term1.getDenominator();
		}
		boolean negative=numerator<0;
		Fraction result=new Fraction(0,numerator,denominator,negative);
		simplifyAndconvertToMixedNumbers(result);
		return result;
	}
	
}
