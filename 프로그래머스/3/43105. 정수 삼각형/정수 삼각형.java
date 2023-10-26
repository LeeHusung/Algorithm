class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += triangle[i][0];
            dp[i][0] = sum;
        }
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += triangle[i][i];
            dp[i][i] = sum2;
        }
        
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                answer = Math.max(dp[i][j], answer);
            }
        }
        
        return answer;
    }
}