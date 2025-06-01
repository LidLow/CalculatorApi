package com.example.calculatorapi.contoller;

import com.example.calculatorapi.dto.CalculationRequest;
import com.example.calculatorapi.service.CalculationService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculationController {
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculate")
    public int calculate(@Valid @RequestBody CalculationRequest request) {
        return calculationService.calculate(request.getA(), request.getB(), request.getOp());
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public Map<String, String> exceptionHandler(Exception e) {
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        return error;
    }
}