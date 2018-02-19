package CodeChef.CodeChefFebruaryCookOff2018;

import FastIO.InputReader;
import FastIO.OutputWriter;

public class ChefAndCookOff {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        for(int i =0 ; i<t;i++)
        {
            int count =0;
            for(int j =0; j<5;j++)
            {
                int x = in.nextInt();
                count+=x;
            }
            switch(count){
                case 0: out.println("Beginner");break;
                case 1: out.println("Junior Developer");break;
                case 2: out.println("Middle Developer"); break;
                case 3: out.println("Senior Developer");break;
                case 4: out.println("Hacker"); break;
                case 5: out.println("Jeff Dean");break;
            }
        }

    }
}
