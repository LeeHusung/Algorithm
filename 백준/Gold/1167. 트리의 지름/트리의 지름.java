import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, answer;
    static int[] ch, dist;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n + 1];
        dist = new int[n + 1];
        answer = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int node = Integer.parseInt(s[0]);
            for (int j = 1; j < s.length - 1; j += 2) {
                int target = Integer.parseInt(s[j]);
                int weight = Integer.parseInt(s[j + 1]);
                graph.get(node).add(new int[]{target, weight});
            }
        }
        DFS(1, 0);
        int start = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = new int[n + 1];
        ch = new int[n + 1];
        DFS(start, 0);
        Arrays.sort(dist);
        System.out.println(dist[n]);
    }

    private static void DFS(int node, int weight) {
        ch[node] = 1;
        dist[node] = weight;
        for (int[] x : graph.get(node)) {
            if (ch[x[0]] == 0) {
                DFS(x[0], weight + x[1]);
            }
        }
    }
}
