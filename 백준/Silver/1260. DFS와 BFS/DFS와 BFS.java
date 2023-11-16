import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        ch = new int[n + 1];
        D(v);
        System.out.println();

        Arrays.fill(ch, 0);
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        ch[v] = 1;
        while (!q.isEmpty()) {
            int p = q.poll();
            System.out.print(p + " ");
            for (int i = 0; i < graph.get(p).size(); i++) {
                int k = graph.get(p).get(i);
                if (ch[k] == 0) {
                    ch[k] = 1;
                    q.offer(k);
                }
            }
        }

    }

    private static void D(int start) {
        ch[start] = 1;
        System.out.print(start + " ");;

        for (int i = 0; i < graph.get(start).size(); i++) {
            int k = graph.get(start).get(i);
            if (ch[k] == 0) {
                D(k);
            }
        }
    }
}
