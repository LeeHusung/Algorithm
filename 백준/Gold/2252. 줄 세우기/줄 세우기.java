import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] arr = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            graph.get(x).add(y);
            arr[y]++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Integer p = q.poll();
            sb.append(p).append(" ");
            for (int x : graph.get(p)) {
                arr[x]--;
                if (arr[x] == 0) {
                    q.offer(x);
                }
            }
        }
        System.out.println(sb);
    }
}
