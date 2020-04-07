package VirtualContestCodeforces.Codeforces1;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        double x = in.nextInt();
        double y = in.nextInt();
        double a = in.nextInt();
        double ans = Math.ceil(x/a) * Math.ceil(y/a);
        System.out.println((long)ans);
    }
}
