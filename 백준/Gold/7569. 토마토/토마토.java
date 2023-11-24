import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    //반례입니다.
    //
    //2 2 3
    //-1 -1
    //-1 -1
    //1 -1
    //0 0
    //-1 0
    //-1 0
    //4가 나와야 합니다.

    //2 X 2 범위 벗어났는데도 nx의 이동 범위롤 n * h 까지 잡아놔서 x가 범위벗어난 한 칸 아래 x까지 익어버림.
    //2차원 배열로 풀다가 위 반례가 도저히 안돼서 3차원으로 변경

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] split = s.split(" ");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        int H = Integer.parseInt(split[2]);

        int[][][] arr = new int[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                String[] split1 = input.split(" ");
                for (int j = 0; j < M; j++) {
                    arr[k][i][j] = Integer.parseInt(split1[j]);
                }
            }
        }

        int[] dz = {0, 0, 0, 0, 1, -1};
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, -1, 0, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                    }
                }
            }
        }
        int[][][] ch = new int[H][N][M];

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 6; j++) {
                    int nz = p[0] + dz[j];
                    int nx = p[1] + dx[j];
                    int ny = p[2] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && nz >= 0 && nz < H && arr[nz][nx][ny] == 0 && ch[nz][nx][ny] == 0) {
                        ch[nz][nx][ny] = 1;
                        arr[nz][nx][ny] = 1;
                        q.offer(new int[]{nz, nx, ny});
                    }
                }
            }
            L++;
        }

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(L - 1);

    }
}
