package com.ol.fractions.core;

/**
 * Enum that contains the supported fraction operation/operators
 * @author OBarenque
 *
 */
public enum Operator {
	MULTIPLY("*"),DIVIDE("/"),ADD("+"),SUBSTRACT("-");
	
	private String operatorString;
	private Operator(final String operatorString) {
		this.operatorString=operatorString;
	}
	
	public String getOperatorString() {
		return operatorString;
	}
}
