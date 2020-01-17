//import java.io.*;
//import java.util.*;



public class Day4A {

    public static void main(String[] args) {
        //347312-805915
        //347000-800000
        //240920-789857
        //244000-789999
        int pass = 0;
        boolean min = false, max = true;
        for (int a = 2; a < 8; a++) {
            for (int b = a; b < 10; b++) {
                for (int c = b; c < 10; c++) {
                    for (int d = c; d < 10; d++) {
                        for (int e = d; e < 10; e++) {
                            for (int f = e; f < 10; f++) {
                                if (a*100000+b*10000+c*1000 >= 244000) min=true;
                                if (a*100000+b*10000+c*1000 >= 789999) max=false;
                                if ((a==b||b==c||c==d||d==e||e==f)&&min&&max) {
                                    pass++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(pass);
    }
}