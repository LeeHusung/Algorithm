import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static char[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[12][6];
        for (int i = 0; i < 12; i++) {
            char[] carr = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = carr[j];
            }
        }

        int cnt = 0;
        while (bomb()) {
            cnt++;

            goDown();
        }
        System.out.println(cnt);



    }

    private static void goDown() {
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] == '.') {
                    for (int k = i; k >= 0; k--) {
                        if (arr[k][j] != '.') {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }

    }

    private static boolean bomb() {
        boolean flag = false;
        LinkedList<int[]> bombList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != '.') {
                    Queue<int[]> q = new LinkedList<>();
                    int[][] ch = new int[12][6];
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        bombList.add(new int[]{p[0], p[1]});
                        for (int k = 0; k < 4; k++) {
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && ch[nx][ny] == 0 && arr[nx][ny] == arr[i][j]) {
                                ch[nx][ny] = 1;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
//                System.out.println(bombList.size());
                if (bombList.size() >= 4) {
                    for (int[] x : bombList) {
                        arr[x[0]][x[1]] = '.';
                    }
                    bombList.clear();
                    flag = true;
                } else bombList.clear();
            }
        }

        return flag;
    }
}