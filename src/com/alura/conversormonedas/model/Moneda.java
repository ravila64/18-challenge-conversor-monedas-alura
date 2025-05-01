package com.alura.conversormonedas.model;

import java.time.LocalDateTime;

public class Moneda {
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double valorConvertido;
    private LocalDateTime fecha;
}
