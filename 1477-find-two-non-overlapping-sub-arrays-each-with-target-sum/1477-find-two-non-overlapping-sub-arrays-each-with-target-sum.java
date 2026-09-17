class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        // best[i] = shortest valid subarray ending at or before i
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int start = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int end = 0; end < n; end++) {

            sum += arr[end];

            while (sum > target) {
                sum -= arr[start];
                start++;
            }

            // Carry forward previous best
            if (end > 0) {
                best[end] = best[end - 1];
            }

            // Current subarray has target sum
            if (sum == target) {

                int len = end - start + 1;

                // Find a previous NON-OVERLAPPING subarray
                if (start > 0 && best[start - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[start - 1]);
                }

                // Current subarray can become the best
                best[end] = Math.min(best[end], len);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}