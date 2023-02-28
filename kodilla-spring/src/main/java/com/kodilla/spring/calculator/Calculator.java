package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements MathActivities {

    @Autowired
    private Display display;

    @Override
    public double add(double a, double b) {
        double val = a + b;
        display.displayValue(val);
        return val;
    }

    @Override
    public double sub(double a, double b) {
        double val = a - b;
        display.displayValue(val);
        return val;
    }

    @Override
    public double mul(double a, double b) {
        double val = a * b;
        display.displayValue(val);
        return val;
    }

    @Override
    public double div(double a, double b) {
        double val = a / b;
        display.displayValue(val);
        return val;
    }
}
