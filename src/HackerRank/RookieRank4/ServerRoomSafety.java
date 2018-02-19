package HackerRank.RookieRank4;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ServerRoomSafety {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int pos[] = new int[n];
        int h[] = new int[n];
        int arr[] = new int[1010];
        boolean left[] = new boolean[1010];
        boolean right[]= new boolean[1010];
        for(int i =0 ; i< n;i++)
            pos[i]=in.nextInt();
        for(int i =0 ; i<n ;i++)
            h[i] = in.nextInt();
        int max=-1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(pos[i]>max)
                max=pos[i]+1;
            if(pos[i]<min)
                min = pos[i]+1;
            arr[pos[i]+1]=h[i];
        }
        left[min]=true;
        for(int i=min;i<=max;i++){
            int x = arr[i];
            int j=i;
            while(x>0 && j<=max) {
                left[++j]=true;
                x--;
            }
        }

        right[max]=true;
        for(int i=max;i>=min;i--){
            int x = arr[i];
            int j=i;
            while(x>0 && j>=min) {
                right[--j]=true;
                x--;
            }
        }
        boolean l =true;
        boolean r =true;
        for (int i =min;i<=max;i++)
            l&=left[i];
        for (int i =min;i<=max;i++)
            r&=right[i];

        if(l && r)
            out.println("BOTH");
        else if(l)
            out.println("LEFT");
        else if(r)
            out.println("RIGHT");
        else
            out.println("NONE");
    }
}
