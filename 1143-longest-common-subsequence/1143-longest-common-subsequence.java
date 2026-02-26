class Solution {
    String str1;
    String str2;
            int helper(int l1,int l2,int dp[][]){
                if(l1<0 || l2<0){
                   return 0;
                }
                if(dp[l1][l2]!=-1)return dp[l1][l2];
                int match=0;
                if(str1.charAt(l1)==str2.charAt(l2)){
//System.out.println("l1 :"+l1+" l2:"+l2);
                    return dp[l1][l2]=1+helper(l1-1,l2-1,dp);
                }
                return dp[l1][l2]=Math.max(helper(l1,l2-1,dp),helper(l1-1,l2,dp));
            }
    public int longestCommonSubsequence(String str1, String str2) {
        // this.str1=str1;
        // this.str2=str2;
        // int dp[][]=new int[str1.length()][str2.length()];
        // for(int a[]:dp){
        //     Arrays.fill(a,-1);
        // }
        // return helper(str1.length()-1,str2.length()-1,dp);

        //tabulation
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        // if i==0 or j==0 return 0
        for(int i=0;i<n;i++)dp[i][0]=0;
        for(int j=0;j<m;j++)dp[0][j]=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int match=0;
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];

    }
}