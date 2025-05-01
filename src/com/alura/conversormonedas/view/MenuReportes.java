package com.alura.conversormonedas.view;

import com.alura.conversormonedas.model.Pais;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class MenuReportes {

    public List<Pais> cargarPaises(){
        Gson gson = new Gson();
        File file = new File("src/com/alura/conversormonedas/data/monedapais.json");
        FileReader reader;
        {
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        Type listType = new TypeToken<List<Pais>>() {
        }.getType();
       // List<Pais> listaMonedas = gson.fromJson(reader, listType);
        return  gson.fromJson(reader, listType);  // estaba listaMonedas;
    }

    public void mostrarOpciones() {
        System.out.println("****Conversor de monedas****");
        System.out.println("1. Listado paises incluidos para conversión");
        System.out.println("2. Conversión de monedas");
        System.out.println("9. Salir");
        System.out.print("Digite opción [1..2] o [9.Salir]");
    }

    public void listarJsonDePaises( List<Pais> lista) {
        int cantidadPaises = lista.size();
        System.out.println("Cantidad de paises para conversion " + cantidadPaises);
        int conse = 1;
        for (Pais pais : lista) {
            System.out.print(conse + "-(" +pais.getCodeCurrency()+")="+pais.getCountry()+" *** ");
            if (conse % 5 != 0) {
            }else {
                System.out.println("_");
            }
            //if (conse > 50) break;
            conse++;
        }
    }

}
