package org.quetzalcode.fractions.core.operation;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.FractionException;
import org.quetzalcode.fractions.core.Operator;

/**
 * Divied operation implementation
 * @author OBarenque
 *
 */
public class DivideFractionOperation extends AbstractFractionOperation {

	public DivideFractionOperation() {
		super(Operator.DIVIDE);
	}

	public Fraction executeOperation(final Fraction term1, final Fraction term2) {
		if(term2.isEmpty()) {
			throw new FractionException("Division by zero is undefined");
		}
		boolean negative=term1.isNegative()!=term2.isNegative();
		Fraction result=new Fraction(0,term1.getNumerator()*term2.getDenominator(),term1.getDenominator()*term2.getNumerator(),negative);
		simplifyAndconvertToMixedNumbers(result);
		return result;
	}

}
