package CodeChef.CodeChefAprilChallenge2020Division2;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.ArrayList;

public class UnitGCD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.nextInt();
        while (n-- > 0) {
            int k = in.nextInt();
            if (k == 1) {
                out.println(1);
                out.println(1 + " " + 1);
                continue;
            }
            int size = k / 2;
            ArrayList list[] = new ArrayList[size];
            boolean a[] = new boolean[k + 1];
            for (int i = 0; i < size; i++) {
                list[i] = new ArrayList<>();
            }
            for (int j = 1; j <= list.length; j++) {
                if (!a[2 * j] && 2 * j <= k) {
                    list[j - 1].add(2 * j);
                    a[2 * j] = true;
                }
            }
            int p = 1;
            for (int i = 0; i < list.length; i++) {
                list[i].add(p);
                a[p] = true;
                p = p + 2;
            }
            if (k % 2 == 1 && !a[p]) list[0].add(p);
            out.println(size);
            for (int i = 0; i < list.length; i++) {
                ArrayList<Integer> temp = list[i];
                out.print(temp.size() + " ");
                for (int j=0;j<temp.size();j++) {
                    out.print(temp.get(j));
                    if(j!=temp.size()-1)    out.print(" ");
                }
                out.println();
            }
        }
    }
}
