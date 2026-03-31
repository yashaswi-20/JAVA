class Solution {
    public int totalFruit(int[] fruits) {
        LinkedHashSet<Integer>set=new LinkedHashSet<>();
        int left=0;
        int max=0;
        for(int i=0;i<fruits.length;i++){
            set.add(fruits[i]);
            if(set.size()>2){
                
                int low=left;
                int lowest=left;
               for(int j=i-1;j>=left;j--){
                if(fruits[j]==fruits[i-1]){
                    lowest=j;
                }
                if(fruits[j]!=fruits[i-1]) break;
               }
                left=lowest;
                set.remove(fruits[left-1]);
                 max=Math.max(max,i-left+1);
                
            }else{
               max=Math.max(max,i-left+1);
            }
        }
        return max;
    }
}