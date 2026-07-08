class Solution {
        List<List<Integer>>res=new ArrayList<>();
        void solve(int candidates[], int target,int i, ArrayList<Integer>temp,int sum){
            if(sum==target){
                    res.add(new ArrayList<>(temp));
                    return;
            }
            if(sum>target || i==candidates.length){
                return;
            }
           for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j]== candidates[j-1]) continue;
            temp.add(candidates[j]);
            solve(candidates,target,j+1,temp,sum+candidates[j]);
            temp.remove(temp.size()-1);
           }

        }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer>temp=new ArrayList<>();
        solve(candidates,target,0,temp,0);
        return res;
    }
}