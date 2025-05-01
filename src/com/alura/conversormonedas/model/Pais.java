package com.alura.conversormonedas.model;

import com.google.gson.annotations.SerializedName;

public class Pais implements Comparable<Pais> {
    @SerializedName("codeCurrency")
    private String codeCurrency;
    @SerializedName("currencyName")
    private String currencyName;
    @SerializedName("country")
    private String country;

    public String getCodeCurrency() {
        return codeCurrency;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCodeCurrency(String codeCurrency) {
        this.codeCurrency = codeCurrency;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "codeCurrency='" + codeCurrency + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pais otro) {
        return this.getCountry().compareTo(otro.getCountry());
    }

}
