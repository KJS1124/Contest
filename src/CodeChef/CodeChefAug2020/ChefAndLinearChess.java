package CodeChef.CodeChefAug2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ChefAndLinearChess {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (k % x == 0) {
                ans = Math.max(ans, x);
            }
        }
        out.println(ans);
    }
}
