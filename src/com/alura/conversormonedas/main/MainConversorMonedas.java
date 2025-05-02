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
        double factor = 0;
        double valorConvertir, totalConversion = 0;
        String moneda1, moneda2 = "";
        String strSalida = "";
        int opc = 0;
        String paisFuente = "COP";
        String paisDestino = "USD";
        while (opc != 9) {
            boolean esValida = false;
            while (!esValida) {
                menu.mostrarOpciones();
                try {
                    opc = leer.nextInt();
                    esValida = (opc == 1 || opc == 2 || opc == 9);
                } catch (InputMismatchException e) {
                    throw new ErrorEnCapturaException("Digite enteros entre 1 y 2 ó 9");
                }
            } // end while

            switch (opc) {
                case 1: {
                    menu.listarJsonDePaises(listaPaises);
                    break;
                }
                case 2: {
                    leer.nextLine(); // consume entrada invalida
                    System.out.print("Digite Pais Fuente :");
                    paisFuente = leer.nextLine();
                    paisFuente = busqueda.toCamelCase(paisFuente.toLowerCase().trim());

                    Pais paisOD = new Pais();
                    paisOD = busqueda.busquedaPais(listaPaises, paisFuente);
                    System.out.println(paisOD.toString());
                    if (paisOD.getCountry() == null) {
                        System.out.println("Pais " + paisFuente + ", No existe en tabla de conversion");
                        break;
                    } else {
                        codeMoney1 = paisOD.getCodeCurrency();
                        paisFuente = paisOD.getCountry();
                        moneda1 = paisOD.getCurrencyName();
                        System.out.println("Codigo moneda :" + codeMoney1 + ", pais :" + paisFuente);
                    }
                    System.out.print("Convertir a MONEDA de Pais destino :");
                    paisDestino = leer.nextLine();
                    paisDestino = busqueda.toCamelCase(paisDestino.toLowerCase().trim());
                    paisOD = busqueda.busquedaPais(listaPaises, paisDestino);
                    System.out.println(paisOD.toString());
                    if (paisOD.getCountry() == null) {
                        System.out.println("Pais " + paisDestino + ", No existe en tabla de conversion");
                        break;
                    } else {
                        codeMoney2 = paisOD.getCodeCurrency();
                        paisDestino = paisOD.getCountry();
                        moneda2 = paisOD.getCurrencyName();
                        System.out.println("A Codigo moneda :" + codeMoney2 + ", pais :" + paisDestino);
                    }
                    if (!Objects.equals(codeMoney1, codeMoney2)) {
                        try {
                            System.out.println("Valor a convertir");
                            valorConvertir = leer.nextDouble();
                            factor = busqueda.factorConversion(codeMoney1, codeMoney2);
                            totalConversion = valorConvertir * factor;
                            strSalida = "Conversion " + valorConvertir + " " + moneda1 + " son ";
                            strSalida += totalConversion + " " + moneda2;
                            System.out.println(strSalida);
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("Digito paises iguales, seleccione diferentes !!!");
                    }
                    break;
                }
                case 9:
                    leer.close();
                    break;

            } //endcase
        } //endwhile
    }
}
