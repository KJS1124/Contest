package CodeChef.CodeChefMarchLongChallenge2018;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ABigSale {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            double loss = 0;
            for (int i = 0; i < n; i++) {
                double price = in.nextInt();
                int items = in.nextInt();
                double discount = in.nextInt();
                double newPrice = price + (price * (discount / 100));
                loss += (price - (newPrice - (newPrice * (discount / 100)))) * items;
            }
            out.println(loss);
        }
    }
}
