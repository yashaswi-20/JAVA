class Solution {
     void solve(ArrayList<String>res,String curr, int open ,int close,int n){
        if(curr.length()==n*2){
            res.add(curr);
            return ;
        }

        if(open < n){
            solve(res,curr+"(",open+1,close,n);
        }
        if(close < open){
            solve(res , curr + ")", open, close+1 ,n);
        }
    }

    public List<String> generateParenthesis(int n) {
        String curr="";
        int open =0;
        int close =0;
        ArrayList<String>res=new ArrayList<>();
         solve(res,curr,open,close,n);
         return res;
    }
}