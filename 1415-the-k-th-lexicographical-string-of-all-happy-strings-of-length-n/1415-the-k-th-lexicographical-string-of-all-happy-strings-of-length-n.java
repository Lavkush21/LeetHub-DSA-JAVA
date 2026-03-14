class Solution {
    private List<String> result = new ArrayList<>();

    public String getHappyString(int n, int k) {
        backtrack(n, new StringBuilder());
        return result.size() < k ? "" : result.get(k - 1);
    }

    private void backtrack(int n, StringBuilder sb) {
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                backtrack(n, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}