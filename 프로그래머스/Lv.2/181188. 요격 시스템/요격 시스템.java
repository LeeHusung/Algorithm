import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> a[0] - b[0]);
        
        int k = 0;
        
//         for (int[] x : targets) {
//             if (x[0] < k) continue;
//             answer++;
//             k = x[1];
//         }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);

        for (int i = 0; i < targets.length; i++) {
            if (!pq.isEmpty() && pq.peek()[1] > targets[i][1]) {
                pq.poll();
                pq.add(targets[i]);
                continue;
            }
            if (!pq.isEmpty() && pq.peek()[1] > targets[i][0]) continue;

            pq.offer(targets[i]);
        }
        
        return pq.size();
    }
}