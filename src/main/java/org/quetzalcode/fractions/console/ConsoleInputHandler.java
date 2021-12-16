package org.quetzalcode.fractions.console;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.quetzalcode.fractions.core.Fraction;
import org.quetzalcode.fractions.core.FractionOperationManager;
import org.quetzalcode.fractions.core.Operator;

/**
 * Handles input from console, validates and translates to fraction objects
 * @author OBarenque
 *
 */
public class ConsoleInputHandler {
	private final static Logger LOGGER = Logger.getLogger(ConsoleInputHandler.class.getName());

	private final FractionOperationManager manager;

	final static Pattern EXPRESSION_REGEX = Pattern.compile("^\\s*(.+)\\s+(-|\\*|\\/|\\+)\\s+(.+)\\s*$");
	
	final static Pattern FRACTION_TERM_REGEX = Pattern.compile("^(-)?(?:(\\d*)_)?(\\d+)\\/(\\d+)$");
	
	final static Pattern WHOLE_NUMBER_TERM_REGEX = Pattern.compile("^(-)?(\\d+)$");
	
	public ConsoleInputHandler(final FractionOperationManager manager) {
		this.manager = manager;
	}
	
	/**
	 * convert term  to fraction.
	 * @param term term in string
	 * @return Fraction
	 */
	private Fraction createFractionFromString(final String term) {
		final Matcher fMatcher = FRACTION_TERM_REGEX.matcher(term);
		if (fMatcher.matches()) {
			return new Fraction(fMatcher.group(2) == null ? 0 : Long.parseLong(fMatcher.group(2)),
					fMatcher.group(3) == null ? 0 : Long.parseLong(fMatcher.group(3)),
							fMatcher.group(4) == null ? 0 : Long.parseLong(fMatcher.group(4)),fMatcher.group(1)!=null);
		}
		final Matcher wMatcher= WHOLE_NUMBER_TERM_REGEX.matcher(term);
		if (wMatcher.matches()) {
			return new Fraction(Long.parseLong(wMatcher.group(2)), 0, 0,wMatcher.group(1)!=null);
		}
		throw new IllegalArgumentException("Term doesn't match expected format: "+term);
		
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
		final Matcher matcher = EXPRESSION_REGEX.matcher(str);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Input doesn't match expected format");
		}
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.log(Level.FINE, "fraction string is valid: ", str);
		}
		final Fraction fraction1 = createFractionFromString(matcher.group(1));
		final Fraction fraction2 = createFractionFromString(matcher.group(3));
		final Operator operator = manager.validateAndGetOperator(matcher.group(2));
		final Fraction result = manager.executeOperation(fraction1, fraction2, operator);
		System.out.printf("Fraction result: %s\n",result.toString());
	}

}
