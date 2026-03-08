class Solution {
    String s1;
    String s2;

    Boolean helper(int i,int j,Boolean dp[][]){
        if(i<0 && j<0)return true;
        if(j<0)return false;
        if(i<0){
            for(int k=0;k<=j;k++){
                if(s2.charAt(k)!='*')return false;
            }
            return true;
        }
      
        if(dp[i][j]!=null)return dp[i][j];
      if(s1.charAt(i)==s2.charAt(j)){
        return dp[i][j]=helper(i-1,j-1,dp);
      }
      else{
        if(s2.charAt(j)=='?'){
            return dp[i][j]=helper(i-1,j-1,dp);
        }
        else if(s2.charAt(j)=='*'){
            return dp[i][j]=helper(i-1,j,dp) || helper(i,j-1,dp);
        }
        return dp[i][j]=false;
      }
    }
    public boolean isMatch(String s, String p) {
        s1=s;
        s2=p;
        int n=s.length();
        int m=p.length();
        Boolean dp[][]=new Boolean [n][m];
       
        return  helper(n-1,m-1,dp);
    }
}