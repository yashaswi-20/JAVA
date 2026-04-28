class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer>map=new HashMap<>();
        List<Integer>res=new ArrayList<>();
        int skip=words[0].length();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        //System.out.println(map);
        for(int i=0;i<skip;i++){
            int left=i;
            HashMap<String,Integer>seen=new HashMap<>();
            int count=0;
            for(int j=i;j<=s.length()-skip;j+=skip){
                String key=s.substring(j,j+skip);
                if(map.containsKey(key)){
               // System.out.println(seen+" "+count+" "+left);
                count++;
                seen.put(key,seen.getOrDefault(key,0)+1);
              //  System.out.println(seen+" "+count+" "+left);

                while(seen.get(key)>map.get(key)){
                  //  System.out.println(seen.get(key)+" "+map.get(key)+" "+count);
                    String del=s.substring(left,left+skip);
                    seen.put(del,seen.get(del)-1);
                    left+=skip;
                    count--;
                }
                if(count==words.length){
                 //   System.out.println(left);
                    res.add(left);
                }
                }else{
               //     System.out.println(key);
                    seen.clear();
                    left=j+skip;
                    count=0;

                }
            }
        }

        return res;
    }
}