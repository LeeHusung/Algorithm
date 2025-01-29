import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int r, c;
    static char[][] arr;
    static int[][] waterArr, ch, ch2;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> gosm = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        arr = new char[r][c];
        waterArr = new int[r][c];
        ch = new int[r][c];
        ch2 = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                waterArr[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> water = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '*') {
                    water.add(new int[]{i, j});
                     ch[i][j] = 1;
                     waterArr[i][j] = 0;
                }
                if (arr[i][j] == 'S') {
                    gosm.offer(new int[]{i, j});
                    ch2[i][j] = 1;
                }
                if (arr[i][j] == 'X') {
                    waterArr[i][j] = -1;
                }
//                if (arr[i][j] == 'D') {
//                    waterArr[i][j] = -5;
//                }
            }
        }

        int L = 0;
        while (!water.isEmpty()) {
            L++;
            int len = water.size();
            for (int i = 0; i < len; i++) {
                int[] p = water.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || arr[nx][ny] == 'X' || ch[nx][ny] == 1 || arr[nx][ny] == 'D') {
                        continue;
                    }
                    waterArr[nx][ny] = Math.min(waterArr[nx][ny], L);
                    ch[nx][ny] = 1;
                    water.add(new int[]{nx, ny});
                }

            }
        }

//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                System.out.print(waterArr[i][j] + " ");
//            }
//            System.out.println();
//        }


        int L2 = 0;
        while (!gosm.isEmpty()) {
            L2++;
            int len = gosm.size();
            for (int i = 0; i < len; i++) {
                int[] p = gosm.poll();
//                System.out.println(p[0] + " " + p[1]);
                if (arr[p[0]][p[1]] == 'D') {
                    System.out.println(L2 - 1);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || waterArr[nx][ny] == -1 || ch2[nx][ny] == 1 || waterArr[nx][ny] <= L2) continue;

                    gosm.add(new int[]{nx, ny});
                    ch2[nx][ny] = 1;
                }
            }
        }

        System.out.println("KAKTUS");
    }
}
