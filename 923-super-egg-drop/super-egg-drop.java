class Solution {
    int[][] dp;

    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(k, n);
    }

    int solve(int eggs, int floors) {
        if (floors <= 1 || eggs == 1)
            return floors;

        if (dp[eggs][floors] != -1)
            return dp[eggs][floors];

        int low = 1, high = floors;
        int ans = Integer.MAX_VALUE;

        // Binary search to find the optimal floor to drop the egg
        while (low <= high) {
            int mid = (low + high) / 2;

            int breakCase = solve(eggs - 1, mid - 1);
            int notBreakCase = solve(eggs, floors - mid);

            // Attempts in worst case for current mid
            int temp = 1 + Math.max(breakCase, notBreakCase);
            ans = Math.min(ans, temp);

            if (breakCase > notBreakCase)
                high = mid - 1; // Attempt was too high, focus on lower floors
            else
                low = mid + 1;  // Attempt was too low, focus on higher floors
        }

        return dp[eggs][floors] = ans;
    }
}