class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            // The shift is simply the value at nums[i]
            int shift = nums[i];
            
            // Calculate the target index using the circular wrap-around formula
            // This handles both positive and negative shifts correctly
            int targetIndex = ((i + shift) % n + n) % n;
            
            result[i] = nums[targetIndex];
        }
        
        return result;
    }
}
