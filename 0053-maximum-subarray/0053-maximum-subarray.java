class Solution {

    int findCross(int nums[], int start, int mid ,int end){
        int leftMax=Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=start;i--){
            sum+=nums[i];
            leftMax=Math.max(sum,leftMax);
        }

         sum=0;
        int rightMax=Integer.MIN_VALUE;
        for(int i=mid+1;i<=end;i++){
            sum+=nums[i];
            rightMax=Math.max(sum,rightMax);
        }
        return leftMax+rightMax;
    }

    int divide(int[] nums,int start,int end){
        if(start==end)return nums[start];

        int mid=(start+end)/2;
        int left=divide(nums,start,mid);
        int right=divide(nums,mid+1,end);
        int cross=findCross(nums,start,mid,end);
        return Math.max(left, Math.max(right,cross));
    }

    public int maxSubArray(int[] nums) {
        
       int res=divide(nums, 0, nums.length-1);
       return res;
        
    }
}