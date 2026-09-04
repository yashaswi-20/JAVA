class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int i=0;
        int max=Integer.MIN_VALUE;
        int stable=Integer.MAX_VALUE;
        int minStable=Integer.MAX_VALUE;
        int resIdx=-1;
        while(i<nums.length){
        int min=Integer.MAX_VALUE;
            if(nums[i]>max){
                max=nums[i];
            }
            for(int j=i;j<nums.length;j++){
                min=Math.min(nums[j],min);
            }
            //System.out.println(max + " " +min);
            if(max-min<=k){
            stable=max-min;
            }
            if(stable<minStable){
                minStable=stable;
                resIdx=i;
                break;
            }

            i++;
        }

        return resIdx;
    }
}