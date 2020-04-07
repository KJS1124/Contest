package VirtualContestCodeforces.Codeforces1;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while(t--!=0){
            String str = in.nextString();
            if(str.matches("^R[0-9]+C[0-9]+")){
                int i=1;
                StringBuilder rowNo  = new StringBuilder();
                while(str.charAt(i)>='0' && str.charAt(i)<='9')
                    rowNo.append(str.charAt(i++));
                i++;
                StringBuilder colNo = new StringBuilder();
                while(i<str.length())
                    colNo.append(str.charAt(i++));
                System.out.println(createString(Integer.parseInt(colNo.toString()))+rowNo);
            }
            else{
                StringBuilder temp =new StringBuilder();
                int i=0;
                while(str.charAt(i)>='A' && str.charAt(i)<='Z')
                    temp.append(str.charAt(i++));
                System.out.println("R"+str.substring(i)+"C"+createNo(temp.toString()));
            }
        }
    }

    public String createString(int n){
        if(n<=0)
            return "";
        n--;
        return createString(n/26) + (char)(n%26 + 'A');
    }

    public long createNo(String str){
        long ans =0;
        for(char c : str.toCharArray())
            ans = ans * 26 + (c - 'A'+1);
        return ans;
    }
}
