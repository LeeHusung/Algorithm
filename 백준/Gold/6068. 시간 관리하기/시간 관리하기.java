import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            if (arr[i][0] > arr[i][1]) {
                System.out.println(-1);
                return;
            }
            end = Math.max(end, arr[i][1]);
        }
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int res = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
//            System.out.println(start + " " + end + " " + middle);
            boolean flag = false;
            int t = middle + arr[0][0];
            if (t > arr[0][1]) {
                flag = true;
            }
            for (int i = 1; i < n; i++) {
                t += arr[i][0];
                if (t > arr[i][1]) {
                    flag = true;
                    break;
                }
            }
            if (flag) end = middle - 1;
            else {
                start = middle + 1;
                res = middle;
            }
        }
        if (res == 0) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }

    }
}
