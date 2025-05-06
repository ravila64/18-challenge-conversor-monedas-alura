package com.alura.conversormonedas.controller;

import com.alura.conversormonedas.model.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarJson {

   public void guardarEnArchivo(Moneda moneda) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String archivo = "src/com/alura/conversormonedas/data/diario.json";
      try (FileWriter writer = new FileWriter(archivo)) {
         gson.toJson(moneda, writer);
         System.out.println("Archivo diario.json guardado correctamente.");
      } catch (IOException e) {
         System.err.println("Error al guardar el archivo: " + e.getMessage());
      }
   }
}
