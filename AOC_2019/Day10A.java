import java.io.*;
import java.util.*;

public class Day10A {

    //method to read file and return as array
    static char[][] reader(String name){
        File file = new File(name);
        ArrayList<String> input = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            scanner.close();

            char[][] map = new char[input.size()][];

            for (int i = 0; i < input.size(); i++) {
                map[i] = input.get(i).toCharArray();
            }

            return(map);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    // static boolean isVisible(String name){

    //     boolean visible = true;


    //     return visible;
    // }

    public static void main(String[] args) {
        char[][] map = reader("test.txt");

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));            
        }

        // for (int i = 0; i < map.length; i++) {
        //     System.out.println("");
        //     for (int j = 0; j < map[1].length; j++) {
        //         System.out.print(map[i][j]);
        //     }
        // }
                
    }
}


// /* function to check if  
// point collinear or not*/
// static void cool_line(int x1, int y1, int x2,  
//             int y2, int x3, int y3)  
// {  
//     if ((y3 - y2) * (x2 - x1) ==  
//         (y2 - y1) * (x3 - x2))  
//         System.out.println("Yes");  
//     else
//         System.out.println("No");  
// }  
  
// // Driver Code  
      
//     public static void main (String[] args) { 
//         int a1 = 1, a2 = 1, a3 = 0,  
//         b1 = 1, b2 = 6, b3 = 9;  
//        cool_line(a1, b1, a2, b2, a3, b3);  
          
          
//     } 
// } 
// //This Code is Contributed by ajit