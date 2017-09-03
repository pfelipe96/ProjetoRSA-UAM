package com.example.paulo.myapplicationrsa;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculos_Criptografia {

    public ArrayList<Integer> arrayList_Criptografia;
    private BigDecimal c_value1, c_value2, c_value3;

    void calcularCriptografia(int v1, int v2, String v3) {

        int[] valoresdeascii = new int[v3.length()];
        for (int i = 0; i < v3.length(); i++) {
            char convertendoInt = v3.charAt(i);
            int convertendoChar = (int) convertendoInt;
            valoresdeascii[i] = convertendoChar;
        }

        arrayList_Criptografia = new ArrayList<Integer>();
        for (int x = 0; x < v3.length(); x++) {
            c_value1 = new BigDecimal(valoresdeascii[x]).pow(v2);
            c_value2 = new BigDecimal(v1);
            c_value3 = c_value1.remainder(c_value2);
            Integer c_arm = new Integer(c_value3.intValue());
            arrayList_Criptografia.add(c_arm);
        }

    }

}


