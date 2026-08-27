import java.util.*;

class Solution {

    public String lexGreaterPermutation(String s, String target) {

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {

            // Try to match target[0...i-1]
            StringBuilder prefix = new StringBuilder();
            boolean[] used = new boolean[n];

            boolean possible = true;

            for (int j = 0; j < i; j++) {

                boolean found = false;

                for (int k = 0; k < n; k++) {

                    if (!used[k] && chars[k] == target.charAt(j)) {
                        used[k] = true;
                        prefix.append(chars[k]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    possible = false;
                    break;
                }
            }

            if (!possible)
                continue;

            // Find smallest unused character > target[i]
            for (int k = 0; k < n; k++) {

                if (!used[k] && chars[k] > target.charAt(i)) {

                    StringBuilder ans = new StringBuilder(prefix);

                    ans.append(chars[k]);
                    used[k] = true;

                    // Add remaining characters in sorted order
                    for (int x = 0; x < n; x++) {
                        if (!used[x]) {
                            ans.append(chars[x]);
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}