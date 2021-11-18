package org.quetzalcode.fractions.core.operation;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.FractionException;
import org.quetzalcode.fractions.core.FractionOperationFactory;
import org.quetzalcode.fractions.core.Operator;

public class MultiplyFractionOperationTest {

	private FractionOperation operation;
	
	@Before
	public void init() {
		operation=FractionOperationFactory.getFractionOperation(Operator.MULTIPLY);
	}

	@Test
	public void testCalculateMultMixedNumbers() {
		Fraction term1=new Fraction(1,1,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(2, result.getDenominator());
	}
	
	@Test
	public void testCalculateMultImproper() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(0,7,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(2, result.getDenominator());
	}
	
	@Test
	public void testCalculateMultPlusMixed() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(2, result.getDenominator());
	}
	
	@Test
	public void testCalculateMultMixedNumbersBothNegatives() {
		Fraction term1=new Fraction(1,1,2,true);
		Fraction term2=new Fraction(2,1,3,true);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(2, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateMultMixedNumbers1stNegative() {
		Fraction term1=new Fraction(1,1,2,true);
		Fraction term2=new Fraction(2,1,3,false);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(2, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

	@Test
	public void testCalculateMultMixedNumbers2ndNegative() {
		Fraction term1=new Fraction(1,1,2,false);
		Fraction term2=new Fraction(2,1,3,true);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(2, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
	
	@Test
	public void testCalculateWholeNumbers() {
		Fraction term1=new Fraction(8,0,0);
		Fraction term2=new Fraction(4,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(32, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateWholeNumbersNegative() {
		Fraction term1=new Fraction(8,0,0,true);
		Fraction term2=new Fraction(4,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(32, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
	
	@Test
	public void testCalculateWholeNumbers2() {
		Fraction term1=new Fraction(4,0,0);
		Fraction term2=new Fraction(8,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(32, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	

	@Test
	public void testCalculateMultZeroByZero() {
		Fraction term1=new Fraction(0,0,0);
		Fraction term2=new Fraction(0,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	
	@Test(expected = FractionException.class)
	public void testCalculateMultMumeratorEmtpy() {
		Fraction term1=new Fraction(0,0,5);
		Fraction term2=new Fraction(1,3,4);
		operation.calculate(term1, term2);
	}
	
	@Test(expected = FractionException.class)
	public void testCalculateMultNumeratorEmtpy2() {
		Fraction term1=new Fraction(0,0,5);
		Fraction term2=new Fraction(1,3,4);
		operation.calculate(term2, term1);
	}
	
	@Test(expected = FractionException.class)
	public void testCalculateMultDenominatorEmtpy() {
		Fraction term1=new Fraction(0,5,0);
		Fraction term2=new Fraction(1,3,4);
		operation.calculate(term1, term2);
	}
	
	@Test(expected = FractionException.class)
	public void testCalculateMultDenominatorEmtpy2() {
		Fraction term1=new Fraction(0,5,0);
		Fraction term2=new Fraction(1,3,4);
		operation.calculate(term2, term1);
	}
	@Test
	public void testCalculateMultZero() {
		Fraction term1=new Fraction(5,0,0);
		Fraction term2=new Fraction(0,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateMultZero2() {
		Fraction term1=new Fraction(0,0,0);
		Fraction term2=new Fraction(5,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
}
