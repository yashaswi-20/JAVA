class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       HashMap<Integer,Integer>map=new HashMap<>();
       int val=0;
       int res=0;
       map.put(0,1);
       for(int i=0;i<nums.length;i++){
            val+=nums[i];
            res+=map.getOrDefault(val-goal,0);
            map.put(val,map.getOrDefault(val,0)+1);
       }
        return res;
    }
}