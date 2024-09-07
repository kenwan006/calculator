package org.example.calculator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.calculator.dto.OperationValues;
import org.example.calculator.entity.Operation;
import org.example.calculator.exception.InvalidSizeException;
import org.example.calculator.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private static final Logger logger = LogManager.getLogger(CalculatorController.class);

    private final Calculator calculator;

    // Constructor-based injection
    @Autowired
    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestParam String operation, @RequestParam Integer num1, @RequestParam Integer num2) {
        try {
            Operation op = Operation.valueOf(operation.toUpperCase());
            Number result = calculator.calculate(op, num1, num2);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            // Invalid operation value
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid operation: " + operation);
        } catch (Exception e) {
            // Handle other exceptions like divided by 0
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/chain")
    public ResponseEntity<?> chain(@RequestParam Number initialValue, @RequestBody OperationValues operationValues) {
        logger.info("Chaining operations starting with {}", initialValue);


        try {
            // Manually validate and convert operations from strings to enums
            Operation[] ops = Arrays.stream(operationValues.getOperations())
                    .map(operation -> {
                        try {
                            return Operation.valueOf(operation.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            // Invalid operation value
                            throw new IllegalArgumentException("Invalid operation: " + operation);
                        }
                    })
                    .toArray(Operation[]::new);

            Number[] values = operationValues.getValues();
            // Check if the number of operations is greater than the number of values
            // Check if the number of operations is greater than the number of values
            if (ops.length > values.length) {
                throw new InvalidSizeException("The size of the operations array is larger than the size of the values array.");
            }

            Number result = calculator.chain(initialValue, ops, values);
            // Return success response
            return ResponseEntity.ok(result);

        } catch (IllegalArgumentException ex) {
            // Handle other exceptions like divided by 0
            logger.error("Error in chaining operations: {}", ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
