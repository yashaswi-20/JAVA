class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left=0;
        int sum=0;
        int result=0;
       for(int right=0;right<nums.length;right++){
            sum+=nums[right];
                while(sum>goal){
                sum-=nums[left];
                left++;
            }
            result+=right-left+1;
       }
       int left1=0;
        int sum1=0;
        int result1=0;
        for(int right=0;right<nums.length;right++){
            if(goal<=0){
                result1=0;
                break;
            }
            sum1+=nums[right];
                while(sum1>goal-1){
                sum1-=nums[left1];
                left1++;
            }
            result1+=right-left1+1;
       }
       return result-result1;

    }
}