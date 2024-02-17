import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] arr = new int[m][2];
        int[] cost = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            graph.get(arr[i][0]).add(arr[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            int[] ch = new int[n + 1];
            q.offer(i);
            ch[i] = 1;
            while (!q.isEmpty()) {
                Integer p = q.poll();
                for (int x : graph.get(p)) {
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        cost[i]++;
                        cost[x]++;
                        q.offer(x);
                    }
                }
            }
        }
        int answer = 0;
        for (int x : cost) {
//            System.out.print(x + " ");
            if (x == n-1) answer++;
        }
//        System.out.println();
        System.out.println(answer);





    }
}
