class Solution {
     HashMap<Integer,Integer>map=new HashMap<>();
    public int filo(int n){
        if(n==0)return 0;
        if(n<=2)return 1;
        if(map.containsKey(n))return map.get(n);
        map.put(n, filo(n-1)+filo(n-2));
        return map.get(n);
    }
    public int fib(int n) {
      
       
         return filo(n);
    }
}