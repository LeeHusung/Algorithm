import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] ch;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ch = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph22 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            graph22.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            graph.get(x).add(y);
            graph22.get(y).add(x);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(ch, 0);
            q.clear();
            ch[i] = 1;
            q.offer(i);
            int cnt = 0;
            boolean flag = false;
            while (!q.isEmpty()) {
                Integer p = q.poll();
                for (Integer x : graph.get(p)) {
                    if (ch[x] == 0) {
                        cnt++;
                        if (cnt > n / 2) {
                            flag = true;
                            break;
                        }
                        ch[x] = 1;
                        q.offer(x);
                    }
                }
                if (flag) {
                    answer++;
                    break;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            Arrays.fill(ch, 0);
            q.clear();
            ch[i] = 1;
            q.offer(i);
            int cnt = 0;
            boolean flag = false;
            while (!q.isEmpty()) {
                Integer p = q.poll();
                for (Integer x : graph22.get(p)) {
                    if (ch[x] == 0) {
                        cnt++;
                        if (cnt > n / 2) {
                            flag = true;
                            break;
                        }
                        ch[x] = 1;
                        q.offer(x);
                    }
                }
                if (flag) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
