class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlenwindow=Integer.MAX_VALUE;
        int currentsum=0;
        int low=0;
        int high=0;
        while(high<nums.length){
            currentsum+=nums[high];
            high++;
            while(currentsum>=target){
                int currentwindowsize=high-low;
                minlenwindow=Math.min(minlenwindow,currentwindowsize);
                currentsum-=nums[low];
                low++;
            }
        }
        return minlenwindow==Integer.MAX_VALUE ? 0 : minlenwindow;
    }
}