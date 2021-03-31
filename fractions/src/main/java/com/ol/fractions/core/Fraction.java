package com.ol.fractions.core;

/**
 * Fraction entity 
 * @author OBarenque
 *
 */
public class Fraction {
	private long denominator;
	private long wholeNumber;
	private long numerator;

	public Fraction(final long wholeNumber, final long numerator, final long denominator) {
		super();
		this.wholeNumber = wholeNumber;
		this.numerator = numerator;
		this.denominator = denominator;
	}

	private Fraction(final Fraction fraction) {
		this.wholeNumber=fraction.wholeNumber;
		this.numerator=fraction.numerator; 
		this.denominator=fraction.denominator;
	}

	public void setNumerator(final long numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(final long denominator) {
		this.denominator = denominator;
	}

	public void setWholeNumber(final long wholeNumber) {
		this.wholeNumber = wholeNumber;
	}

	public boolean isImproper() {
		return numerator > denominator;
	}

	public boolean hasWholeNumber() {
		return wholeNumber != 0;
	}

	public boolean hasFraction() {
		return !(numerator == 0 || denominator == 0);
	}

	@Override
	public Fraction clone() {
		return new Fraction(this);
	}

	public long getWholeNumber() {
		return wholeNumber;
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (denominator ^ (denominator >>> 32));
		result = prime * result + (int) (numerator ^ (numerator >>> 32));
		result = prime * result + (int) (wholeNumber ^ (wholeNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		if (wholeNumber != other.wholeNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (hasWholeNumber()) {
			sb.append(wholeNumber).append("_");
		}
		sb.append(numerator).append("/").append(denominator);
		return sb.toString();
	}
}

