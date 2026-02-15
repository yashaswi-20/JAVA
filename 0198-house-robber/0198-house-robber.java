class Solution {
    int nums[];
    int dp[][];
  
    int n;
    
    int helper(int i,int prev ){
        if(i==n)return 0;
        if(dp[i][prev]!=-1)return dp[i][prev];
        int skip=helper(i+1,0);
        boolean cantake=true;
        if(prev==1){
        cantake=false;
        }
        int take=0;
        if(prev==0){
             take=nums[i]+helper(i+1,1);
        }
        return dp[i][prev]=Math.max(skip,take);
    }
    public int rob(int[] nums) {
        this.nums=nums;
       
        this.n=nums.length;
        dp=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return helper(0,0);
    }
}