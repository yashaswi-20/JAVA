class Solution {
    List<List<String>> res = new ArrayList<>();

    boolean isSafe(int i, int j, char[][]board) {
        for(int k=0;k<board.length;k++){
            if(board[i][k]=='Q')return false;
        }
        for(int k=0;k<board.length;k++){
            if(board[k][j]=='Q')return false;
        }
        int n=board.length;
        int row=i;
        int col=j;
        while(row<n && col<n){
            if(board[row][col]=='Q')return false;
            row++;
            col++;
        }
        row=i;
        col=j;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q')return false;
            row--;
            col--;
        }

        row=i;
        col=j;
        while(row>=0 && col<n){
            if(board[row][col]=='Q')return false;
            row--;
            col++;
        }
         row=i;
        col=j;
        while(row<n && col>=0){
            if(board[row][col]=='Q')return false;
            row++;
            col--;
        }

        return true;
    }

    void solve(int row , char board[][]) {
        if(row==board.length){
            ArrayList<String>list=new ArrayList<>();

            for(int i=0;i<board.length;i++){
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }

        for(int i=0;i<board.length;i++){
            if(isSafe(row,i,board)){
                board[row][i]='Q';
                solve(row+1,board);
                board[row][i]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
       solve(0, board);

       return res;
    }
}