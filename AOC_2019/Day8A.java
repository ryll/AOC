import java.io.*;
import java.util.*;

public class Day8A {

    //method to read file and return as array
    static ArrayList<String> reader(String name){
        File file = new File(name);
        try{
            Scanner scanner = new Scanner(file);
            String input = scanner.nextLine();
            ArrayList<String> layers = new ArrayList<>();

            while (!input.isEmpty()) {
                layers.add(input.substring(0, 150));
                input = input.substring(150);
            }
            scanner.close();
            return(layers);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        //get input
        ArrayList<String> layers = reader("Input8A.txt");
        int min = 150; int pos = 0;

        for (int i = 0; i < layers.size(); i++) {
            if ((layers.get(i).length() - layers.get(i).replace("0", "").length())<min) {
                min = layers.get(i).length() - layers.get(i).replace("0", "").length();
                pos = i;
            }
        }
        System.out.println((layers.get(pos).length() - layers.get(pos).replace("1", "").length())*(layers.get(pos).length() - layers.get(pos).replace("2", "").length()) );
    }

}