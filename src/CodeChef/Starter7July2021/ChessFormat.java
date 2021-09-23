package CodeChef.Starter7July2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ChessFormat {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int test = in.nextInt();
        while(test--!=0) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a + b > 60) out.println(4);
            else if (a + b >= 11) out.println(3);
            else if (a + b >= 3) out.println(2);
            else out.println(1);
        }
    }
}
