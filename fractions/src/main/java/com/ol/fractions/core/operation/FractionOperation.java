package com.ol.fractions.core.operation;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.Operator;

/**
 * Fraction operation interface
 * @author OBarenque
 *
 */
public interface FractionOperation {
	
	public Fraction calculate(final Fraction term1,final Fraction term2);

	public Operator getOperator();
}
