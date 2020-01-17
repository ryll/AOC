import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1A {
    public static void main(String[] args) {
 
        File file = new File("Input1A.txt");
        
        try{
            Scanner scanner = new Scanner(file);
            int fuel = 0;
            while(scanner.hasNextLine()){
                int input = Integer.parseInt(scanner.nextLine());
                fuel = fuel+input/3-2;
            }
            scanner.close();
            System.out.println(fuel);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
}
