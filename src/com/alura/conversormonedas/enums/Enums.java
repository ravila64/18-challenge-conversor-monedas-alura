package com.alura.conversormonedas.enums;

import java.util.Arrays;

public class Enums {
   public static void main(String[] args) {
      for (Dia dia: Dia.values()){
         System.out.println(dia);
      }
      Dia domingo = Dia.DOMINGO;
      System.out.println("name "+domingo.name());
      System.out.println("ordinal "+domingo.ordinal());
      System.out.println("longitud del string "+domingo.toString().length());
      System.out.println(domingo);

      for (Mes mes: Mes.values()){
         System.out.println(mes +" long de cada mes "+mes.toString().length());
      }
      System.out.println("Numero de meses "+ Arrays.stream(Mes.values()).count());
   }
}
