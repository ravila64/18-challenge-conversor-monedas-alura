package com.alura.conversormonedas.model;

public record Currency(String base_code, String target_code, double conversion_rate) {
}
