package CodeChef.CodeChefDecemberLongChalleneg2019;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class Addition {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();
        String s2 = in.nextString();
        StringBuffer temp = new StringBuffer();
        int extra = Math.abs(s.length() - s2.length());
        for (int i = 0; i < extra; i++) temp.append("0");
        if (s.length() < s2.length()) s = temp.toString()+s;
        else s2 = temp.toString()+s2;
        s='0'+s;
        s2='0'+s2;
        out.println(findSolution(this, s, s2));
    }

    public static int findSolution(Addition addition, String s, String s2) {
        int max = 0;
        int isFound = find(s2);
        int tempmax = 0;
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int first = (int) (s.charAt(i) - '0');
            int second = (int) (s2.charAt(i) - '0');
            carry = carry + first + second;
            if (carry == 2) tempmax++;
            else if (carry==3) tempmax = 1;
            else tempmax = 0;
            carry /= 2;
            max = Math.max(max, tempmax+1);
        }
        return max*isFound;
    }

    public static int find(String s) {
        for (char c : s.toCharArray())
            if (c == '1') return 1;
        return 0;
    }
}
