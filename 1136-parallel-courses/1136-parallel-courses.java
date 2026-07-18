import java.util.*;
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] cnt = new int[n + 1];
        for (int[] relation : relations) {
            cnt[relation[1]]++;
            graph.get(relation[0]).add(relation[1]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) q.offer(i);
        }
        if (q.isEmpty()) return -1;

        int result = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            result++;
            for (int i = 0; i < len; i++) {
                int p = q.poll();
                for (int j = 0; j < graph.get(p).size(); j++) {
                    int x = graph.get(p).get(j);
                    cnt[x]--;
                    if (cnt[x] == 0) {
                        q.offer(x);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] != 0) return -1;
        }
        return result;

    }
}