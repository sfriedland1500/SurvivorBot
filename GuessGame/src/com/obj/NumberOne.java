package com.obj;

public class NumberOne {

    public int someVar;
    public static final int RANGE_MIN = 1111;

    public NumberOne() {
        System.out.println("-- creatign nubmerone instance");
        this.someVar = 15;
    }


    public NumberOne( int arg) {
        this.someVar = arg;
    }


    public static void testFunction() {
        System.out.println("calling static");
    }

    public void testFunction1() {
        System.out.println("calling instance");
    }
}
