package com.alura.conversormonedas.main;

import com.alura.conversormonedas.controller.RutinasPais;
import com.alura.conversormonedas.exception.ErrorEnCapturaException;
import com.alura.conversormonedas.model.Pais;
import com.alura.conversormonedas.view.MenuReportes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainConversorMonedas {

   public static void main(String[] args) throws FileNotFoundException {
      MenuReportes menu = new MenuReportes();
      Scanner leer = new Scanner(System.in);

      List<Pais> listaPaises = menu.cargarPaises();
      RutinasPais busqueda = new RutinasPais();
      String codeMoney1 = "COP";
      String codeMoney2 = "USD";
      double valorConvertir;
      double factor = 0;
      String moneda1, moneda2 = "";
      int opc = 0;
      String paisFuente = "COP";
      String paisDestino = "USD";
      String opcion = "";
      String input = "";

      while (opc != 9) {
         boolean esValida = false;
         while (!esValida) {
            menu.mostrarOpciones();
            try {
               opcion = leer.nextLine();
               opc = Integer.parseInt(opcion);
               esValida = (opc == 1 || opc == 2 || opc == 9);
            } catch (InputMismatchException | NumberFormatException e) {
               System.out.println("Dígite números enteros entre 1 y 2 ó 9 ");
               opc=0;
               break;
               //throw new ErrorEnCapturaException("Dígite números enteros entre 1 y 2 ó 9 ");
            }
         } // end while

         switch (opc) {
            case 1: {
               menu.listarJsonDePaises(listaPaises);
               break;
            }
            case 2: {
               paisFuente = busqueda.leerPais("Fuente");
               Pais paisOD = busqueda.busquedaPais(listaPaises, paisFuente);
               if (paisOD.getCountry() == null) {
                  System.out.println("Pais " + paisFuente + ", No existe en tabla de conversion");
                  break;
               } else {
                  System.out.println(paisOD);
                  codeMoney1 = paisOD.getCodeCurrency();
                  paisFuente = paisOD.getCountry();
                  moneda1 = paisOD.getCurrencyName();
                  System.out.println("Codigo moneda :" + codeMoney1 + ", pais :" + paisFuente);
               }
               paisDestino = busqueda.leerPais("Destino");
               paisOD = busqueda.busquedaPais(listaPaises, paisDestino);
               if (paisOD.getCountry() == null) {
                  System.out.println("Pais " + paisDestino + ", No existe en tabla de conversion");
                  break;
               } else {
                  System.out.println(paisOD);
                  codeMoney2 = paisOD.getCodeCurrency();
                  paisDestino = paisOD.getCountry();
                  moneda2 = paisOD.getCurrencyName();
                  System.out.println("A Codigo moneda :" + codeMoney2 + ", pais :" + paisDestino);
               }
               // validar paises repetidos
               if (!Objects.equals(codeMoney1, codeMoney2)) {
                  try {
                     System.out.print("Valor a convertir : ");
                     try {
                        input = leer.nextLine();
                        valorConvertir = Double.parseDouble(input);
                     } catch (NumberFormatException e) {
                        System.out.println("Por favor digitar un numero " + e.getMessage());
                        break;
                     }
                     factor = busqueda.factorConversion(codeMoney1, codeMoney2);
                     busqueda.calcularConversion(valorConvertir, factor, moneda1, moneda2, codeMoney1, codeMoney2);
                     System.out.println(" ");
                  } catch (IOException | InterruptedException e) {
                     throw new RuntimeException(e);
                  }
               } else {
                  System.out.println("Seleccione paises diferentes !!!");
               }
               break;
            }
            case 9:
               System.out.println("Fin aplicación");
               break;
         } //endcase
      } //endwhile
   }

}
