class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        // x == total
        // We have to remove every element
        if (target == 0) {
            return n;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // prefixSum -> earliest index
        map.put(0, -1);

        int prefixSum = 0;
        int maxLen = -1;

        for (int i = 0; i < n; i++) {

            prefixSum += nums[i];

            int required = prefixSum - target;

            if (map.containsKey(required)) {
                int j = map.get(required);

                maxLen = Math.max(maxLen, i - j);
            }

            // Keep earliest occurrence
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        if (maxLen == -1) {
            return -1;
        }

        return n - maxLen;
    }
}