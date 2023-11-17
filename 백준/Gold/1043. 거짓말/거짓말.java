import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            graph.get(i).add(i);
        }

        int knowFact = sc.nextInt();
        int[] knowArr = new int[knowFact];
        for (int i = 0; i < knowFact; i++) {
            knowArr[i] = sc.nextInt();
        }

        int cnt = 0;
        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int attendSum = sc.nextInt();
            ArrayList<Integer> keep = new ArrayList<>();
            for (int j = 1; j <= attendSum; j++) {
                int x = sc.nextInt();
                keep.add(x);
            }
            parties.add(keep);
            for (int j = 0; j < keep.size(); j++) {
                for (int k = j + 1; k < keep.size(); k++) {
                    int z = keep.get(j);
                    int h = keep.get(k);
                    graph.get(z).add(h);
                    graph.get(h).add(z);
                }
            }
        }

        int[] ch = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        for (int x : knowArr) {
            if (ch[x] == 0) {
                q.offer(x);
                ch[x] = 1;
            }
        }
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int i = 0; i < graph.get(p).size(); i++) {
                int k = graph.get(p).get(i);
                if (ch[k] == 0) {
                    ch[k] = 1;
                    q.offer(k);
                }
            }
        }

        for (ArrayList<Integer> party : parties) {
            boolean lie = true;
            for (int person : party) {
                if (ch[person] == 1) {
                    lie = false;
                    break;
                }
            }
            if (lie) cnt++;
        }

        System.out.println(cnt);
    }
}
