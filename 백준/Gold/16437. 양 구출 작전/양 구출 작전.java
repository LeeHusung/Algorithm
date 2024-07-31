import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static long sum;
    static int n;
    static long[] arr;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static void D(int idx, int pa) {
        for (Integer x : graph.get(idx)) {
            D(x, idx);
        }
        if (pa != -1 && arr[idx] > 0) {
            arr[pa] += arr[idx];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n + 1];
        sum = 0;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String x = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            graph.get(next).add(i);
            arr[i] = cnt;
            if (x.equals("W")) {
                arr[i] *= -1;
            }
        }

        D(1, -1);
        System.out.println(arr[1]);
    }
}
