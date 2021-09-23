package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class TravelPass {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        String s = in.nextString();
        int countZero = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '0') {
                countZero++;
            }
        }
        out.println(((countZero*a)+((n-countZero)*b)));
    }
}
