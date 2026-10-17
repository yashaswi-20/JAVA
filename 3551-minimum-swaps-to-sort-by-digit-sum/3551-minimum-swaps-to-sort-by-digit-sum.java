import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // each entry: {digitSum, value, originalIndex}
        int[][] items = new int[n][3];
        for (int i = 0; i < n; i++) {
            int k = nums[i], sum = 0;
            while (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            items[i][0] = sum;
            items[i][1] = nums[i];
            items[i][2] = i;
        }

        // target order: by digit sum, then by value
        Arrays.sort(items, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                                  : Integer.compare(a[1], b[1]));

        // items[i][2] = original index of the element that belongs at position i
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || items[i][2] == i) continue;

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = items[j][2];
                cycleSize++;
            }
            swaps += cycleSize - 1;
        }

        return swaps;
    }
}