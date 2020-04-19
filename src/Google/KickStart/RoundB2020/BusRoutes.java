package Google.KickStart.RoundB2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class BusRoutes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.nextInt();
        long d = in.nextLong();
        long arr[] = new long[n];
        long arr2[] = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        if(arr2[n-1]+arr[n-1]<=d) arr2[n-1]=find(arr[n-1],d);

        if(arr.length==1) out.println("Case #"+testNumber+": " +arr[0]);
        else{
            for(int i =n-2;i>=0;i--){
                if(arr2[i]+arr[i]<=arr2[i+1]) arr2[i]+=find(arr[i],arr2[i+1]);
            }
            out.println("Case #"+testNumber+": " +arr2[0]);
        }
    }

    public long find(long x,long y){
        double temp=0;
        temp = y%x;

        return y-(long)(temp);
    }
}
