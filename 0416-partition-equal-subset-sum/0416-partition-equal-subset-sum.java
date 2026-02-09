class Solution {
    int helper(int nums[],int k,int n,int dp[][]){
        if(k==0)return 1;
        if(n<0 || k<0)return 0;
        if(dp[k][n]!=-1)return dp[k][n];
        int pick=helper(nums,k-nums[n],n-1,dp);
        int skip=helper(nums,k,n-1,dp);

        return  dp[k][n]=(pick==1 || skip==1 )?1:0;

    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        int find=sum/2;
        boolean dp[][]=new boolean [find+1][nums.length+1];
        // for(int ar[]:dp){
        //     Arrays.fill(ar,-1);
        // }
        // return helper(nums,find,nums.length-1,dp)==1?true:false;
        for(int i=0;i<=nums.length;i++){
            dp[0][i]=true;
        }
        for(int k=1;k<=find;k++){
            for(int n=1;n<=nums.length;n++){
                dp[k][n]=dp[k][n-1];
                if(k>=nums[n-1]){
                    dp[k][n]=dp[k][n] || dp[k-nums[n-1]][n-1];
                }
            }
        }
        return dp[find][nums.length];
    }
}