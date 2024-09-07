package org.example.calculator.dto;

import org.example.calculator.entity.Operation;

//encapsulate multiple operations and  enable chaining method on each operation
public class OperationValues {
    private String[] operations; // Operations are still strings to allow manual validation
    private Number[] values;

    // Getters and setters
    public String[] getOperations() {
        return operations;
    }

    public void setOperations(String[] operations) {
        this.operations = operations;
    }

    public Number[] getValues() {
        return values;
    }

    public void setValues(Number[] values) {
        this.values = values;
    }
}
