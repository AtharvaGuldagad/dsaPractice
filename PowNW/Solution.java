package PowNW;

public class Solution {
    public double myPow(double x, int n) {
        if (x==0) return 0;
        if(n== 0) return 1;
        double res = rec(x, Math.abs((long) n));
        return (n>=0)? res: 1/res;
    }
    double rec(double x, long n) {
        if(n==0) return 1;
        double hf=rec(x,n/2);
        return (n%2== 0)?hf*hf :x*hf*hf;
    }
}
