class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        // Har cell pe jao
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Agar island milta hai (value > 0)
                if (grid[i][j] > 0) {
                    // DFS call karo jisse poora island mil jaye aur sum return kare
                    long sum = dfs(grid, i, j);
                    
                    // Agar sum k se divide ho jaye, toh count badhao
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Helper function: DFS
    private long dfs(int[][] grid, int r, int c) {
        // Base Case: Grid ke bahar chale gaye ya cell pani hai (0)
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        // Current cell ka value save karo aur usko 0 kar do (visited mark karne ke liye)
        long currentVal = grid[r][c];
        grid[r][c] = 0; 

        // Chaaron directions mein jao aur unka sum add karo
        long totalSum = currentVal;
        totalSum += dfs(grid, r + 1, c); // Neeche
        totalSum += dfs(grid, r - 1, c); // Upar
        totalSum += dfs(grid, r, c + 1); // Daaye
        totalSum += dfs(grid, r, c - 1); // Baaye

        return totalSum;
    }
}