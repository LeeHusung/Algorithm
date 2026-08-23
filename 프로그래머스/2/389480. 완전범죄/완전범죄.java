import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int len = info.length;
        int[][] dp = new int[len + 1][m];
        
        for (int [] k : dp) {
            Arrays.fill(k, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        
        for (int i = 0; i < len; i++) {
            int a = info[i][0];
            int b = info[i][1];
            
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                if (dp[i][j] + a < n) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + a);
                }
                if (j + b < m) {
                    dp[i + 1][j + b] = Math.min(dp[i + 1][j + b], dp[i][j]);
                }
            }
        }
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[len][i]);
        }
        
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}