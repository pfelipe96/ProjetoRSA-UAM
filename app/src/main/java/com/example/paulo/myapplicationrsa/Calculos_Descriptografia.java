package com.example.paulo.myapplicationrsa;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Calculos_Descriptografia {


    public ArrayList<String> arrayList_Descriptografia = new ArrayList<String>();
    private BigDecimal value1, value2, value3;


    void calcularDescriptografia(String v1, int v2, String v3) {

        String d_arm1="0";

        for (int i = 1; i <= 1; i++) {
            value1 = new BigDecimal(v3).pow(v2);
            value2 = new BigDecimal(v1);
            value3 = value1.remainder(value2);
            int d_arm = new Integer(value3.intValue());
            d_arm1 = String.valueOf(Character.toChars(d_arm));
        }

        arrayList_Descriptografia.add(d_arm1);
    }
}

