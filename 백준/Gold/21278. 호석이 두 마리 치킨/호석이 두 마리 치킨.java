import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[] arr, ch;
    static int[] tmp;
    static List<int[]> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private static void D(int L, int idx) {
        if (L == 2) {
            int c = cal();
            list.add(new int[]{tmp[0], tmp[1], c});
            return;
        }
        for (int i = idx; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                tmp[L] = i + 1;
                D(L + 1, i + 1);
                ch[i] = 0;
            }
        }
    }

    private static int cal() {
        int[] cost = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (i == tmp[0] || i == tmp[1]) continue;
            int[] ch2 = new int[n + 1];
            q.offer(i);
            ch2[i] = 1;
            int L = 0;
            while (!q.isEmpty()) {
                int len = q.size();
                L++;
                boolean flag = false;
                for (int j = 0; j < len; j++) {
                    Integer p = q.poll();
                    for (Integer x : graph.get(p)) {
                        if (ch2[x] == 1) continue;
                        if (x == tmp[0] || x == tmp[1]) {
                            cost[i] = L * 2;
                            flag = true;
                            break;
                        }
                        q.offer(x);
                        ch2[x] = 1;
                    }
                }
                if (flag) {
                    break;
                }
            }
            q.clear();
        }
        int res = 0;
        for (int i = 1; i < cost.length; i++) {
            res += cost[i];
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n + 1];
        ch = new int[n + 1];
        tmp = new int[2];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        D(0, 0);
        Collections.sort(list, (a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        System.out.println(list.get(0)[0] + " " + list.get(0)[1] + " " + list.get(0)[2]);
    }

}
