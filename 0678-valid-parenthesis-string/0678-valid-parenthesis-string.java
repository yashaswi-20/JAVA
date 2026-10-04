class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                open.push(i);
            }

            else if (c == '*') {
                star.push(i);
            }

            else { // ')'

                // First, try to match with '('
                if (!open.isEmpty()) {
                    open.pop();
                }

                // Otherwise, use '*' as '('
                else if (!star.isEmpty()) {
                    star.pop();
                }

                // Nothing available to match ')'
                else {
                    return false;
                }
            }
        }
        // System.out.println(open);
        // System.out.println(star);
        // Match remaining '(' with '*' acting as ')'
        while (!open.isEmpty() && !star.isEmpty()) {

            int openIndex = open.pop();
            int starIndex = star.pop();

            // '*' must come AFTER '('
            if (starIndex < openIndex) {
                return false;
            }
        }

        // Still have unmatched '('
        return open.isEmpty();
    }
}