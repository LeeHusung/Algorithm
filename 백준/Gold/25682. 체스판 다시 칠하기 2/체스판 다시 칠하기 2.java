import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int n, m, k;
    static int[][] arr;
    static int[][] sum, sum2;
    static int[][] tmp, tmp2;
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        arr = new int[n + 1][m + 1];
        sum = new int[n + 1][m + 1];
        sum2 = new int[n + 1][m + 1];
        tmp = new int[n + 1][m + 1];
        tmp2 = new int[n + 1][m + 1];
        boolean color = false;
        //첫 칸이 검은색일 때 칠하는 경우 저장
        for(int i=1;i<=n;i++){
            String str = br.readLine();
            for(int j=1;j<=m;j++){
                char c = str.charAt(j-1);
                if(!color && c == 'W')	//검은색으로 색 변경
                    tmp[i][j] = 1;
                else if(color && c == 'B')	//흰색으로 색 변경
                    tmp[i][j] = 1;
                color = !color;
            }
            if(m % 2 == 0)
                color = !color;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (tmp[i][j] == 0) {
                    tmp2[i][j] = 1;
                } else {
                    tmp2[i][j] = 0;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (arr[i][j] == tmp[i][j]) {
                    tmp[i][j] = 0;
                }
                if (arr[i][j] == tmp2[i][j]) {
                    tmp2[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + tmp[i][j];
                sum2[i][j] = sum2[i - 1][j] + sum2[i][j - 1] - sum2[i - 1][j - 1] + tmp2[i][j];
            }
        }

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int cnt = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                int cnt2 = sum2[i][j] - sum2[i - k][j] - sum2[i][j - k] + sum2[i - k][j - k];
                min = Math.min(min, cnt);
                min = Math.min(min, cnt2);
            }
        }
        System.out.println(min);
    }
}
