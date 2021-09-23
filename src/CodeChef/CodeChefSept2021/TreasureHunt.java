package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.Vector;

public class TreasureHunt {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.nextInt();
        long m = in.nextInt();
        long mod = 998244353;
        long max = Math.max(n, m);
        long ans = 0;
        for (int distance = 1; distance < n * m - 2; distance++) {
            long totalSum = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    totalSum += calculate(n, m, i, j, distance);
                }
            }
            ans = (long) ((ans + ((totalSum) * power(31, distance - 1, mod))) % mod);
        }

        out.println(ans);
    }

    public long calculate(long n, long m, long x, long y, long distance) {
        long area = 4*distance;
        area -= 2 * distance + 1 - 2 * x;
        if (x + distance > m) area -= 2 * distance + 1 - 2 * (m - x + 1);
        area -= 2 * distance + 1 - 2 * y;
        if (y + distance > n) area -= 2 * distance + 1 - 2 * (n - y + 1);

        area += distance - (x + y) + 1;
        if (distance >= x + n - y + 1) area += distance - (x + n - y + 1) + 1;
        area += distance - (m - x + 1 + y) + 1;
        final long l = m - x + 1 + n - y + 1;
        if (distance >= l) area += distance - (l) + 1;
        return area;
    }

    public long power(long number, long x, long mod) {
        long result = 1;
        number %= mod;
        if (number == 0) return 0;
        while (x > 0) {
            if ((x & 1) != 0) result = (result * number) % mod;

            x = x >> 1;
            number = (number * number) % mod;
        }
        return result;
    }
}
