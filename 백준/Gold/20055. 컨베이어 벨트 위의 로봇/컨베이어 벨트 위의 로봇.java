import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr, robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        arr = new int[n * 2];
        robot = new int[n * 2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        while (true) {
            int tmp = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
                if (robot[i - 1] == 1) {
                    robot[i] = robot[i - 1];
                    robot[i - 1] = 0;
                }
                if (robot[n - 1] == 1) {
                    robot[n - 1] = 0;
                }
            }
            arr[0] = tmp;

            for (int i = n * 2 - 1; i >= 0; i--) {
                if (robot[i] == 1) {
                    if (arr[i + 1] >= 1 && robot[i + 1] == 0) {
                        arr[i + 1]--;
                        robot[i] = 0;
                        robot[i + 1] = 1;
                        if (robot[n - 1] == 1) {
                            robot[n - 1] = 0;
                        }
                    }
                }
            }
            if (arr[0] != 0) {
                robot[0] = 1;
                arr[0]--;
            }
            if (!check()) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean check() {
        int empty = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) empty++;
        }
        if (empty >= k) {
            return false;
        }
        return true;
    }
}
