package com.ol.fractions.core.util;

/**
 * Math methods used for fractions
 * @author OBarenque
 *
 */
public class MathUtils {
	
	/**
	 * least common multiple
	 * @param a
	 * @param b
	 * @return
	 */
	public static long lcm(long a, long b) {
		return (a * b) / euclidGcd(a, b);
	}

	/**
	 * greatest common divisor calculator
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long euclidGcd(long a, long b) {
		a=Math.abs(a);
		b=Math.abs(b);
		long t = 0;
		if (b > a) {
			t = b;
			b = a;
			a = t;
		} 
		while (b != 0) {
			t = a;
			a = b;
			b = t % b;
		}
		return a;
	}

}
