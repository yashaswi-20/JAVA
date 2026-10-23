class Solution {
    public int sortPermutation(int[] nums) {
        int []sorted= Arrays.copyOf(nums,nums.length);
        Arrays.sort(sorted);
        int k=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=sorted[i]){
                if(k==-1){
                    k=nums[i];
                }else{
                    k&=nums[i];
                }
            }
        }

         return k == -1 ? 0 : k;
    }
}