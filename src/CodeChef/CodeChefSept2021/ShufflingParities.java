package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ShufflingParities {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            oddCount += x % 2 == 1 ? 1 : 0;
            evenCount += x % 2 == 0 ? 1 : 0;
        }
        int ans = 0;
        if (oddCount != 0 || evenCount != 0) {
            ans = oddCount < evenCount ? oddCount : evenCount;
            oddCount -= ans;
            evenCount -= ans;
            ans *= 2;
        }
        if (oddCount != 0) {
            ans += oddCount / 2;
        } else {
            ans += evenCount / 2;
            ans += evenCount%2;
        }
        out.println(ans);
    }
}
