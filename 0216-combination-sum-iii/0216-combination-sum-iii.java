class Solution {
    List<List<Integer>>res=new ArrayList<>();

    void solve(int i, int k, ArrayList<Integer>temp,int target,int sum){
        if(sum==target && k==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(k==0)return;
        if(sum>target)return;

        for(int j=i;j<=9;j++){
            temp.add(j);

            solve(j+1, k-1 , temp,target, sum+j);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer>temp=new ArrayList<Integer>();
        solve(1,k,temp,n,0);
        return res;
    }
}