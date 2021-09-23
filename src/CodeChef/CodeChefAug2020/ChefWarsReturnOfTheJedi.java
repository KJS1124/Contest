package CodeChef.CodeChefAug2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ChefWarsReturnOfTheJedi {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int d = in.nextInt();
        int p = in.nextInt();
        while (p > 0 && d > 0) {
            d -= p;
            p /= 2;
        }
        out.println((d <= 0 ? 1 : 0));
    }
}
