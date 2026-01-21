class Solution {
        int helper(int nums[],int i,int n,int dp[]){
            if(i==n-1)return nums[i];
            if(i>=n)return 0;
            if(dp[i]!=-1)return dp[i];
            int pick=helper(nums,i+2,n,dp)+ nums[i];
            int skip=helper(nums,i+1,n,dp);
            return dp[i]= Math.max(pick,skip);
        }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,nums.length,dp);
    }
}