import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            System.out.println(cal(n + 1, 2 * n));
        }

    }

    private static int cal(int start, int end) {
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            boolean flag = true;
            if (i == 2 || i == 3) {
                flag = true;
                cnt++;
                continue;
            }
            if (i == 1) {
                flag = false;
                continue;
            }
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}