import java.util.*;
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int[] ch = new int[costs.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[1] - b[1] : a[2] - b[2]);
        for (int i = 0; i < candidates; i++) {
            pq.add(new int[]{0, i, costs[i]});
            ch[i] = 1;
        }
        for (int i = costs.length - 1; i >= costs.length - candidates; i--) {
            if (ch[i] == 0) {
                ch[i] = 1;
                pq.add(new int[]{1, i, costs[i]});
            }
        }
        int xIdx = candidates - 1;
        int yIdx = costs.length - candidates;
        long answer = 0;
        while (k --> 0) {
            int[] p = pq.poll();
            answer += p[2];
            if (p[0] == 0) {
                xIdx++;
                if (xIdx < costs.length && ch[xIdx] == 0) {
                    pq.add(new int[]{0, xIdx, costs[xIdx]});
                    ch[xIdx] = 1;
                }
            } else if (p[0] == 1) {
                yIdx--;
                if (yIdx >= 0 && ch[yIdx] == 0) {
                    ch[yIdx] = 1;
                    pq.add(new int[]{1, yIdx, costs[yIdx]});
                }
            }
        }
        return answer;
    }
}