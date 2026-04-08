class Solution {
    public int trap(int[] height) {
            int maxVolume=0;
            int leftmax=0;
        for(int i=0;i<height.length;i++){
            int left=0;
            int right=height.length-1;
            int rightmax=0;
            
                leftmax=Math.max(leftmax,height[i]);
                System.out.println(leftmax);
            while(right>=i){
                rightmax=Math.max(rightmax,height[right]);
                right--;
            }
            int vol=Math.min(leftmax,rightmax)-height[i];
            maxVolume+=vol;
        }
        return maxVolume;
    }
}