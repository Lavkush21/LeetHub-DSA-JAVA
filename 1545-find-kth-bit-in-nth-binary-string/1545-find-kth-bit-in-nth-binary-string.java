class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int mid = (int) Math.pow(2, n - 1);
        
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            // Find mirror bit and invert it
            char res = findKthBit(n - 1, (int) Math.pow(2, n) - k);
            return res == '0' ? '1' : '0';
        }
    }
}
