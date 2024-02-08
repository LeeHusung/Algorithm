// import java.util.*;
// class Solution {
//     static int answer, dir, n;
//     static int[] dx = {1, 0, -1, 0};
//     static int[] dy = {0, -1, 0, 1};
//     static int[][] dist, ch;
    
//     public static void D(int L, int x, int y, int dir, int cost, int[][] board) {
//         if (cost >= answer) return;
//         if (x == n-1 && y == n-1) {
//             // System.out.println("cost : " + cost);
//             answer = Math.min(answer, cost);
//             return;
//         }
//         ch[x][y] = 1;
//         // System.out.println("x : " + x + ", y : " + y + ", cost : " + cost);
//         for (int i = 0; i < 4; i++) {
//             int nx = x + dx[i];
//             int ny = y + dy[i];
//             if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0 && board[nx][ny] != 1) {
//                 if (L == 0) {
//                     ch[nx][ny] = 1;
//                     D(L + 1, nx, ny, i, cost + 100, board);
//                     ch[nx][ny] = 0;
//                 }
//                 else if (L > 0 && i != dir) {
//                     ch[nx][ny] = 1;
//                     D(L + 1, nx, ny, i, cost + 600, board);
//                     ch[nx][ny] = 0;
//                 }
//                 else if (L > 0 && i == dir) {
//                     ch[nx][ny] = 1;
//                     D(L + 1, nx, ny, i, cost + 100, board);
//                     ch[nx][ny] = 0;
//                 }
//             }
//         }
//     }
    
//     public int solution(int[][] board) {
//         answer = Integer.MAX_VALUE;
//         dir = 0;
        
//         n = board.length;
//         dist = new int[n][n];
//         ch = new int[n][n];
        
//         D(0, 0, 0, 0, 0, board);
        
//         return answer;
//     }
// }

import java.util.*;
class Solution {
    static int answer, dir, n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][][] dist;
    
    public static void D(int x, int y, int dir, int cost, int[][] board) {
        // if (cost >= answer) return;
        // if (x == n-1 && y == n-1) {
        //     // System.out.println("cost : " + cost);
        //     answer = Math.min(answer, cost);
        //     return;
        // }
        // System.out.println("x : " + x + ", y : " + y + ", cost : " + cost);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] != 1) {
                int newCost = cost + (dir == -1 || dir == i ? 100 : 600);
                if (dist[nx][ny][i] > newCost) {
                    dist[nx][ny][i] = newCost;
                    D(nx, ny, i, newCost, board);
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        dir = 0;
        
        n = board.length;
        dist = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        D(0, 0, -1, 0, board);
        
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dist[n-1][n-1][i]);
        }
        
        return answer;
    }
}