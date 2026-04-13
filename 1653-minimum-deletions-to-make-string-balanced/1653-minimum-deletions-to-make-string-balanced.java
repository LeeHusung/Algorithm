import java.util.*;
class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();
        int[] cnt = new int[len];
        int tmp = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == 'b') {
                tmp++;
            }
            cnt[i] += tmp;
        }

        tmp = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i + 1) == 'a') {
                tmp++;
            }
            cnt[i] += tmp;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            answer = Math.min(answer, cnt[i]);
        }
        return answer;
    }
}