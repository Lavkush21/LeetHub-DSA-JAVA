class Solution {
    private int[] parent, rank;

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (rank[px] < rank[py]) { int t = px; px = py; py = t; }
        parent[py] = px;
        if (rank[px] == rank[py]) rank[px]++;
        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {
        TreeSet<Integer> candidates = new TreeSet<>();
        for (int[] e : edges) {
            candidates.add(e[2]);
            candidates.add(e[2] * 2);
        }
        List<Integer> vals = new ArrayList<>(candidates);

        if (!canAchieve(n, edges, k, vals.get(0))) return -1;

        int lo = 0, hi = vals.size() - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canAchieve(n, edges, k, vals.get(mid))) {
                ans = vals.get(mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(int n, int[][] edges, int k, int target) {
        parent = new int[n];
        rank   = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int edgesUsed = 0, upgradesUsed = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < target)       return false;
                if (!union(e[0], e[1]))  return false;
                edgesUsed++;
            }
        }
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] >= target) {
                if (union(e[0], e[1])) edgesUsed++;
            }
        }
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < target && e[2] * 2 >= target) {
                if (upgradesUsed < k && union(e[0], e[1])) {
                    edgesUsed++;
                    upgradesUsed++;
                }
            }
        }
        return edgesUsed == n - 1;
    }
}