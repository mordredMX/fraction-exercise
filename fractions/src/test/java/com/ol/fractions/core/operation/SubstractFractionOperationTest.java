package com.ol.fractions.core.operation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.FractionOperationFactory;
import com.ol.fractions.core.Operator;

public class SubstractFractionOperationTest {
	private FractionOperation operation;
	
	@Before
	public void init() {
		operation=FractionOperationFactory.getFractionOperation(Operator.SUBSTRACT);
	}
	@Test
	public void testCalculateNegSumMixedNumbers() {
		Fraction term1=new Fraction(1,1,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(-5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculateNegImproper() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(0,7,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(-5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculateNegImproperPlusMixed() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(-5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculatePosSumMixedNumbers() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(1,1,2);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculatePosImproper() {
		Fraction term1=new Fraction(0,7,3);
		Fraction term2=new Fraction(0,3,2);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculatePosImproperPlusMixed() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(0,3,2);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculateZeroSubstraction() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(2,2,6);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
	}
	
	@Test
	public void testCalculateWholeNumberMinusFraction() {
		Fraction term1=new Fraction(5,0,0);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(2, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
	}
	@Test
	public void testCalculateWholeNumberMinusFraction2() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(3,0,0);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(-2, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
	}
	
}
