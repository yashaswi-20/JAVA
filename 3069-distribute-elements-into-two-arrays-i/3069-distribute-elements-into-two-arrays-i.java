class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer>l1=new ArrayList<>();
        ArrayList<Integer>l2= new ArrayList<>();
        if(nums.length<=2) return nums;

        l1.add(nums[0]);
        l2.add(nums[1]);

        for(int i=2;i<nums.length;i++){
            if(l1.getLast() > l2.getLast()){
                l1.add(nums[i]);
            }else{
                l2.add(nums[i]);
            }
        }
        int res[]= new int[nums.length];

        for(int i=0;i<l1.size();i++){
            res[i]= l1.get(i);
        }

        int k=l1.size();

        for(int j=0;j<l2.size();j++){
            res[k]=l2.get(j);
            k++;
        }

        return res;

    }
}