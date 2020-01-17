import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5A {

    //method to read file and return as array
    static int[] reader(String name){
        File file = new File(name);
        try{
            Scanner scanner = new Scanner(file);
            String[] input = scanner.nextLine().split(",");
            int[] program = new int[input.length];
            for (int i=0; i<input.length; i++) {
                program[i] = Integer.parseInt(input[i]);
            }
            scanner.close();
            return(program);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
   
    public static void main(String[] args) {

        //get input
        int[] prog = reader("Input5A.txt");

        //initialize parameters
        int n = 0;
        int p1,p2;
        int op = prog[n]%100;
        boolean[] mode = new boolean[2]; //true = immediate, false = position
        while(!(op==99)){
            int num = prog[n]/100;
            for (int i = 0; i < 2; i++) {
                mode[i] = (num%10==1) ? true : false;
                num=num/10;
            }
            if (op==1) { //addition
                p1 = (mode[0]) ? prog[n+1] : prog[prog[n+1]];
                p2 = (mode[1]) ? prog[n+2] : prog[prog[n+2]];
                prog[prog[n+3]] = p1+p2;
                n=n+4;
            } else if (op==2){ //multiplication
                p1 = (mode[0]) ? prog[n+1] : prog[prog[n+1]];
                p2 = (mode[1]) ? prog[n+2] : prog[prog[n+2]];
                prog[prog[n+3]] = p1*p2;
                n=n+4;
            } else if (op==3){ //input
                Scanner scan = new Scanner(System.in);
                System.out.printf("Enter input value:  ");
                int temp = scan.nextInt();
                scan.close();
                prog[prog[n+1]] = temp;
                n=n+2;
            } else if (op==4){ //output
                p1 = (mode[0]) ? prog[n+1] : prog[prog[n+1]];
                System.out.println("Output: "+p1);
                n=n+2;
            } else if (op==5){ //jump if true
                p1 = (mode[0]) ? prog[n+1] : prog[prog[n+1]];
                p2 = (mode[1]) ? prog[n+2] : prog[prog[n+2]];
                n = (p1!=0) ? p2 : n+3;
            } else if (op==6){ //jump if false
                p1 = (mode[0]) ? prog[n+1] : prog[prog[n+1]];
                p2 = (mode[1]) ? prog[n+2] : prog[prog[n+2]];
                n = (p1==0) ? p2 : n+3;                
            } else if (op==7){ //less than
                p1 = (mode[0]) ? prog[n+1] : prog[prog[n+1]];
                p2 = (mode[1]) ? prog[n+2] : prog[prog[n+2]];
                prog[prog[n+3]] = (p1<p2) ? 1 : 0;
                n=n+4;
            } else if (op==8){ //equals
                p1 = (mode[0]) ? prog[n+1] : prog[prog[n+1]];
                p2 = (mode[1]) ? prog[n+2] : prog[prog[n+2]];
                prog[prog[n+3]] = (p1==p2) ? 1 : 0;
                n=n+4;
            } else {
                System.out.println("Error");
            }
            op = prog[n]%100;
        }
    }
}