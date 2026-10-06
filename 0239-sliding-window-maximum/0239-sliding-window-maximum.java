import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIndex = 0;
        
        // Deque to store indices of elements, maintaining them in decreasing order of values
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current sliding window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 2. Remove elements from the back that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add the current element's index
            deque.offerLast(i);
            
            // 4. The front of the deque is the maximum for the window starting at (i - k + 1)
            if (i >= k - 1) {
                result[resIndex++] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}