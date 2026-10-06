class Solution {
    public int firstUniqChar(String s) {
        // Frequency array for 26 lowercase English letters
        int[] freq = new int[26];
        
        // Step 1: Count the occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Step 2: Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        // If no unique character exists
        return -1;
    }
}