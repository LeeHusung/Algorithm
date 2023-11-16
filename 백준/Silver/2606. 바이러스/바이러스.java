import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fair = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < fair; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int[] ch = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        ch[1] = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int p = q.poll();
            cnt++;
            for (int i = 0; i < graph.get(p).size(); i++) {
                int k = graph.get(p).get(i);
                if (ch[k] == 0) {
                    ch[k] = 1;
                    q.offer(k);
                }
            }
        }
        System.out.println(cnt - 1);

    }
}
