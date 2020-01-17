import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9A {

    //method to read file and return as array
    static long[] reader(String name){
        File file = new File(name);
        try{
            Scanner scanner = new Scanner(file);
            String[] input = scanner.nextLine().split(",");
            long[] program = new long[input.length];
            for (int i=0; i<input.length; i++) {
                program[i] = Long.parseLong(input[i]);
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
        long[] prog = reader("Input9A.txt");
        long input = 2;

        Intcode tester = new Intcode(prog, input);
        System.out.println(tester.getOutput());
                
    }
}