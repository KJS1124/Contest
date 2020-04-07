package VirtualContestCodeforces.Codeforces3;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();
        String t = in.nextString();

        int x1 = s.charAt(0) - 'a';
        int y1 = s.charAt(1) - '0';
        int x2 = t.charAt(0) - 'a';
        int y2 = t.charAt(1) - '0';

        int diff = x1 - x2;
        int diff2 = y1 - y2;
        diff = Math.abs(diff);
        diff2 = Math.abs(diff2);

        int moves = Math.min(Math.abs(x1 - x2), Math.abs(y1 - y2));
        moves += (moves - Math.abs(Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2))));
        out.println(diff>diff2?diff:diff2);
        print(x1,x2,y1,y2,out);

    }


    public void print(int x1, int x2, int y1, int y2, OutputWriter out) {
        if (x1 == x2 && y2 == y1)
            return;
        if (x1 < x2 && y1 < y2) {
            out.println("LD");
            print(x1-1,x2,y1-1,y2,out);
        } else if (x1 < x2 && y1 > y2) {
            out.println("RD");
            print(x1+1,x2,y1+1,y2,out);
        } else if (x1 > x2 && y1 > y2) {
            out.println("LU");
            print(x1+1,x2,y1+1,y2,out);
        } else if (x1 > x2 && y1 < y2) {
            out.println("RU");
            print(x1+1,x2,y1-1,y2,out);
        } else if (x1 == x2) {
            if (y1 < y2) {
                out.println("R");
                print(x1,x2,y1+1,y2,out);
            } else {
                out.println("L");
                print(x1,x2,y1-1,y2,out);
            }
        } else if (y1 == y2) {
            if (x1 < x2) {
                out.println("D");
                print(x1+1,x2,y1,y2,out);
            } else {
                out.println("U");
                print(x1-1,x2,y1,y2,out);
            }

        }

    }

}
