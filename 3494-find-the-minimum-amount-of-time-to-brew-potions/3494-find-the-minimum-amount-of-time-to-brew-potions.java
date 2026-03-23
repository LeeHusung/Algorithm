import java.util.*;
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] dp = new long[n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j + 1] = Math.max(dp[j + 1], dp[j]) + (long) skill[j] * mana[i];
            }
            for (int k = n - 1; k > 0; k--) {
                dp[k] = dp[k + 1] - (long) skill[k] * mana[i];
            }
        }
        
        return (long) dp[n];

    }
}