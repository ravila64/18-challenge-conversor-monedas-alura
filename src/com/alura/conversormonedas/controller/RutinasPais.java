package com.alura.conversormonedas.controller;

import com.alura.conversormonedas.model.Currency;
import com.alura.conversormonedas.model.Pais;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

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

    public String toCamelCase(String str){
        String[] words = str.split(" ");
        StringBuilder camelCaseStr = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                camelCaseStr.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase()+" ");
            }
        }
        return camelCaseStr.toString().trim();
    }

    public double factorConversion(String codeO,String codeD) throws IOException, InterruptedException {
        // crear gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // inicializa API_KEY
        String api_key = System.getenv("API_KEY_EXCHANGERATE");
        if (api_key != null && !api_key.isEmpty()) {
            System.out.println("API Key: Verified");
        } else {
            System.out.println("La variable de entorno o api_key no está definida, para este dispositivo.");
            return 0;
        }
        // formato https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
        String url = "https://v6.exchangerate-api.com/v6/"+api_key+"/pair/"+codeO+"/"+codeD;
        String json = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        Currency result = gson.fromJson(json, Currency.class);
        System.out.println("Result :"+result);
        return result.conversion_rate();
    }

    public void calcularConversion(double valorConvertir, double factor, String moneda1, String moneda2, String code1, String code2 ){
        double totalConversion = valorConvertir * factor;
        String str = "Conversion %.2f  %s   %s son %.2f  %s %s ";
        System.out.printf(str,valorConvertir, code1, moneda1, totalConversion, code2, moneda2).toString();
    }

    public String leerPais(String complemento){
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite Pais "+complemento+" :");
        String pais = leer.nextLine();
        pais = this.toCamelCase(pais.toLowerCase().trim());
        return pais;
    }

}
