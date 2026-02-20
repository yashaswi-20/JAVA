class Solution {
    int coins[];
    int helper(int i,int k,int dp[][]){
        if(i==0){
            if(k%coins[0]==0)return k/coins[0];
            else return (int)1e9;
        }
        if(dp[i][k]!=-1)return dp[i][k];
        int pick=Integer.MAX_VALUE;
        if(coins[i]<=k){
            pick=1+helper(i,k-coins[i],dp);
        }
        int skip=helper(i-1,k,dp);
        return dp[i][k]= Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        this.coins=coins;
        int dp[][]=new int [coins.length][amount+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
       int res=  helper(coins.length-1,amount,dp);
       int comp=(int)1e9;
       if(res==comp)return -1;
       return res;
    }
}