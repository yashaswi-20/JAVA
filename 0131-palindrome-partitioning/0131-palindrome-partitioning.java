class Solution {
    List<List<String>>res =new ArrayList<>();
    public List<List<String>> partition(String s) {
        ArrayList<String>temp =new ArrayList<>();
        solve(s,0,temp);
        return res;
    }
    void solve(String s,int idx, ArrayList<String>temp){
        if(idx==s.length()){
            res.add(new ArrayList<>(temp));
        }

        for(int i=idx;i<s.length();i++){
            if(partition(s,idx,i)){
                temp.add(s.substring(idx,i+1));
                solve(s,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    boolean partition(String s,int sidx, int eidx){
        int i=sidx;
        int j=eidx;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}