package com.sun.dailyprj.junit.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/*
 * =====================================================================================
 * Summary:
 *
 * File: CalculatorTest.java
 * Author: Yanpeng.Sun
 * Create: 2019/3/13 11:23
 * =====================================================================================
 */
public class CalculatorTest{
    private Calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    @Test
    public void add() {
        double resultAdd = mCalculator.add(2d,3d);
        assertThat(resultAdd,is(equalTo(5d)));
    }

    @Test
    public void sub() {
        double resultSub = mCalculator.sub(1d,1d);
        assertThat(resultSub,is(equalTo(0d)));
    }

    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d,17d);
        assertThat(resultSub,is(equalTo(-16d)));
    }

    @Test
    public void div() {
        double resultDiv = mCalculator.div(32d,2d);
        assertThat(resultDiv,is(equalTo(16d)));
    }

    @Test
    public void divDivideByZeroThrows() {
        mCalculator.div(32d,0d);
    }

    @Test
    public void mul() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertThat(resultMul, is(equalTo(64d)));
    }
}