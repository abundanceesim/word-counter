/*
 * File name: CounterTest.java
 * Author: Abundance Esim, Jaswinder Singh, Jingmei Li
 * Course: CST8288
 * Assignment: Assignment 01
 * Professor: Prof. Reginald Dyer
 * Due Date: March 11, 2022
 */

package assignment01_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import assignment01.Counter;
import assignment01.CounterModel;


/**
 * This class tests methods in the Counter class.
 * @author Abundance Esim, Jaswinder Singh, Jingmei Li
 *
 */
class CounterTest {
	CounterModel theModel; 
	Counter theController; 
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Starting tests...");
	}
	
	@AfterAll
	static void afterAllCleanup() {
		System.out.println("Cleaning up...");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		theController = new Counter();
	}
	
	@Nested @DisplayName("CounterModel Object Test")
	class CounterModelObjectTest {
		@Test
		void testObjectNotNull() {
			
			assertNotNull(theController);
		}
	}


}
