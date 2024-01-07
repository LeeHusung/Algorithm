import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int k = 0;
        
        for (int[] x : targets) {
            if (x[0] < k) continue;
            answer++;
            k = x[1];
        }
        
        return answer;
    }
}