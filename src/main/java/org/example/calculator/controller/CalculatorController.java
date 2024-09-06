package org.example.calculator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.calculator.dto.OperationValues;
import org.example.calculator.entity.Operation;
import org.example.calculator.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Number calculate(@RequestParam String operation, @RequestParam Number num1, @RequestParam Number num2) {
        logger.info("Calculating {} operation on {} and {}", operation, num1, num2);
        Operation op = Operation.valueOf(operation.toUpperCase());
        return calculator.calculate(op, num1, num2);
    }

    @PostMapping("/chain")
    public Number chain(@RequestParam Number initialValue, @RequestBody OperationValues operationValues) {
        logger.info("Chaining operations starting with {}", initialValue);
        Operation[] ops = operationValues.getOperations();
        Number[] values = operationValues.getValues();
        return calculator.chain(initialValue, ops, values);
    }
}
