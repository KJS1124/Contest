package CodeChef.CodeChefAug2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class SmallestKMP {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String str = in.nextString();
        String pat = in.nextString();
        int h[] = new int[26];
        int ph[] = new int[26];
        for (char c : str.toCharArray())
            h[c - 'a']++;
        for (char c : pat.toCharArray())
            ph[c - 'a']++;
        int init = 0;
        for (int i = 0; i < 26; i++) {
            if (h[i] != 0) {
                init = i;
                break;
            }

        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (h[i] > 0) {
                if (i + 'a' == pat.charAt(0) && i != init) break;
                while (h[i] > ph[i]) {
                    ans.append((char) (i + 'a') + "");
                    h[i]--;
                }
                if (i + 'a' == pat.charAt(0)) break;

            }
        }
        ans.append(pat);
        for (char c : pat.toCharArray())
            h[c - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (h[i] > 0) {
                while (h[i] > 0) {
                    ans.append((char) (i + 'a') + "");
                    h[i]--;
                }
            }
        }
        out.println(ans.toString());

    }
}
