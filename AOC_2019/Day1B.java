import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1B {

    static int fuelCount(int n){
        n = n/3-2;
        if (n<0){
            return(0);
        }
        return(n+fuelCount(n));
    }

    public static void main(String[] args) {
 
        File file = new File("Input1A.txt");
        
        try{
            Scanner scanner = new Scanner(file);
            int fuel = 0;
            while(scanner.hasNextLine()){
                int input = Integer.parseInt(scanner.nextLine());
                fuel = fuel+fuelCount(input);
            }
            scanner.close();
            System.out.println(fuel);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
}
