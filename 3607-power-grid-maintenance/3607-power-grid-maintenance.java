import java.util.*;
class Solution {
    static List<SortedSet<Integer>> graph = new ArrayList<>();
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        for (int i = 0; i <= c; i++) {
            graph.add(new TreeSet<>());
        }
        for (int[] con : connections) {
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(con[0]);
        }
        boolean[] visited = new boolean[c + 1];
        for (int i = 1; i <= c; i++) {
            if (visited[i]) continue;
            SortedSet<Integer> component = new TreeSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true;
            component.add(i);
            while (!q.isEmpty()) {
                int p = q.poll();
                for (int nb : graph.get(p)) {   // 이 시점 graph.get(p)는 직접 이웃
                    if (!visited[nb]) {
                        visited[nb] = true;
                        component.add(nb);
                        q.offer(nb);
                    }
                }
            }
            for (int node : component) {
                graph.set(node, component);     // 같은 참조를 공유
            }
        }
        int[] ch = new int[c + 1];
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                if (ch[q[1]] == 0) {
                    res.add(q[1]);
                } else if (ch[q[1]] == 1) {
                    res.add(check(q[1], ch));
                }
            } else if (q[0] == 2) {
                //offline
                ch[q[1]] = 1;
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        graph.clear();
        return result;
    }

    public int check(int x, int[] ch) {
        // System.out.println("x: " + x);
        // System.out.println("ch: " + Arrays.toString(ch));
        while(!graph.get(x).isEmpty()) {
            if (ch[graph.get(x).first()] == 1) {
                graph.get(x).remove(graph.get(x).first());
            } else {
                return graph.get(x).first();
            }
        }

        return -1;
    }
}