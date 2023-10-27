import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int camera = Integer.MIN_VALUE;
        
        for (int[] x : routes) {
            if (camera < x[0]) {
                camera = x[1];
                answer++;
            }
            
        }
        
        
        return answer;
    }
}