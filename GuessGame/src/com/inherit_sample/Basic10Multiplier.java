package com.inherit_sample;

public class Basic10Multiplier implements BasicMultiplier {

    @Override
    public int multiply(int arg) {
        return arg * 10;
    }

    public void whoami() {
        System.out.println("I'm 10 multiplier");
    }

}
