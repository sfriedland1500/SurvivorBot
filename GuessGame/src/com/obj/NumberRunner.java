package com.obj;

public class NumberRunner {

    public static void main(String[] args) {


        NumberOne n1 = new NumberOne();
        System.out.println(n1.someVar);
        System.out.println(n1.RANGE_MIN);

        NumberOne n2 = new NumberOne(20);
        System.out.println(n2.someVar);
        System.out.println(n2.RANGE_MIN);


        System.out.println(NumberOne.RANGE_MIN);


        n1.testFunction1();
        n1.testFunction();
        NumberOne.testFunction();

    }
}
