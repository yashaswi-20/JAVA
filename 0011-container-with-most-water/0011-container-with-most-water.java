class Solution {
    public int maxArea(int[] height) {
       int left=0;
       int right=height.length-1;
       int maxArea=0;
       while(left<right){
        int small=(height[left]<height[right])?height[left]:height[right];
        int dist=right-left;
        maxArea=Math.max(maxArea,small*dist);
        if(height[left]<height[right]){
            left++;
        }else{
            right--;
        }
       }
       return maxArea;
    }
}