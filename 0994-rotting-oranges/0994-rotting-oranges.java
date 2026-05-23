import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCnt = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> q = new ArrayDeque<>();
        int[][] ch = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) freshCnt++;
                else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                }
            }
        }
        if (freshCnt == 0) {
            return 0;
        }
        int minute = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            // System.out.println(q.size());
            minute++;
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1 && ch[nx][ny] == 0) {
                        // System.out.println("nx , ny : " + nx + ", " + ny);
                        q.offer(new int[]{nx, ny});
                        ch[nx][ny] = 1;
                        grid[nx][ny] = 2;
                        freshCnt--;
                    }
                }
            }
           
            // System.out.println("==================minute: " + minute);
            // for (int[] x : grid) {
            //     for (int y : x) {
            //         System.out.print(y + " ");
            //     }
            //     System.out.println();
            // }
            if (freshCnt == 0) {
                return minute;
            }
        }
        if (freshCnt > 0) return -1;
        return minute;

    }
}