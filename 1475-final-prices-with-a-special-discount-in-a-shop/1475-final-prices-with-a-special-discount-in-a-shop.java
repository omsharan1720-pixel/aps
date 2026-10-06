class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = prices.clone(); // Copy the original prices
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    answer[i] = prices[i] - prices[j];
                    break; // Stop at the first valid discount
                }
            }
        }
        
        return answer;
    }
}