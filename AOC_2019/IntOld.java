import java.util.*;
public class IntOld {
    private boolean[] mode = new boolean[2]; //true = immediate, false = position
    //initialize parameters
    private int op, num, p1, p2, output;
    private int[] n = new int[5];
    private int input = 0;
    private int i = 0;
    private boolean inMode;
    private boolean phaseCheck = true;

    public IntOld(int[] inProg, ArrayList<Integer> phase){
        int prog[][] = new int[5][inProg.length];
        for (int s = 0; s < 5; s++) {
            prog[s] = inProg.clone();
            n[s] = 0;
        }

        outer:
        while(!(op==99)){
            //resets values for new loop
            op = prog[i][n[i]]%100; input = output;
            inMode = phaseCheck ? true : false;

            while(!(op==99)){
                num = prog[i][n[i]]/100;
                for (int k = 0; k < 2; k++) {
                    mode[k] = (num%10==1) ? true : false;
                    num=num/10;
                }
                if (op==1) { //addition
                    p1 = (mode[0]) ? prog[i][n[i]+1] : prog[i][prog[i][n[i]+1]];
                    p2 = (mode[1]) ? prog[i][n[i]+2] : prog[i][prog[i][n[i]+2]];
                    prog[i][prog[i][n[i]+3]] = p1+p2;
                    n[i]=n[i]+4;
                } else if (op==2){ //multiplication
                    p1 = (mode[0]) ? prog[i][n[i]+1] : prog[i][prog[i][n[i]+1]];
                    p2 = (mode[1]) ? prog[i][n[i]+2] : prog[i][prog[i][n[i]+2]];
                    prog[i][prog[i][n[i]+3]] = p1*p2;
                    n[i]=n[i]+4;
                } else if (op==3){ //input
                    prog[i][prog[i][n[i]+1]] = inMode ? phase.get(i) : input;
                    inMode = false;
                    n[i]=n[i]+2;
                } else if (op==4){ //output
                    p1 = (mode[0]) ? prog[i][n[i]+1] : prog[i][prog[i][n[i]+1]];
                    output = p1;
                    n[i]=n[i]+2;
                    if (i==4) {
                        i = 0;
                        phaseCheck = false;                        
                    }else{
                        i++;
                    }
                    break;
                } else if (op==5){ //jump if true
                    p1 = (mode[0]) ? prog[i][n[i]+1] : prog[i][prog[i][n[i]+1]];
                    p2 = (mode[1]) ? prog[i][n[i]+2] : prog[i][prog[i][n[i]+2]];
                    n[i] = (p1!=0) ? p2 : n[i]+3;
                } else if (op==6){ //jump if false
                    p1 = (mode[0]) ? prog[i][n[i]+1] : prog[i][prog[i][n[i]+1]];
                    p2 = (mode[1]) ? prog[i][n[i]+2] : prog[i][prog[i][n[i]+2]];
                    n[i] = (p1==0) ? p2 : n[i]+3;                
                } else if (op==7){ //less than
                    p1 = (mode[0]) ? prog[i][n[i]+1] : prog[i][prog[i][n[i]+1]];
                    p2 = (mode[1]) ? prog[i][n[i]+2] : prog[i][prog[i][n[i]+2]];
                    prog[i][prog[i][n[i]+3]] = (p1<p2) ? 1 : 0;
                    n[i]=n[i]+4;
                } else if (op==8){ //equals
                    p1 = (mode[0]) ? prog[i][n[i]+1] : prog[i][prog[i][n[i]+1]];
                    p2 = (mode[1]) ? prog[i][n[i]+2] : prog[i][prog[i][n[i]+2]];
                    prog[i][prog[i][n[i]+3]] = (p1==p2) ? 1 : 0;
                    n[i]=n[i]+4;
                } else {
                    System.out.println("Error");
                    break;
                }
                op = prog[i][n[i]]%100;
                if(op==99){
                    break outer;
                }
                //System.out.println(Arrays.toString(prog[i])+" "+i+" "+n[i]+" "+op);

            }
        }
    }
    public int getOutput(){
        return output;
    }
}