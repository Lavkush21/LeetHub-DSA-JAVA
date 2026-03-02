import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> trailingZeros = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailingZeros.add(count);
        }

        int swaps = 0;
     
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int foundIdx = -1;

            for (int j = i; j < n; j++) {
                if (trailingZeros.get(j) >= required) {
                    foundIdx = j;
                    break;
                }
            }

        
            if (foundIdx == -1) return -1;

            swaps += (foundIdx - i);
            int rowToMove = trailingZeros.remove(foundIdx);
            trailingZeros.add(i, rowToMove);
        }

        return swaps;
    }
}
