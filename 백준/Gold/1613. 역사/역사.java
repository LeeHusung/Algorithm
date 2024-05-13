import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            arr[x][y] = 1;
        }

        for (int i = 1; i <= n; i++) { //경유
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    if (arr[j][i] == 1 && arr[i][l] == 1) arr[j][l] = 1;
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            if (x < 1 || y < 1 || x > n || y > n) sb.append(0).append("\n");
            else {
                if (arr[x][y] == 1) sb.append(-1).append("\n");
                else if (arr[y][x] == 1) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
