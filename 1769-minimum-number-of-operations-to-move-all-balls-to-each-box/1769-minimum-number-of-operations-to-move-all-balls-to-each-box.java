import java.util.*;
class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];

        for (int i = 0, cnt = 0, sum = 0; i < answer.length; i++) {
            answer[i] += sum;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            sum += cnt;
        }
        for (int i = answer.length - 1, cnt = 0, sum = 0; i >= 0; i--) {
            answer[i] += sum;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            sum += cnt;
        }
        return answer;
    }
}