class Solution {

    int helper(String s1,String s2,int n,int m,int dp[][]){
        if(m<0)return n+1;
        if(n<0 )return m+1;

        if(dp[n][m]!=-1)return dp[n][m];
        if(s1.charAt(n)==s2.charAt(m)){
            return dp[n][m]= helper(s1,s2,n-1,m-1,dp);
        }
        int replace=0;
        int delete=0;
        int insert=0;
        delete=1+helper(s1,s2,n-1,m,dp);
        insert=1+helper(s1,s2,n,m-1,dp);
        replace=1+helper(s1,s2,n-1,m-1,dp);
        return dp[n][m]=Math.min(delete,Math.min(insert,replace));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return helper(word1,word2,n-1,m-1,dp);
    }
}