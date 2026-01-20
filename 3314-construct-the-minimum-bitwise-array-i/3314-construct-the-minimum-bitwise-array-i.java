import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        // Iterate through each prime number in the input list
        for (int i = 0; i < n; i++) {
            int target = nums.get(i);
            boolean found = false;
            
            /**
             * Brute Force Search:
             * We are looking for the smallest 'x' such that (x | (x + 1)) == target.
             * Since we need the MINIMUM x, we start counting from 0 upwards.
             */
            for (int x = 0; x <= target; x++) {
                // The bitwise OR of x and x+1 changes the rightmost 0 in x to a 1.
                if ((x | (x + 1)) == target) {
                    ans[i] = x;
                    found = true;
                    // Since we found the smallest x, we exit the inner loop immediately.
                    break; 
                }
            }
            
            // If no such x was found after checking all values up to target
            if (!found) {
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}