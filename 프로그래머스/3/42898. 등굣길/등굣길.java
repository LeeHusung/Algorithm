class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[m+1][n+1];
        // dp[1][1] = 1;
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                for (int[] x : puddles) {
                    dp[x[0]][x[1]] = 0;
                }
                if (i==1 && j==1) dp[j][i] = 1;
                else dp[j][i] = (dp[j-1][i] + dp[j][i-1])  % 1000000007;
            }
        }
        
        return dp[m][n];
    }
}