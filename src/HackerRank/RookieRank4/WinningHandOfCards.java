package HackerRank.RookieRank4;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class WinningHandOfCards {


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int arr[] = new int[n];
        int state = 0;
        int dp[][] = new int[2][m];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) dp[state][j] = dp[state ^ 1][j];
            for (int j = 0; j < m; j++) dp[state][(int) ((  (long) arr[i] * j) % m)] += dp[state ^ 1][j];
            dp[state][(arr[i] % m)]++;
            state = state ^ 1;
        }
        out.println(dp[state ^ 1][x]);
    }
}
