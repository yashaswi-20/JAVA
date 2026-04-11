class Solution {
    
    public int numberOfSubstrings(String s) {
      HashMap<Character,Integer>map=new HashMap<>();
      int left=0;
      int res=0;
      for(int right=0;right<s.length();right++){
        map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
          while(map.containsKey('a') && map.containsKey('b') && map.containsKey('c') && map.get('a')>0 
                && map.get('b')>0 && map.get('c')>0){
                    int temp=s.length()-1-right+1;
                    res+=temp;
                    map.put(s.charAt(left),map.get(s.charAt(left))-1);
                    left++;
                   
            }
      }
      return res;
    }
}