class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb=new StringBuilder(s);
        Stack<Integer>st=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }

            if(s.charAt(i)==')'){
                int start=st.pop();
                String content = sb.substring(start + 1, i);
                String reversed = new StringBuilder(content).reverse().toString();
                sb.replace(start + 1, i, reversed);
            }
        }

        String res=sb.toString();

       res= res.replace("(", "");
        res=res.replace(")","");

        return res;
    }
}