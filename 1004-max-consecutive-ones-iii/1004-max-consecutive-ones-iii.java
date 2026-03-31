class Solution {
  public int longestOnes(int[] nums, int k) {
    int left=0;
    int max=0;

      for(int right=0;right<nums.length;right++){
        if(nums[right]==1){
            max=Math.max(max,right-left+1);
        }else{
            if(k>0){
                max=Math.max(max,right-left+1);
                k--;
            }else{
                
              while(nums[left]!=0){
                left++;
              }
              left++;
              
            }
        }
      }
      return max;
}
}