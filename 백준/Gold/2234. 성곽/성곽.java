import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m, max;
    static String[][] arr;
    static int[][][] ch;
    static Queue<int[]> q = new LinkedList<>();
    static LinkedList<int[]> list = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0}; //남동북서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        max = Integer.MIN_VALUE;
        arr = new String[m][n];
        ch = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.toBinaryString(Integer.parseInt(s1[j]));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (arr[i][j].length() != 4) {
                    arr[i][j] = "0" + arr[i][j];
                }
            }
        }

        int sumRoom = 0;
        int maxRoom = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j][0] == 0) {
                    sumRoom++;
                    q.offer(new int[]{i, j});
                    ch[i][j][0] = sumRoom;
                    int cnt = 0;
                    while (!q.isEmpty()) {
                        cnt++;
                        int[] p = q.poll();
                        list.add(new int[]{p[0], p[1]});
                        String str = arr[p[0]][p[1]];
                        for (int k = 0; k < str.length(); k++) {
                            if (str.charAt(k) == '0') {
                                int nx = p[0] + dx[k];
                                int ny = p[1] + dy[k];
                                if (nx >= 0 && ny >= 0 && nx < m && ny < n && ch[nx][ny][0] == 0) {
                                    ch[nx][ny][0] = sumRoom;
                                    q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    for (int[] x : list) {
                        ch[x[0]][x[1]][1] = cnt;
                    }
                    list.clear();
                    maxRoom = Math.max(maxRoom, cnt);
                }
            }
        }
        System.out.println(sumRoom);
        System.out.println(maxRoom);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                    if (ch[i][j][0] != ch[nx][ny][0]) {
                        max = Math.max(max, ch[i][j][1] + ch[nx][ny][1]);
                    }
                }
            }
        }
        System.out.println(max);



    }
}