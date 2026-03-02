class Solution {
    String s1;
    String s2;
    int helper(int i,int j,int dp[][]){

        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int match=0;
        if(s1.charAt(i)==s2.charAt(j)){
           return dp[i][j]=match=1+helper(i-1,j-1,dp);
        }

        return dp[i][j]=Math.max(helper(i-1,j,dp),helper(i,j-1,dp));
    }
    public int longestPalindromeSubseq(String s) {
        this.s1=s;
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        String rev=sb.reverse().toString();
        this.s2=rev;
        int dp[][]=new int [n][n];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return helper(n-1,n-1,dp);
    }
}