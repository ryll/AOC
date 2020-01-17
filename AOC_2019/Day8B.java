import java.io.*;
import java.util.*;

public class Day8B {

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
        String image = "";


        //get decoded image
        for (int i = 0; i < 150; i++) {
            for (String layer : layers) {
                if (layer.charAt(i)=='0') {
                    image += '.';
                    break;
                }
                else if (layer.charAt(i)=='1') {
                    image += '#';
                    break;
                }
            }
        }
        while (!image.isEmpty()) {
            System.out.println(image.substring(0, 25));
            image = image.substring(25);
        }
    }

}