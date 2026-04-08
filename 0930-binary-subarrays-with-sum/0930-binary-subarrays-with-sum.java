class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       HashMap<Integer,Integer>map=new HashMap<>();
       int prefix[]=new int[nums.length];
       int val=0;
       for(int i=0;i<nums.length;i++){
            val+=nums[i];
            prefix[i]=val;
       }
       int res=0;
       for(int i=0;i<prefix.length;i++){
        
        if(prefix[i]==goal){
            int add=map.getOrDefault(0,0);
             map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
            res+=add+1;
            System.out.println('a');
        }
        else if(prefix[i]>goal){
            int check=prefix[i]-goal;
            int add=map.getOrDefault(check,0);
             map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
            System.out.println('b');
            res+=add;
        }else{
            System.out.println('c');

            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
       }
        return res;
    }
}