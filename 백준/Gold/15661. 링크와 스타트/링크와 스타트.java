import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, min;
    static int[][] arr;
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D(0, 0);
        System.out.println(min);
    }

    private static void D(int L, int start) {
        if (L > 0) {
            int m = check();
            min = Math.min(m, min);
        }

        for (int i = start; i < n; i++) {
            list.add(i);
            D(L + 1, i + 1);
            list.pollLast();
        }
    }

    private static int check() {
        List<Integer> side = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!list.contains(i)) side.add(i);
        }

        int myTeam = 0;
        int sideTeam = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int one = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int next = list.get(j);
                myTeam += arr[one][next];
                myTeam += arr[next][one];
            }
        }
        for (int i = 0; i < side.size() - 1; i++) {
            int one = side.get(i);
            for (int j = i + 1; j < side.size(); j++) {
                int next = side.get(j);
                sideTeam += arr[one][next];
                sideTeam += arr[next][one];
            }
        }
        return Math.abs(myTeam - sideTeam);

    }
}
