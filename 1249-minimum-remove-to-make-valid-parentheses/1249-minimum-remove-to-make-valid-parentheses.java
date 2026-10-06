class Solution {
    public String minRemoveToMakeValid(String s) {
        // 1st Pass: Remove invalid closing parentheses ')' from left to right
        StringBuilder sb = new StringBuilder();
        int openCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
                sb.append(c);
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                    sb.append(c);
                }
                // If openCount == 0, this ')' is unmatched, so we skip it
            } else {
                sb.append(c); // Lowercase letters
            }
        }
        
        // 2nd Pass: Remove invalid opening parentheses '(' from right to left
        StringBuilder result = new StringBuilder();
        int closeCount = 0;
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == ')') {
                closeCount++;
                result.append(c);
            } else if (c == '(') {
                if (closeCount > 0) {
                    closeCount--;
                    result.append(c);
                }
                // If closeCount == 0, this '(' is unmatched, so we skip it
            } else {
                result.append(c);
            }
        }
        
        // Reverse back to get the original correct order
        return result.reverse().toString();
    }
}