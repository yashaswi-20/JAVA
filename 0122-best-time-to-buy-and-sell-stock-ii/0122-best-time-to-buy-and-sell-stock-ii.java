class Solution {
    int prices[];
    int helper(int i,int buy,int dp[][]){
        if(i==prices.length)return 0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        int profit;
        if(buy==1){
            int take =-prices[i] + helper(i+1,0,dp);
            int skip=0+helper(i+1,1,dp);
            profit= Math.max(take,skip);
        }else{
            int sell=prices[i]+helper(i+1,1,dp);
            int skip=0+ helper(i+1,0,dp);
            profit= Math.max(sell,skip);
        }
        return dp[i][buy]=profit;

    }
    public int maxProfit(int[] prices) {
       this.prices=prices;
       int dp[][]=new int [prices.length+1][2];
       for(int i=0;i<=prices.length;i++){
        dp[i][0]=-1;
        dp[i][1]=-1;
       }
        return helper(0,1,dp);
    }
}