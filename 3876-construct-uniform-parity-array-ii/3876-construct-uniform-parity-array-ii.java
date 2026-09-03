class Solution {
    public boolean uniformArray(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] % 2 == 0) {
            for (int x : nums) {
                if (x % 2 != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}