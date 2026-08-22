class Solution {
    public boolean checkDivisibility(int n) {
        
        int dsum=0;
        int dmul=1;
        int total=0;
        int rem=n;
        while(n>0){
            int k=n%10;
            dsum+=k;
            dmul*=k;
            n=n/10;
        }
        total=dsum+dmul;

        if(rem%total ==0) return true;
        else return false;
    }
}