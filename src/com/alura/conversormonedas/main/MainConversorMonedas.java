package com.alura.conversormonedas.main;

import com.alura.conversormonedas.controller.RutinasPais;
import com.alura.conversormonedas.exception.ErrorEnCapturaException;
import com.alura.conversormonedas.model.Pais;
import com.alura.conversormonedas.view.MenuReportes;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainConversorMonedas {
    public static void main(String[] args) throws FileNotFoundException {
        MenuReportes menu = new MenuReportes();
        Scanner leer = new Scanner(System.in);
        List<Pais> listaPaises = menu.cargarPaises();
        RutinasPais busqueda = new RutinasPais();

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
                    //leer = new Scanner(System.in);
                    leer.nextLine(); // consume entrada invalida
                    System.out.print("Digite Pais Fuente :");
                    paisFuente = leer.nextLine();
                    paisFuente = paisFuente.toLowerCase().trim();
                    paisFuente = paisFuente.substring(0,1).toUpperCase()+paisFuente.substring(1);
                    // falta rutina capital case para nombres compuestos
                    Pais paisOrigen = new Pais();
                    paisOrigen = busqueda.busquedaPais(listaPaises,paisFuente);
                    System.out.println(paisOrigen.toString());
                    if (paisOrigen.getCountry()==null){
                        System.out.println("Pais "+paisFuente+" no existe en tabla de conversion");
                        break;
                    }
                    // BUSCAR PAIS FUENTE, traer codigo
                    System.out.print(" A MONEDA de Pais destino :");
                    paisDestino = leer.nextLine();
                    // BUSCAR PAIS DESTINO traer codigo
                    break;
                }
                case 9:
                    break;
            } //endcase
        } //endwhile
    }
}
