class Solution {
    public int filo(int n,int[]dp){
        if(n==0)return 0;
        if(n<=2)return 1;
        if(dp[n]!=-1)return dp[n];
        dp[n]= filo(n-1,dp)+filo(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
         return filo(n,dp);
    }
}