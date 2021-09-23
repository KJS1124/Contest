package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class XOREqual {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        Map<Integer, Integer> noXored = new HashMap<>();
        Map<Integer, Integer> xored = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            noXored.compute(number, (key, value) -> value == null ? 1 : value + 1);
            xored.compute(number ^ x, (key, value) -> value == null ? 1 : value + 1);
        }
        int max = 0;
        int minOperations = Integer.MAX_VALUE;
        for (Map.Entry entry : noXored.entrySet()) {
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            int xorValue = (xored.containsKey(key) ? xored.get(key) : 0);
            xorValue = x == 0 ? 0 : xorValue;
            if (value + xorValue > max) {
                max = value + xorValue;
                minOperations = xorValue;
            } else if (value + xorValue == max) {
                if (minOperations > xorValue) {
                    minOperations = xorValue;
                }
            }
        }

        out.println(max + " " + minOperations);
    }
}
