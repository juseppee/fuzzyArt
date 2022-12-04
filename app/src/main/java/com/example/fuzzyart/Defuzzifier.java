package com.example.fuzzyart;

import java.util.ArrayList;

public class Defuzzifier {

    public static double defuzzi(ArrayList<Double> aggregateArray, ArrayList<Rules> rules){
        int i = 0;
        double sumNumerator = 0;
        double sumDenominator = 0;

        while (i < 32)
        {
            sumNumerator += aggregateArray.get(i) * rules.get(i).checkA();
            sumDenominator += aggregateArray.get(i);
            i++;
        }
        System.out.println(sumNumerator + " " + sumDenominator);
        if (sumNumerator == 0)
            return 0;
        return ((double) sumNumerator / sumDenominator);
    }
}