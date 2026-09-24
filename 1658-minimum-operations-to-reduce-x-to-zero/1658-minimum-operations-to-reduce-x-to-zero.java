class Solution {
    public int minOperations(int[] nums, int x) {
        int prefix[] = new int[nums.length];

        int sum=0;
        for(int i=0;i<nums.length;i++){
            prefix[i]=sum+nums[i];
            sum+=nums[i];
        }
        int target=sum-x;
        if(target==0) return nums.length;

        HashMap<Integer,Integer>map =new HashMap<>();
        map.put(0,-1);
        int count=0;
        sum=0;
        int  maxlen=-1;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            map.put(sum,i);
            
            if(map.containsKey(sum-target)){
               int prev=map.get(sum-target);
                int len=i-prev;
            maxlen=Math.max(maxlen,len);
            }
           
        }
        if (maxlen == -1) {
            return -1;
        }

        return nums.length - maxlen;


        
    }   
}