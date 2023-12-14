import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    static int n, m;
    static int[][] arr, ch;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static LinkedList<int[]> grooms = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n][n];
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        grooms.add(new int[]{n - 1, 0});
        grooms.add(new int[]{n - 2, 0});
        grooms.add(new int[]{n - 1, 1});
        grooms.add(new int[]{n - 2, 1});

        for (int i = 0; i < m; i++) {
            String[] z = br.readLine().split(" ");
            int d = Integer.parseInt(z[0]);
            int s = Integer.parseInt(z[1]);

            move(d, s);
            check();
            makeGrooms();

//            System.out.println("====arr===");
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < n; k++) {
//                    System.out.print(arr[j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();


        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0) answer += arr[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void move(int d, int s) {

        for (int j = 0; j < grooms.size(); j++) {
            int[] p = grooms.poll();
//            System.out.println("기존구름: " + p[0] + " " + p[1]);
            int nx = p[0];
            int ny = p[1];
            for (int i = 0; i < s; i++) {
                nx += dx[d];
                ny += dy[d];
                if (ny == -1 && nx == -1) {
                    nx = n-1;
                    ny = n-1;
                }
                else if (ny == -1 && nx == n) {
                    nx = 0;
                    ny = n-1;
                } else if (ny == n && nx == n) {
                    ny = 0;
                    nx = 0;
                } else if (ny == n && nx == -1) {
                    ny = 0;
                    nx = n-1;
                } else if (nx == n) nx = 0;
                else if (ny == -1) ny = n - 1;
                else if (nx == -1) nx = n - 1;
                else if (ny == n) ny = 0;
            }
//            System.out.println(nx + " " + ny);
            grooms.add(new int[]{nx, ny});
            ch[nx][ny] = 1;
            arr[nx][ny]++;
        }
//        for (int[] g :
//                grooms) {
//            System.out.println("움직인 후 구름: " + g[0] + " " + g[1]);
//        }


    }

    private static void makeGrooms() {
        grooms.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] >= 2 && ch[i][j] == 0) {
                    arr[i][j] -= 2;
                    grooms.add(new int[]{i, j});
                }
            }
        }

//        System.out.println("====ch===");
//        for (int j = 0; j < n; j++) {
//            for (int k = 0; k < n; k++) {
//                System.out.print(ch[j][k] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        for (int i = 0; i < n; i++) Arrays.fill(ch[i], 0);
    }

    private static void check() {
        for (int[] g : grooms) {
            int cnt = 0;
            for (int i = 2; i <= 8; i += 2) {
                int nx = g[0] + dx[i];
                int ny = g[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] > 0) {
                    cnt++;
                }
            }
            arr[g[0]][g[1]] += cnt;
        }
    }
}
