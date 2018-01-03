package com.litejunit.v3.sample;

import com.litejunit.v3.After;
import com.litejunit.v3.AfterClass;
import com.litejunit.v3.Before;
import com.litejunit.v3.BeforeClass;
import com.litejunit.v3.Test;
import com.litejunit.v3.runner.JUnitCore;

import static com.litejunit.v3.Assert.*;

public class CalculatorTest {

    Calculator calculator = null;

    @Before
    public void prepare() {
        calculator = new Calculator();
    }

    @After
    public void clean() {
        calculator = null;
    }

    @Test
    public void testAdd() {

        calculator.add(10);
        assertEquals(15, calculator.getResult());
    }

    @Test
    public void testSubtract() {
        calculator.add(10);
        calculator.subtract(5);
        assertEquals(5, calculator.getResult());
    }

    @BeforeClass
    public static void prepareGlobalResouce() {
        System.err.println("prepare global resource");
    }

    @AfterClass
    public static void cleanGlobalResouce() {
        System.err.println("clean global resource");
    }


    public static void main(String[] args) {
        JUnitCore.runClass(CalculatorTest.class);

    }
}
