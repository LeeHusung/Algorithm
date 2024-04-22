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
    static List<Integer> res = new ArrayList<>();
    static int[] minFat = new int[4];

    private static void D(int L, int start) {
        if (check(list)) {
            return;
        }
        for (int i = start; i < n; i++) {
            list.add(i);
            D(L + 1, i + 1);
            list.removeLast();
        }
    }

    private static boolean check(LinkedList<Integer> list) {
        int protein = 0;
        int fat = 0;
        int carbon = 0;
        int vitamin = 0;
        int cost = 0;
        for (Integer i : list) {
            int[] x = arr[i];
            protein += x[0];
            fat += x[1];
            carbon += x[2];
            vitamin += x[3];
            cost += x[4];
        }
        if (minFat[0] <= protein && minFat[1] <= fat &&
                minFat[2] <= carbon && minFat[3] <= vitamin) {
            if (cost == min) {
                return true;
            }
            if (min > cost) {
                res.clear();
                min = Math.min(min, cost);
                res.addAll(list);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][5];
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            minFat[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D(0, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
        for (Integer re : res) {
            System.out.print(re + 1 + " ");
        }

    }

}
