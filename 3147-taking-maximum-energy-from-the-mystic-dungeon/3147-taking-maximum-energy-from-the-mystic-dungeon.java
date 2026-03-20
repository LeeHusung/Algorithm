class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int len = energy.length;
        int[] dp = new int[len];
        dp[len - 1] = energy[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (i + k >= len) {
                dp[i] = energy[i];
                continue;
            }
            dp[i] = energy[i] + dp[i + k];
        }

        int answer = Integer.MIN_VALUE;
        for (int x : dp) {
            answer = Math.max(answer, x);
        }
        return answer;
    }
}