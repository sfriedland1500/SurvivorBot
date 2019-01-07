package com.mda;

public class TwoD {
    public static void main(String[] args) {


        // calculate random SAT 400-1600
        // calculate random GPA 50-100


        int dd[][] = new int[100][2];


        for (int i = 0; i < 100; i++) {

            dd[i][0] = (int) (Math.random() * 100);
            dd[i][1] = (int) (Math.random() * 1601);
        }

        System.out.println(dd[15][0]);
        System.out.println(dd[15][1]);


        // find how many records have values of SAT > 1200
        int count = 0;
        for(int a = 0; a < dd.length; a++){
            if (dd[a][1] > 1200) {
                count++;
            }
        }
        System.out.println(count);
    }
}
