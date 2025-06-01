package com.example.calculatorapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationRequest {
    @NotNull
    private Integer a;
    @NotNull
    private Integer b;
    @NotNull
    private String op;
}
