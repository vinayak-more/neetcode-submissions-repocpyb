class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return solve(s, 0, dict, dp);
    }

    private boolean solve(String s, int index, Set<String> dict, Boolean[] dp) {
        if (index == s.length()) return true;

        if (dp[index] != null) return dp[index];

        for (int end = index + 1; end <= s.length(); end++) {
            String word = s.substring(index, end);
            if (dict.contains(word) && solve(s, end, dict, dp)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
}
