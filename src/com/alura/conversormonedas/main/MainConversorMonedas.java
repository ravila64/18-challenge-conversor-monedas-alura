package com.alura.conversormonedas.main;

import com.alura.conversormonedas.controller.MovimientosDiarios;
import com.alura.conversormonedas.controller.RutinasPais;
import com.alura.conversormonedas.model.Pais;
import com.alura.conversormonedas.view.MenuReportes;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MainConversorMonedas {

   public static void main(String[] args) throws IOException {
      MenuReportes menu = new MenuReportes();
      Scanner leer = new Scanner(System.in);
      List<Pais> listaPaises = menu.cargarPaises();
      RutinasPais busqueda = new RutinasPais();

      String codeMoney1 = "COP";
      String codeMoney2 = "USD";
      String moneda1, moneda2 = "";
      String paisFuente = "COP";
      String paisDestino = "USD";
      String opcion = "";
      String input = "";
      double valorConvertir = 0;
      double factor = 0;
      int opc = 0;
      int ultimaOpc=1;

      while (opc != 9) {
         boolean esValida = false;
         while (!esValida) {
            ultimaOpc = menu.mostrarOpciones();
            try {
               opcion = leer.nextLine();
               opc = Integer.parseInt(opcion);
               esValida = (opc >= 1 && opc <= ultimaOpc) || opc == 9;
            } catch (InputMismatchException | NumberFormatException e) {
               opc = 0;
               System.out.println("Dígite números enteros entre [1.."+ultimaOpc+"] ó 9=salir");
               break;
               //throw new ErrorEnCapturaException("Dígite números enteros entre 1 y 2 ó 9 ");
            }
         } // end while

         switch (opc) {
            case 1: { // listado paises incluidos en la conversion
               menu.listarJsonDePaises(listaPaises);
               break;
            }
            case 2: { // listado paises con nombres similares
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
                     System.out.print("Valor a convertir, en " + codeMoney1 + " :");
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
            case 3: { // listar paises con nombres similares
               boolean sigue = true;
               String buscar = "";
               while (sigue) {
                  buscar = busqueda.leerPais("con nombres similiares").trim();
                  if (buscar.length() < 2) {
                     System.out.println("Por favor dígite minimo 2 letras para la búsqueda ");
                  } else {
                     sigue = false;
                  }
               } // wend
               List<Pais> listaSimilar = menu.buscarPaisesNombreSimilar(listaPaises, buscar);
               System.out.println("**Paises con nombres similares**");
               if (listaSimilar.isEmpty()) {
                  System.out.println("No existen paises con nombre : " + buscar);
               } else {
                  for (Pais pais : listaSimilar) {
                     System.out.println("->" + pais.getCountry() + " " + pais.getCodeCurrency());
                  }
               }
               break;
            }
            case 4: { // listar movimientos diarios
               // llamar a listar movimientos
               MovimientosDiarios listar = new MovimientosDiarios();
               listar.listarMovimientos();
               break;
            }
            case 5:{ // listar mvtos diarios por rango de fechas
               MovimientosDiarios listar = new MovimientosDiarios();
               listar.listarMovimientosRangoFechas();
               break;
            }
            case 9:
               System.out.println("Fin aplicación");
               break;
         } //endcase
      } //endwhile
   }

}
