// class Solution {
//         int helper(int nums[],int i,int n,int dp[]){
//             if(i==n-1)return nums[i];
//             if(i>=n)return 0;
//             if(dp[i]!=-1)return dp[i];
//             int pick=helper(nums,i+2,n,dp)+ nums[i];
//             int skip=helper(nums,i+1,n,dp);
//             return dp[i]= Math.max(pick,skip);
//         }
//     public int rob(int[] nums) {
//         int dp[]=new int[nums.length];
//         Arrays.fill(dp,-1);
//         return helper(nums,0,nums.length,dp);
//     }
// }
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
       // if (n == 0) return 0;

        int[] dp = new int[n + 2];  // extra space avoids bounds checks

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
