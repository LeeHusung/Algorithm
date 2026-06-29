import java.util.*;
class Solution {
    public int[][] candyCrush(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        while (true) {
            boolean flag = false;
            int[][] ch = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = board[i][j];
                    if (x == 0) continue;
                    int cnt = 1;
                    int tmp = j;
                    while (true) {
                        if (tmp + 1 < m && board[i][tmp + 1] == x) {
                            cnt++;
                            tmp++;
                        } else break;
                    }
                    if (cnt >= 3) {
                        flag = true;
                        while (tmp >= j) {
                            ch[i][tmp--] = 1;
                        }
                    }
                    cnt = 1;
                    tmp = i;
                    while (true) {
                        if (tmp + 1 < n && board[tmp + 1][j] == x) {
                            cnt++;
                            tmp++;
                        } else break;
                    }
                    if (cnt >= 3) {
                        flag = true;
                        while (tmp >= i) {
                            ch[tmp--][j] = 1;
                        }
                    }
                }
            }
            if (!flag) break;
            // System.out.println("=========ch================");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ch[i][j] == 1) {
                        board[i][j] = 0;
                    }
                    // System.out.print(ch[i][j] + " ");
                }
                // System.out.println();
            }
            down(board);
            // System.out.println("=========board================");
            // for (int i = 0; i < n; i++) {
            //     for (int j = 0; j < m; j++) {
            //         System.out.print(board[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }

        return board;
    }
























        // List<int[]> list = new ArrayList<>();
        // List<int[]> res = new ArrayList<>();
        // boolean flag = false;
        // while (true) {
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < m; j++) {
        //             int x = board[i][j];
        //             Queue<int[]> q = new ArrayDeque<>();
        //             q.offer(new int[]{i, j, board[i][j]});
        //             int cnt = 1;
        //             int[][] ch = new int[n][m];
        //             ch[i][j] = 1;
        //             while(!q.isEmpty()) {
        //                 int len = q.size();
        //                 // System.out.println("len: " + len);
        //                 for (int z = 0; z < len; z++) {
        //                     int[] p = q.poll();
        //                     // System.out.println("p: " + Arrays.toString(p));
        //                     boolean con = false;
        //                     for (int k = 0; k < 4; k++) {
        //                         int nx = p[0] + dx[k];
        //                         int ny = p[1] + dy[k];
        //                         if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && board[nx][ny] == x) {
        //                             // System.out.println("nx: " + nx + " , ny : " + ny);
        //                             ch[nx][ny] = 1;
        //                             q.offer(new int[]{nx, ny, board[nx][ny]});
        //                             list.add(new int[]{nx, ny});
        //                             con = true;
        //                         }
        //                     }
        //                     if (con) {
        //                         System.out.println("i: " + i + " , j : " + j);
        //                         cnt++;
        //                     }
        //                 }
        //             }
        //             System.out.println("cnt: " + cnt);
        //             if (cnt >= 3) {
        //                 System.out.println("cnt!!! i: " + i + " , j : " + j);
        //                 flag = true;
        //                 for (int[] tmp : list) {
        //                     res.add(tmp);
        //                 }
        //             }
        //             list.clear();
        //             q.clear();
        //             for (int[] tmp : res) {
        //                 board[tmp[0]][tmp[1]] = 0;
        //                 System.out.println("tmp: " + Arrays.toString(tmp));
        //             }
        //             res.clear();
        //         }
        //     }
         
        //     down(board);
        //     if (!flag) break;
        //     System.out.println("=========================");
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < m; j++) {
        //             System.out.print(board[i][j] + " ");
        //         }
        //         System.out.println();
        //     }
        // }
        // return board;
    // }
    public void down(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = board[j][i];
                if (x != 0) st.push(x);
            }
            for (int j = n - 1; j >= 0; j--) {
                if (!st.isEmpty()) {
                    board[j][i] = st.pop();
                } else {
                    board[j][i] = 0;
                }
            }
        }
    }
}