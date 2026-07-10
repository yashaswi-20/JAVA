class Solution {
    List<List<Integer>>res =new ArrayList<>();
    
    void solve(int arr[] , ArrayList<Integer>list, int i){
        if(i==arr.length){
            
            return;
        }
        
       for(int j=i;j<arr.length;j++){
           if(j>i && arr[j]==arr[j-1]) continue;
           list.add(arr[j]);
           res.add(new ArrayList<Integer>(list));
           solve(arr,list,j+1);
           list.remove(list.size()-1);
       }
    }
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer>list =new ArrayList<>();
        res.add(new ArrayList<>(list));
        solve(arr, list , 0);
        return res;
    }
}
