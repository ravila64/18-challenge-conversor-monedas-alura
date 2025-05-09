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

   public boolean validarFecha(String fecha) {
      if (fecha.length() != 10) {
         return false;
      }
      //                 en  fb  ma  ab  my  ju  jl  ag  sp  oc  nv  dc
      int diasEnMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      String year = fecha.substring(0, 4);
      String month = fecha.substring(5, 7);
      String day = fecha.substring(8, 10);
      //System.out.println(year + " " + month + " " + day);
      int year1 = Integer.parseInt(year);
      int month1 = Integer.parseInt(month);
      int day1 = Integer.parseInt(day);
      boolean fechaOk = false;
      if (year1 >= 2000 && month1 >= 1 && month1 <= 12 && day1 >= 1 && day1 <= 31) {
         if (month1 == 2 && year1 % 4 == 0) {  // bisiesto
            if (day1 <= diasEnMes[month1 - 1] + 1) {
               fechaOk = true;
            }
         } else {
            if (day1 <= diasEnMes[month1 - 1]) {
               fechaOk = true;
            }
         }
      }
      return fechaOk;
   }

   public void listarMovimientosRangoFechas() throws IOException, DateTimeParseException {
      Gson gson = new Gson();
      // Convertir los Strings a LocalDate
      Scanner scanner = new Scanner(System.in);

      boolean esFechaCorrecta = false;
      String input = "";
      LocalDate fechaI = LocalDate.now();
      LocalDate fechaF = LocalDate.now();
      while (!esFechaCorrecta) {
         System.out.print("Ingrese una fecha Inicial (yyyy-MM-dd): ");
         input = scanner.nextLine().trim();
         if (validarFecha(input)) {
            fechaI = LocalDate.parse(input);
            esFechaCorrecta = true;
         } else {
            System.out.println("Corregir fecha inicial errada:"+input);
         }
      }

      esFechaCorrecta = false;
      while (!esFechaCorrecta) {
         System.out.print("Ingrese una fecha Final (yyyy-MM-dd): ");
         input = scanner.nextLine().trim();
         if (validarFecha(input)) {
            fechaF = LocalDate.parse(input);
            esFechaCorrecta = true;
         }else {
            System.out.println("Corregir fecha final errada :"+input);
         }
      }

      System.out.println("Listado de movimientos entre "+fechaI+" hasta "+fechaF);
      try (FileReader reader = new FileReader(archivo)) {
         Type listType = new TypeToken<List<Moneda>>() {
         }.getType();
         List<Moneda> monedas = gson.fromJson(reader, listType);
         for (Moneda moneda : monedas) {
            // Verificar si está entre las fechas
            String fechaMvto = moneda.getFecha().substring(0, 10);
            LocalDate fechaComparar = LocalDate.parse(fechaMvto);
            if ((fechaComparar.isEqual(fechaI) || fechaComparar.isAfter(fechaI)) &&
                  (fechaComparar.isEqual(fechaF) || fechaComparar.isBefore(fechaF))) {
               System.out.println(moneda);   // el toma el .toString()
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
