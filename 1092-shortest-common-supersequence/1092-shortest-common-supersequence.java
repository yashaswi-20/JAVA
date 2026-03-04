class Solution {

  

    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int [n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        String lcs="";
            int i=n;
            int j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                lcs+=str1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j]<dp[i][j-1]){
                j--;
            }else{
                i--;
            }
        }
        StringBuilder sb=new StringBuilder(lcs);
        lcs=sb.reverse().toString();
        int a=0;
        int b=0;
        String res="";
        System.out.println(lcs);
        for(int k=0;k<lcs.length();k++){
            while(str1.charAt(a)!=lcs.charAt(k) && a<str1.length()){
                System.out.println(str1.charAt(a)+" "+lcs.charAt(k) +" "+  a+" "+k);
                res+=str1.charAt(a);
                a++;
            }
            a++;
            while(str2.charAt(b)!=lcs.charAt(k) && b<str2.length()){
                res+=str2.charAt(b);
                b++;
            }
            b++;
            res+=lcs.charAt(k);

        }
        if(a<=str1.length()-1){
            res+=str1.substring(a);
        }
        if(b<=str2.length()-1){
            res+=str2.substring(b);
        }

        return res;
    }
}