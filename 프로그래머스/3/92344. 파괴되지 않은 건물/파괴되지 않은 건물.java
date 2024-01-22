class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n + 2][m + 2];
        
        for (int[] current : skill) {
            int type = current[0];
            int r1 = current[1];
            int c1 = current[2];
            int r2 = current[3];
            int c2 = current[4];
            int degree = current[5];
            if (type == 1) { // 파괴
                sum[r1 + 1][c1 + 1] += -degree;
                sum[r2 + 2][c2 + 2] += -degree;
                sum[r2 + 2][c1 + 1] += degree;
                sum[r1 + 1][c2 + 2] += degree;
                // for (int i = 1; i <= n + 1; i++) {
                //     for (int j = 1; j <= m + 1; j++) {
                //         sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + sum[i][j];
                //     }
                // }
              
                // for (int i = 0; i < n; i++) {
                //     for (int j = 0; j < m; j++) {
                //         board[i][j] += sum[i+1][j+1];
                //     }
                // }
                //  System.out.println("-----board------");
                // for (int i = 0; i < n; i++) {
                //     for (int j = 0; j < m; j++) {
                //         System.out.print(board[i][j] + " ");
                //     }
                //     System.out.println();
                // }
            } else { // 힐
                sum[r1 + 1][c1 + 1] += degree;
                sum[r2 + 2][c2 + 2] += degree;
                sum[r2 + 2][c1 + 1] += -degree;
                sum[r1 + 1][c2 + 2] += -degree;
                // for (int i = 1; i <= n + 1; i++) {
                //     for (int j = 1; j <= m + 1; j++) {
                //         sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + sum[i][j];
                //     }
                // }
                // for (int i = 0; i < n; i++) {
                //     for (int j = 0; j < m; j++) {
                //         board[i][j] += sum[i+1][j+1];
                //     }
                // }
            }
           
        }
  
         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= m; j++) {
                 sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + sum[i][j];
             }
         }
                //  System.out.println("sum------------");
                // for (int i = 1; i <= n + 1; i++) {
                //     for (int j = 1; j <= m + 1; j++) {
                //         System.out.print(sum[i][j] + " ");
                //     }
                //     System.out.println();
                // }
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // System.out.print(board[i][j] + " ");
                if (board[i][j] + sum[i + 1][j + 1] > 0) answer++;
            }
             // System.out.println();
        }
            
        
        return answer;
    }
}