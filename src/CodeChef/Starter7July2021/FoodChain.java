package CodeChef.Starter7July2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class FoodChain {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int e = in.nextInt();
        int k = in.nextInt();
        int answer = 1;
        while (e / k > 0) {
            answer++;
            e = e / k;
        }
        out.println(answer);
    }
}
