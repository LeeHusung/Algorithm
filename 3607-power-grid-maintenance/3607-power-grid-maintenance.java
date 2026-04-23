import java.util.*;
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int[] parents = new int[c + 1];
        int[] ch = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            parents[i] = i;
            map.put(i, new PriorityQueue<>());
        }
        for (int[] con : connections) {
            union(con[0], con[1], parents);
        }
        
        for (int i = 1; i <= c; i++) {
            int find = find(i, parents);
            map.get(find).offer(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 2) {
                ch[q[1]] = 1;
            } else if (q[0] == 1) {
                if (ch[q[1]] == 0) {
                    res.add(q[1]);
                } else {
                    int num = q[1];
                    PriorityQueue<Integer> pq = map.get(parents[num]);
                    boolean flag = false;
                    while (!pq.isEmpty()) {
                        if (ch[pq.peek()] == 0) {
                            res.add(pq.peek());
                            flag = true;
                            break;
                        } else {
                            pq.poll();
                        }
                    }
                    if (!flag) {
                        res.add(-1);
                    }
                }
            }
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public void union(int x, int y, int[] parents) {
        int fx = find(x, parents);
        int fy = find(y, parents);
        if (fx < fy) {
            parents[fy] = fx;
        } else parents[fx] = fy;
    }

    public int find(int x, int[] parents) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x], parents);
    }
}