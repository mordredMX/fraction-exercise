package com.ol.fractions.core.operation;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.Operator;

public class DivideFractionOperation extends AbstractFractionOperation {

	public DivideFractionOperation() {
		super(Operator.DIVIDE);
	}

	public Fraction executeOperation(final Fraction term1, final Fraction term2) {
		Fraction result=new Fraction(0,term1.getNumerator()*term2.getDenominator(),term1.getDenominator()*term2.getNumerator());
		simplifyAndconvertToMixedNumbers(result);
		return result;
	}

}
