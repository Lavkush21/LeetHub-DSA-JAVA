class Solution {
    public int minOperations(String s, int k) {

        int n = s.length();

        // Count initial zeros
        int startZeros = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') startZeros++;
        }

        if (startZeros == 0) return 0;

        // operations[z] = min steps to reach z zeros
        int[] operations = new int[n + 1];
        Arrays.fill(operations, -1);

        // Unvisited states grouped by parity
        TreeSet<Integer> evenSet = new TreeSet<>();
        TreeSet<Integer> oddSet = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) evenSet.add(i);
            else oddSet.add(i);
        }

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startZeros);
        operations[startZeros] = 0;

        // Mark start as visited
        if (startZeros % 2 == 0) evenSet.remove(startZeros);
        else oddSet.remove(startZeros);

        while (!queue.isEmpty()) {

            int z = queue.poll();

            // Compute reachable zero range after one operation
            int minNewZ = z + k - 2 * Math.min(k, z);
            int maxNewZ = z + k - 2 * Math.max(0, k - (n - z));

            // Choose correct parity set
            TreeSet<Integer> currSet =
                    (minNewZ % 2 == 0) ? evenSet : oddSet;

            Integer next = currSet.ceiling(minNewZ);

            while (next != null && next <= maxNewZ) {

                operations[next] = operations[z] + 1;

                if (next == 0) return operations[next];

                queue.offer(next);

                currSet.remove(next); // mark visited
                next = currSet.ceiling(minNewZ);
            }
        }

        return -1;
    }
}