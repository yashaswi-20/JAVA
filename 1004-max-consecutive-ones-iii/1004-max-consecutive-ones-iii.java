class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
       
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                int len=i-left+1;
                max=Math.max(len,max);
            }else{
                if(k>0){
                 
                    int len=i-left+1;
                    k--;
                    max=Math.max(max,len);
                }else{
                   
                    while(nums[left]!=0){
                        left++;
                       
                    }
                    left++;
                    
                    int len=i-left+1;
                    max=Math.max(max,len);
                }
            }
        }
        return max;
    }
}