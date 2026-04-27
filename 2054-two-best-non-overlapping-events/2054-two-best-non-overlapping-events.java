import java.util.*;
class Solution {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int res = 0;
            int maxVal = 0;
        for (int[] x : events) {
            while (!pq.isEmpty() && pq.peek()[0] < x[0]) {
                int[] p = pq.poll();
                maxVal = Math.max(maxVal, p[1]);
            }
             pq.add(new int[]{x[1], x[2]});

            res = Math.max(res, x[2] + maxVal);
        }

        return res;
    }
}