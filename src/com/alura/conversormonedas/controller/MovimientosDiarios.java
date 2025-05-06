package com.alura.conversormonedas.controller;

import com.alura.conversormonedas.model.Moneda;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovimientosDiarios {

   //public final String archivo="src/com/alura/conversormonedas/data/diario.json";
   public final String archivo = "src/diario.json";
   File file = null;

   public void listarMovimientos() throws IOException {
      Gson gson = new Gson();
      try (FileReader reader = new FileReader(archivo)) {
         Type listType = new TypeToken<List<Moneda>>() {
         }.getType();
         List<Moneda> monedas = gson.fromJson(reader, listType);

         for (Moneda moneda : monedas) {
            System.out.println(moneda.toString());
         }

      } catch (FileNotFoundException e) {
         System.out.println(e.getMessage());
      }
   }

   public boolean grabarMovimientos(Moneda nuevaMoneda) {
      Gson gson = new Gson();
      List<Moneda> monedas = new ArrayList<>();
      try {
         file = new File(archivo);
         if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            Type listType = new TypeToken<List<Moneda>>() {
            }.getType();
            monedas = gson.fromJson(reader, listType);
            reader.close();
         } else {
            GuardarJson createFile = new GuardarJson();
            createFile.guardarEnArchivo(nuevaMoneda);
            System.out.println("Grabado 1era vez diario.json");
         }
      } catch (IOException e) {
         System.out.println("Error al leer el archivo: " + e.getMessage());
      }

      // Agregar la nueva moneda
      monedas.add(nuevaMoneda);

      // Escribir el archivo actualizado
      try (Writer writer = new FileWriter(file)) {
         gson.toJson(monedas, writer);
      } catch (IOException e) {
         System.out.println("Error al escribir el archivo: " + e.getMessage());
      }
      return true;
   }


}
