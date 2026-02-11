class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int heigh = n -1;

        while(mid<=heigh) {
            if(nums[mid]==0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            } else {
                if(nums[mid]==1) {
                    mid++;
                }
                else {
                    nums[mid] = nums[heigh];
                    nums[heigh] = 2;
                    heigh--;
                }
            }
        }
       

    }
}