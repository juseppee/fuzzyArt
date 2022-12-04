package com.example.fuzzyart;

import java.util.ArrayList;

public class Rules {

    String ruleIMT;
    String rulePh;
    String ruleH;
    String ruleBH;
    String ruleSt;
    double ruleA;

    public Rules(String ruleIMT, String rulePh, String ruleH, String ruleBH, String ruleSt, double ruleA){
        this.ruleIMT = ruleIMT;
        this.rulePh = rulePh;
        this.ruleH = ruleH;
        this.ruleBH = ruleBH;
        this.ruleSt = ruleSt;
        this.ruleA = ruleA;
    }

    public double checkIMT(int x){
        double res;
        if (this.ruleIMT.equals("IMT_norm"))
            res = Variables.IMT_norm(x);
        else
            res = Variables.IMT_high(x);
        return res;
    }

    public double checkPh(int x){
        double res;
        if (this.rulePh.equals("Ph_yes"))
            res = Variables.Ph_yes(x);
        else
            res = Variables.Ph_no(x);
        return res;
    }

    public double checkH(int x){
        double res;
        if (this.ruleH.equals("H_old"))
            res = Variables.H_old(x);
        else
            res = Variables.H_notOld(x);
        return res;
    }

    public double checkBH(int x){
        double res;
        if (this.ruleBH.equals("BH_yes"))
            res = Variables.BH_yes(x);
        else
            res = Variables.BH_no(x);
        return res;
    }

    public double checkST(int x){
        double res;
        if (this.ruleSt.equals("ST_high"))
            res = Variables.ST_high(x);
        else
            res = Variables.ST_low(x);
        return res;
    }

    public double checkA(){
        return this.ruleA;
    }

    public static ArrayList<Rules> genRules(){
        ArrayList<Rules> rules = new ArrayList<Rules>();

        rules.add(new Rules("IMT_norm", "Ph_no", "H_notOld", "BH_no", "ST_high", Variables.A_no()));
        rules.add(new Rules("IMT_norm", "Ph_no", "H_notOld", "BH_no", "ST_low", Variables.A_no()));
        rules.add(new Rules("IMT_norm", "Ph_no", "H_notOld", "BH_yes", "ST_high", Variables.A_no()));
        rules.add(new Rules("IMT_norm", "Ph_no", "H_old", "BH_no", "ST_high", Variables.A_no()));

        rules.add(new Rules("IMT_norm", "Ph_yes", "H_old", "BH_no", "ST_high", Variables.A_no()));
        rules.add(new Rules("IMT_high", "Ph_no", "H_notOld", "BH_no", "ST_high", Variables.A_maybe_no()));
        rules.add(new Rules("IMT_high", "Ph_yes", "H_notOld", "BH_no", "ST_high", Variables.A_50()));
        rules.add(new Rules("IMT_high", "Ph_no", "H_old", "BH_no", "ST_high", Variables.A_maybe_yes()));

        rules.add(new Rules("IMT_high", "Ph_no", "H_notOld", "BH_yes", "ST_high", Variables.A_maybe_no()));
        rules.add(new Rules("IMT_high", "Ph_no", "H_notOld", "BH_no", "ST_low", Variables.A_50()));
        rules.add(new Rules("IMT_norm", "Ph_yes", "H_old", "BH_no", "ST_high", Variables.A_maybe_no()));
        rules.add(new Rules("IMT_norm", "Ph_yes", "H_notOld", "BH_yes", "ST_high", Variables.A_maybe_no()));

        rules.add(new Rules("IMT_norm", "Ph_yes", "H_notOld", "BH_no", "ST_low", Variables.A_maybe_no()));
        rules.add(new Rules("IMT_norm", "Ph_no", "H_old", "BH_yes", "ST_high", Variables.A_no()));
        rules.add(new Rules("IMT_norm", "Ph_no", "H_old", "BH_no", "ST_low", Variables.A_maybe_no()));
        rules.add(new Rules("IMT_norm", "Ph_no", "H_notOld", "BH_yes", "ST_low", Variables.A_no()));

        rules.add(new Rules("IMT_high", "Ph_yes", "H_old", "BH_yes", "ST_high", Variables.A_yes()));
        rules.add(new Rules("IMT_high", "Ph_yes", "H_old", "BH_no", "ST_low", Variables.A_yes()));
        rules.add(new Rules("IMT_high", "Ph_yes", "H_notOld", "BH_yes", "ST_low", Variables.A_yes()));
        rules.add(new Rules("IMT_high", "Ph_no", "H_old", "BH_yes", "ST_low", Variables.A_yes()));

        rules.add(new Rules("IMT_norm", "Ph_yes", "H_old", "BH_yes", "ST_low", Variables.A_maybe_yes()));
        rules.add(new Rules("IMT_high", "Ph_yes", "H_old", "BH_yes", "ST_low", Variables.A_yes()));
        rules.add(new Rules("IMT_norm", "Ph_no", "H_old", "BH_yes", "ST_low", Variables.A_maybe_no()));
        rules.add(new Rules("IMT_norm", "Ph_yes", "H_notOld", "BH_yes", "ST_low", Variables.A_50()));

        rules.add(new Rules("IMT_norm", "Ph_yes", "H_old", "BH_no", "ST_low", Variables.A_maybe_yes()));
        rules.add(new Rules("IMT_norm", "Ph_yes", "H_old", "BH_yes", "ST_high", Variables.A_maybe_no()));
        rules.add(new Rules("IMT_high", "Ph_no", "H_notOld", "BH_yes", "ST_low", Variables.A_maybe_yes()));
        rules.add(new Rules("IMT_high", "Ph_no", "H_old", "BH_no", "ST_low", Variables.A_maybe_yes()));

        rules.add(new Rules("IMT_norm", "Ph_no", "H_old", "BH_yes", "ST_high", Variables.A_maybe_yes()));
        rules.add(new Rules("IMT_high", "Ph_yes", "H_notOld", "BH_no", "ST_low", Variables.A_maybe_yes()));
        rules.add(new Rules("IMT_high", "Ph_yes", "H_notOld", "BH_yes", "ST_high", Variables.A_50()));
        rules.add(new Rules("IMT_high", "Ph_yes", "H_old", "BH_no", "ST_high", Variables.A_maybe_yes()));

        return rules;
    }
}