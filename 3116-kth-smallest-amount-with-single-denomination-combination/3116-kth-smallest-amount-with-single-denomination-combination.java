class Solution {
    public long findKthSmallest(int[] coins, int k) {
        
        long low=1;
        long high = (long)coins[0]*k;

        while(low<high){
            long mid= low + (high-low)/2;

            long count = findCountOfX(0,1,0,mid,coins);

            if(count >= k){
                high=mid;
            }else{
                low=mid+1;
            }

        }
            return low;
    }

        long findCountOfX(int idx, long lcm, long elements ,long x, int[]coins){

            if(idx ==coins.length ){
                if(elements==0){
                    return 0;
                }

                long count=x/lcm;
                if(elements %2 ==1){
                    return count;
                }else{
                    return -count;
                }
            }

            long notTake = findCountOfX(idx+1, lcm, elements, x, coins);

            long abc= (long) coins[idx];
            long newLcm = findLcm(lcm, coins[idx]);
            long take=0;

            take=findCountOfX(idx+1, newLcm, elements+1, x, coins);

            return take+notTake;
        }

        long findLcm ( long a , long b){
            return a/ gcd(a,b) * b;
        }

        long gcd(long a, long b){
            while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
        }

    
}