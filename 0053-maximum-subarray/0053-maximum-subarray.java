class Solution {

    int cross(int nums[],int start,int end,int mid){
        int leftMax=Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=start;i--){
            sum+=nums[i];
            leftMax=Math.max(leftMax,sum);
        }
        sum=0;
        int rightMax=Integer.MIN_VALUE;
        for(int i=mid+1;i<=end;i++){
            sum+=nums[i];
            rightMax=Math.max(rightMax,sum);
        }

        return leftMax+rightMax;
    }

    int  divide(int nums[],int start,int end){
        if(start==end){
            return nums[start];
        }
        int max=Integer.MIN_VALUE;
        int mid=start+(end-start)/2;
       int left= divide(nums,start,mid);
       int right= divide(nums,mid+1,end);
       int cross=cross(nums,start,end,mid);

       return Math.max(left,Math.max(right,cross));
    }
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        
        int res=divide(nums,0,n-1);
        return res;
    }
}