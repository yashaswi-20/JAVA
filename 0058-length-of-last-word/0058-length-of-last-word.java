class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length()-1;
        // int count=0;
        // int check=0;
        // for(int i=n;i>=0;i--){
        //      if(count==0 && s.charAt(i)==' '){
        //         check=1;
        //         continue;
        //     }
        //     else if(check==1 && s.charAt(i)==' ' ){
        //         break;
        //     }
        //     else if(s.charAt(i)!=' ' ){
        //         count++;
        //     }
            
            
           
        // }


        // for (int i=n; i>=0; i--){
        //     if (check == 0){
        //         if (s.charAt(i) != ' '){

        //         }
        //     }
        // }
        int k=n;
        while(s.charAt(k)==' '){
               k--;
            }
       int count=0;
        for (int i=k; i>=0; i--){
           
            if(s.charAt(i)==' ') break;
            else{
                count++;
            }
        }
        return count;
    }
}