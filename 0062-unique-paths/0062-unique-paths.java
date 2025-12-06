class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
        public boolean equals(Object o){
            Pair p=(Pair)o;

            return p.x==x && p.y==y;
        }
        public int hashCode(){
            return 31*x+y;
        }
    
}

class Solution {
    HashMap<Pair,Integer>map=new HashMap<>();
    public int uniquePaths(int m, int n) {
        Pair key=new Pair(m,n);
        if(map.containsKey(key))return map.get(key);
        if(m==1 && n==1)return 1;
        if(m==0 || n==0)return 0;
        
        int ways=uniquePaths(m-1,n)+uniquePaths(m,n-1);
        map.put(key,ways);
        return ways;
    }
}