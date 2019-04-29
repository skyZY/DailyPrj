package com.sun.dailyprj.junit.calculator;


import android.annotation.SuppressLint;

import static androidx.core.util.Preconditions.checkArgument;

public class Calculator {

    public enum Operator {ADD, SUB, DIV, MUL}

    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    @SuppressLint("RestrictedApi")
    public double div(double firstOperand, double secondOperand) {
        checkArgument(secondOperand != 0, "secondOperand must be != 0, you cannot divide by zero");
        return firstOperand / secondOperand;
    }

    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
}
