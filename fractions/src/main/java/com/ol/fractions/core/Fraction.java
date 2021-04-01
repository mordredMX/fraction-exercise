package com.ol.fractions.core;

/**
 * Fraction entity 
 * @author OBarenque
 *
 */
public final class Fraction {
	private long denominator;
	private long wholeNumber;
	private long numerator;
	private boolean negative;

	public Fraction(final long wholeNumber, final long numerator, final long denominator) {
		this(wholeNumber,numerator,denominator,Boolean.FALSE);
	}
	
	public Fraction(final long wholeNumber, final long numerator, final long denominator,final boolean negative) {
		super();
		this.setWholeNumber(wholeNumber );
		this.setNumerator(numerator);
		this.setDenominator(denominator);
		this.setNegative(negative);
	}

	private Fraction(final Fraction fraction) {
		this.wholeNumber=fraction.wholeNumber;
		this.numerator=fraction.numerator; 
		this.denominator=fraction.denominator;
		this.negative=fraction.negative;
	}
	
	public void setNegative(final boolean negative) {
		this.negative=negative;
	}
	
	public boolean isNegative() {
		return this.negative;
	}

	public void setNumerator(final long numerator) {
		this.numerator = Math.abs(numerator);
	}

	public void setDenominator(final long denominator) {
		this.denominator = Math.abs(denominator);
	}

	public void setWholeNumber(final long wholeNumber) {
		this.wholeNumber = Math.abs(wholeNumber);
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
	
	public boolean isEmpty() {
		return !hasFraction() && !hasWholeNumber(); 
	}

	@Override
	public Fraction clone() {
		return new Fraction(this);
	}

	public long getWholeNumber() {
		return wholeNumber;
	}
	public long getSignedWholeNumber() {
		return negative?(wholeNumber*-1):wholeNumber;
	}

	public long getNumerator() {
		return numerator;
	}
	public long getSignedNumerator() {
		return negative?(numerator*-1):numerator;
	}

	public long getDenominator() {
		return denominator;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (denominator ^ (denominator >>> 32));
		result = prime * result + (negative ? 1231 : 1237);
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
		if (negative != other.negative)
			return false;
		if (numerator != other.numerator)
			return false;
		if (wholeNumber != other.wholeNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(!hasWholeNumber() && !hasFraction()) {
			return String.valueOf(wholeNumber);
		}
		StringBuilder sb = new StringBuilder();
		if(isNegative()) {
			sb.append("-");
		}
		if (hasWholeNumber()) {
			sb.append(wholeNumber);
		}
		if(hasFraction()) {
			if(hasWholeNumber()) {
				sb.append("_");
			}
			sb.append(numerator).append("/").append(denominator);
		}
		return sb.toString();
	}
}

