
class Solution {
    HashMap<String,Integer>map=new HashMap<>();
    public int uniquePaths(int m, int n) {
        String s=m+","+n;
        if(map.containsKey(s))return map.get(s);
        if(m==1 && n==1)return 1;
        if(m==0 || n==0)return 0;
        
        map.put(s,uniquePaths(m-1,n)+uniquePaths(m,n-1));
       
        return map.get(s);
    }
}