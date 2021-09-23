package CodeChef.CodeChefJulyChallenge2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ChefAndStrings {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int first = in.nextInt();
        long ans =0 ;
        for(int i =0;i<n-1;i++){
            int x = in.nextInt();
            ans+=Math.abs(first-x)-1;
            first = x;
        }
        
        out.println(ans);
    }
}
