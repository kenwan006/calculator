package org.example.calculator.dto;

import org.example.calculator.entity.Operation;

//encapsulate multiple operations and  enable chaining method on each operation
public class OperationValues {
    private Operation[] operations;
    private Number[] values;

    // Getters and Setters
    public Operation[] getOperations() {
        return operations;
    }

    public void setOperations(Operation[] operations) {
        this.operations = operations;
    }

    public Number[] getValues() {
        return values;
    }

    public void setValues(Number[] values) {
        this.values = values;
    }
}
