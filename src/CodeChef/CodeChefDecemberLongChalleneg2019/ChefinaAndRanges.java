package CodeChef.CodeChefDecemberLongChalleneg2019;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ChefinaAndRanges {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair();
            pair.left = in.nextInt();
            pair.right = in.nextInt();
            pairs.add(pair);
        }

        pairs.sort((l, r) -> {
            return l.left.compareTo(r.left);
        });

        int ans = Integer.MAX_VALUE;
        int tempans = 0;
        int current = 0;
        boolean isNeeded = false;
        for (int i = 1; i < n; i++) {
            boolean isDelete = true;
            if (pairs.get(current).right >= pairs.get(i).left) {
                tempans++;

            } else {
                isDelete = false;
            }
            if (!isDelete) {
                current = i;
                ans = Math.min(ans, tempans);
                tempans = 0;
            }
        }

        out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static class Pair {
        Integer left;
        Integer right;
    }
}
