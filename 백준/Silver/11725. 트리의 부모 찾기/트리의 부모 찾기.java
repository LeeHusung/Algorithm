import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int[] ch = new int[n + 1];
        ch[1] = 1;
        Map<Integer, Integer> map = new HashMap<>();

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int x : graph.get(p)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    map.put(x, p);
                    q.offer(x);
                }
            }
        }
        int[] arr = new int[n + 1];
        for (int key : map.keySet()) {
            arr[key] = map.get(key);
        }

        for (int i = 2; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }
}
