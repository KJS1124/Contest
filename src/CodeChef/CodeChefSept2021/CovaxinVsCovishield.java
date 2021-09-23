package CodeChef.CodeChefSept2021;

import FastIO.InputReader;
import FastIO.OutputWriter;

import java.math.BigInteger;

public class CovaxinVsCovishield {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int test = in.nextInt();
        long x = in.nextInt();
        long a = in.nextInt();
        long b = in.nextInt();
        long c = in.nextInt();
        long d = in.nextInt();
        long p = in.nextInt();
        long q = in.nextInt();
        long r = in.nextInt();
        long s = in.nextInt();
        long t = in.nextInt();
        long m = in.nextInt();
        for(int i=0;i<test;i++){
            long left = x;
            long ans = getAns(a, b, c, d, left);

            a = getCalculation(a,ans,t,m,p);
            b = getCalculation(b,ans,t,m,q);
            c = getCalculation(c,ans,t,m,r);
            d = getCalculation(d,ans,t,m,s);

            out.println(ans);
        }
    }

    private long getCalculation(long first, long ans,long t,long mod, long second) {
        BigInteger firstB = new BigInteger(String.valueOf(first));
        BigInteger ansB = new BigInteger(String.valueOf(ans));
        BigInteger tB = new BigInteger(String.valueOf(t));
        BigInteger modB = new BigInteger(String.valueOf(mod));
        BigInteger secondB = new BigInteger(String.valueOf(second));

        BigInteger mul = ansB.multiply(tB);
        BigInteger sum = mul.add(firstB);
        BigInteger modAns = sum.mod(modB);
        BigInteger lastAns = modAns.add(secondB);
        return lastAns.longValue();
    }

    private BigInteger getCalculation2(long first, long second, long third) {
        BigInteger firstB = new BigInteger(String.valueOf(first));
        BigInteger secondB = new BigInteger(String.valueOf(second));
        BigInteger thirdB = new BigInteger(String.valueOf(third));

        BigInteger mul = secondB.multiply(thirdB);
        BigInteger lastAns = mul.add(firstB);
        return lastAns;
    }

    private long getAns(long a, long b, long c, long d, long left) {
        BigInteger leftB = new BigInteger(String.valueOf(left));
        long coDCount=1;
        long covDCount=1;
        long ans=0;
        BigInteger co;
        BigInteger cov;

        while(leftB.compareTo(BigInteger.valueOf(0))>0){
            BigInteger used;
            co = getCalculation2(a,coDCount-1,b);
            cov = getCalculation2(c,covDCount-1,d);

            if(co.compareTo(cov)>0){
                used = cov;
                covDCount++;
            }
            else if(co.compareTo(cov)<0){
                used = co;
                coDCount++;
            }
            else {
                if(covDCount>coDCount){
                    used = co;
                    coDCount++;
                }
                else{
                    used = cov;
                    covDCount++;

                }
            }
            if(leftB.compareTo(used)>=0){
                ans++;
                leftB = leftB.subtract(used);
            }
            else break;
        }
        return ans;
    }
}
