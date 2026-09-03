class Solution {
    public boolean uniformArray(int[] nums) {
        Arrays.sort(nums);

        int targetParity = nums[0] % 2;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != targetParity) {
                // Subtract the smallest element
                int x = nums[i] - nums[0];

                if (x < 1 || x % 2 != targetParity) {
                    return false;
                }
            }
        }

        return true;
    }
}