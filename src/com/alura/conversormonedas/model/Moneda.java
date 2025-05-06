package com.alura.conversormonedas.model;

import java.time.LocalDateTime;

public class Moneda {
   private String base_code;
   private String target_code;
   private double conversion_rate;
   private double valorAConvertir;
   private double valorConversion;
   private String fecha;

   public Moneda(String base_code, String target_code, double conversion_rate,
                 double valorAConvertir, double valorConversion, String fecha) {
      this.base_code = base_code;
      this.target_code = target_code;
      this.conversion_rate = conversion_rate;
      this.valorAConvertir = valorAConvertir;
      this.valorConversion = valorConversion;
      this.fecha = fecha;
   }

   public Moneda() {
   }
   // getters
   public String getBase_code() {
      return base_code;
   }

   public double getConversion_rate() {
      return conversion_rate;
   }

   public String getFecha() {
      return fecha;
   }

   public String getTarget_code() {
      return target_code;
   }

   public double getValorAConvertir() {
      return valorAConvertir;
   }

   public double getValorConversion() {
      return valorConversion;
   }

   @Override
   public String toString() {
      return "Moneda{" +
            "base_code='" + base_code + '\'' +
            ", target_code='" + target_code + '\'' +
            ", conversion_rate=" + conversion_rate +
            ", valorAConvertir=" + valorAConvertir +
            ", valorConversion=" + valorConversion +
            ", fecha='" + fecha + '\'' +
            '}';
   }
}
