package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue(true);
    }

    /**
     * Hello World Test
     */
   @Test
public void helloWorldTest()
{
    System.out.println("Hello World");
    assertFalse(true); // This line asserts that the test fails.
}

}
