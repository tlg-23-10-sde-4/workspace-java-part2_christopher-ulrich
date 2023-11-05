/*
 * Test methods should be tight and granular and focused on one aspect of functionality.
 *
 * A test method should fail for a SINGLE reason.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

import java.sql.SQLOutput;

public class CalculatorTest {   // HAS to be a public class

    // Fixture - the business object(s) under test
    private Calculator calc;    // Looks null, but is initialized in @Before

    @BeforeClass
    public static void initializeTestRun() {
        System.out.println("initializeTestRun");
    }

    @AfterClass
    public static void finalizeTestRun() {
        System.out.println("finalizeTestRun");
    }

    @Before
    public void setUp() {   // Prevents writing redundant code; fires before each test
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void tearDown() {    // Useful for freeing up any resources used in testing
        System.out.println("tearDown");
    }

    @Test
    public void testAdd() {
        System.out.println("testAdd");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("testDivide");
        assertEquals(3.5, calc.divide(7, 2), .001);
    }

    @Test
    public void testIsEven() {
        System.out.println("testIsEven");
        assertTrue(calc.isEven(4)); // passes if true
        assertFalse(calc.isEven(11));   // passes if false
    }
}