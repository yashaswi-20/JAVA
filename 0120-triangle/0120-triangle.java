class Solution {

    int compute(List<List<Integer>> arr, int r, int c, int lr, int[][] dp) {
        // invalid index
        if (c < 0 || c >= arr.get(r).size()) {
            return Integer.MAX_VALUE;
        }

        // base case
        if (r == lr - 1) {
            return arr.get(r).get(c);
        }

        if (dp[r][c] != 12000) return dp[r][c];

        int down = compute(arr, r + 1, c, lr, dp);
        int diag = compute(arr, r + 1, c + 1, lr, dp);

        return dp[r][c] = arr.get(r).get(c) + Math.min(down, diag);
    }

    public int minimumTotal(List<List<Integer>> arr) {
        int lr = arr.size();
        int[][] dp = new int[lr][lr];

        for (int[] row : dp) {
            Arrays.fill(row, 12000);
        }

        return compute(arr, 0, 0, lr, dp);
    }
}
