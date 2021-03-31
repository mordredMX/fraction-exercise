package com.ol.fractions.core.operation;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.FractionOperationFactory;
import com.ol.fractions.core.Operator;

public class DivideFractionOperationTest {

	private FractionOperation operation;
	
	@Before
	public void init() {
		operation=FractionOperationFactory.getFractionOperation(Operator.DIVIDE);
	}

	@Test
	public void testCalculateSumMixedNumbers() {
		Fraction term1=new Fraction(1,1,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
	}
	
	@Test
	public void testCalculateImproper() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(0,7,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
	}
	
	@Test
	public void testCalculateImproperPlusMixed() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		System.out.println(result);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(9, result.getNumerator());
		Assert.assertEquals(14, result.getDenominator());
	}

}
