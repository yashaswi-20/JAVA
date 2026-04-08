class Solution {
    public int trap(int[] height) {
            int maxVolume=0;
            int leftmax=0;
            int rmax[]=new int[height.length];
            int rvalue=0;
            for(int i=height.length-1;i>=0;i--){
                rvalue=Math.max(rvalue,height[i]);
                rmax[i]=rvalue;
            }
            int rightmax=0;         
        for(int i=0;i<height.length;i++){
                leftmax=Math.max(leftmax,height[i]);
                rightmax=rmax[i];
            int vol=Math.min(leftmax,rightmax)-height[i];
            maxVolume+=vol;
        }
        return maxVolume;
    }
}