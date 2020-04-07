package CodeChef.CodeChefMarchLongChallenge2018;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.HashMap;

public class MixTheColors {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                map.compute((long)x,(key,value)->{
                  if(value==null)
                      return 1;
                  else
                      return value+1;
                });
            }

            //for()
        }
    }
}
