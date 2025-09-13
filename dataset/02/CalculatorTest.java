package com.juliafealves.calculator;

import com.juliafealves.calculator.models.Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    https://github.com/juliafealves/calculator-app/blob/master/app/src/main/java/com/juliafealves/calculator/models/Calculator.java
*/

public class CalculatorTest
{
    private static final double DELTA = 0.001;

    @Test
    public void testSum() throws Exception
    {
        double number1 = 2.5;
        double number2 = 1.3;
        double expected = 3.8;

        double output = Calculator.sum(number1, number2);
        assertEquals(expected, output, DELTA);
    }

    @Test
    public void testMinus() throws Exception
    {
        double number1 = 2.5;
        double number2 = 1.3;
        double expected = 1.2;

        double output = Calculator.minus(number1, number2);
        assertEquals(expected, output, DELTA);

        number1 = 1.0;
        number2 = 2.5;
        expected = -1.5;
        output = Calculator.minus(number1, number2);
        assertEquals(expected, output, DELTA);
    }

    @Test
    public void testMultiplication() throws Exception
    {
        double number1 = 3.5;
        double number2 = 2;
        double expected = 7;

        double output = Calculator.multiplication(number1, number2);
        assertEquals(expected, output, DELTA);
    }

    @Test
    public void testDivision() throws Exception
    {
        double number1 = 5;
        double number2 = 2;
        double expected = 2.5;

        double output = Calculator.division(number1, number2);
        assertEquals(expected, output, DELTA);
    }
}