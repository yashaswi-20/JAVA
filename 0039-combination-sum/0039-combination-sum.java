class Solution {
        List<List<Integer>>res=new ArrayList<>();
        void solve(int candidates[], int target,int i, ArrayList<Integer>temp,int sum){
            if(sum==target){
                    res.add(new ArrayList<>(temp));
                    return;
                }
                
            if(i==candidates.length){
                
                return;
            }

            if(sum<=target){
                temp.add(candidates[i]);
                //System.out.println(temp + " " + sum);
                 solve(candidates, target,i,temp,sum+candidates[i]);
                temp.remove(temp.size()-1);
            }
               
                //System.out.println(temp + " " + sum);
                solve(candidates, target,i+1,temp,sum);

        }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer>temp=new ArrayList<>();
        solve(candidates,target,0,temp,0);
        return res;
    }
}