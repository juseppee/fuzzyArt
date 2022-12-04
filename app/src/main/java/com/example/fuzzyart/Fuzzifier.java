package com.example.fuzzyart;

import java.util.ArrayList;

public class Fuzzifier {

    public static ArrayList<Double> fuzzi(ArrayList<Rules> rules, int xIMT, int xPh, int xH, int xBH, int xST) {
        ArrayList<Double> fuzziArray = new ArrayList();
        int i = 0;
        int j = 0;
        while (j < 32) {
            fuzziArray.add(rules.get(j).checkIMT(xIMT));
            fuzziArray.add(rules.get(j).checkPh(xPh));
            fuzziArray.add(rules.get(j).checkH(xH));
            fuzziArray.add(rules.get(j).checkBH(xBH));
            fuzziArray.add(rules.get(j).checkST(xST));
            j++;
        }
        return fuzziArray;
    }
}
