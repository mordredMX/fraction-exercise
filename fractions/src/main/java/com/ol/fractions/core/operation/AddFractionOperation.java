package com.ol.fractions.core.operation;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.Operator;

public class AddFractionOperation extends AbstractFractionOperation {

	public AddFractionOperation() {
		super(Operator.ADD);
	}

	public Fraction executeOperation(Fraction term1, Fraction term2) {
		if(term1.getDenominator()!=term2.getDenominator()) {
			changeFractionsToSameDenominator(term1, term2);
		}
		Fraction result=new Fraction(term1.getWholeNumber()+term2.getWholeNumber(),term1.getNumerator()+term2.getNumerator(),term1.getDenominator());
		simplifyAndconvertToMixedNumbers(result);
		return result;
	}
	
}
