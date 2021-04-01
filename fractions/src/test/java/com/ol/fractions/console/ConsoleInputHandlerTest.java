package com.ol.fractions.console;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.FractionOperationManager;
import com.ol.fractions.core.Operator;

/**
 * tested several valid and invalid combination of console input expression
 * @author OBarenque
 *
 */
public class ConsoleInputHandlerTest {
	private ConsoleInputHandler console;
	private FractionOperationManager manager;

	@Before
	public void setUp() throws Exception {
		manager=Mockito.mock(FractionOperationManager.class);
		console= new ConsoleInputHandler(manager);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testHandleFractionStringEmpty() {
		console.handleFractionString("");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testHandleFractionStringSpaces() {
		console.handleFractionString("  ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testHandleFractionStringInvalidExpression() {
		console.handleFractionString(" fsfsf sfs");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHandleFractionStringNull() {
		console.handleFractionString(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHandleFractionStringInvalidTerm() {
		console.handleFractionString("A + 1");
	}
	
	@Test
	public void testHandleFractionStringValid1() {
		Mockito.when(manager.validateAndGetOperator("+")).thenReturn(Operator.ADD);
		Mockito.when(manager.executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class))).thenReturn(new Fraction(0,0,0));
		console.handleFractionString("1/2 + 1/2");
		Mockito.verify(manager,Mockito.atLeastOnce()).validateAndGetOperator("+");
		Mockito.verify(manager,Mockito.atLeastOnce()).executeOperation(new Fraction(0,1,2), new Fraction(0,1,2), Operator.ADD);
	}

	
	@Test
	public void testHandleFractionStringValid2() {
		Mockito.when(manager.validateAndGetOperator("/")).thenReturn(Operator.DIVIDE);
		Mockito.when(manager.executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class))).thenReturn(new Fraction(0,0,0));
		console.handleFractionString("4_1/5 / -1/5");
		Mockito.verify(manager,Mockito.atLeastOnce()).validateAndGetOperator("/");
		Mockito.verify(manager,Mockito.atLeastOnce()).executeOperation(new Fraction(4,1,5), new Fraction(0,1,5,true), Operator.DIVIDE);
	}
	
	
	@Test
	public void testHandleFractionStringValid3() {
		Mockito.when(manager.validateAndGetOperator("+")).thenReturn(Operator.ADD);
		Mockito.when(manager.executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class))).thenReturn(new Fraction(0,0,0));
		console.handleFractionString("4 + 2");
		Mockito.verify(manager,Mockito.atLeastOnce()).validateAndGetOperator("+");
		Mockito.verify(manager,Mockito.atLeastOnce()).executeOperation(new Fraction(4,0,0), new Fraction(2,0,0), Operator.ADD);
	}
	
	@Test
	public void testHandleFractionStringValid4() {
		Mockito.when(manager.validateAndGetOperator("*")).thenReturn(Operator.MULTIPLY);
		Mockito.when(manager.executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class))).thenReturn(new Fraction(0,0,0));
		console.handleFractionString("31/5 * 5");
		Mockito.verify(manager,Mockito.atLeastOnce()).validateAndGetOperator("*");
		Mockito.verify(manager,Mockito.atLeastOnce()).executeOperation(new Fraction(0,31,5), new Fraction(5,0,0), Operator.MULTIPLY);
	}
	
	@Test
	public void testHandleFractionStringValid5() {
		Mockito.when(manager.validateAndGetOperator("*")).thenReturn(Operator.MULTIPLY);
		Mockito.when(manager.executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class))).thenReturn(new Fraction(0,0,0));
		console.handleFractionString("0 * 0");
		Mockito.verify(manager,Mockito.atLeastOnce()).validateAndGetOperator("*");
		Mockito.verify(manager,Mockito.atLeastOnce()).executeOperation(new Fraction(0,0,0), new Fraction(0,0,0), Operator.MULTIPLY);
	}
	
	@Test
	public void testHandleFractionStringValid6() {
		Mockito.when(manager.validateAndGetOperator("+")).thenReturn(Operator.ADD);
		Mockito.when(manager.executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class))).thenReturn(new Fraction(0,0,0));
		console.handleFractionString("1_4/5 + 5_6/8");
		Mockito.verify(manager,Mockito.atLeastOnce()).validateAndGetOperator("+");
		Mockito.verify(manager,Mockito.atLeastOnce()).executeOperation(new Fraction(1,4,5), new Fraction(5,6,8), Operator.ADD);
	}
	
	@Test
	public void testHandleFractionStringValid7() {
		Mockito.when(manager.validateAndGetOperator("-")).thenReturn(Operator.SUBSTRACT);
		Mockito.when(manager.executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class))).thenReturn(new Fraction(0,0,0));
		console.handleFractionString("2 - -3_1/5");
		Mockito.verify(manager,Mockito.atLeastOnce()).validateAndGetOperator("-");
		Mockito.verify(manager,Mockito.atLeastOnce()).executeOperation(new Fraction(2,0,0), new Fraction(3,1,5,true), Operator.SUBSTRACT);
	}
	
	
	
}
