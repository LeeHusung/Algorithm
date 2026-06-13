import java.util.*;
class Solution {
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] swap : allowedSwaps) {
            graph.get(swap[0]).add(swap[1]);
            graph.get(swap[1]).add(swap[0]);
        }

        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1) continue;
            Queue<Integer> q = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            q.offer(i);
            list.add(i);
            ch[i] = 1;
            while (!q.isEmpty()) {
                int p = q.poll();
                for (int j = 0; j < graph.get(p).size(); j++) {
                    int k = graph.get(p).get(j);
                    if (ch[k] == 0) {
                        q.offer(k);
                        list.add(k);
                        ch[k] = 1;
                    }
                }
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : list) {
                if (map.containsKey(source[x])) {
                    map.put(source[x], map.get(source[x]) + 1);
                } else {
                    map.put(source[x], 1);
                }
            }
            int cnt = 0;
            for (int x : list) {
                int c = map.containsKey(target[x]) ? map.get(target[x]) : 0;
                if (c > 0) {
                    map.put(target[x], c - 1);
                } else {
                    cnt++;
                }
            }

            answer += cnt;
        }


        return answer;

    }


}