import java.util.*;

public class Intcode {
    //initialize parameters
    private int[] mode = new int[3]; //0=pos, 1=imm, 2=rel
    private int op, num; private int n = 0;
    private long p1, p2, output; private long relbase = 0;

    public Intcode(long[] inProg, long input){
        long prog[] = new long[(int)Math.pow(2,10)*inProg.length];
        for (int i = 0; i < inProg.length; i++) {
            prog[i] = inProg[i];
        }
        op = (int)prog[n]%100;

        outer:
        while(!(op==99)){
            num = (int)prog[n]/100;
            Arrays.fill(mode, 0);
            for (int k = 0; k < 3; k++) {
                mode[k] = num%10;
                num=num/10;
                if (num==0){
                    break;
                }
            }
            switch (op){
                case 1: //addition
                    switch (mode[0]) {
                        case 0:
                            p1 = prog[(int)prog[n+1]];
                            break;
                        case 1:
                            p1 = prog[n+1];
                            break;
                        case 2:
                            p1 = prog[(int)(prog[n+1]+relbase)];
                            break;
                    }
                    switch (mode[1]) {
                        case 0:
                            p2 = prog[(int)prog[n+2]];
                            break;
                        case 1:
                            p2 = prog[n+2];
                            break;
                        case 2:
                            p2 = prog[(int)(prog[n+2]+relbase)];
                            break;
                    }
                    switch (mode[2]) {
                        case 0:
                            prog[(int)prog[n+3]] = p1+p2;
                            break;
                        case 2:
                            prog[(int)(prog[n+3]+relbase)] = p1+p2;
                            break;
                    }
                    n=n+4;
                    break;

                case 2: //multiplication
                    switch (mode[0]) {
                        case 0:
                            p1 = prog[(int)prog[n+1]];
                            break;
                        case 1:
                            p1 = prog[n+1];
                            break;
                        case 2:
                            p1 = prog[(int)(prog[n+1]+relbase)];
                            break;
                    }
                    switch (mode[1]) {
                        case 0:
                            p2 = prog[(int)prog[n+2]];
                            break;
                        case 1:
                            p2 = prog[n+2];
                            break;
                        case 2:
                            p2 = prog[(int)(prog[n+2]+relbase)];
                            break;
                    }
                    switch (mode[2]) {
                        case 0:
                            prog[(int)prog[n+3]] = p1*p2;
                            break;
                        case 2:
                            prog[(int)(prog[n+3]+relbase)] = p1*p2;
                            break;
                    }
                    n=n+4;
                    break;

                case 3: //input
                    switch (mode[0]) {
                        case 0:
                            prog[(int)prog[n+1]] = input;
                            break;
                        case 2:
                            prog[(int)(prog[n+1]+relbase)] = input;
                            break;
                    }
                    n=n+2;
                    break;

                case 4: //output
                    switch (mode[0]) {
                        case 0:
                            output = prog[(int)prog[n+1]];
                            break;
                        case 1:
                            output = prog[n+1];
                            break;
                        case 2:
                            output = prog[(int)(prog[n+1]+relbase)];
                            System.out.println(output);
                            
                            break;
                    }
                    n=n+2;
                    break;

                case 5: //jump if true
                    switch (mode[0]) {
                        case 0:
                            p1 = prog[(int)prog[n+1]];
                            break;
                        case 1:
                            p1 = prog[n+1];
                            break;
                        case 2:
                            p1 = prog[(int)(prog[n+1]+relbase)];
                            break;
                    }
                    switch (mode[1]) {
                        case 0:
                            p2 = prog[(int)prog[n+2]];
                            break;
                        case 1:
                            p2 = prog[n+2];
                            break;
                        case 2:
                            p2 = prog[(int)(prog[n+2]+relbase)];
                            break;
                    }
                    n = (p1!=0) ? (int)p2 : n+3;
                    break;

                case 6: //jump if false
                    switch (mode[0]) {
                        case 0:
                            p1 = prog[(int)prog[n+1]];
                            break;
                        case 1:
                            p1 = prog[n+1];
                            break;
                        case 2:
                            p1 = prog[(int)(prog[n+1]+relbase)];
                            break;
                    }
                    switch (mode[1]) {
                        case 0:
                            p2 = prog[(int)prog[n+2]];
                            break;
                        case 1:
                            p2 = prog[n+2];
                            break;
                        case 2:
                            p2 = prog[(int)(prog[n+2]+relbase)];
                            break;
                    }
                    n = (p1==0) ? (int)p2 : n+3; 
                    break;

                case 7: //less than
                    switch (mode[0]) {
                        case 0:
                            p1 = prog[(int)prog[n+1]];
                            break;
                        case 1:
                            p1 = prog[n+1];
                            break;
                        case 2:
                            p1 = prog[(int)(prog[n+1]+relbase)];
                            break;
                    }
                    switch (mode[1]) {
                        case 0:
                            p2 = prog[(int)prog[n+2]];
                            break;
                        case 1:
                            p2 = prog[n+2];
                            break;
                        case 2:
                            p2 = prog[(int)(prog[n+2]+relbase)];
                            break;
                    }
                    switch (mode[2]) {
                        case 0:
                            prog[(int)prog[n+3]] = (p1<p2) ? 1 : 0;
                            break;
                        case 2:
                            prog[(int)(prog[n+3]+relbase)] = (p1<p2) ? 1 : 0;
                            break;
                    }
                    n=n+4;
                    break;

                case 8: //equals
                    switch (mode[0]) {
                        case 0:
                            p1 = prog[(int)prog[n+1]];
                            break;
                        case 1:
                            p1 = prog[n+1];
                            break;
                        case 2:
                            p1 = prog[(int)(prog[n+1]+relbase)];
                            break;
                    }
                    switch (mode[1]) {
                        case 0:
                            p2 = prog[(int)prog[n+2]];
                            break;
                        case 1:
                            p2 = prog[n+2];
                            break;
                        case 2:
                            p2 = prog[(int)(prog[n+2]+relbase)];
                            break;
                    }
                    switch (mode[2]) {
                        case 0:
                            prog[(int)prog[n+3]] = (p1==p2) ? 1 : 0;
                            break;
                        case 2:
                            prog[(int)(prog[n+3]+relbase)] = (p1==p2) ? 1 : 0;
                            break;
                    }
                    n=n+4;
                    break;

                case 9: //change relbase
                    switch (mode[0]) {
                        case 0:
                            relbase = relbase + prog[(int)prog[n+1]];
                            break;
                        case 1:
                            relbase = relbase + prog[n+1];
                            break;
                        case 2:
                            relbase = relbase + prog[(int)(prog[n+1]+relbase)];
                            break;
                    }
                    n=n+2;
                    break;

                default:
                System.out.println("Error");
                break outer;
            }
            op = (int)prog[n]%100;
        }
    }
    public long getOutput(){
        return output;
    }
}