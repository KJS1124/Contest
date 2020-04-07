package CodeChef.CodeChefAprilChallenge2018;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class AverageOfPairs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while(t--!=0){
            int n =in.nextInt();
            boolean flag[] = new boolean[1000];
            int arr[] = new int[n];
            for(int i=0 ; i<n;i++){
                arr[i] =in.nextInt();
                flag[arr[i]]=true;
            }

            int count =0;
            for(int i=0;i<n;i++){
                for(int j =i+1;j<n;j++){
                    if(arr[i]%2==arr[j]%2 && flag[(arr[i]+arr[j])/2])
                        count++;
                }
            }
            out.println(count);
        }
    }
}