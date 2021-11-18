package org.quetzalcode.fractions.core;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class FractionOperationManagerTest {
	
	private FractionOperationManager operationManager;
	
	@Before
	public void init() {
		operationManager=new FractionOperationManager();
	}

	@Test
	public void testExecuteOperation1() {
		Fraction term1=new Fraction(1,1,2);
		Fraction term2=new Fraction(0,1,4);
		Fraction result=operationManager.executeOperation(term1, term2, Operator.ADD);
		Assert.assertEquals(result.getWholeNumber(), 1);
		Assert.assertEquals(result.getNumerator(), 3);
		Assert.assertEquals(result.getDenominator(), 4);
	}
	
	@Test
	public void testExecuteOperation2() {
		Fraction term1=new Fraction(1,1,2);
		Fraction term2=new Fraction(1,1,4);
		Fraction result=operationManager.executeOperation(term1, term2, Operator.SUBSTRACT);
		Assert.assertEquals(result.getWholeNumber(), 0);
		Assert.assertEquals(result.getNumerator(), 1);
		Assert.assertEquals(result.getDenominator(), 4);
	}
	
	@Test
	public void testExecuteOperation3() {
		Fraction term1=new Fraction(0,3,7);
		Fraction term2=new Fraction(0,6,5);
		Fraction result=operationManager.executeOperation(term1, term2, Operator.DIVIDE);
		Assert.assertEquals(result.getWholeNumber(), 0);
		Assert.assertEquals(result.getNumerator(), 5);
		Assert.assertEquals(result.getDenominator(), 14);
	}
	
	@Test
	public void testExecuteOperation4() {
		Fraction term1=new Fraction(0,2,3);
		Fraction term2=new Fraction(0,5,6);
		Fraction result=operationManager.executeOperation(term1, term2, Operator.MULTIPLY);
		Assert.assertEquals(result.getWholeNumber(), 0);
		Assert.assertEquals(result.getNumerator(), 5);
		Assert.assertEquals(result.getDenominator(), 9);
	}
}
