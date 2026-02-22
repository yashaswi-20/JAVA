class Solution {
    int coins[];

    int helper(int i,int k,int dp[][]){
        if(k==0)return 1;
        if(i==0){
            if(k%coins[0]==0)return 1;
            else return 0;
        }
        if(dp[i][k]!=-1)return dp[i][k];
        int pick=0;
        if(k>=coins[i]){
            pick=helper(i,k-coins[i],dp);
        }
        int skip=helper(i-1,k,dp);
        return dp[i][k]=pick+skip;
    }
    public int change(int amount, int[] coins) {
        this.coins=coins;
        int dp[][]=new int [coins.length][amount+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return helper(coins.length-1,amount,dp);
    }
}