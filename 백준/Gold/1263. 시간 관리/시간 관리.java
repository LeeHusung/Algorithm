import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        if (arr[0][0] > arr[0][1]) {
            System.out.println(-1);
            return;
        }
        int answer = -1;
        int latestTime = arr[0][1] - arr[0][0];
        for (int i = 0; i <= latestTime; i++) {
            int start = i;
            for (int j = 0; j < arr.length; j++) {
                start += arr[j][0];
                if (start > arr[j][1]) {
                    System.out.println(answer);
                    return;
                }
            }
            answer = i;
        }
        System.out.println(answer);
    }
}
