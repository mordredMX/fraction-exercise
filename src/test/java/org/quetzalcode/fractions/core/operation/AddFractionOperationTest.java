package org.quetzalcode.fractions.core.operation;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.FractionOperationFactory;
import org.quetzalcode.fractions.core.Operator;

public class AddFractionOperationTest {
	private FractionOperation operation;

	@Before
	public void init() throws SecurityException, IOException {
//		 LogManager.getLogManager().readConfiguration(AddFractionOperationTest.class.getResourceAsStream("/logging.properties"));
		operation = FractionOperationFactory.getFractionOperation(Operator.ADD);
	}

	@Test
	public void testCalculateAddMixedNumbers() {
		Fraction term1 = new Fraction(1, 1, 2);
		Fraction term2 = new Fraction(2, 1, 3);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddImproper() {
		Fraction term1 = new Fraction(0, 3, 2);
		Fraction term2 = new Fraction(0, 7, 3);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddImproperPlusMixed() {
		Fraction term1 = new Fraction(0, 3, 2);
		Fraction term2 = new Fraction(2, 1, 3);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(3, result.getWholeNumber());
		Assert.assertEquals(5, result.getNumerator());
		Assert.assertEquals(6, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddWholeNumberPlusFraction() {
		Fraction term1 = new Fraction(5, 0, 0);
		Fraction term2 = new Fraction(2, 1, 3);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(7, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddWholeNumberPlusFraction2() {
		Fraction term1 = new Fraction(2, 1, 3);
		Fraction term2 = new Fraction(3, 0, 0);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(5, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddWholeNumberPlusFractionNegatives() {
		Fraction term1 = new Fraction(2, 1, 3, true);
		Fraction term2 = new Fraction(3, 0, 0, true);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(5, result.getWholeNumber());
		Assert.assertEquals(1, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

	@Test
	public void testCalculateAddWholeNumberPlusNegativeFraction() {
		Fraction term1 = new Fraction(2, 1, 3, true);
		Fraction term2 = new Fraction(3, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(2, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddNegativeWholeNumberPlusFraction() {
		Fraction term1 = new Fraction(2, 1, 3, false);
		Fraction term2 = new Fraction(3, 0, 0, true);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(0, result.getWholeNumber());
		Assert.assertEquals(2, result.getNumerator());
		Assert.assertEquals(3, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

	@Test
	public void testCalculateAddZeroToWholeNumber() {
		Fraction term1 = new Fraction(2, 0, 0, false);
		Fraction term2 = new Fraction(0, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddWholeNumberToZero() {
		Fraction term1 = new Fraction(0, 0, 0, false);
		Fraction term2 = new Fraction(2, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
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
	public void testCalculateAddTwoWholeNumbers() {
		Fraction term1 = new Fraction(4, 0, 0, false);
		Fraction term2 = new Fraction(2, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(6, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddTwoWholeNumbersFirstNegative() {
		Fraction term1 = new Fraction(4, 0, 0, true);
		Fraction term2 = new Fraction(2, 0, 0, false);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

	@Test
	public void testCalculateAddTwoWholeNumbersSecondNegative() {
		Fraction term1 = new Fraction(4, 0, 0, false);
		Fraction term2 = new Fraction(2, 0, 0, true);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(2, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertFalse(result.isNegative());
	}

	@Test
	public void testCalculateAddTwoWholeNumbersBothNegatives() {
		Fraction term1 = new Fraction(4, 0, 0, true);
		Fraction term2 = new Fraction(2, 0, 0, true);
		Fraction result = operation.calculate(term1, term2);
		Assert.assertEquals(6, result.getWholeNumber());
		Assert.assertEquals(0, result.getNumerator());
		Assert.assertEquals(0, result.getDenominator());
		Assert.assertTrue(result.isNegative());
	}

}
