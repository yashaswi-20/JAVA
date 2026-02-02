class Solution {
    int helper(int [][]arr,int r,int c,int dp[][]){
        int n=arr.length;
        if(r==n-1)return arr[r][c];
        int min=Integer.MAX_VALUE;
        if(dp[r][c]!=200)return dp[r][c];
        int down=helper(arr,r+1,c,dp)+arr[r][c];
        int dl=Integer.MAX_VALUE;
        int dr=Integer.MAX_VALUE;
        if(c-1>=0){
           dl =helper(arr,r+1,c-1,dp)+arr[r][c];
        }
        if(c+1<=n-1){
           dr=helper(arr,r+1,c+1,dp)+arr[r][c]; 
        }
        min=Math.min(down,Math.min(dr,dl));
        return dp[r][c]=min;
    }
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int dp[][]=new int[n][n];
        // for(int []a:dp){
        //     Arrays.fill(a,200);
        // }
        // int min=Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //    min=Math.min(min,helper(arr,0,i,dp));
        // }
        // return min;

        //tabulation
        for(int i=0;i<n;i++){
            dp[n-1][i]=arr[n-1][i];
        }
        int min=Integer.MAX_VALUE;
        for(int r=n-2;r>=0;r--){
            for(int c=0;c<n;c++){
                int down=dp[r+1][c]+arr[r][c];
                int dl=(c-1>=0)?dp[r+1][c-1]+arr[r][c]:Integer.MAX_VALUE;
                int dr=(c+1<=n-1)?dp[r+1][c+1]+arr[r][c]:Integer.MAX_VALUE;
                dp[r][c]=Math.min(down,Math.min(dr,dl));

            }
        }
        for(int i=0;i<n;i++){
            min=Math.min(min,dp[0][i]);
        }
        return min;

    }
}