class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();

        int i = 0;
        while (set.size() < k + 1 && i < s.length()) {
            set.add(s.charAt(i++));
        }

        for (char ch : set) {
            sb.append(ch);
        }

        if (i >= s.length()) return sb.toString();

        for (int j = i; j < s.length(); j++) {

            if (set.size() >= k + 1) {
                set.remove(set.iterator().next());
            }

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                sb.append(s.charAt(j));
            }
        }

        return sb.toString();
    }
}