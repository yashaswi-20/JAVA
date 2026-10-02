class Solution {
    List<String>res=new ArrayList<>();
    void solve(int i, int j, int n,String temp){
        if(i==n && j==n){
            res.add(temp);
            return;
        }
        if(i>n || j>n)return;


        solve(i+1,j,n,temp+'(');
        if(i>j){
        solve(i,j+1,n,temp+')');
        }
    }

    public List<String> generateParenthesis(int n) {
        solve(0,0,n,"");
        return res;
    }
}