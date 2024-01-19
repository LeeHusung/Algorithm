
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[] ch;
    static boolean flag = false;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private static void D(int node, int L) {
        if (L == 4) {
            flag = true;
            return;
        }
        for (int x : graph.get(node)) {
            if (ch[x] == 0) {
                ch[x] = 1;
                D(x, L + 1);
                ch[x] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        ch = new int[n];
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

        //깊이가 4인 노드가 있는지 찾는 문제다.

        for (int i = 0; i < n; i++) {
            ch[i] = 1;
            D(i, 0);
            if (flag) {
                System.out.println(1);
                return;
            }
            ch[i] = 0;
        }
        System.out.println(0);


    }

}
