class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String component : components) {
            if(component.isEmpty() || component.equals(".")) {
                continue;
            } else if (component.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        return "/" + String.join("/", stack);
    }
}