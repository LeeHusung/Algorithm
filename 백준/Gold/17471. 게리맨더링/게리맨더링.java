import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, answer;
    static int[] nums, ch, people;
    static ArrayList<ArrayList<Integer>> graph;
    static LinkedList<Integer> list = new LinkedList<>();
    private static void D(int L, int start) {
        if (L >= 1) {
            if (check(list)) {
                int x = 0;
                int y = 0;
                for (int i = 1; i <= n; i++) {
                    if (list.contains(i)) {
                        x += people[i];
                    } else y += people[i];
                }
                answer = Math.min(answer, Math.abs(x - y));
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                list.add(i);
                D(L + 1, i + 1);
                ch[i] = 0;
                list.pollLast();
            }
        }
    }

    private static boolean check(LinkedList<Integer> list) {
//        for (Integer integer : list) {
//            System.out.print(integer + " ");
//        }
//        System.out.println();

        LinkedList<Integer> other = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) other.add(i);
        }

        if (!list.isEmpty() && !other.isEmpty()) {
            if (bfs(list) && bfs(other)) return true;
        }
        return false;
    }

    private static boolean bfs(LinkedList<Integer> list) {
        int[] ch = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(list.get(0));
        ch[list.get(0)] = 1;
        int cnt = 1;
        while (!q.isEmpty()) {
            Integer p = q.poll();
            for (int x : graph.get(p)) {
                if (ch[x] == 0 && list.contains(x)) {
                    ch[x] = 1;
                    q.offer(x);
                    cnt++;
                }
            }
        }
        if (cnt == list.size()) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        nums = new int[n + 1];
        ch = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        String[] s = br.readLine().split(" ");
        people = new int[s.length + 1];
        for (int i = 1; i < s.length + 1; i++) {
            people[i] = Integer.parseInt(s[i - 1]);
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < Integer.parseInt(s1[0]); j++) {
                graph.get(i).add(Integer.parseInt(s1[j + 1]));
            }
        }

        D(0, 1);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else System.out.println(answer);
    }

}
