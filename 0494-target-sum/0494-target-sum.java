class Solution {
    int nums[];
    int helper(int i,int k){
        if(i==0){
            if(k==0 && nums[0]==k)return 2;
            if(k==0 || nums[0]==k)return 1;
            else return 0;
        }
       // System.out.println("k: "+k);
        int pick=0;
        if(k>=nums[i]){
            pick=helper(i-1,k-nums[i]);
        }
        int skip=helper(i-1,k);
        return pick+skip;
    }
    public int findTargetSumWays(int[] nums, int target) {
        this.nums=nums;
        int total=0;
       for(int i=0;i<nums.length;i++){
        total+=nums[i];
       }
       if (total < Math.abs(target)) return 0;
       if((total-target)%2!=0)return 0;
       int find=(total-target)/2;
       return helper(nums.length-1,find);

    }
}