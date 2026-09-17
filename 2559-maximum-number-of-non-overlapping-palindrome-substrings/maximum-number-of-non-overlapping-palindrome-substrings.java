class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        
        // Step 1: Precompute palindromes
        // isPal[i][j] = true if s[i...j] is a palindrome
        boolean[][] isPal = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            isPal[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPal[i][i + 1] = true;
            }
        }
        
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1]) {
                    isPal[i][j] = true;
                }
            }
        }
        
        // Step 2: DP
        // dp[i] = max palindromes using first i characters
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // Option 1: skip character i-1
            dp[i] = dp[i - 1];
            
            // Option 2: use a palindrome ending at i-1
            // Try all possible start positions j
            for (int j = 0; j < i; j++) {
                int len = i - j;
                if (len >= k && isPal[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n];
    }
}