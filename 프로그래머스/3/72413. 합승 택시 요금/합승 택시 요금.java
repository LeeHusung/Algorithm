import java.util.*;
class Node implements Comparable<Node> {
    public int idx, cost;
    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node node) {
        return this.cost - node.cost;
    }
}

class Solution {
    public static final int MAX = 300 * 100000;
    public int[][] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        graph = new int[n][n];
        for(int i = 0; i<n; i++) Arrays.fill(graph[i], MAX);
        
        for(int[] x : fares) {
            graph[x[0]-1][x[1]-1] = x[2];
            graph[x[1]-1][x[0]-1] = x[2];
        }
        
        int[] start = dijkstra(s-1);
        int[] aStart = dijkstra(a-1);
        int[] bStart = dijkstra(b-1);
        
        for (int i = 0; i<n; i++) {
            answer = Math.min(answer, start[i] + aStart[i] + bStart[i]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int target) {
        
        int[] cost = new int[graph.length];
        Arrays.fill(cost, MAX);
        cost[target] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(target, 0));
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < graph.length; i++) {
                if (cost[i] > node.cost + graph[node.idx][i]) {
                    cost[i] = node.cost + graph[node.idx][i];
                    pq.offer(new Node(i, node.cost + graph[node.idx][i]));
                }
            }
        }
        return cost;
        
    }
    
}