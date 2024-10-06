import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, min;
    static int[] arr, cal, ch;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        cal = new int[n];
        ch = new int[n];
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                graph.get(i).add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
        }

        D(0);
        System.out.println(min);
    }

    private static void D(int L) {
        if (L == n) {
            calculate();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                cal[L] = i + 1;
                D(L + 1);
                ch[i] = 0;
            }
        }

    }

    private static void calculate() {
        int[] tmp = arr.clone();
        int cnt = 0;
        for (int i = 0; i < cal.length; i++) {
            int num = cal[i];
            cnt += tmp[num];
            for (int[] x : graph.get(num)) {
                tmp[x[0]] -= x[1];
                if (tmp[x[0]] <= 0) {
                    tmp[x[0]] = 1;
                }
            }
        }
        min = Math.min(min, cnt);
    }
}
