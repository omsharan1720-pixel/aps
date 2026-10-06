import java.util.Stack;

class StockSpanner {
    // Stack to store pairs of {price, span}
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Combine spans of previous days with prices less than or equal to current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        // Push the current price along with its calculated span
        stack.push(new int[]{price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */