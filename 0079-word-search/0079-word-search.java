class Solution {

    boolean solve(char [][]board, String word, int i , int j, int k,int n,int [][]vis){
        if(i>=board.length ||j>=board[0].length || i < 0 || j < 0  )return false;
        if (vis[i][j] == 1)
        return false;

        if(k==n)return true;

      if(board[i][j] != word.charAt(k))
    return false;
    k++;
        if (k == n)
    return true;
        vis[i][j] =1;
        boolean found= solve(board, word, i+1, j, k,n,vis) ||
        solve(board, word, i, j+1, k,n,vis) || 
        solve(board, word, i-1, j, k,n,vis) ||
        solve(board, word, i, j-1, k,n,vis);
        vis[i][j] =0;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int n= word.length();
        int l=board.length;
        int m= board[0].length;
        int vis[][] = new int [l][m];
       for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
        if (solve(board, word, i, j, 0, n, vis))
            return true;
    }
}

return false;
    }
}