class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String min = "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                temp += s.charAt(j);
                if (s.charAt(j) == '1') {
                    count++;
                }
                if (count == k) {

                    if ((j - i + 1) < minLen) {
                        min = temp;
                        minLen = temp.length();

                    }
                    if ((j - i + 1) == minLen) {
                        if (temp.compareTo(min) < 0) {
                            min = temp;
                            minLen = temp.length();
                        }
                    }break;
                }
            }
        }
        return min;
    }
}