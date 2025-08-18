class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(sb.length());
                sb.append("(");
            } else if (s.charAt(i) == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                    sb.append(")");
                }
            } else {
                sb.append(s.charAt(i));
            }
        }

        while(!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }
}

/***

class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> intStack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                intStack.push(i);
            } else if (s.charAt(i) == ')') {
                if(!intStack.isEmpty()) {
                    intStack.pop();
                } else {
                    set.add(i);
                } 
            } 
        }

        StringBuilder sb = new StringBuilder();

        while(!intStack.isEmpty()) {
            set.add(intStack.pop());
        }

        for(int i=0; i<s.length(); i++) {
            if(!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}

 */