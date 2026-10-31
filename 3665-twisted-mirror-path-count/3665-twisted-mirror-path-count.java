class Solution {
    long[][][] dp;
    private long path(int i, int j, int n, int m, int[][] grid, int dr) {
        if (i < 0 || j < 0 || i >= n || j >= m) return 0L;
        if (i == n - 1 && j == m - 1) return 1L;
        if (dp[dr][i][j] != -1) return dp[dr][i][j];
        long cnt = 0, md = 1000000007;
        if (grid[i][j] == 1) {
            if (dr == 1) cnt = (cnt + path(i + 1, j, n, m, grid, 0)) % md;
            else cnt = (cnt + path(i, j + 1, n, m, grid, 1)) % md;
        } else {
            cnt = (cnt + path(i + 1, j, n, m, grid, 0)) % md;
            cnt = (cnt + path(i, j + 1, n, m, grid, 1)) % md;
        }
        dp[dr][i][j] = cnt;
        return cnt;
    }

    public int uniquePaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new long[2][n][m];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < n; i++)
                Arrays.fill(dp[j][i], -1L);
        }
        return (int) path(0, 0, n, m, grid, 0);
    }
}