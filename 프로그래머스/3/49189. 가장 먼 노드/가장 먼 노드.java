import java.util.*;

class Solution {
    public int solution(int n, int[][] vertex) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] x : vertex) {
            graph.get(x[0]-1).add(x[1]-1);
            graph.get(x[1]-1).add(x[0]-1);
        }

        Queue<Integer> pq = new LinkedList<>();
        int[] dist = new int[n];
        int[] ch = new int[n];
        pq.offer(0);
        ch[0] = 1;
        int max = 0;
        
        while (!pq.isEmpty()) {
            int p = pq.poll();
            for (int x : graph.get(p)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    pq.offer(x);
                    dist[x] = dist[p] + 1;
                    max = Math.max(max, dist[x]);
                }
            }
        }
        for (int x : dist) {
            if (x == max) answer++;
        }

        return answer;
    }
}
