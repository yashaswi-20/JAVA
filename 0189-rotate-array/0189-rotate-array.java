class Solution {
    public void rotate(int[] nums, int k) {
        int j=0;
        int n=nums.length;
        int i=nums.length-1;
        while(j<i){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i--;
            j++;
        }

        i=0;
        j=(k%n)-1;
        while(i<j){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j--;
        }
        
        i=k%n;
        j=n-1;
        while(i<j){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j--;
        }

    }
}