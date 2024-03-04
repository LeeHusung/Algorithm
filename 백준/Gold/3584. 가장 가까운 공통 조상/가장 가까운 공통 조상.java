import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph;
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < n - 1; j++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                graph.get(y).add(x);
            }

            String[] s = br.readLine().split(" ");
            int resx = Integer.parseInt(s[0]);
            int resy = Integer.parseInt(s[1]);
            if (resy == resx) {
                sb.append(resx).append("\n");
                continue;
            }
            int[] ch = new int[n + 1];
            D(resx, a, ch);
            ch = new int[n + 1];
            D(resy, b, ch);

            boolean flag = false;
            for (int j = a.size()-1; j >= 0; j--) {
                for (int k = b.size()-1; k >= 0; k--) {
                    if (a.get(j).equals(b.get(k))) {
                        sb.append(a.get(j)).append("\n");
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            a.clear();
            b.clear();
            for (int j = 0; j < graph.size(); j++) {
                graph.get(j).clear();
            }
        }
        System.out.println(sb);
    }

    private static void D(int idx, LinkedList<Integer> a, int[] ch) {
        ch[idx] = 1;
        for (int x : graph.get(idx)) {
            if (ch[x] == 0 && graph.get(idx).size() > 0) {
                D(x, a, ch);
            }
        }
        a.add(idx);

    }
}