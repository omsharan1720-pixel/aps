import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean destroyed = false;
            
            // Collision happens only when stack has a right-moving asteroid (+)
            // and the current asteroid is moving left (-)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.peek();
                if (Math.abs(top) < Math.abs(ast)) {
                    // Top asteroid explodes, continue checking against the next asteroid in stack
                    stack.pop();
                    continue;
                } else if (Math.abs(top) == Math.abs(ast)) {
                    // Both asteroids explode
                    stack.pop();
                }
                // Current asteroid is destroyed (either smaller than top, or equal size)
                destroyed = true;
                break;
            }
            
            // If the current asteroid survived all collisions, add it to the stack
            if (!destroyed) {
                stack.push(ast);
            }
        }
        
        // Convert stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}