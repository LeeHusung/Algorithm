import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = s.charAt(j) - '0';
            }
        }

        boolean flag = true;
        if (n < 3 || m < 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != b[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) {
                System.out.println(0);
                return;
            }
            else {
                System.out.println(-1);
                return;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    cnt++;
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if (a[k][l] == 0) a[k][l] = 1;
                            else a[k][l] = 0;
                        }
                    }
                } else continue;
            }
        }

        boolean answerFlag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    answerFlag = false;
                    break;
                }
            }
            if (!answerFlag) break;
        }
        if (answerFlag) {
            System.out.println(cnt);
        }
        else {
            System.out.println(-1);
        }

    }
}
