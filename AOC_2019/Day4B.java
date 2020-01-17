//import java.io.*;
//import java.util.*;



public class Day4B {

    public static void main(String[] args) {
        //347312-805915
        //347000-800000
        int pass = 0;
        boolean min = false;
        for (int a = 3; a < 8; a++) {
            for (int b = a; b < 10; b++) {
                for (int c = b; c < 10; c++) {
                    for (int d = c; d < 10; d++) {
                        for (int e = d; e < 10; e++) {
                            for (int f = e; f < 10; f++) {
                                if (a*100000+b*10000+c*1000 >= 347000) min=true;
                                if(min&&((a==b&&b!=c)||(b==c&&a!=b&&c!=d)||(c==d&&b!=c&&d!=e)||(d==e&&c!=d&&e!=f)||(e==f&&d!=e))) {
                                    pass++;
                                    System.out.println(a+""+b+""+c+""+d+""+e+""+f);
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