class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int check = 0;
        int ck = 0;
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(s.charAt(i));
            if (s.charAt(i) == ' ' && res==0) {
                if (ck == 1){
                 
                    break;
                }
                while(i<s.length() && s.charAt(i)==' '){
                    i++;
                ck=1;
                }
                i--;
                continue;
            }
           
            if (s.charAt(i) == '0' && res == 0) {
                ck = 1;
                continue;
            }

            if (s.charAt(i) == '-') {
                if (i > 0 && s.charAt(i - 1) != ' ') {
                    break;
                }
                check = 1;
                continue;
            }
            if (s.charAt(i) == '+') {
                if (i == 0 || s.charAt(i - 1) == ' ')
                    continue;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                break;

            int str = (int) s.charAt(i) - (int) '0';
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 &&
                            str > (check==1 ? 8 : 7))) {
                return check==1
                        ? Integer.MIN_VALUE
                        : Integer.MAX_VALUE;
            }
            res = res * 10 + str;

        }
        if (check == 1) {
            res = -res;
        }
       
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) res;
    }
}