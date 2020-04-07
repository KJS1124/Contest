package USACO.Section1;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class Ride {
    static int mod =47;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String comit = in.nextString();
        String group = in.nextString();
        int comitno = 0;
        int groupno = 0;
        for(char c : comit.toCharArray())
            comitno+= (int) ((int)c - 64);
        for(char c : group.toCharArray())
            group+= (int) ((int)c - 64);
        out.println(comit + " "+group);
        out.println((comitno%mod==groupno%mod?"GO":"STAY"));
    }
}
