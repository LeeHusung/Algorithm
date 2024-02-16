import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, l, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        answer = 0;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s1[0]);
            arr[i][1] = Integer.parseInt(s1[1]);
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int x = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            if (x < arr[i][0]) {
                x = arr[i][0];
            }
            while (x < arr[i][1]) {
                x += l;
                answer++;
            }
        }
        System.out.println(answer);

    }
}
