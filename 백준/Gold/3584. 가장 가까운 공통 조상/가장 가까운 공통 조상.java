import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph;
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
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
            D(resx, a);
            D(resy, b);
            boolean flag = false;
            for (int j = 0; j < a.size(); j++) {
                for (int k = 0; k < b.size(); k++) {
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

        }
        System.out.println(sb);
    }

    private static void D(int idx, List<Integer> a) {
        a.add(idx);
        for (int x : graph.get(idx)) {
            D(x, a);
        }
    }
}