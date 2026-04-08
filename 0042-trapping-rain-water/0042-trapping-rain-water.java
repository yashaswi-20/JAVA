class Solution {
    public int trap(int[] height) {
            int maxVolume=0;
            int leftmax=0;
            int rmax[]=new int[height.length];
            int rvalue=0;
            for(int i=height.length-1;i>=0;i--){
                rvalue=Math.max(rvalue,height[i]);
                rmax[i]=rvalue;
                //System.out.println(rmax[i]);
            }
            int rightmax=0;         
        for(int i=0;i<height.length;i++){
            int left=0;
            int right=height.length-1;
                leftmax=Math.max(leftmax,height[i]);
            
                rightmax=rmax[i];
                
            
            int vol=Math.min(leftmax,rightmax)-height[i];
            maxVolume+=vol;
        }
        return maxVolume;
    }
}