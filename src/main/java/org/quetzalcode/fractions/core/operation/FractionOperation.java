package org.quetzalcode.fractions.core.operation;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.Operator;

/**
 * Fraction operation interface
 * @author OBarenque
 *
 */
public interface FractionOperation {
	
	public Fraction calculate(final Fraction term1,final Fraction term2);

	public Operator getOperator();
}
