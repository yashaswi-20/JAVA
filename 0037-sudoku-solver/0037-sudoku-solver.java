class Solution {

    boolean isSafe(char[][] board, int row, int col, char num) {

    // Check row
    for (int j = 0; j < 9; j++) {
        if (board[row][j] == num)
            return false;
    }

    // Check column
    for (int i = 0; i < 9; i++) {
        if (board[i][col] == num)
            return false;
    }

    // Check 3x3 subgrid
    int startRow = (row / 3) * 3;
    int startCol = (col / 3) * 3;

    for (int i = startRow; i < startRow + 3; i++) {
        for (int j = startCol; j < startCol + 3; j++) {
            if (board[i][j] == num)
                return false;
        }
    }

    return true;
}

    boolean solve(char[][]board){
        
          for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isSafe(board, i, j,k)){
                            board[i][j]=k;
                            if(solve(board))return true;
                            board[i][j]='.';
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        
      solve(board);
    }
}