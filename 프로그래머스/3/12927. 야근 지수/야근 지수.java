import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int len = works.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += works[i];
            pq.offer(works[i]);
        }
        if (sum <= n) return 0;
        long avg = (sum - n) / len;
        
        int[] res = new int[len];
        
        
        
        int cnt = 0;
        while(!pq.isEmpty()) {
            if (cnt == n) break;
            int p = pq.poll();
            p--;
            cnt++;
            pq.offer(p);
        }
        
        int idx = 0;
         while(!pq.isEmpty()) {
            res[idx++] = pq.poll();   
         }
        
        
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] * res[i];
            answer += res[i];
        }
        
        return answer;
    }
}