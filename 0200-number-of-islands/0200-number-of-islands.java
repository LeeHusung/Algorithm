import java.util.*;
class Solution {
    static int[][] ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    private void bfs(int n, int m, int x, int y, char[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] ==0 && grid[nx][ny] == '1') {
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && ch[i][j] == 0) {
                    cnt++;
                    bfs(n, m, i, j, grid);
                }
            }
        }
        return cnt;
    }
}