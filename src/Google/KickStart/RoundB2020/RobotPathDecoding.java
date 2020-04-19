package Google.KickStart.RoundB2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class RobotPathDecoding {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s  = in.nextString();
        int N =0;
        int E=0;
        int S=0;
        int W=0;
        for(int i =0;i<s.length();i++){

            String temp ="";
            if(s.charAt(i)>='1' && s.charAt(i)<='9'){
                temp=getString(i,s);
                i = geti(i,s);
                i--;
            } else temp += s.charAt(i);
            for(char c : temp.toCharArray())
                switch (c){
                    case 'N': N++; break;
                    case 'W': W++; break;
                    case 'E': E++; break;
                    case 'S': S++; break;
                    default:

                }
        }

        N%=1000000000;
        S%=1000000000;
        E%=1000000000;
        W%=1000000000;
        int r = S+1;
        int c = E+1;
        if(N>S){
            int temp = N-S;
            r=1000000001-temp;
        } else {
            r-=N;
        }

        if(W>E){
            int temp=W-E;
            c = 1000000001-temp;
        } else {
            c-=W;
        }

        out.println("Case #"+testNumber+": "+c+" "+r);
    }

    private int geti(int i, String s) {
        boolean isFirst=true;
        int count=1;
        while(i<s.length() && count!=0){
            if(s.charAt(i)=='(') if(isFirst) isFirst=false; else count++;
            else if(s.charAt(i)==')') count--;
            i++;
        }
        return i;
    }

    public String getString(int i,String s){
        String temp="";
        int number =0;
        String n ="";
        while(i<s.length() && s.charAt(i)>='1' && s.charAt(i)<='9'){
            n+=s.charAt(i);
            i++;
        }
        number = Integer.parseInt(n);
        String temp2="";
        if(s.charAt(i)=='(') i++;
        while(i<s.length() && s.charAt(i)!=')'){
            if(s.charAt(i)>='1' && s.charAt(i)<='9') {
               temp2+= getString(i,s);
               i=geti(i,s);
               i--;
            } else
                temp2+=s.charAt(i);
            i++;
        }
        while (number--!=0){
            temp+=temp2;
        }
        return temp;

    }
}
