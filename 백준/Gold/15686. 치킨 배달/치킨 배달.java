import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static int[][] arr;
    static ArrayList<int[]> chickens, homes;

    public static void D(int start, int L, ArrayList<int[]> selectChicken) {
        if (L == m) {
            int sum = 0;
            for (int i = 0; i < homes.size(); i++) {
                int max = Integer.MAX_VALUE;
                for (int[] x : selectChicken) {
                    int k = Math.abs(x[0] - homes.get(i)[0]) + Math.abs(x[1] - homes.get(i)[1]);
                    max = Math.min(k, max);
                }
                sum += max;
            }
            answer = Math.min(sum, answer);
            return;
        } else {
            for (int i = start; i < chickens.size(); i++) {
                selectChicken.add(chickens.get(i));
                D(i + 1, L + 1, selectChicken);
                selectChicken.remove(selectChicken.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = Integer.MAX_VALUE;

        arr = new int[n][n];

        chickens = new ArrayList<>();
        homes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) homes.add(new int[]{i, j});
                if (arr[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }
        D(0, 0, new ArrayList<>());
        System.out.println(answer);
    }
}
