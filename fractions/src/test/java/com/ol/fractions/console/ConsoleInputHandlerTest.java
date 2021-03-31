package com.ol.fractions.console;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.FractionOperationManager;
import com.ol.fractions.core.Operator;

public class ConsoleInputHandlerTest {
	private ConsoleInputHandler console;
	private FractionOperationManager manager;

	@Before
	public void setUp() throws Exception {
		manager=Mockito.mock(FractionOperationManager.class);
		console= new ConsoleInputHandler(manager);
		Mockito.when(manager.validateAndGetOperator(Mockito.anyString())).thenReturn(Operator.ADD);
		Mockito.when(manager.executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class))).thenReturn(new Fraction(0,0,0));
	}

	@Test
	public void testHandleFractionString() {
		console.handleFractionString("1/2 + 1/2");
		Mockito.verify(manager,Mockito.atLeastOnce()).validateAndGetOperator(Mockito.anyString());
		Mockito.verify(manager,Mockito.atLeastOnce()).executeOperation(Mockito.any(Fraction.class), Mockito.any(Fraction.class), Mockito.any(Operator.class));
	}

}
