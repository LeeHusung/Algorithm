import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] arr, ch;
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void D(int start, int cnt) {
        if (start == arr[1]) {
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (ch[graph.get(start).get(i)] == 0) {
                ch[graph.get(start).get(i)] = 1;
                D(graph.get(start).get(i), cnt + 1);
                ch[graph.get(start).get(i)] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n + 1];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        String[] s = br.readLine().split(" ");
        arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] sss = br.readLine().split(" ");
            int x = Integer.parseInt(sss[0]);
            int y = Integer.parseInt(sss[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        ch[arr[0]] = 1;
        D(arr[0], 0);
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

//        Queue<Integer> q = new LinkedList<>();
//        q.offer(arr[0]);
//        ch[arr[0]] = 1;
//
//        int bfs = bfs(ch, graph, q);
//        if (bfs == -1) {
//            System.out.println(-1);
//            return;
//        } else System.out.println(bfs - 1);


    }

//    private static int bfs(int[] ch, ArrayList<ArrayList<Integer>> graph, Queue<Integer> q) {
//        int L = 0;
//        while (!q.isEmpty()) {
//            int len = q.size();
//            L++;
//            for (int i = 0; i < len; i++) {
//                int p = q.poll();
////                System.out.println(p);
//                if (p == arr[1]) return L;
//                for (int j = 0; j < graph.get(p).size(); j++) {
//                    if (ch[graph.get(p).get(j)] == 0) {
//                        ch[graph.get(p).get(j)] = 1;
//                        q.offer(graph.get(p).get(j));
//                    }
//                }
//
//            }
//        }
//        return -1;
//    }
}
