class Solution {
    List<String>list=new ArrayList<>();
    void solve(HashMap<Integer,String>map,String digit,int i, String temp){
        if(i==digit.length()){
            list.add(temp);
            return;
        }

        int num=digit.charAt(i)-'0';
        String t=map.get(num);
        for(int j=0;j<t.length();j++){
            solve(map,digit,i+1,temp+t.charAt(j));
            
        }
        
        
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String>map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
       
            solve(map,digits,0,"");
        return list;

    }
}