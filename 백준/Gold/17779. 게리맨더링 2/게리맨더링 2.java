import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int x = 1; x <= n; x++) {
            for (int y = 2; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (1 <= x && x < x+d1+d2 &&  x+d1+d2 <= n && 1 <= y - d1 && y < y + d2 && y + d2 <= n) {
                            int[][] check = check(x, y, d1, d2);

                            int[] point = new int[5];
                            for (int i = 1; i <= n; i++) {
                                for (int j = 1; j <= n; j++) {
                                    if (check[i][j] == 1) point[0] += arr[i][j];
                                    if (check[i][j] == 2) point[1] += arr[i][j];
                                    if (check[i][j] == 3) point[2] += arr[i][j];
                                    if (check[i][j] == 4) point[3] += arr[i][j];
                                    if (check[i][j] == 5) point[4] += arr[i][j];
                                }
                            }
                            int max = 0;
                            int min = Integer.MAX_VALUE;
                            for (int z : point) {
                                max = Math.max(max, z);
                                min = Math.min(min, z);
                            }
                            answer = Math.min(answer, max - min);
                        }
                    }
                }
            }
        }
        System.out.println(answer);


    }

    private static int[][] check(int x, int y, int d1, int d2) {
        int[][] section = new int[n + 1][n + 1];

        for (int i = 0; i <= d2; i++) {
            section[x + i][y + i] = 5;
            section[x + d1 + i][y - d1 + i] = 5;
        }

        for (int i = 0; i <= d1; i++) {
            section[x + i][y - i] = 5;
            section[x + d2 + i][y + d2 - i] = 5;
        }

        for (int i = x + 1; i < x + d1 + d2; i++) {
            boolean flag = false;
            for (int j = 1; j <= n; j++) {
                if (section[i][j] == 5) {
                    if (flag) break;
                    flag = true;
                    continue;
                }
                if (flag) section[i][j] = 5;

            }
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (section[r][c] == 5) continue;
                if (r < x + d1 && c <= y) section[r][c] = 1;
                else if (r <= x + d2 && c > y) section[r][c] = 2;
                else if (r >= x + d1 && c < y - d1 + d2) section[r][c] = 3;
                else if (r > x + d2 && c >= y-d1+d2) section[r][c] = 4;
            }
        }

        return section;
    }
}
