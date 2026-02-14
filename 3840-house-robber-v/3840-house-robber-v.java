class Solution {
    int nums[];
    long dp[][];
    int colors[];
    int n;
    
    long helper(int i,int prev ){
        if(i==n)return 0;
        if(dp[i][prev]!=-1)return dp[i][prev];
        long skip=helper(i+1,0);
        boolean cantake=true;
        if(i>0 && prev==1 && colors[i]==colors[i-1]){
        cantake=false;
        }
        long take=0;
        if(cantake){
             take=nums[i]+helper(i+1,1);
        }
        return dp[i][prev]=Math.max(skip,take);
    }
    public long rob(int[] nums, int[] colors) {
        this.nums=nums;
        this.colors=colors;
        this.n=nums.length;
        dp=new long[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return helper(0,0);
    }
}