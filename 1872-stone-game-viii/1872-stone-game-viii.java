class Solution {

    int[] prefix;
    Integer[] memo;

    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        prefix = new int[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        memo = new Integer[n];

        return solve(1);
    }

    private int solve(int i) {

        if (i == prefix.length - 1) {
            return prefix[i];
        }

        if (memo[i] != null) {
            return memo[i];
        }

        int takeCurrent = prefix[i] - solve(i + 1);

        int skipCurrent = solve(i + 1);

        return memo[i] = Math.max(takeCurrent, skipCurrent);
    }
}