package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class MinimumDigitSum2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long l = 2;
        long r = in.nextLong();

        if (l == n || r == n) {
            out.println(n);
        } else if (l > n && r > n) {
            out.println(l);
        } else if (l < n && r > n) {
            out.println(n);
        } else {
            long min = Long.MAX_VALUE;
            long base = 0;
            while (l < r && (n / r) < r) {
                long q = n / r;
                long rem = n % r;
                if (min > q + rem) {
                    base = r;
                    min = q + rem;
                }
                r = n / (q + 1);
            }

            while (l <= r) {
                long nn = n;
                long com = 0;
                while (true) {
                    if (nn < l) {
                        com += nn;
                        if (com < min) {
                            base = l;
                            min = com;
                        }
                        break;
                    }
                    com += nn % l;
                    nn /= l;
                    if (com > min) break;
                }
                l++;
            }
            out.println(base);
        }
    }
}
