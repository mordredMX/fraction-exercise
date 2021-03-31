package com.ol.fractions.core.operation;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.Operator;

public class SubstractFractionOperation extends AbstractFractionOperation{

	public SubstractFractionOperation() {
		super(Operator.SUBSTRACT);
	}

	public Fraction executeOperation(final Fraction term1, final Fraction term2) {
		if(term1.getDenominator()!=term2.getDenominator()) {
			changeFractionsToSameDenominator(term1, term2);
		}
		final long numerator=term1.getNumerator()-term2.getNumerator();
		Fraction result=new Fraction(term1.getWholeNumber()-term2.getWholeNumber(),numerator,numerator==0?numerator:term1.getDenominator());
		simplifyAndconvertToMixedNumbers(result);
		return result;
	}

}
