import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int n, m, k, min, answer;
    static int[][] arr, copy;
    static int[] ch;
    static LinkedList<int[]> list = new LinkedList<>();
    static LinkedList<int[]> res = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        min = Integer.MAX_VALUE;
        answer = Integer.MAX_VALUE;
        arr = new int[n][m];
        copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        for (int i = 0; i < k; i++) {
            String[] s1 = br.readLine().split(" ");
            int r = Integer.parseInt(s1[0]) - 1;
            int c = Integer.parseInt(s1[1]) - 1;
            int s = Integer.parseInt(s1[2]);
            list.add(new int[]{r, c, s});
        }

        ch = new int[list.size()];
        D(0);
        System.out.println(answer);
    }

    private static void D(int L) {
        if (L == k) {
            cal(res);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                res.add(list.get(i));
                D(L + 1);
                ch[i] = 0;
                res.pollLast();
            }
        }
    }

    private static void cal(LinkedList<int[]> res) {
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i].clone();
        }
        for (int[] x : res) {
            int startX = x[0] - x[2];
            int startY = x[1] - x[2];
            int endX = x[0] + x[2];
            int endY = x[1] + x[2];
            int z = (endX - startX + 1) / 2;
            int cnt = 0;
            while (cnt != z) {
                cnt++;
                rotate(startX, startY, endX, endY);
                startX++;
                startY++;
                endX--;
                endY--;
            }
        }
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                c += copy[i][j];
            }
            min = Math.min(min, c);
        }
        answer = Math.min(answer, min);

    }

    private static void rotate(int startX, int startY, int endX, int endY) {
        int x = copy[startX][endY];
        for (int i = endY; i > startY; i--) {
            copy[startX][i] = copy[startX][i - 1];
        }
        int y = copy[endX][endY];
        for (int i = endX; i > startX; i--) {
            copy[i][endY] = copy[i - 1][endY];
        }
        copy[startX + 1][endY] = x;
        x = copy[endX][startY];
        for (int i = startY; i < endY - 1; i++) {
            copy[endX][i] = copy[endX][i + 1];
        }
        copy[endX][endY - 1] = y;
        for (int i = startX; i < endX - 1; i++) {
            copy[i][startY] = copy[i + 1][startY];
        }
        copy[endX - 1][startY] = x;
    }
}