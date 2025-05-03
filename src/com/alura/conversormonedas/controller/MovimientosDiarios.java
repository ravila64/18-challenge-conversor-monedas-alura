package com.alura.conversormonedas.controller;

import com.alura.conversormonedas.model.Moneda;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MovimientosDiarios {

   public boolean leerMovimientos() {
      ObjectMapper objectMapper = new ObjectMapper();
      Map<String, Moneda> diaro = new HashMap<>();

      try {
         File archivo = new File("src/com/alura/conversormonedas/data/movimientos.json");
         if (archivo.exists()) {
            diaro = objectMapper.readValue(archivo, Map.class);
         }
      } catch (IOException e) {
         System.out.println("Error al leer el archivo! " + e.getMessage());
      }
      return true;
   }
}
