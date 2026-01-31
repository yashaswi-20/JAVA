class Solution {
    int compute(List<List<Integer>>arr,int r,int c,int lr,int dp[][]){
        if(r==lr-1)return arr.get(r).get(c);
        if(dp[r][c]!=12000)return dp[r][c];
        int same=compute(arr,r+1,c,lr,dp)+arr.get(r).get(c);
        int next=compute(arr,r+1,c+1,lr,dp)+arr.get(r).get(c);
        return dp[r][c]=Math.min(same,next);
    }
    public int minimumTotal(List<List<Integer>> arr) {
        int lr=arr.size();
        int dp[][]=new int[lr][lr];
        for(int [] a:dp){
            Arrays.fill(a,12000);
        }
        return compute(arr,0,0,lr,dp);
    }
}