class Solution {
    public int minimumDeletions(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int min_idx=0;
        int max_idx=0;
        if(nums.length==1)return 1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
                min_idx=i;
            }

            if(nums[i]>max){
                max=nums[i];
                max_idx=i;
            }

        }

        //from start
        int mIdx=Math.max(min_idx,max_idx);
        int e1=nums.length-mIdx-1;
        int a1=mIdx+1;
        

        //from end
        int minIdx=Math.min(min_idx,max_idx);
        int e2=minIdx;
        int a2=nums.length-minIdx;

        //from start and end
        System.out.println(minIdx);

        int a3=minIdx+1 + (nums.length-mIdx);
        int e3=nums.length  - a3;

        System.out.println(a1 + " "+ a2 + " " + a3 + " " +e3  );
        // if(e1> e2 && e1 >e3) return a1;

        // else if(e2 > e1 && e2>e3) return a2;

        // else return a3;

        return Math.min(a1, Math.min(a2,a3));

    }
}