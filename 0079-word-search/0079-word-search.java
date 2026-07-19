class Solution {

    boolean solve(char[][] board, String word, int i, int j, int k,int vis[][]){

        if(i>=board.length || j>= board[0].length || i<0 || j<0)return false;
        if(vis[i][j] ==1)return false;
        if(k==word.length())return true;

        if(board[i][j]!=word.charAt(k)) return false;
        vis[i][j] =1;
        k++;
        if(k==word.length())return true;

        boolean res=solve(board,word, i+1 , j, k,vis) || 
        solve(board,word, i , j+1, k,vis) || 
        solve(board,word, i-1 , j, k,vis) || 
        solve(board,word, i , j-1, k,vis);
        vis[i][j] =0;
        return res;

    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int vis[][] =new int[n][m];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(solve(board,word,i,j,0,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}