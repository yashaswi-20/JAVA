class Solution {
    Boolean dp[];
    boolean solve(List<String>wordDict, String s, int i){
       
        if (i==s.length()) return true;

if (dp[i] != null)
    return dp[i];
      
       for(String word : wordDict){
        if(s.startsWith(word,i)){
            if(solve(wordDict, s ,i+word.length())){
                dp[i] = true;
                return true;
            }
        }
       }
       dp[i] = false;
    return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return solve(wordDict,s,0);
    }
}