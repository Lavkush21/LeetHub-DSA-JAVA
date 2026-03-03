import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Exactly K = (At most K) - (At most K-1)
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            // Add current element to window
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Shrink window if distinct elements exceed k
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            // Total valid subarrays ending at 'right' is the window size
            count += (right - left + 1);
        }
        return count;
    }
}
