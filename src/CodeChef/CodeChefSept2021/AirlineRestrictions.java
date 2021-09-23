package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class AirlineRestrictions {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        if (a + b <= d && c <= e) {
            out.println("YES");
        } else if (a + c <= d && b <= e) {
            out.println("YES");
        } else if (b + c <= d && a <= e) {
            out.println("YES");
        } else {
            out.println("NO");
        }

    }
}
