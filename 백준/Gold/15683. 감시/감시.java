import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int n, m, answer;
    static int[][] arr;
    static List<int[]> cctvs = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][][] direction = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };
    public static void D(int idx) {
        if (idx == cctvs.size()) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) sum++;
                }
            }
            answer = Math.min(answer, sum);
        } else {
            int[] cctv = cctvs.get(idx);
            int x = cctv[0];
            int y = cctv[1];
            int cctvNum = cctv[2];
            for (int i = 0; i < direction[cctvNum].length; i++) {
                int[][] tmp = copyArr(arr);
                for (int j = 0; j < direction[cctvNum][i].length; j++) {
                    int dir = direction[cctvNum][i][j];
                    mark(x, y, dir);
                }
                D(idx + 1);
                arr = tmp;
            }
        }
    }

    private static int[][] copyArr(int[][] arr) {
        int[][] newArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    private static void mark(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == 6) break;
            arr[nx][ny] = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        answer = Integer.MAX_VALUE;
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    cctvs.add(new int[]{i, j, arr[i][j]});
                }
            }
        }
        D(0);
        System.out.println(answer);
    }
}
