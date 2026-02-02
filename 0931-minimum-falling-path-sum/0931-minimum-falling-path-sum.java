class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // STEP 1: Base case (last row)
        for (int c = 0; c < n; c++) {
            dp[n - 1][c] = arr[n - 1][c];
        }

        // STEP 2: Fill from bottom to top
        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c < n; c++) {

                int down = dp[r + 1][c];
                int dl = (c > 0) ? dp[r + 1][c - 1] : Integer.MAX_VALUE;
                int dr = (c < n - 1) ? dp[r + 1][c + 1] : Integer.MAX_VALUE;

                dp[r][c] = arr[r][c] + Math.min(down, Math.min(dl, dr));
            }
        }

        // STEP 3: Same as your outer loop
        int min = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            min = Math.min(min, dp[0][c]);
        }

        return min;
    }
}
