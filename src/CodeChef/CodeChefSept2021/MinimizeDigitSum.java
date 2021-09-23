package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class MinimizeDigitSum {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();

        if (l == n || r == n) {
            out.println(n);
        } else if (l > n && r > n) {
            out.println(l);
        } else if (l < n && r > n) {
            out.println(n);
        } else {
            int min = Integer.MAX_VALUE;
            int base = 0;
            while (l < r && (n / r) < r) {
                int q = n / r;
                int rem = n % r;
                if (min > q + rem) {
                    base = r;
                    min = q + rem;
                }
                r = n / (q + 1);
            }

            while (l <= r) {
                int nn = n;
                int com = 0;
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

    public int sumOfDigit(int n, int b) {
        int unitDigit, sum = 0;
        while (n > 0) {
            unitDigit = n % b;
            sum += unitDigit;
            n = n / b;
        }
        return sum;
    }
}
