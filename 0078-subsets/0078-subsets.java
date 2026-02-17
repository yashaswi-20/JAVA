class Solution {
    List<List<Integer>>l=new ArrayList<>();
    void helper(int nums[],int i,ArrayList<Integer>list){
        int n=nums.length;
        if(i==n){
            l.add(new ArrayList(list));
            System.out.println("Adding to result: " + list);

            return;
        }
        System.out.println("Entering i=" + i + " list=" + list);
        list.add(nums[i]);
        helper(nums,i+1,list);
        list.remove(list.size()-1);
        System.out.println("Backtracking i=" + i + " list=" + list);
        helper(nums,i+1,list);

        
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer>list=new ArrayList<>();
    
        helper(nums,0,list);
        return l;
    }
}