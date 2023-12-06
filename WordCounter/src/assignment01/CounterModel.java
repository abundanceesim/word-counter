/*
 * File name: CounterModel.java
 * Author: Abundance Esim, Jaswinder Singh, Jingmei Li
 * Course: CST8288
 * Assignment: Assignment 01
 * Professor: Prof. Reginald Dyer
 * Due Date: March 11, 2022
 */

package assignment01;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.scene.control.TextArea;

/**
 * CounterModel would perform the data manipulation required by the application. It contains the data for the application and would communicate with 
 * both the view and the controller. It uses PropertyChangeSupport to notify listeners that data has changed.
 * @author Abundance Esim, Jaswinder Singh, Jingmei Li
 */
public class CounterModel {
	
	/** PropertyChangeSupport object. It contains methods to alert listeners of changes to bound properties.*/
	private PropertyChangeSupport support;
	
	/**Number of characters.*/
	private int charCt;
		
	/**Number of words.*/
	private int wordCt;
		
	/**Number of lines.*/
	private int lineCt;
		
	/**Number of digits.*/
	private int digitCt;
		
	/**
	 * Constructor for CounterModel, it creates an instance of the PropertyChangeSupport class and passes it a reference to this class.
	 */
    public CounterModel() {
    	support = new PropertyChangeSupport(this);
    }

	/**
	 * This method registers a property change listener with the Property Change Support.
	 * @param listener The Property Change Listener to be added.
	 */
	public void addChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}
	
	/**
	 * This method removes a property change listener from the list of registered Property Change Listeners.
	 * @param listener The Property Change Listener to be removed.
	 */
	public void removeChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
	
	/*Notify all listeners that the certain property has changed from its old value to its new value*/
	/**
	 * This method would notify all Property Change Listeners that a certain bound property has changed from its old value to a new one.
	 * @param propertyName The name of the property.
	 * @param oldValue The old value of the property.
	 * @param newValue The new value of the property.
	 */
	public void setNewValue(String propertyName, int oldValue, int newValue) {
		support.firePropertyChange(propertyName, oldValue, newValue);
	}
	
	/**
	 * This method would be used to process and calculate the number of characters, lines, words and digits in the 
	 * text input by the user into the text area.
	 * @param textInput The text input in the text area.
	 */
	public void processInputs(TextArea textInput){
    	
		String text;

		/* Character, word, line and digits  counts.*/
		int charCts, wordCts, lineCts, digitCts;  

		charCts = charCt;
		wordCts = wordCt;
		lineCts = lineCt;
		digitCts = digitCt;
		
		/*text variable is the text gotten from the Text Area*/
		text = textInput.getText();
		
		/*charCt is the length of the text string.*/
		charCt = text.length();
		

		/* Compute the wordCt by counting the number of characters
	              in the text that lie at the beginning of a word.  The
	              beginning of a word is a letter such that the preceding
	              character is not a letter. If the letter is the first character in the
	              text, then it is the beginning of a word.  If the letter
	              is preceded by an apostrophe, and the apostrophe is
	              preceded by a letter, than its not the first character
	              in a word.
		 */
		wordCt = 0;
		for (int i = 0; i < charCt; i++) {
			boolean startOfWord;
			if ( Character.isLetter(text.charAt(i)) == false )
				startOfWord = false;
			else if (i == 0)
				startOfWord = true;
			else if ( Character.isLetter(text.charAt(i-1)) )
				startOfWord = false;
			else if ( text.charAt(i-1) == '\'' && i > 1 
					&& Character.isLetter(text.charAt(i-2)) )
				startOfWord = false;
			else
				startOfWord = true;
			if (startOfWord)
				wordCt++;
		}

		/*Line count is computed if the enter key is pressed or if there is any character present on a line.*/
		lineCt = 0;
		for (int i = 0; i < charCt; i++) {
			if (text.charAt(i) == '\n')
		            lineCt++;
		}
		if(charCt!=0) {
	        lineCt++;
	    }
		
		/*Compute digit count by checking if the character at the current index is a digit.*/
		digitCt = 0;
		for (int i = 0; i < charCt; i++) {
			if ( Character.isDigit(text.charAt(i)))
				digitCt++;
		}
		
		/*Recomputing the character count to ignore whitespaces and the enter key.*/
		charCt = (int)text.chars().filter(ch -> (ch != ' ') && (ch != '\n')).count();
		
		/*Notify listeners that properties have changed from their old values to the new ones.*/
		setNewValue("charCt", charCts, charCt);
		setNewValue("wordCt", wordCts, wordCt);
		setNewValue("lineCt", lineCts, lineCt);
		setNewValue("digitCt", digitCts, digitCt);
		
	} 

}
