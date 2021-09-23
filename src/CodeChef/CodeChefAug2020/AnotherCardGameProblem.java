package CodeChef.CodeChefAug2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class AnotherCardGameProblem {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int chef = in.nextInt();
        int rick = in.nextInt();
        out.print((getDigits(chef) < getDigits(rick) ? 0 : 1) + " ");
        out.println(Math.min(getDigits(chef), getDigits(rick)));
    }

    private int getDigits(int x) {
        return (x + 8) / 9;
    }
}
