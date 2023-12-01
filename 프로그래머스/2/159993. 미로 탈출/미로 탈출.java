import java.util.*;
class Solution {
    
    static int answer, n, m;
    static int[][] arr, ch, dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
     public static int toStart(int x, int y) {
         
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        ch = new int[n][m];
        ch[x][y] = 1;
        dist = new int[n][m];
        int L = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (arr[p[0]][p[1]] == 2) return dist[p[0]][p[1]];
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] != 1) {
                        ch[nx][ny] = 1;
                        dist[nx][ny] = L;
                        q.offer(new int[]{nx, ny, p[2] + 1});
                    }
                }
            }
        }
         return 0;
    }
    
    public static int toExit(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        ch = new int[n][m];
        ch[x][y] = 1;
        dist = new int[n][m];
        int L = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                if (arr[p[0]][p[1]] == 3) return dist[p[0]][p[1]];
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] != 1) {
                        ch[nx][ny] = 1;
                        dist[nx][ny] = L;
                        q.offer(new int[]{nx, ny, p[2] + 1});
                    }
                }
            }
        }
        return 0;
    }
    public int solution(String[] maps) {
        answer = 0;
        n = maps.length;
        m = maps[0].length();
        
        arr = new int[n][m];
        
        
        for (int i = 0; i < maps.length; i++) {
            String str = maps[i];
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'S') {
                    arr[i][j] = 2;
                }
                if (str.charAt(j) == 'E') {
                    arr[i][j] = 3;
                }
                if (str.charAt(j) == 'L') {
                    arr[i][j] = 5;
                }
                if (str.charAt(j) == 'O') {
                    arr[i][j] = 0;
                }
                if (str.charAt(j) == 'X') {
                    arr[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 5) {
                    
                     int toExit = toExit(i, j);
                    int toStart = toStart(i, j);
                    if(toExit == 0 || toStart == 0) answer = -1;
                    else answer = toExit + toStart;
                }
            }
        }
        return answer;
    }
}