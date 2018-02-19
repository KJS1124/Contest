package CodeChef.CodeChefFebruaryCookOff2018;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.util.ArrayList;

public class ChefAndTuples {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while(t--!=0){
            long n = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            int count=0;
            ArrayList<Integer>fact = factorize((int)n);
            for(int i =0;i<fact.size();i++)
            {
                for(int j =0 ; j<fact.size();j++)
                {
                    if(i==j)
                        continue;
                    for(int k =0 ; k<fact.size();k++)
                    {
                        if(j==k)
                            continue;
                        if(n==fact.get(i)*fact.get(j)*fact.get(k))
                            count++;
                    }
                }
            }
            out.println(count);
        }
    }

    ArrayList<Integer> factorize(int n) {
        ArrayList<Integer> res=new ArrayList<>();
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                res.add(i);
                n /= i;
            }
        }
        if (n != 1) {
            res.add(n);
        }
        return res;
    }

}
