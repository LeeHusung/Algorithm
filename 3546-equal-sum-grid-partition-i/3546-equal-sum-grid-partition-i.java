class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long x = 0;
        for (int i = 0; i < m; i++) {
            x += grid[0][i];
        }
        long y = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                y += grid[i][j];
            }
        }
        if (x == y) return true;

        for (int i = 1; i < n - 1; i++) {
            long tmp = 0;
            for (int j = 0; j < m; j++) {
                tmp += grid[i][j];
            }
            x += tmp;
            y -= tmp;
            if (x == y) return true;
        }

        x = 0;
        for (int i = 0; i < n; i++) {
            x += grid[i][0];
        }
        y = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                y += grid[j][i];
            }
        }
        if (x == y) return true;

        for (int i = 1; i < m - 1; i++) {
            long tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp += grid[j][i];
            }
            x += tmp;
            y -= tmp;
            if (x == y) return true;
        }
        return false;
    }
}