package com.ol.fractions.core;

/**
 * Exception to handle errors found in fraction calculation
 * @author OBarenque
 *
 */
public class FractionException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6953202502110601379L;

	public FractionException() {
		super();
	}

	public FractionException(final String message,final Throwable cause) {
		super(message, cause);
	}

	public FractionException(final String s) {
		super(s);
	}

	public FractionException(final Throwable cause) {
		super(cause);
	}
	

}
