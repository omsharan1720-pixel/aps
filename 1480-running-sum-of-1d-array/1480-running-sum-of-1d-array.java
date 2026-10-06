class Solution {
    public int[] runningSum(int[] nums) {
        // Iterate starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Add the previous running sum to the current element
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}