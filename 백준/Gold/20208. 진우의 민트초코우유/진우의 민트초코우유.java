import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h;
    static int[] start, res, ch;
    static int[][] arr;
    static List<int[]> mints = new ArrayList<>();
    static int max = 0;
    private static void dfs(int L) {
        if (L == mints.size()) {

            cal(res);
            return;
        }
        for (int i = 0; i < mints.size(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                res[L] = i;
                dfs(L + 1);
                res[L] = 0;
                ch[i] = 0;
            }
        }
    }

    private static void cal(int[] res) {
        int[] arr = start.clone();
        int cnt = 0;
        int curH = m;
        for (int i = 0; i < res.length; i++) {
            int idx = res[i];
            int[] mint = mints.get(idx);
            int x = Math.abs(mint[0] - arr[0]) + Math.abs(mint[1] - arr[1]);
            if (curH < x) break;
            curH += h;
            curH -= x;
            cnt++;
            arr = new int[2];
            arr[0] = mint[0];
            arr[1] = mint[1];
            int xx = Math.abs(arr[0] - start[0]) + Math.abs(arr[1] - start[1]);
            if (curH >= xx) max = Math.max(max, cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        h = Integer.parseInt(s[2]);
        arr = new int[n][n];
        start = new int[2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                }
                if (arr[i][j] == 2) {
                    mints.add(new int[]{i, j});
                }
            }
        }
        res = new int[mints.size()];
        ch = new int[mints.size()];
        dfs(0);

        System.out.println(max);


    }

}
