class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N==0){
            return 1;
        }

        if(N<0){
            x=1/x;
            N=-N;
        }
        double half=myPow(x,(int)(N/2));
        if(n%2==0){
            return half*half;
        }

        return half*half*x;
    }
}