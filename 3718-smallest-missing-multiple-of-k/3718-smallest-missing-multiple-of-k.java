class Solution {
    public int missingMultiple(int[] nums, int k) {
        int mul=k;
        while(true){
            int check=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==mul){
                    check=1;
                }
            }
            if(check==0)return mul;
            mul+=k;
            
        }
    }
}