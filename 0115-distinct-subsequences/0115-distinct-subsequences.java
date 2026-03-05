class Solution {

    int helper(String s,String t,int i,int j,int dp[][]){
        if(j==t.length())return 1;
        if(i==s.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(s.charAt(i)!=t.charAt(j)){
            return dp[i][j]= helper(s,t,i+1,j,dp);
        }

        return dp[i][j]=helper(s,t,i+1,j+1,dp) + helper(s,t,i+1,j,dp);
    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
       return helper(s,t,0,0,dp);
    }
}