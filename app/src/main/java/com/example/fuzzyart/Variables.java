package com.example.fuzzyart;

public class Variables {

    public static double IMT_norm(int x){
        return AttachFunc.left(27,28,x);
    }

    public static double IMT_high(int x){
        return AttachFunc.right(27,28,x);
    }

    public static double Ph_yes(int x){
        return AttachFunc.right(0.1,0.9,x);
    }

    public static double Ph_no(int x){
        return AttachFunc.left(0.1,0.9,x);
    }

    public static double H_notOld(int x){
        return AttachFunc.left(54,55,x);
    }

    public static double H_old(int x){
        return AttachFunc.right(54,55,x);
    }

    public static double BH_yes(int x){
        return AttachFunc.right(0.1,0.9,x);
    }

    public static double BH_no(int x){
        return AttachFunc.left(0.1,0.9,x);
    }

    public static double ST_high(int x){
        return AttachFunc.left(6000,7000,x);
    }

    public static double ST_low(int x){
        return AttachFunc.right(6000,7000,x);
    }

    public static double A_no(){
        return 0;
    }
    public static double A_maybe_no(){
        return 1;
    }
    public static double A_50(){
        return 2;
    }
    public static double A_maybe_yes(){
        return 3;
    }
    public static double A_yes(){
        return 4;
    }
}



