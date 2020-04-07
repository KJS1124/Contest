package CodeChef.CodeChefMarchLongChallenge2018;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ChefAndGlove {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            int finger[] = new int[n];
            int gloves[] = new int[n];
            for(int i=0 ; i<n;i++)
                finger[i] = in.nextInt();
            for(int i=0 ; i<n;i++)
                gloves[i] = in.nextInt();

            boolean front = true;
            boolean back = true;
            for(int i=0;i<n;i++)
                if(finger[i]>gloves[i]){
                    front =false;
                    break;
                }
            for(int i=0;i<n;i++)
                if(finger[i]>gloves[n-1-i]){
                    back =false;
                    break;
                }
            if(front && back)
                out.println("both");
            else if(front)
                out.println("front");
            else if(back)
                out.println("back");
            else
                out.println("none");
        }
    }
}
