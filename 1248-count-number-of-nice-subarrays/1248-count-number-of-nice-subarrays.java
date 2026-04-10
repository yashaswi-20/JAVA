class Solution {
    int atMost(int []nums,int k){
        int odds=0;
        int left=0;
        int subarrays=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                odds++;
            }
            while(odds>k){
                if(nums[left]%2!=0){
                    odds--;
                }
                left++;
            }
            subarrays+=i-left+1;
        }
        return subarrays;
    }
    public int numberOfSubarrays(int[] nums, int k) {
       return atMost(nums,k)-atMost(nums,k-1);
    }
}