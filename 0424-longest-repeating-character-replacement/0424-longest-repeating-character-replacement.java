class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen=0;
        int j=0;
        int n=s.length();
        int maxfreq=0;
        int freq[]=new int[26];
        int i=0;
        while(j<n){
            freq[s.charAt(j)-'A']++;
            for(int p=0;p<26;p++){
                maxfreq=Math.max(maxfreq,freq[p]);
            }
            if((j-i+1)-maxfreq<=k){
                maxlen=Math.max(maxlen,j-i+1); 
            }else{
                while( (j-i+1)-maxfreq>k){
                    freq[s.charAt(i)-'A']--;
                    i++;
                }
            }
            j++;
        }
        return maxlen;
    }
}