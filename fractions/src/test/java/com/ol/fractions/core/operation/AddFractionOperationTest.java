package com.ol.fractions.core.operation;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.FractionOperationFactory;
import com.ol.fractions.core.Operator;


public class AddFractionOperationTest {
	private FractionOperation operation;
	
	@Before
	public void init() {
		operation=FractionOperationFactory.getFractionOperation(Operator.ADD);
	}

	@Test
	public void testCalculateSumMixedNumbers() {
		Fraction term1=new Fraction(1,1,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculateImproper() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(0,7,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculateImproperPlusMixed() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
	}
	
	@Test
	public void testCalculateWholeNumberPlusFraction() {
		Fraction term1=new Fraction(5,0,0);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(7, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
	}
	@Test
	public void testCalculateWholeNumberPlusFraction2() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(3,0,0);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(5, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
	}
	

}
