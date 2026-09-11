class Solution {
    int res = 0;
    HashSet<String> set = new HashSet<>();

    void solve(int digits[], int j, int vis[], String temp) {
        //System.out.println(temp);

        if (temp.length() == 3 && temp.charAt(0) != '0' && (temp.charAt(2) - '0') % 2 == 0) {
            if (!set.contains(temp)) {
                set.add(temp);
                res++;
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (temp.length() == 0 && digits[i] == 0)
                continue;

            if (temp.length() == 2 && digits[i] % 2 != 0)
                continue;
            if (vis[i] == 1)
                continue;
            vis[i] = 1;
            solve(digits, i + 1, vis, temp + digits[i]);
            vis[i] = 0;
        }
    }

    public int totalNumbers(int[] digits) {

        int vis[] = new int[digits.length];
        solve(digits, 0, vis, "");
        return res;
    }
}