class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int postfix[] =new int[nums.length];

        int min=Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<min){
                min=nums[i];
            }
            postfix[i]= min;  
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);

            if(max-postfix[i]<=k){
                return i;
            }
        }
        return -1;
    }
}