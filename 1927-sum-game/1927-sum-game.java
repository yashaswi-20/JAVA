class Solution {
    public boolean sumGame(String num) {
        int left=0;
        int right= num.length()-1;
        int leftSum=0;
        int rightSum=0;
        int leftQ=0;
        int rightQ=0;
        while(left<right){
            char l=num.charAt(left);
            char r=num.charAt(right);
            if(l=='?'){
                leftQ++;
            }else{
                leftSum+=l -'0';
            }

            if(r=='?'){
                rightQ++;
            }else{
                rightSum+= r- '0';
            }

            left++;
            right--;
        }
        int Sdiff= leftSum-rightSum;
        int Qdiff=rightQ-leftQ;
        if(leftQ==rightQ){
            if(leftSum==rightSum){
                return false;
            }else{
                return true;
            }
        }
        System.out.print(Sdiff+ " " + Qdiff);
        return Sdiff != 9* Qdiff/2.0;
    }
}