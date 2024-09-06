package org.example.calculator.service;

import org.example.calculator.entity.Operation;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public Number calculate(Operation op, Number num1, Number num2) {
        double x = num1.doubleValue();
        double y = num2.doubleValue();

        switch (op) {
            case ADD:
                return x + y;
            case SUBTRACT:
                return x - y;
            case MULTIPLY:
                return x * y;
            case DIVIDE:
                if (y == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return x / y;
//            case CUSTOM:
//                return x + y * 2;
            default:
                throw new UnsupportedOperationException("Operation not supported: " + op);
        }
    }

    public Number chain(Number initialValue, Operation[] ops, Number[] values) {
        double result = initialValue.doubleValue();
        for (int i = 0; i < ops.length; i++) {
            result = calculate(ops[i], result, values[i]).doubleValue();
        }
        return result;
    }
}
