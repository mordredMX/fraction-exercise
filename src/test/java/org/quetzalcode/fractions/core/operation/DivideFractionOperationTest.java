package org.quetzalcode.fractions.core.operation;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.FractionException;
import org.quetzalcode.fractions.core.FractionOperationFactory;
import org.quetzalcode.fractions.core.Operator;

public class DivideFractionOperationTest {

	private FractionOperation operation;
	
	@Before
	public void init() {
		operation=FractionOperationFactory.getFractionOperation(Operator.DIVIDE);
	}

	@Test
	public void testCalculateDivMixedNumbers() {
		Fraction term1=new Fraction(1,1,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateImproper() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(0,7,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateImproperPlusMixed() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateDivMixedNumbersBothNegatives() {
		Fraction term1=new Fraction(1,1,2,true);
		Fraction term2=new Fraction(2,1,3,true);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateDivMixedNumbers1stNegative() {
		Fraction term1=new Fraction(1,1,2,true);
		Fraction term2=new Fraction(2,1,3,false);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

	@Test
	public void testCalculateDivMixedNumbers2ndNegative() {
		Fraction term1=new Fraction(1,1,2,false);
		Fraction term2=new Fraction(2,1,3,true);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
	
	@Test
	public void testCalculateWholeNumbers() {
		Fraction term1=new Fraction(8,0,0);
		Fraction term2=new Fraction(4,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateWholeNumbersNegative() {
		Fraction term1=new Fraction(8,0,0,true);
		Fraction term2=new Fraction(4,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
	
	@Test
	public void testCalculateWholeNumbers2() {
		Fraction term1=new Fraction(4,0,0);
		Fraction term2=new Fraction(8,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(2, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	/**
	 * throw error on division
	 */
	@Test(expected= FractionException.class)
	public void testCalculateDivZeroByZero() {
		Fraction term1=new Fraction(0,0,0);
		Fraction term2=new Fraction(0,0,0);
		operation.calculate(term1, term2);

	}
	
	/**
	 * throw error on division
	 */
	@Test(expected=FractionException.class)
	public void testCalculateDivZero() {
		Fraction term1=new Fraction(5,0,0);
		Fraction term2=new Fraction(0,0,0);
		operation.calculate(term1, term2);

	}
	
	@Test
	public void testCalculateDivZeroDivided() {
		Fraction term1=new Fraction(0,0,0);
		Fraction term2=new Fraction(5,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
}
