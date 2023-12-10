import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static int[][] arr, likes;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int answer = 0;
        arr = new int[n][n];
        likes = new int[n * n][5];
        for (int i = 0; i < n * n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                likes[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < likes.length; i++) {
            int[] like = likes[i];
            setSeat(like);
        }

        for (int i = 0; i < likes.length; i++) {
            int[] like = likes[i];
            int student = like[0];
            ArrayList<Integer> list = new ArrayList<>();
            for (int l = 1; l < like.length; l++) {
                list.add(like[l]);
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int cnt = 0;
                    if (arr[j][k] == student) {
                        for (int l = 0; l < 4; l++) {
                            int nx = j + dx[l];
                            int ny = k + dy[l];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && list.contains(arr[nx][ny])) {
                                cnt++;
                            }
                        }
                    }
                    if (cnt == 0) answer += 0;
                    if (cnt == 1) answer += 1;
                    if (cnt == 2) answer += 10;
                    if (cnt == 3) answer += 100;
                    if (cnt == 4) answer += 1000;
                }
            }

        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }

    private static void setSeat(int[] like) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] == a[2] ? (b[3] == a[3] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : b[3] - a[3]) : b[2] - a[2]);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < like.length; i++) {
            list.add(like[i]);
        }
        int student = like[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    int cnt = 0;
                    int empty = findEmpty(i, j);
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n && list.contains(arr[nx][ny])) {
                            cnt++;
                        }
                    }
                    pq.offer(new int[]{i, j, cnt, empty});
                }
            }
        }
//        System.out.println(pq.size());
        if (!pq.isEmpty()) {
            int[] p = pq.poll();
//            for (int i = 0; i < p.length; i++) {
//                System.out.print(p[i]);
//            }
//            System.out.println();
            arr[p[0]][p[1]] = student;
        }
    }

    private static int findEmpty(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
