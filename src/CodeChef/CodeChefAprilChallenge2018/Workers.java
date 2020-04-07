package CodeChef.CodeChefAprilChallenge2018;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class Workers {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        Long id[] = new Long[3];
        id[0]=(long)Integer.MAX_VALUE;
        id[1]=(long)Integer.MAX_VALUE;
        id[2]=(long)Integer.MAX_VALUE;
        for(int i =0 ; i<n;i++)
            arr[i]=in.nextInt();
        for(int i =0 ; i<n;i++){
            int x = in.nextInt();
            if(id[x-1]>arr[i])
                id[x-1]=(long)arr[i];
        }

        out.println((id[2]<id[0]+id[1]?id[2]:id[0]+id[1]));
    }
}
