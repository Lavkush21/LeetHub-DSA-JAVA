class Solution {
    public int countCommas(int n) {
        long total = 0;


        int[] starts  = {1000, 1_000_000, 1_000_000_000};
        int[] ends    = {999_999, 999_999_999, Integer.MAX_VALUE};
        int[] commas  = {1, 2, 3};

        for (int i = 0; i < starts.length; i++) {
            if (n < starts[i]) break;
            long count = (long) Math.min(n, ends[i]) - starts[i] + 1;
            total += count * commas[i];
        }

        return (int) total;
    }
}