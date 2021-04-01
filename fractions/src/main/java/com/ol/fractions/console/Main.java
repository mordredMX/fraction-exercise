package com.ol.fractions.console;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ol.fractions.core.FractionOperationManager;

/**
 * Main class for console application to execute fractions operations
 * @author OBarenque
 *
 */
public class Main {
	
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	private ConsoleInputHandler inputHandler;

	public void init() {
		inputHandler = new ConsoleInputHandler(new FractionOperationManager());
	}

	public void start() {
		try (Scanner sc = new Scanner(System.in)) {
			String str = null;
			while (true) {
				System.out.println("Enter a fraction operation ('1_1/2 + 3/5', '1/5 / 1', '1/5 * 3/2'): ");
				if(!sc.hasNextLine()) {
					System.out.println("Application is terminated");
					break;
				}
				str = sc.nextLine(); 
				try {
					inputHandler.handleFractionString(str);
				} catch (Exception e) {
					System.err.println(String.format("Error while procesing operation",e.getMessage()));
					LOGGER.log(Level.SEVERE, String.format("Error while processing: %s",str), e);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Main main=new Main();
		main.init();
		main.start();
	}

}
