import java.io.*;
import java.util.*;

public class Day6B {

    static ArrayList<String> reader(String name){
        File file = new File(name);
        try{
            Scanner scanner = new Scanner(file);
            ArrayList<String> list = new ArrayList<String>();
            while(scanner.hasNextLine()){
                list.add(scanner.nextLine());                
            }            
            scanner.close();
            return(list);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String,Integer> orbits = new HashMap<String,Integer>();
        orbits.put("COM",0);
        ArrayList<String> input = reader("Input6A.txt.");
        ArrayList<String> from = new ArrayList<String>();
        ArrayList<String> to = new ArrayList<String>();
        ArrayList<String> YOU = new ArrayList<String>();
        Queue<String> left = new LinkedList<>();
        String last = "YOU";
        String intersect = null;
        for (int i = 0; i < input.size(); i++) {
            from.add(input.get(i).substring(0,3));    
            to.add(input.get(i).substring(4));    
        }
        while(!last.equals("COM")){
            last = from.get(to.indexOf(last));
            YOU.add(last);        
        } 
        last = "SAN";
        while(!last.equals("COM")){
            last = from.get(to.indexOf(last));
            if(YOU.contains(last)){
                intersect = last;
                break;
            } 
        }   
        String next = "COM";
        while (!from.isEmpty()) {
            while (from.contains(next)) {
                orbits.put(to.get(from.indexOf(next)), orbits.get(next)+1);
                left.add(to.get(from.indexOf(next)));
                to.remove(from.indexOf(next));
                from.remove(from.indexOf(next));       
            }
            next = left.poll();            
        }
        System.out.println(orbits.get("YOU")+orbits.get("SAN")-2*orbits.get(intersect)-2);
    }
}