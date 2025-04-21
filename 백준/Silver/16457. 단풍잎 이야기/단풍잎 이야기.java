import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static LinkedList<Integer> list = new LinkedList<>();
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        arr = new int[m][k];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < k; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D(0, 1);
        System.out.println(answer);
    }

    private static void D(int L, int start) {
        if (L == n) {
            int max = check();
            answer = Math.max(answer, max);
      
            return;
        }
        for (int i = start; i <= n * 2; i++) {
            list.add(i);
            D(L + 1, i + 1);
            list.removeLast();
        }

    }

    private static int check() {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < k; j++) {
                int x = arr[i][j];
                if (!list.contains(x)) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}
