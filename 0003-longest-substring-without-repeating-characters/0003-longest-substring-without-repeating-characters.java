class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
      for(int i=0;i<s.length();i++){
        int freq[]=new int[256];
        for(int j=i;j<s.length();j++){
            if(freq[s.charAt(j)]==1) break;
               max= Math.max(max,j-i+1);
               freq[s.charAt(j)]=1;
            
        }
      }
      return max;
    }
}