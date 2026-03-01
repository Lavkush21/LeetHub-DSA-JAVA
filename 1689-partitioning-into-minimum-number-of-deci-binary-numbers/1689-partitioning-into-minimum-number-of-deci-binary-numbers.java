class Solution {
    public int minPartitions(String n) {
        int maxSum = 0;
        for(int i =0; i < n.length(); i++) {
            int currSum = n.charAt(i) - '0';
            if(currSum > maxSum) {
                maxSum = currSum;
            }
            if(maxSum == 9) return 9;
        }
        return maxSum;
        
    }
}