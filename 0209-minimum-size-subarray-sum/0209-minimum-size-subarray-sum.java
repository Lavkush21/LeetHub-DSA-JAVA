class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        // 1. Change MIN_VALUE to MAX_VALUE
        int minLength = Integer.MAX_VALUE; 

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        // 2. Fix the typo 'retuen' to 'return'
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
