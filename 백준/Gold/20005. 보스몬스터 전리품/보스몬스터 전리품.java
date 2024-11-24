import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int p = Integer.parseInt(s[2]);
        int[][] arr = new int[m][n];
        int[][] ch = new int[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) == 'X') {
                    arr[i][j] = -1;
                } else if (s1.charAt(j) == 'B') {
                    arr[i][j] = -5;
                    q.offer(new int[]{i, j});
                    ch[i][j] = 1;
                } else if (s1.charAt(j) >= 'a' && s1.charAt(j) <= 'z') {
                    arr[i][j] = s1.charAt(j) - 48;
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = s1[0].charAt(0) - 48;
            map.put(x, Integer.parseInt(s1[1]));
        }
        long bossBlood = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] poll = q.poll();
                if (arr[poll[0]][poll[1]] > 0) {
                    set.add(arr[poll[0]][poll[1]]);
                }
                for (int j = 0; j < 4; j++) {
                    int nx = poll[0] + dx[j];
                    int ny = poll[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && ch[nx][ny] == 0 && arr[nx][ny] != -1) {
                        q.offer(new int[]{nx, ny});
                        ch[nx][ny] = 1;
                    }
                }

            }
            for (Integer x : set) {
                Integer attack = map.get(x);
                bossBlood -= attack;
            }
            if (bossBlood <= 0) {
                break;
            }
        }
        System.out.println(set.size());
    }
}
