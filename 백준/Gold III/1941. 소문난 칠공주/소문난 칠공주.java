import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int answer;
    static int[][] arr, ch;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        arr = new int[5][5];
        ch = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                if (split[j].equals("S")) {
                    arr[i][j] = 2;
                } else arr[i][j] = 1;
            }
        }

        D(0, 0);

        System.out.println(answer);
    }

    private static void D(int L, int start) {
        if (L == 7) {
            check();
        } else {
            for (int i = start; i < 25; i++) {
                ch[i / 5][i % 5] = 1;
                D(L + 1, i + 1);
                ch[i / 5][i % 5] = 0;
            }
        }
    }

    private static boolean check() {
        int[][] copy = new int[5][5];
        for (int i = 0; i < 5; i++) {
            copy[i] = ch[i].clone();
        }

        int cnt = 0;
        int s = 0;
        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (copy[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p[0] + dx[k];
                int ny = p[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && copy[nx][ny] == 1) {
                    if (arr[nx][ny] == 2) s++;
                    copy[nx][ny] = 0;
                    cnt++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        if (cnt == 7 && s >= 4) answer++;

        return false;
    }
}
