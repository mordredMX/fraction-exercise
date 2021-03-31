package com.ol.fractions.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ol.fractions.core.operation.FractionOperation;
import com.ol.fractions.core.util.FractionUtils;


public class FractionOperationManager {
	private final static Logger LOGGER = Logger.getLogger(FractionOperationManager.class.getName());

	public Operator validateAndGetOperator(final String str) {

		for (Operator o : Operator.values()) {
			if (o.getOperatorString().equals(str)) {
				if(LOGGER.isLoggable(Level.FINE)){
					LOGGER.log(Level.FINE, "validating operator: {0} ",o.name() );
				}
				return o;
			}
		}
		throw new IllegalArgumentException("Not valid operator: " + str);
	}

	public Fraction executeOperation(final Fraction term1, final Fraction term2, final Operator operator) {
		if(LOGGER.isLoggable(Level.INFO)){
			LOGGER.log(Level.INFO, "Starting process for operation: {0}",FractionUtils.convertToStringOperation(term1, term2, operator));
		}
		try {
			final FractionOperation fractionOperation = FractionOperationFactory.getFractionOperation(operator);
			final Fraction fraction = fractionOperation.calculate(term1, term2);
			if(LOGGER.isLoggable(Level.INFO)){
				LOGGER.log(Level.INFO, "Finishing process for operation with result: {0}",fraction);
			}
			return fraction;
		} 
		catch(FractionException e) {
			LOGGER.log(Level.FINE,"Error while executing operation",e);
			throw e;
		}
		catch (Exception e) {
			throw new FractionException("Error while executing operation", e);
		}

	}


}
