class Solution {
    List<List<String>>res=new ArrayList<>();
    void solve(int idx, String s, ArrayList<String>temp){
        if(idx==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(partition(i,s,idx)){
                temp.add(s.substring(idx,i+1));
            
            solve(i+1,s,temp);
            temp.remove(temp.size()-1);
            }
        }
    }
    boolean partition(int endidx, String s,int startidx){
        int i=startidx;
        int j=endidx;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        solve(0,s,new ArrayList());
        return res;
    }
}