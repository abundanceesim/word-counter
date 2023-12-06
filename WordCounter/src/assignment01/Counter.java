/*
 * File name: Counter.java
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
 * This class is the controller for the application. The Counter class implements the interface CounterController and it is also a Controller object. 
 * This class would communicate with both the model and view to make sure that changes to data are reflected in the appropriate locations.
 * @author Abundance Esim, Jaswinder Singh, Jingmei Li
 */
public class Counter implements CounterController {

	/**
	 * Object of CounterModel.
	 */
	private CounterModel theModel; 
	
	/**
	 * Object of CounterView. It is provided with a reference to the controller.
	 */
	private CounterView theView = new CounterView(this);

	/*This method would process the character, word, line and digit counts of the text in the Text Area.*/
	@Override
    public void processInput(TextArea textInput) {
        theModel.processInputs(textInput);
    }

    /*This method creates the GUI for the application. It would only create a model instance if there is no instance of the model already.*/
    @Override
    public void createGUI(Stage stage) {
        if (theModel == null){
            theModel = new CounterModel();
        }
        addModel(theModel);
        theView.start(stage);
    }

    /*This would be used by the controller to register a property change listener(the view) for the model.*/
    @Override
    public void addModel(CounterModel model) {
        model.addChangeListener(theView);
    }
}	

