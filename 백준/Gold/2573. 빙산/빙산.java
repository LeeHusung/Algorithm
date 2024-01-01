import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] arr, tmp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }


        int time = 0;
        while (true) {
            if (checkArea() >= 2) break;
//            System.out.println(checkArea());
            time++;

            melt();
            for (int i = 0; i < n; i++) {
                arr[i] = tmp[i].clone();
            }

            if (checkZero()) {
                System.out.println(0);
                return;
            }
//            System.out.println("=====arr=====");
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(tmp[i][j] + " ");
//                }
//                System.out.println();
//            }
        }
        System.out.println(time);
    }

    private static boolean checkZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0) return false;
            }
        }
        return true;
    }

    private static void melt() {
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i].clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                            cnt++;
                        }
                    }
                    if (arr[i][j] - cnt < 0) tmp[i][j] = 0;
                    else tmp[i][j] -= cnt;
                }
            }
        }
    }

    private static int checkArea() {
        int[][] ch = new int[n][m];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    cnt++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && ch[nx][ny] == 0 && arr[nx][ny] > 0) {
                                ch[nx][ny] = 1;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }

                }
            }
        }
        return cnt;
    }
}
