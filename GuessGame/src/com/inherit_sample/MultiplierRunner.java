package com.inherit_sample;

public class MultiplierRunner {

    public static void main(String[] args) {

        BasicMultiplier bm = new Basic10Multiplier();
        int res1 = bm.multiply(2);
        System.out.println(res1);

        BasicMultiplier bm10000 = new Basic10000Multiplier();
        int res2 = bm10000.multiply(2);
        System.out.println(res2);

        Basic10Multiplier bm100 = new Basic100Multiplier();
        int res3 = bm100.multiply(2);
        System.out.println(res3);
        bm100.whoami();
    }
}
