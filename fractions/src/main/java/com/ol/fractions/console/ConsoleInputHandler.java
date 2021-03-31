package com.ol.fractions.console;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ol.fractions.core.Fraction;
import com.ol.fractions.core.FractionOperationManager;
import com.ol.fractions.core.Operator;

public class ConsoleInputHandler {
	private final static Logger LOGGER = Logger.getLogger(ConsoleInputHandler.class.getName());

	private FractionOperationManager manager;

	private final static Pattern pattern = Pattern.compile(
			"^(?:(\\d+)_{0,1}){0,1}(?:(\\d+)\\/(\\d+)){0,1}\\s+(-|\\*|\\/|\\+)\\s+(?:(\\d+)_{0,1}){0,1}(?:(\\d+)\\/(\\d+)){0,1}$");

	public ConsoleInputHandler(FractionOperationManager manager) {
		this.manager = manager;
	}

	/**
	 * handles input string validates using regular expression and extracts operands
	 * and operator using regex groups to launch the operation
	 * 
	 * @param str
	 */
	public void handleFractionString(final String str) {
		System.out.printf("Fraction operation is: %s\n", str);
		if (str == null || str.trim().length() == 0) {
			throw new IllegalArgumentException("Invalid emtpy parameter: " + str);
		}
		final Matcher matcher = pattern.matcher(str);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Input doesn't match expected format");
		}
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "fraction string is valid: ", str);
		}
		final Fraction fraction1 = new Fraction(matcher.group(1) == null ? 0 : Long.valueOf(matcher.group(1)),
				matcher.group(2) == null ? 0 : Long.valueOf(matcher.group(2)),
				matcher.group(3) == null ? 0 : Long.valueOf(matcher.group(3)));
		final Fraction fraction2 = new Fraction(matcher.group(5) == null ? 0 : Long.valueOf(matcher.group(5)),
				matcher.group(6) == null ? 0 : Long.valueOf(matcher.group(6)),
				matcher.group(7) == null ? 0 : Long.valueOf(matcher.group(7)));
		final Operator operator = manager.validateAndGetOperator(matcher.group(4));
		final Fraction result = manager.executeOperation(fraction1, fraction2, operator);
		System.out.printf("Fraction result: %s\n",result.toString());
	}

}
