import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // A set to keep track of elements within the current sliding window of size k
        HashSet<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is already in our window, we found duplicates within distance k
            if (window.contains(nums[i])) {
                return true;
            }
            
            // Add the current element to the window
            window.add(nums[i]);
            
            // Maintain the sliding window size: if the window exceeds size k, remove the oldest element
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}