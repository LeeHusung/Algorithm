import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        D(0, 0, n);
        System.out.println(sb.toString());

    }

    private static void D(int x, int y, int z) {
        if (same(x, y, z)) {
            sb.append(arr[x][y]);
        } else {
            sb.append("(");
            D(x, y, z / 2);
            D(x, y + z / 2, z / 2);
            D(x + z / 2, y, z / 2);
            D(x + z / 2, y + z / 2, z / 2);
            sb.append(")");
        }
    }

    private static boolean same(int x, int y, int z) {
        if (z == 1) {
            return true;
        } else {
            int k = arr[x][y];
            for (int i = x; i < x + z; i++) {
                for (int j = y; j < y + z; j++) {
                    if (arr[i][j] != k) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}