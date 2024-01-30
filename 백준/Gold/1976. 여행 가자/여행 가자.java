import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (i != j && Integer.parseInt(s[j]) == 1) {
                    graph.get(i + 1).add(j + 1);
                }
            }
        }
        String[] s = br.readLine().split(" ");
        int[] path = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            path[i] = Integer.parseInt(s[i]);
        }

        boolean flag = true;
        for (int i = 0; i < path.length - 1; i++) {
            int[] ch = new int[n + 1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(path[i]);
            ch[path[i]] = 1;
            while (!q.isEmpty()) {
                Integer p = q.poll();
                for (int x : graph.get(p)) {
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        q.offer(x);
                    }
                }
            }

            if (ch[path[i + 1]] == 0) {
                flag = false;
                break;
            }
        }

        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
