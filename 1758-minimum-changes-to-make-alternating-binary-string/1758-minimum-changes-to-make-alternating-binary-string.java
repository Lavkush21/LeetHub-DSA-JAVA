class Solution {
    public int minOperations(String s) {
        int cost01 = 0; // Operations to make pattern "0101..."
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // Pattern "0101..." means even indices should be '0' 
            // and odd indices should be '1'
            if (i % 2 == 0) {
                if (s.charAt(i) != '0') cost01++;
            } else {
                if (s.charAt(i) != '1') cost01++;
            }
        }
        
        // The cost for "1010..." is simply (n - cost01)
        return Math.min(cost01, n - cost01);
    }
}
