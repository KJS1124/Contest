package CodeChef.CodeChefAprilChallenge2020Division2;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class SquaredSubsequences {
    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t;
        t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            long k = 4;
            long arr[] = new long[n];
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            long p = 1;
            int i = 0, j = 0;
            double ans = 0;
            while (j < n) {
                p = (p * a[j] % k) % k;
                int s = j;
                out.print("p "+p +" ");
                if (p != 2) {
                    long pt = 1;
                    long prev = 1;
                    for (; s >= i; s--) {
                        pt = (pt * a[s] % k) % k;
                        out.print(pt +" ");
                        if (pt != 2) {
                            break;
                        }
                        prev = pt;
                    }
                    ans += (s + 1 - i) * 1.0 * (n - j);
                    i = s + 1;
                    p = prev;
                }

                j++;
            }
            out.println((long) ans);
            //System.out.println();
        }
    }
}

