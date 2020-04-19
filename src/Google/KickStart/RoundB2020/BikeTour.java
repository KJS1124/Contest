package Google.KickStart.RoundB2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class BikeTour {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

            int n  = in.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i]= in.nextInt();
            int count=0;
            for(int i =1 ; i< n-1;i++){
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1] ) count++;
            }
            out.println("Case #"+testNumber+": "+count);

    }
}
