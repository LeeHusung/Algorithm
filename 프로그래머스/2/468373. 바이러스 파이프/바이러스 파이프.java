import java.util.*;
class Solution {
    static int[] types = {1, 2, 3};
    static int max = Integer.MIN_VALUE;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        int[] arr = new int[k];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            graph.get(x).add(new int[]{y, type});
            graph.get(y).add(new int[]{x, type});
        }
        
        D(k, 0, arr, n, infection, edges);
        
        
        
        return max;
    }
    
    public void D(int k, int L, int[] arr, int n, int infection, int[][] edges) {
        if (L == k) {
            // for (int i = 0; i < arr.length; i++) {
            //     System.out.print(arr[i] + " ");
            // }
            // System.out.println();
            bfs(arr, n, infection, edges);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (L > 0 && types[i] == arr[L - 1]) continue;
            arr[L] = types[i];
            D(k, L + 1, arr, n, infection, edges);
        }
    }
    
    public void bfs(int[] arr, int n, int infection, int[][] edges) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] ch = new int[n + 1];
        q.offer(infection);
        ch[infection] = 1;
        int idx = 0;
        while (!q.isEmpty()) {
            int p = q.poll();
            List<Integer> list = loop(p, ch, idx, arr);
            // for (int i = 0; i < graph.get(p).size(); i++) {
            //     if (ch[graph.get(p).get(i)[0]] == 0 && arr[idx] == graph.get(p).get(i)[1]) {
            //         q.offer(graph.get(p).get(i)[0]);
            //         ch[graph.get(p).get(i)[0]] = 1;
            //     }
            // }
            for (int tmp : list) {
                q.offer(tmp);
            }
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    List<Integer> list2 = loop(i, ch, idx, arr);
                    for (int tmp : list2) {
                        q.offer(tmp);
                    }
                    // for (int j = 0; j < graph.get(i).size(); j++) {
                    //     if (ch[graph.get(i).get(j)[0]] == 0 && arr[idx] == graph.get(i).get(j)[1]) {
                    //         q.offer(graph.get(i).get(j)[0]);
                    //         ch[graph.get(i).get(j)[0]] = 1;
                    //     }
                    // }
                    
                }
            }
            idx++;
            if (idx == arr.length) break;
        }
        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 1) tmp++;
        }
        // for (int i = 1; i < ch.length; i++) {
        //         System.out.print(ch[i] + " ");
        //     }
        // System.out.println();
        max = Math.max(max, tmp);
    }
    
    public List<Integer> loop(int p, int[] ch, int idx, int[] arr) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        q.offer(p);
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < graph.get(poll).size(); i++) {
                if (ch[graph.get(poll).get(i)[0]] == 0 && arr[idx] == graph.get(poll).get(i)[1]) {
                    q.offer(graph.get(poll).get(i)[0]);
                    ch[graph.get(poll).get(i)[0]] = 1;
                    list.add(graph.get(poll).get(i)[0]);
                }
            }
        }
        return list;
    }
}