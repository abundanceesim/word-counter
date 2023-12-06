/*
 * File name: CounterController.java
 * Author: Abundance Esim, Jaswinder Singh, Jingmei Li
 * Course: CST8288
 * Assignment: Assignment 01
 * Professor: Prof. Reginald Dyer
 * Due Date: March 11, 2022
 */

package assignment01;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * CounterController is an interface which is realized by the Counter class. It contains methods that would enable the CounterModel, CounterView and
 * Counter classes interact with each other.
 * @author Abundance Esim, Jaswinder Singh, Jingmei Li
 *
 */
public interface CounterController {

	/**
	 * This would be used by the controller to register a property change listener(the view) for the model.
	 * @param model The model that requires a listener.
	 */
	public void addModel(CounterModel model);
	
	/**
	 * This is used to create the application's GUI.
	 * @param stage The application window.
	 */
	public void createGUI(Stage stage);
	
	/**
	 * This method would be used to process and calculate the number of characters, lines, words and digits in the 
	 * text input by the user into the text area.
	 * @param textInput The text input in the text area.
	 */
	public void processInput(TextArea textInput);
	
}
