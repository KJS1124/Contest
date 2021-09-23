package CodeChef.CodeChefJulyChallenge2020;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ChefAndCardGame {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while(t--!=0){
            int n = in.nextInt();
            int arr[] = new int[2];
            for(int i =0; i<n;i++){
                int l = in.nextInt();
                int r = in.nextInt();
                l = sum(l);
                r = sum(r);
                if(l==r){
                    arr[0]++;
                    arr[1]++;
                }
                else if(l>r) arr[0]++;
                else arr[1]++;
            }

            if(arr[1]==arr[0]) out.println(2+" "+arr[1]);
            else if(arr[0]>arr[1]) out.println(0+" "+arr[0]);
            else out.println(1+" "+arr[1]);
        }
    }

    public int sum(int x){
        int ans = 0;
        while(x!=0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }
}
