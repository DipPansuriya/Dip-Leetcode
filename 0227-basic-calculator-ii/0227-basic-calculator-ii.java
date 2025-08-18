class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int num = 0;
        char lastChar = '+';

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = s.charAt(i) - '0';

                for(; i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)); i++) {
                    num  = num * 10 + s.charAt(i + 1) - '0';
                }
            }

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == s.length() - 1) {
                if(lastChar == '+') {
                    stack.push(num);
                }

                if(lastChar == '-') {
                    stack.push(-num);
                }

                if(lastChar == '*') {
                    stack.push(stack.pop() * num);
                }

                if(lastChar == '/') {
                    stack.push(stack.pop() / num);
                }

                num = 0;
                lastChar = ch;
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}