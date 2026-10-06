class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price seen so far
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Check if selling today yields a higher profit
            }
        }
        
        return maxProfit;
    }
}