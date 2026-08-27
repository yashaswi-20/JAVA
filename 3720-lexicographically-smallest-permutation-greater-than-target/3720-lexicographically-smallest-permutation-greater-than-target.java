class Solution {

    public String lexGreaterPermutation(String s, String target) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {

            // Try to make prefix [0...i-1] equal to target.
            String prefix = target.substring(0, i);

            // Check whether prefix can be formed from s.
            int[] count = new int[26];

            for (char c : chars) {
                count[c - 'a']++;
            }

            boolean possible = true;

            for (char c : prefix.toCharArray()) {
                if (count[c - 'a'] == 0) {
                    possible = false;
                    break;
                }
                count[c - 'a']--;
            }

            if (!possible) continue;

            // Find smallest character > target[i]
            for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder(prefix);

                    ans.append((char) ('a' + c));
                    count[c]--;

                    // Fill remaining positions with smallest chars
                    for (int x = 0; x < 26; x++) {
                        while (count[x] > 0) {
                            ans.append((char) ('a' + x));
                            count[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}