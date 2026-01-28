class Solution {
    int helper(int [][]arr,int row,int col,int dp[][]){
        if(row==0 && col==0)return 1;
        if(row<0 || col<0)return 0;
        if(arr[row][col]==1)return 0;
        if(dp[row][col]!=-1)return dp[row][col];

        return dp[row][col]=helper(arr,row-1,col,dp)+helper(arr,row,col-1,dp);
    }

    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int dp[][]=new int[m][n];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        if(arr[0][0]==1)return 0;
        return helper(arr,m-1,n-1,dp);
    }
}