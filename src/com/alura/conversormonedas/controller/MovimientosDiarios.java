package com.alura.conversormonedas.controller;

import com.alura.conversormonedas.model.Moneda;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovimientosDiarios {

   public final String archivo = "src/com/alura/conversormonedas/data/diario.json";
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

   public void listarMovimientosRangoFechas() throws IOException, DateTimeParseException {
      Gson gson = new Gson();
      // Convertir los Strings a LocalDate
      Scanner scanner = new Scanner(System.in);

      // Formato esperado: yyyy-MM-dd
      System.out.print("Ingrese una fecha Inicial (yyyy-MM-dd): ");
      String input = scanner.nextLine();
      // Validar y convertir
      LocalDate fechaI = LocalDate.parse(input);
      // Usa el formato ISO por defecto: yyyy-MM-dd
      // Si quieres devolver como String en otro formato:
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//      String fechaInic = fechaI.format(formatter);
//      System.out.println("Fecha inicial ingresada: " + fechaInic);

      System.out.print("Ingrese una fecha Final (yyyy-MM-dd): ");
      input = scanner.nextLine();
      // Validar y convertir
      LocalDate fechaF = LocalDate.parse(input);
      // Usa el formato ISO por defecto: yyyy-MM-dd
      // Si quieres devolver como String en otro formato:
      //formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//      String fechaFin = fechaF.format(formatter);
//      System.out.println("Fecha Final ingresada: " + fechaFin);

//      LocalDate fechaInicio = LocalDate.parse(fechaInic);
//      LocalDate fechaFinal = LocalDate.parse(fechaFin);

      try (FileReader reader = new FileReader(archivo)) {
         Type listType = new TypeToken<List<Moneda>>() {
         }.getType();
         List<Moneda> monedas = gson.fromJson(reader, listType);

         for (Moneda moneda : monedas) {
            // Verificar si está entre las fechas
            String fechaMvto = moneda.getFecha().substring(0,10);
            LocalDate fechaComparar = LocalDate.parse(fechaMvto);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaActual = fechaComparar.format(formatter);
            if ((fechaComparar.isEqual(fechaI) || fechaComparar.isAfter(fechaI)) &&
                  (fechaComparar.isEqual(fechaF) || fechaComparar.isBefore(fechaF))) {
               System.out.println(moneda.toString());
            }
         }
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
