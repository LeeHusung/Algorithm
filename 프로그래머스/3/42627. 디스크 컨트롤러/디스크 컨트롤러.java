import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        int t = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int idx = 0;
        
        while (idx < n || !pq.isEmpty()) {
            while (idx < n && jobs[idx][0] <= t) {
                pq.offer(new int[]{jobs[idx][0], jobs[idx++][1]});
                
            }
            if (pq.isEmpty()) {
                t = jobs[idx][0];
            } else {
                int[] p = pq.poll();
                answer += t + p[1] - p[0];
                t += p[1];
            }
        }
        
        answer = (int) Math.floor(answer / n);
        
        return answer;
    }
}