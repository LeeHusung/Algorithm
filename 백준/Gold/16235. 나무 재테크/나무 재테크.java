import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static PriorityQueue<int[]> trees = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    static List<int[]> dies = new ArrayList<>();
    static List<int[]> newTrees = new ArrayList<>();
    static int[][] arr, feed;
    static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    static int[] dy = {0, -1, 0, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        feed = new int[n][n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            Arrays.fill(arr[i], 5);
            for (int j = 0; j < n; j++) {
                feed[i][j] = Integer.parseInt(s1[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]) - 1;
            int y = Integer.parseInt(s1[1]) - 1;
            int age = Integer.parseInt(s1[2]);
            trees.add(new int[]{x, y, age});
        }

        for (int i = 0; i < k; i++) {
            spring();
            summer();
            autumn();
            winter();
            for (int[] p : newTrees) {
                trees.add(p);
            }
            newTrees.clear();
        }
        System.out.println(trees.size());

    }

    private static void spring() {
        int len = trees.size();
        for (int i = 0; i < len; i++) {
            int[] p = trees.poll();
            if (p[2] > arr[p[0]][p[1]]) {
                dies.add(p);
                continue;
            }
            arr[p[0]][p[1]] -= p[2];
            newTrees.add(new int[]{p[0], p[1], p[2] + 1});
        }
    }

    private static void summer() {
        for (int[] die : dies) {
            arr[die[0]][die[1]] += die[2] / 2;
        }
        dies.clear();
    }

    private static void autumn() {
        for (int[] tree : newTrees) {
            if (tree[2] % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = tree[0] + dx[i];
                    int ny = tree[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    trees.add(new int[]{nx, ny, 1});
                }
            }
        }
    }

    private static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] += feed[i][j];
            }
        }
    }

}
