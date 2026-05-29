import java.util.*;
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long profit = 0;
        int n = prices.length;
        int[] originals = new int[n];

        for (int i = 0; i < n; i++) {
            originals[i] = prices[i] * strategy[i];
            profit += originals[i];
        }

        long answer = profit;

        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < k / 2; i++) {
            sum1 += originals[i];
        }
        long tmp2 = 0;
        for (int i = k / 2; i < k; i++) {
            sum2 += originals[i];
            tmp2 += prices[i];
        }

        for (int i = 0; i < n; i++) {
            long k1 = 0 - sum1;
            long k2 = tmp2 - sum2;
            answer = Math.max(answer, profit + k1 + k2);
            if (i == n - k) {
                break;
            }
            sum1 -= originals[i];
            sum1 += originals[i + k / 2];

            sum2 += originals[i + k];
            sum2 -= originals[i + k / 2];

            tmp2 -= prices[i + k / 2];
            tmp2 += prices[i + k];
        }


        return answer;
    }
}