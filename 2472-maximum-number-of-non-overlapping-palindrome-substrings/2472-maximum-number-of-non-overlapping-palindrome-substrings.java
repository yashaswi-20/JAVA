class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // dp[i] = maximum number of palindromes
        // that can be selected from s[0 ... i-1]
        int[] dp = new int[n + 1];

        for (int end = 0; end < n; end++) {

            // Don't take a palindrome ending at 'end'
            dp[end + 1] = dp[end];

            // Try every possible starting point
            for (int start = end; start >= 0; start--) {

                if (end - start + 1 < k)
                    continue;

                if (isPalindrome(s, start, end)) {

                    dp[end + 1] = Math.max(
                        dp[end + 1],
                        dp[start] + 1
                    );

                    // Important!
                    // Since we're processing end from left to right,
                    // we can stop here for the greedy version.
                    break;
                }
            }
        }

        return dp[n];
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}