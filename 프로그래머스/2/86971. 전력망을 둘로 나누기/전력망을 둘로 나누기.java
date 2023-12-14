import java.util.*;
class Solution {

    static int answer;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void calculate(int n, int[] ch, int[][] wires) {
        int[] chhh = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < wires.length; i++) {
            if (ch[i] == 0) {
                q.offer(wires[i][0]);
                break;
            }
        }
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int x : graph.get(p)) {
                if (chhh[x] == 0) {
//                    System.out.println(x);
                    chhh[x] = 1;
                    q.offer(x);
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i < chhh.length; i++) {
            if (chhh[i] == 1) cnt++;
        }
        int x = cnt;
        int y = n - x;
        // for (int k = 0; k < chhh.length; k++) System.out.print(chhh[k] + " ");
        // System.out.println("x, y " + x + " " + y);
//        System.out.println(Math.abs(x - y));
        answer = Math.min(answer, Math.abs(x - y));
//        System.out.println(answer);
                graph.clear();

    }

    public void D(int n, int[][] wires, int L) {
        if (L == n) return;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch[L] = 1;
        for (int i = 0; i < wires.length; i++) {
            if (ch[i] == 0) {
                int x = wires[i][0];
                int y = wires[i][1];
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
        }
        calculate(n, ch, wires);
        ch[L] = 0;
        D(n, wires, L + 1);
    }

    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        ch = new int[n + 1];

//         for (int[] wire : wires) {
//             int x = wire[0];
//             int y = wire[1];
//             graph.get(x).add(y);
//             graph.get(y).add(x);
//         }

        D(n, wires, 0);

        return answer;
    }
}