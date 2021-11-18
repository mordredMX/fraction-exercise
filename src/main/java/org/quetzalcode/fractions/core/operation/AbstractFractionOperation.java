package org.quetzalcode.fractions.core.operation;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.Operator;
import org.quetzalcode.fractions.core.util.FractionUtils;
import org.quetzalcode.fractions.core.util.MathUtils;

/**
 * abstract class with reusable methods for a FractionOperation
 * @author OBarenque
 *
 */
public abstract class AbstractFractionOperation implements FractionOperation {

	private final static Logger LOGGER = Logger.getLogger(AbstractFractionOperation.class.getName());

	private Operator operator;

	public AbstractFractionOperation(final Operator operator) {
		this.operator = operator;
	}

	public Operator getOperator() {
		return operator;
	}

	@Override
	public Fraction calculate(final Fraction term1, final Fraction term2) {
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.log(Level.INFO, "starting to calculate: {0}",
					FractionUtils.convertToStringOperation(term1, term2, getOperator()));
		}
		FractionUtils.validateFraction(term1);
		FractionUtils.validateFraction(term2);
		final Fraction iterm1 = prepareFractionForOperation(term1);
		final Fraction iterm2 = prepareFractionForOperation(term2);
		return executeOperation(iterm1, iterm2);
	}

	/**
	 * operation execution to be delegeted to implementations
	 * 
	 * @param term1
	 * @param term2
	 * @return
	 */
	public abstract Fraction executeOperation(final Fraction term1, final Fraction term2);

	/**
	 * prepare a fraction object for operation cloning it to avoid affecting
	 * original instance and converting it to improper fraction
	 * 
	 * @param fraction
	 * @return
	 */
	protected Fraction prepareFractionForOperation(final Fraction fraction) {
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "starting to preparation: {0}", fraction.toString());
		}
		Fraction cFraction = fraction.clone();
		convertToImproper(cFraction);
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "finishing to preparation: {0}", cFraction.toString());
		}
		return cFraction;
	}

	/**
	 * given two fractions changes them to have the same denominator by: calculating
	 * least common multiple
	 * 
	 * @param term1
	 * @param term2
	 */
	protected void changeFractionsToSameDenominator(final Fraction term1, final Fraction term2) {
		long lcm = MathUtils.lcm(term1.getDenominator(), term2.getDenominator());
		if (lcm == 0) {
			lcm = 1;
		}
		changeFractionToCommonDenaminator(lcm, term2);
		changeFractionToCommonDenaminator(lcm, term1);
	}

	private void changeFractionToCommonDenaminator(long lcm, Fraction fraction) {
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "starting to change fraction:  to common denominator: {0} {1}",
					new String[] { fraction.toString(), String.valueOf(lcm) });
		}
		if (!fraction.isEmpty() && lcm != fraction.getDenominator()) {
			if (lcm > fraction.getDenominator()) {
				long div = lcm / fraction.getDenominator();
				fraction.setDenominator(fraction.getDenominator() * div);
				fraction.setNumerator(fraction.getNumerator() * div);
			} else {
				long mult = fraction.getDenominator() / lcm;
				fraction.setDenominator(fraction.getDenominator() / mult);
				fraction.setNumerator(fraction.getNumerator() / mult);
			}
		}
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "finishing to change fraction:  to common denominator: {0} {1}",
					new String[] { fraction.toString(), String.valueOf(lcm) });
		}
	}

	/**
	 * simplifies a fraction by using great common divisor
	 * 
	 * @param fraction
	 */
	protected void simplify(Fraction fraction) {
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "starting to fraction simplification for: {0} ", fraction.toString());
		}
		if (fraction.hasFraction()) {
			long gcd = MathUtils.euclidGcd(fraction.getNumerator(), fraction.getDenominator());
			if (gcd > 1 && gcd <= fraction.getDenominator()) {
				fraction.setNumerator(fraction.getNumerator() / gcd);
				fraction.setDenominator(fraction.getDenominator() / gcd);
			}
		}
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "finishing to fraction simplification for: {0} ", fraction.toString());
		}
	}

	/**
	 * convert given fraction to improper
	 * 
	 * @param fraction
	 */
	protected void convertToImproper(final Fraction fraction) {
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "converting fraction to improper: {0} ", fraction.toString());
		}
		if (fraction.hasWholeNumber()) {
			if (!fraction.hasFraction()) {
				fraction.setDenominator(1);
				fraction.setNumerator(fraction.getWholeNumber());
			} else {
				fraction.setNumerator(
						(fraction.getDenominator() * fraction.getWholeNumber()) + fraction.getNumerator());
			}
			fraction.setWholeNumber(0);
		}
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "converted fraction to improper: {0} ", fraction.toString());
		}
	}

	/**
	 * simplifies and then converts fractions to mixed numbers, used for final
	 * representation of the result fraction
	 * 
	 * @param fraction
	 */
	protected void simplifyAndconvertToMixedNumbers(final Fraction fraction) {
		simplify(fraction);
		convertToMixedNumbers(fraction);
	}

	/**
	 * converts fraction to mixe numbers
	 * 
	 * @param fraction
	 */
	protected void convertToMixedNumbers(final Fraction fraction) {
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "converting fraction to mixnumber: {0} ", fraction.toString());
		}
		if (fraction.hasFraction() && fraction.getNumerator() >= fraction.getDenominator()) {
			long c = fraction.getNumerator() / fraction.getDenominator();
			long m = fraction.getNumerator() % fraction.getDenominator();
			fraction.setWholeNumber(fraction.getWholeNumber() + c);
			fraction.setNumerator(m);
			if (m == 0) {
				fraction.setDenominator(0);
			}
		}
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "converted fraction to mixnumber: {0} ", fraction.toString());
		}
	}

}
