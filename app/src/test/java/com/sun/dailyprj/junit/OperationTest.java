package com.sun.dailyprj.junit;

import com.sun.dailyprj.junit.operate.Operation;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * =====================================================================================
 * Summary:
 *
 * File: OperationTest.java
 * Author: Yanpeng.Sun
 * Create: 2019/3/12 17:49
 * =====================================================================================
 */
public class OperationTest{

    @Test
    public void addition() {
        assertEquals(5.0, Operation.addition(2f,3f),0f);
    }

    @Test
    public void soustraction() {
        assertEquals(5,Operation.soustraction(12,7),0);
    }

    @Test
    public void multiplication() {
        assertEquals(6,Operation.multiplication(2,3),0);
    }

    @Test
    public void division() {
        try{
            assertEquals(2,Operation.division(12,6),0);
        } catch (Operation.DivideByZeroException e) {
            fail();
            e.printStackTrace();
        }
    }

    @Test
    public void carre() {
        assertEquals(16, Operation.carre(4), 0);
    }

    @Test
    public void racineCarree() {

        try
        {
            assertEquals(4, Operation.racineCarree(16), 0);
        }
        catch(Operation.NegativeNumberException e)
        {
            fail();
        }
    }

    @Test(expected = Operation.NegativeNumberException.class)
    public void testRacineCarreeDUnNombreNegatif() throws Operation.NegativeNumberException
    {
        Operation.racineCarree(-42);
    }
}