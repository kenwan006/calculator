package org.example.calculator;

import org.example.calculator.entity.Operation;
import org.example.calculator.service.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testCalculateAddition() {
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2, 3));
    }

    @Test
    void testCalculateSubtraction() {
        assertEquals(1.0, calculator.calculate(Operation.SUBTRACT, 3, 2));
    }

    @Test
    void testCalculateMultiplication() {
        assertEquals(6.0, calculator.calculate(Operation.MULTIPLY, 2, 3));
    }

    @Test
    void testCalculateDivision() {
        assertEquals(2.0, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

    @Test
    void testCalculateDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(Operation.DIVIDE, 6, 0));
    }

    @Test
    void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(Operation.CUSTOM, 6, 3));
    }

    @Test
    void testChainOperations() {
        Number initialValue = 10;
        Operation[] operations = {Operation.ADD, Operation.MULTIPLY, Operation.SUBTRACT};
        Number[] values = {3, 2, 5};
        assertEquals(21.0, calculator.chain(initialValue, operations, values));
    }
}
