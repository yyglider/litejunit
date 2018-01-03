package com.litejunit.sample;

import com.litejunit.extension.RepeatedTest;
import com.litejunit.extension.TestSetup;
import com.litejunit.sample.calculator.CalculatorSuite;
import com.litejunit.v2.Test;
import com.litejunit.v2.TestSuite;


public class AllTest {
	/*public static Test suite(){
		
		TestSuite suite= new TestSuite("All Test");
		suite.addTest(CalculatorSuite.suite());		
		suite.addTestSuite(PersonTest.class);
		return suite;
		
	}*/
	
	public static Test suite(){
		
		TestSuite suite= new TestSuite("All Test");
		suite.addTest(CalculatorSuite.suite());		
		suite.addTest(new RepeatedTest(new TestSuite(PersonTest.class), 2));
		return new OverallTestSetup(suite);
	}
	
	
	static class OverallTestSetup extends TestSetup{

		public OverallTestSetup(Test test) {
			super(test);
			
		}
		@Override
		protected void setUp() throws Exception {
			System.out.println("this is overall testsetup");
		}
		@Override
		protected void tearDown() throws Exception {
			System.out.println("this is overall teardown");
		}
		
	}
}
