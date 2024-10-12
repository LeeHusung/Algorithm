import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] ch, tmp;
    static ArrayList<ArrayList<Integer>> graph;
    static List<Integer> arr = new ArrayList<>();
    static int idx = 1;
    static boolean flag;
    private static void D(int x) {
        if (!flag) return;
        Set<Integer> set = new HashSet<>();
        for (Integer p : graph.get(x)) {
            if (ch[p] == 0) {
                ch[p] = 1;
                set.add(p);
            }
        }

        int size = set.size();
        for (int i = 0; i < size; i++) {
            if (set.remove(arr.get(idx))) {
                D(arr.get(idx++));
            } else {
                flag = false;
                return;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        flag = true;
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        if (arr.get(0) != 1) {
            System.out.println(0);
            return;
        }
        ch[1] = 1;
        D(1);

        if (!flag) {
            System.out.println(0);
            return;
        }

        System.out.println(1);

    }
}
