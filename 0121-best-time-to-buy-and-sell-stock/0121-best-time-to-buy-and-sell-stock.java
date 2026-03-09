class Solution {
    int prices[];
    int n;
    int helper(int i,int j,int dp[][]){
        if(i<0 || j<0)return 0;

        if(dp[i][j]!=-1)return dp[i][j];
        int pick=Math.max((prices[j]-prices[i]),helper(i-1,j-1,dp));
        
        int skip=Math.max((prices[j]-prices[i]),helper(i-1,j,dp));
        
        return dp[i][j]=Math.max(pick,skip);
    }
    public int maxProfit(int[] prices) {
        // this.prices=prices;
         n=prices.length;
    //     int dp[][]=new int[n][n];
         if(prices.length==1)return 0;
        
    //     for(int i=1;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             int pick=Math.max((prices[j]-prices[i]),dp[i-1][j-1]);
    //             int skip=Math.max((prices[j]-prices[i]),dp[i-1][j]);
    //             dp[i][j]=Math.max(pick,skip);
    //         }
    //     }
    //    return dp[n-1][n-1];
        int mini=prices[0];
        int profit=0;
        for(int i=1;i<n;i++){
            int cost=prices[i]-mini;
            profit=Math.max(profit,cost);
            mini=Math.min(mini,prices[i]);
        }
        return profit;
    }
}