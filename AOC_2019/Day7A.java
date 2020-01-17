import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day7A {

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
        int[] prog = reader("Input7A.txt");
        int max = 0;
        
        //get permutations
        ArrayList<Integer> vals = new ArrayList<>();
        Collections.addAll(vals, 0,1,2,3,4);
        HashSet<ArrayList<Integer>> perm = getPerm(vals);
        
        //loop through permutations
        for (ArrayList<Integer> arrL : perm) {
            IntOld amp = new IntOld(prog, arrL);
            max = amp.getOutput()>max ? amp.getOutput() : max;
        }
        System.out.println(max);
        
    }

    public static HashSet<ArrayList<Integer>> getPerm(ArrayList<Integer> vals){
        
        //return empty hashset if vals is empty
        if (vals.size()==1) {   
            HashSet<ArrayList<Integer>> one = new HashSet<>();
            one.add(vals);
            return one;
        }
        //get initial value
        int first = vals.get(0);

        //get array w/o initial
        ArrayList<Integer> vals2 = vals;
        vals2.remove(0);

        //recursive call
        HashSet<ArrayList<Integer>> rest = getPerm(vals2);

        HashSet<ArrayList<Integer>> perms = new HashSet<>();

        int loop;
        for (ArrayList<Integer> val : rest) {
            loop = val.size(); 
            for (int i = 0; i <= loop; i++) {
                ArrayList<Integer> valTemp = new ArrayList<>(val);
                valTemp.add(i,first); 
                perms.add(valTemp);               
            }            
        }
        return perms;
    }
}