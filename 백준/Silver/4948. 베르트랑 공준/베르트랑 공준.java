import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[246913];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i < 246913; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    arr[i] = 0;
                    break;
                }
                arr[i] = 1;
            }
        }
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int cnt = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if (arr[i] == 1) cnt++;
            }
            System.out.println(cnt);

//            System.out.println(cal(n + 1, 2 * n));
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