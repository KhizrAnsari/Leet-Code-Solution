import java.util.Arrays;

public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[j][k] stores whether XOR sum 'k' is possible at column 'j'
        // Using a 2D array instead of 3D optimizes memory space and locality.
        boolean[][] dp = new boolean[n][1024];
        
        // Initialize the starting position (0, 0)
        dp[0][grid[0][0]] = true;
        
        // Fill out the first row (can only move right)
        for (int j = 1; j < n; j++) {
            int val = grid[0][j];
            for (int k = 0; k < 1024; k++) {
                if (dp[j - 1][k]) {
                    dp[j][k ^ val] = true;
                }
            }
        }
        
        // Process the rest of the rows
        for (int i = 1; i < m; i++) {
            boolean[][] nextDp = new boolean[n][1024];
            
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                
                // Transition from top cell (i - 1, j)
                for (int k = 0; k < 1024; k++) {
                    if (dp[j][k]) {
                        nextDp[j][k ^ val] = true;
                    }
                }
                
                // Transition from left cell (i, j - 1)
                if (j > 0) {
                    for (int k = 0; k < 1024; k++) {
                        if (nextDp[j - 1][k]) {
                            nextDp[j][k ^ val] = true;
                        }
                    }
                }
            }
            dp = nextDp; // Move to the next row
        }
        
        // Find the minimum XOR sum possible at the bottom-right corner
        for (int k = 0; k < 1024; k++) {
            if (dp[n - 1][k]) {
                return k;
            }
        }
        
        return 0;
    }
}