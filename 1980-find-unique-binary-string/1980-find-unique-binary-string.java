class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < nums.length; i++) {
           
            char diagonalChar = nums[i].charAt(i);
            sb.append(diagonalChar == '0' ? '1' : '0');
        }
        
        return sb.toString();
    }
}
