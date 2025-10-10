import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] arr;
    static int[][] dice;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int res = 0;
    private static void change(int x1, int y1, int x2, int y2) {
        int tmp = dice[x1][y1];
        dice[x1][y1] = dice[x2][y2];
        dice[x2][y2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        arr = new int[n][m];
        dice = new int[][]
                {
                {0, 2, 0},
                {4, 1, 3},
                {0, 5, 0},
                {0, 6, 0}
                };
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1=동 2=서 3=남 4=북
        int dir = 1;
        int diceX = 0;
        int diceY = 0;

        for (int i = 0; i < k; i++) {
            if (dir == 1) {
                if (diceY + 1 >= m) {
                    change(1, 1, 1, 2);
                    change(1, 0, 1, 2);
                    change(1, 2, 3, 1);
                    dir = 2;
                    diceY--;

                    int arrivalScore = arr[diceX][diceY];
                    int cnt = bfs(arrivalScore, diceX, diceY);
                    if (dice[3][1] > arrivalScore) {
                        dir = 4;
                    } else if (dice[3][1] < arrivalScore) {
                        dir = 3;
                    }
                    res += arrivalScore * cnt;
                } else {
                    change(1, 1, 1, 2);
                    change(1, 1, 3, 1);
                    change(1, 0, 1, 1);
                    diceY++;

                    int arrivalScore = arr[diceX][diceY];
                    int cnt = bfs(arrivalScore, diceX, diceY);
                    if (dice[3][1] > arrivalScore) {
                        dir = 3;
                    } else if (dice[3][1] < arrivalScore) {
                        dir = 4;
                    }
                    res += arrivalScore * cnt;
                }

//                System.out.println("diceX : " + diceX + " " + "diceY: " + diceY);
//                System.out.println("arrivalScore : " + arrivalScore + " " + "cnt: " + cnt);
            } else if (dir == 2) {
                if (diceY - 1 < 0) {
                    change(1, 1, 1, 2);
                    change(1, 1, 3, 1);
                    change(1, 0, 1, 1);
                    dir = 1;
                    diceY++;
                    int arrivalScore = arr[diceX][diceY];
                    int cnt = bfs(arrivalScore, diceX, diceY);
                    if (dice[3][1] > arrivalScore) {
                        dir = 3;
                    } else if (dice[3][1] < arrivalScore) {
                        dir = 4;
                    }
                    res += arrivalScore * cnt;
                } else {
                    change(1, 1, 1, 2);
                    change(1, 0, 1, 2);
                    change(1, 2, 3, 1);
                    diceY--;
                    int arrivalScore = arr[diceX][diceY];
                    int cnt = bfs(arrivalScore, diceX, diceY);
                    if (dice[3][1] > arrivalScore) {
                        dir = 4;
                    } else if (dice[3][1] < arrivalScore) {
                        dir = 3;
                    }
                    res += arrivalScore * cnt;
                }

            } else if (dir == 3) {
                if (diceX + 1 >= n) {
                    change(0, 1, 1, 1);
                    change(1, 1, 2, 1);
                    change(2, 1, 3, 1);
                    dir = 4;
                    diceX--;
                    int arrivalScore = arr[diceX][diceY];
                    int cnt = bfs(arrivalScore, diceX, diceY);
                    if (dice[3][1] > arrivalScore) {
                        dir = 1;
                    } else if (dice[3][1] < arrivalScore) {
                        dir = 2;
                    }
                    res += arrivalScore * cnt;
                } else {
                    change(0, 1, 3, 1);
                    change(1, 1, 3, 1);
                    change(2, 1, 3, 1);
                    diceX++;
                    int arrivalScore = arr[diceX][diceY];
                    int cnt = bfs(arrivalScore, diceX, diceY);
                    if (dice[3][1] > arrivalScore) {
                        dir = 2;
                    } else if (dice[3][1] < arrivalScore) {
                        dir = 1;
                    }
                    res += arrivalScore * cnt;
                }

            } else if (dir == 4) {
                if (diceX - 1 < 0) {
                    change(0, 1, 3, 1);
                    change(1, 1, 3, 1);
                    change(2, 1, 3, 1);
                    dir = 3;
                    diceX++;
                    int arrivalScore = arr[diceX][diceY];
                    int cnt = bfs(arrivalScore, diceX, diceY);
                    if (dice[3][1] > arrivalScore) {
                        dir = 2;
                    } else if (dice[3][1] < arrivalScore) {
                        dir = 1;
                    }
                    res += arrivalScore * cnt;

                } else {
                    diceX--;
                    change(0, 1, 1, 1);
                    change(1, 1, 2, 1);
                    change(2, 1, 3, 1);
                    int arrivalScore = arr[diceX][diceY];
                    int cnt = bfs(arrivalScore, diceX, diceY);
                    if (dice[3][1] > arrivalScore) {
                        dir = 1;
                    } else if (dice[3][1] < arrivalScore) {
                        dir = 2;
                    }
                    res += arrivalScore * cnt;
                }

            }
        }

        System.out.println(res);

    }

    private static int bfs(int arrivalScore, int diceX, int diceY) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] ch = new int[n][m];
        q.offer(new int[]{diceX, diceY});
        ch[diceX][diceY] = 1;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
//            System.out.println("p[0]: " + p[0] + " " + "p[1]: " + p[1]);
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                        && arr[nx][ny] == arrivalScore && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
