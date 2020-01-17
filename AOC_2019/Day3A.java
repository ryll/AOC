import java.io.*;
import java.util.*;
import java.lang.Math;

public class Day3A {
    static MapGuide[] reader(String name, int line) {
        File file = new File(name);
        try{
            Scanner scanner = new Scanner(file);
            if(line==2)scanner.nextLine();
            String[] input = scanner.nextLine().split(",");
            MapGuide[] output = new MapGuide[input.length];
            for (int i=0; i<input.length; i++) {
                output[i] = new MapGuide(input[i].substring(0,1),Integer.parseInt(input[i].substring(1)));
            }
            scanner.close();
    
            return(output);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
   
    public static void main(String[] args) {
        MapGuide[] map = reader("Input3A.txt",1);
        ArrayList<String> posList = new ArrayList<String>();
        posList.add("0,0");
        int posy = 0,posx = 0;
        for (int n = 0; n < map.length; n++) {
            switch (map[n].getDirection()) {
                case "R":
                    for (int i = 0; i < map[n].getAmount(); i++) {
                        posx++;
                        posList.add(posx+","+posy);
                    }
                    break;
                case "L":
                    for (int i = 0; i < map[n].getAmount(); i++) {
                        posx--;
                        posList.add(posx+","+posy);
                    }
                    break;
                case "U":
                    for (int i = 0; i < map[n].getAmount(); i++) {
                        posy++;
                        posList.add(posx+","+posy);
                    }                
                    break;
                case "D":
                    for (int i = 0; i < map[n].getAmount(); i++) {
                        posy--;
                        posList.add(posx+","+posy);
                    }
                    break;
                default:
                    break;
            }
        }
        map = reader("Input3A.txt",2);
        posy = 0;posx = 0;int dist = 0; int tempdist;
        
        for (int n = 0; n < map.length; n++) {
            switch (map[n].getDirection()) {
                case "R":
                    for (int i = 0; i < map[n].getAmount(); i++) {
                        posx++;
                        if (posList.contains(posx+","+posy)) {
                            tempdist = Math.abs(posx)+Math.abs(posy);
                            if (tempdist < dist || dist == 0) {
                                dist = tempdist;                        
                            }
                        }
                    }
                    break;
                case "L":
                    for (int i = 0; i < map[n].getAmount(); i++) {
                        posx--;
                        if (posList.contains(posx+","+posy)) {
                            tempdist = Math.abs(posx)+Math.abs(posy);
                            if (tempdist < dist || dist == 0) {
                                dist = tempdist;                        
                            }
                        }
                    }
                    break;
                case "U":
                    for (int i = 0; i < map[n].getAmount(); i++) {
                        posy++;
                        if (posList.contains(posx+","+posy)) {
                            tempdist = Math.abs(posx)+Math.abs(posy);
                            if (tempdist < dist || dist == 0) {
                                dist = tempdist;                        
                            }
                        }
                    }                
                    break;
                case "D":
                    for (int i = 0; i < map[n].getAmount(); i++) {
                        posy--;
                        if (posList.contains(posx+","+posy)) {
                            tempdist = Math.abs(posx)+Math.abs(posy);
                            if (tempdist < dist || dist == 0) {
                                dist = tempdist;                        
                            }
                        }
                    }
                    break;
                default:
                    break;                
            }
            System.out.println(map.length+", "+ n +", "+dist);    
        }
        System.out.println(dist);
    }
}