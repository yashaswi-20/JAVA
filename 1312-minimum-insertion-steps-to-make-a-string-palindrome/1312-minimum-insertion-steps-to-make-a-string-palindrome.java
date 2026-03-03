class Solution {
    int helper(String s1,String s2,int i,int j,int dp[][]){
        if(i<0 || j<0)return 0;

        if(dp[i][j]!=-1)return dp[i][j];
        int match=0;
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=match=1+helper(s1,s2,i-1,j-1,dp);
        }

        return dp[i][j]=Math.max(helper(s1,s2,i-1,j,dp),helper(s1,s2,i,j-1,dp));

    }
    public int minInsertions(String s) {
        StringBuilder sb=new StringBuilder(s);
        String rev=sb.reverse().toString();
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        int res=helper(s,rev,n-1,n-1,dp);
        System.out.println(res);
        System.out.println(n);

        return n-res;
    }
}