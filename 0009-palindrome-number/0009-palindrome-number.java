class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int rem=0;
        int val=x;
        while(val>0){
            rem=(rem*10) + (val%10);
            val=val/10;
        }
        return rem==x;
    }
}