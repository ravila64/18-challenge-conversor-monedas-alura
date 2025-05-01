package com.alura.conversormonedas.controller;

import com.alura.conversormonedas.model.Pais;
import java.util.List;

public class RutinasPais {

    public Pais busquedaPais(List<Pais> lista, String paisBuscar) {

        Pais itemPais = new Pais();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCountry().contains(paisBuscar)) {
                itemPais.setCodeCurrency(lista.get(i).getCodeCurrency());
                itemPais.setCurrencyName(lista.get(i).getCurrencyName());
                itemPais.setCountry(lista.get(i).getCountry());
                break;
            }
        }
        return itemPais;
    }
}
