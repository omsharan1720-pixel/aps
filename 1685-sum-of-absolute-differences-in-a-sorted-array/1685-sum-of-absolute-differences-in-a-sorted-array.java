class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        
        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            // Sum of absolute differences with elements to the left
            int leftDiff = (nums[i] * i) - prefixSum[i];
            
            // Sum of absolute differences with elements to the right
            int rightDiff = (prefixSum[n] - prefixSum[i + 1]) - (nums[i] * (n - 1 - i));
            
            result[i] = leftDiff + rightDiff;
        }
        
        return result;
    }
}