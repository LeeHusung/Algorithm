import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] ch, task;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nn = Integer.parseInt(st.nextToken());
            for(int j=0; j<nn; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        ch = new int[m + 1];
        task = new int[m + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            ch = new int[m + 1];
            if (D(i)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean D(int person) {
        for (Integer canDoT : graph.get(person)) {
            if (ch[canDoT] == 1) continue;
            ch[canDoT] = 1;
            if (task[canDoT] == 0 || D(task[canDoT])) {
                task[canDoT] = person;
                return true;
            }
        }
        return false;
    }
}
