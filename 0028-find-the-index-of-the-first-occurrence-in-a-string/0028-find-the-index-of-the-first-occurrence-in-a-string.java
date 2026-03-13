class Solution {
    public int strStr(String haystack, String needle) {
        String s=needle + "$" + haystack;
        int n=s.length();
        int m=needle.length();

        int[] z=new int[n];

        for(int i=1;i<n;i++){
            int j=0;
            while(i+j<n && s.charAt(j)==s.charAt(i+j)){
                j++;
            }
            z[i]=j;
            if(z[i]==m){
                return i-m-1;
            }
        }
        return -1;
    }
}