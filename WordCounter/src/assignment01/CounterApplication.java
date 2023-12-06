/*
 * File name: CounterApplication.java
 * Author: Abundance Esim, Jaswinder Singh, Jingmei Li
 * Course: CST8288
 * Assignment: Assignment 01
 * Professor: Prof. Reginald Dyer
 * Due Date: March 11, 2022
 */

package assignment01;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class is the main class in this application. It inherits methods from Application class and would be used to launch the Word Counter application.
 * @author Abundance Esim, Jaswinder Singh, Jingmei Li
 *
 */
public class CounterApplication extends Application {
	/**
	 * Controller object, its createGUI method would be used to create the stage for the application.
	 */
	private Counter controller = new Counter();
	
	/**
	 * This is the main entry point for the application.
	 * @param args The command line arguments passed.
	 */
	public static void main(String[] args) {
		javafx.application.Application.launch(CounterApplication.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		controller.createGUI(stage);
	}

}
