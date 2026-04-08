class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            int temp=0;
            for(int j=i;j<nums.length;j++){
               temp+=nums[j];
               if(temp==goal)res++;
            }
        }
        return res;
    }
}