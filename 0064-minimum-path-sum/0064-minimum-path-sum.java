class Solution {
    static final int INF = Integer.MAX_VALUE / 4;

   int helper(int[][] cost, int r, int c, int m, int n,
                      HashMap<String, Integer> map) {

        // out of bounds
        if (r >= m || c >= n) return INF;

        // destination
        if (r == m - 1 && c == n - 1) return cost[r][c];

        String key = r + "," + c;
        if (map.containsKey(key)) return map.get(key);

        int right = helper(cost, r, c + 1, m, n, map);
        int down  = helper(cost, r + 1, c, m, n, map);
        // int diag  = helper(cost, r + 1, c + 1, m, n, map);

        int res = cost[r][c] + Math.min(right,down);
        map.put(key, res);
        return res;
    }

   
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        HashMap<String, Integer> map = new HashMap<>();
        return helper(grid, 0, 0, m, n, map);
    }
}



