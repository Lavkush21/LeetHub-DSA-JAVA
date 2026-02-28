class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int MOD = 1_000_000_007;
        
        for (int i = 1; i <= n; i++) {
            // Find number of bits in i
            int bits = (int)(Math.log(i) / Math.log(2)) + 1;
            // Shift result left by bits and add i
            result = ((result << bits) | i) % MOD;
        }
        
        return (int) result;
    }
}