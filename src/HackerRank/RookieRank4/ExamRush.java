package HackerRank.RookieRank4;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;

public class ExamRush {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int t = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0 ; i< n;i++)
            list.add(in.nextInt());
        Collections.sort(list);
        int count =0;
        for(int x:list)
            if(t<x)
                break;
            else
            {
                count++;
                t -= x;
            }
        out.println(count);
    }
}
