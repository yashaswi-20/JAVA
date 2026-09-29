class Solution {


    public boolean dfs(char[][]grid, int i, int j,int s_len,Boolean dp[][][] ){
        

        if(i>=grid.length || j>=grid[0].length) return false;


        s_len= grid[i][j]=='(' ? s_len+1 : s_len-1;
        if(s_len<0){
            return false;
        }
       // System.out.println(i + " " + j+ " " +s_len );
        if(i==grid.length-1 && j==grid[0].length-1){
            
            if(s_len==0){
               // System.out.println("hit");
                return true;
            }else{
                return false;
            }
        }
        
        if(dp[i][j][s_len]!=null)return dp[i][j][s_len];
        


        boolean right=dfs(grid,i,j+1,s_len,dp);
        boolean down=dfs(grid,i+1, j,s_len,dp);

        return dp[i][j][s_len] = right || down;

    }
    public boolean hasValidPath(char[][] grid) {
        
        int n=grid.length, m=grid[0].length;
       Boolean dp[][][] =new Boolean [n+1][m+1][n+m+1];
        return dfs(grid,0,0,0,dp);

    }
}