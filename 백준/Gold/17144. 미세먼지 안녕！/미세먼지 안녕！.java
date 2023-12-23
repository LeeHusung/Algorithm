import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int r, c, t;
    static int[][] arr, tmp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        t = Integer.parseInt(s[2]);
        List<int[]> cleaner = new ArrayList<>();
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
                if (arr[i][j] == -1) cleaner.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < t; i++) {
            tmp = new int[r][c];
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    if (arr[j][k] > 0) {
                        int z = arr[j][k] / 5;
                        int cnt = 0;
                        for (int l = 0; l < 4; l++) {
                            int nx = j + dx[l];
                            int ny = k + dy[l];
                            if (nx >= 0 && ny >= 0 && nx < r && ny < c && arr[nx][ny] != -1) {
                                tmp[nx][ny] += z;
                                cnt++;
                            }
                        }
                        arr[j][k] -= cnt * z;
                        tmp[j][k] += arr[j][k];
                    }
                }
            }
//            System.out.println("=====확산=====");
//            for (int v = 0; v < tmp.length; v++) {
//                for (int j = 0; j < tmp[v].length; j++) {
//                    System.out.print(tmp[v][j] + " ");
//                }
//                System.out.println();
//            }

//            System.out.println("=====공기청정기 작동=====");

            int[] highCleaner = cleaner.get(0);
            for (int j = highCleaner[0]; j > 0; j--) {
                tmp[highCleaner[0]][highCleaner[1]] = 0;
                tmp[j][0] = tmp[j - 1][0];
            }
            for (int j = 0; j < c - 1; j++) {
                tmp[0][j] = tmp[0][j + 1];
            }
            for (int j = 0; j < highCleaner[0]; j++) {
                tmp[j][c - 1] = tmp[j + 1][c - 1];
            }
            for (int j = c - 1; j > 0; j--) {
                tmp[highCleaner[0]][j] = tmp[highCleaner[0]][j - 1];
            }

            int[] lowCleaner = cleaner.get(1);
            for (int j = lowCleaner[0]; j < r - 1; j++) {
                tmp[lowCleaner[0]][lowCleaner[1]] = 0;
                tmp[j][0] = tmp[j + 1][0];
            }
            for (int j = 0; j < c - 1; j++) {
                tmp[r - 1][j] = tmp[r-1][j + 1];
            }
            for (int j = r - 1; j > lowCleaner[0]; j--) {
                tmp[j][c - 1] = tmp[j - 1][c - 1];
            }
            for (int j = c - 1; j > 0; j--) {
                tmp[lowCleaner[0]][j] = tmp[lowCleaner[0]][j - 1];
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j] = tmp[j].clone();
            }
//
//            for (int v = 0; v < tmp.length; v++) {
//                for (int j = 0; j < tmp[v].length; j++) {
//                    System.out.print(tmp[v][j] + " ");
//                }
//                System.out.println();
//            }

        }

        int answer = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                if (tmp[i][j] > 0) {
                    answer += tmp[i][j];
                }
            }
        }
        System.out.println(answer);

    }
}
