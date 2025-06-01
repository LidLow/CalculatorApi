package com.example.calculatorapi.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    public int calculate (int a, int b, String op) {
        return switch (op) {
            case "add" -> a + b;
            case "sub" -> a - b;
            case "mul" -> a * b;
            case "div" -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Unknown operation: " + op);
        };
    }
}