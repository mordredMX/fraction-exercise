package org.quetzalcode.fractions.core.operation;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.FractionOperationFactory;
import org.quetzalcode.fractions.core.Operator;

public class SubstractFractionOperationTest {
	private FractionOperation operation;
	
	@Before
	public void init() throws SecurityException, IOException {
//		 LogManager.getLogManager().readConfiguration(AddFractionOperationTest.class.getResourceAsStream("/logging.properties"));
		operation=FractionOperationFactory.getFractionOperation(Operator.SUBSTRACT);
	}
	@Test
	public void testCalculateSubsNegSumMixedNumbers() {
		Fraction term1=new Fraction(1,1,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
	@Test
	public void testCalculateSubsNegImproper() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(0,7,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
	@Test
	public void testCalculateSubsNegImproperPlusMixed() {
		Fraction term1=new Fraction(0,3,2);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
	@Test
	public void testCalculateSubsPosSumMixedNumbers() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(1,1,2);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateSubsPosImproper() {
		Fraction term1=new Fraction(0,7,3);
		Fraction term2=new Fraction(0,3,2);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateSubsPosImproperPlusMixed() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(0,3,2);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateSubsZeroSubstraction() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(2,2,6);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	
	@Test
	public void testCalculateSubsWholeNumberMinusFraction() {
		Fraction term1=new Fraction(5,0,0);
		Fraction term2=new Fraction(2,1,3);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(2, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}
	@Test
	public void testCalculateSubsWholeNumberMinusFraction2() {
		Fraction term1=new Fraction(2,1,3);
		Fraction term2=new Fraction(3,0,0);
		Fraction result=operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(2, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
	
	@Test
	public void testCalculateSubsWholeNumberPlusFractionNegatives() {
		Fraction term1 = new Fraction(2, 1, 3, true);
		Fraction term2 = new Fraction(3, 0, 0, true);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(2, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateSubsWholeNumberPlusNegativeFraction() {
		Fraction term1 = new Fraction(2, 1, 3, true);
		Fraction term2 = new Fraction(3, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(5, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

	@Test
	public void testCalculateSubsNegativeWholeNumberPlusFraction() {
		Fraction term1 = new Fraction(2, 1, 3, false);
		Fraction term2 = new Fraction(3, 0, 0, true);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(5, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateSubsZeroToWholeNumber() {
		Fraction term1 = new Fraction(2, 0, 0, false);
		Fraction term2 = new Fraction(0, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateSbusWholeNumberToZero() {
		Fraction term1 = new Fraction(0, 0, 0, false);
		Fraction term2 = new Fraction(2, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

	@Test
	public void testCalculateAddZeroToZero() {
		Fraction term1 = new Fraction(0, 0, 0, false);
		Fraction term2 = new Fraction(0, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateSubsTwoWholeNumbers() {
		Fraction term1 = new Fraction(4, 0, 0, false);
		Fraction term2 = new Fraction(2, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateSubsTwoWholeNumbersFirstNegative() {
		Fraction term1 = new Fraction(4, 0, 0, true);
		Fraction term2 = new Fraction(2, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(6, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

	@Test
	public void testCalculateSubsTwoWholeNumbersSecondNegative() {
		Fraction term1 = new Fraction(4, 0, 0, false);
		Fraction term2 = new Fraction(2, 0, 0, true);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(6, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddTwoWholeNumbersBothNegatives() {
		Fraction term1 = new Fraction(4, 0, 0, true);
		Fraction term2 = new Fraction(2, 0, 0, true);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}
	
}
