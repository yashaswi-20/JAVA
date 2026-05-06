class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int start=k%n;
        start=n-start;
        int i=0;
        ArrayList<Integer>list=new ArrayList<>();
        
        while(i<n){
            if(start>=n){
                int j=start%n;
                list.add(nums[j]);
                start++;
            }else{
                list.add(nums[start]);
                start++;
            }
            i++;
        }
        for (int j = 0; j < list.size(); j++) {
            nums[j] = list.get(j);
        }
    }
}