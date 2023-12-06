/*
 * File name: CounterView.java
 * Author: Abundance Esim, Jaswinder Singh, Jingmei Li
 * Course: CST8288
 * Assignment: Assignment 01
 * Professor: Prof. Reginald Dyer
 * Due Date: March 11, 2022
 */

package assignment01;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This class contains all the controls and components required for the application. It implements the PropertyChangeListener and as a result, it would
 * be registered as a listener for property changes in the model(CounterModel). It would then be populated with the new values for the changed properties.
 * @author Abundance Esim, Jaswinder Singh, Jingmei Li
 *
 */
public class CounterView implements PropertyChangeListener {

	/** textInput is the area where the user would input their text.*/
	private TextArea textInput;     

	/** Label for the number of lines.*/
	private Label lineCountLabel;  
	
	/**Label for the number of words */
	private Label wordCountLabel;   
	
	/**Label for the number of characters.*/
	private Label charCountLabel; 
	
	/**Label for the number of digits.*/
	private Label digitCountLabel;
	
	/**ToolBar containing instructions for the user.*/
	private ToolBar statusBar;

	/**This button would be used to process user input.*/
	private Button countButton;

	/**CounterController object. The view requires a controller object in order to invoke methods on the controller.*/
	private CounterController controller;

	/**
	 * This constructor is used to pass a reference of the controller to the view.
	 * @param controller The object of the CounterController interface which would also be used by Counter class.
	 */
	public CounterView(CounterController controller){
		this.controller = controller;
	} 


	/**
	 * The stage would contain all the elements and controls required to use the application. This would be used in the Counter class.
	 * @param primaryStage The application window.
	 */
	public void start(Stage primaryStage) {
		textInput = new TextArea();
		textInput.setPrefRowCount(20);
		textInput.setPrefColumnCount(50);
		statusBar = new ToolBar();

		createStatusBar();
	
		countButton = new Button("Process the Text");
		countButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	
		/* When an action(e.g click) is performed on the count button, inputs should be processed using the controller's method.*/
		countButton.setOnAction(click -> {       
			controller.processInput(textInput);
		});

		/*Close the application when the Esc key is pressed.*/
		primaryStage.addEventHandler( KeyEvent.KEY_RELEASED, ( KeyEvent event) -> {

			if ( !event.isConsumed() && KeyCode.ESCAPE == event.getCode()) {
				primaryStage.close();
			}
		});
	
		/*Setting label styles*/
		lineCountLabel = createLabel("  Number of lines:", "green");
		wordCountLabel = createLabel("  Number of words:", "red");
		charCountLabel = createLabel("  Number of chars:", "blue");
		digitCountLabel = createLabel("  Number of digits:", "black");
	
		/*Vertical box created for laying out the controls specified vertically.*/
		VBox root = new VBox( 6,new BorderPane(statusBar),textInput, new BorderPane(countButton), 
				lineCountLabel, wordCountLabel, charCountLabel,digitCountLabel);
	
		root.setStyle("-fx-background-color: lightgrey; -fx-border-color: grey; -fx-border-width:5px");

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MicrosoftWord/Word/Char/digit Counter");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	/**
	 * This method creates a label for the application using the arguments specified in the method's parameters.
	 * @param name The label text to be used.
	 * @param textFillColor The color of the label text.
	 * @return label The label created.
	 */
	public Label createLabel(String name, String textFillColor) {
		Label label;
		name = name + " 0";
		label = new Label(name);
		label.setStyle("-fx-text-fill: " + textFillColor + "; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
		label.setMaxWidth(1000);
	
		return label;
	}

	/**
	 * This method is used to create the status bar for the application where the user would get instructions on how to use the application.
	 */
	public void createStatusBar() {

		Label typeText = new Label("Type your text here:");

		typeText.setStyle("-fx-text-fill: black; -fx-font: bold  12pt serif;-fx-padding: 4px;");
		Label exitText = new Label("Press Esc to Exit");
		Pane pane = new Pane();

		HBox.setHgrow(pane, Priority.ALWAYS);

		statusBar.getItems().addAll(typeText, pane, exitText);

	}

	/*
	 * This method would be called whenever there is a change in the value of any of the specified properties.
	 * It would update the specific count required and change the label text to reflect the new value.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		/*Getting the name of the changed property.*/
		String propertyName = evt.getPropertyName();
	
		/*For each changed property, set them to their appropriate labels.*/
		
		if (propertyName.equals("lineCt")) {
			String newLineCt = evt.getNewValue().toString();
			lineCountLabel.setText("  Number of lines:  " + newLineCt);	
		}
	
		if (propertyName.equals("wordCt")) {
			String newWordCt = evt.getNewValue().toString();
			wordCountLabel.setText("  Number of words:  " + newWordCt);	
		}
	
		if (propertyName.equals("charCt")) {
			String newCharCt = evt.getNewValue().toString();
			charCountLabel.setText("  Number of chars:  " + newCharCt);
		}
	
		if (propertyName.equals("digitCt")) {
			String newDigitCt = evt.getNewValue().toString();
			digitCountLabel.setText("  Number of digits:  " + newDigitCt);
		}
	
	}

}
