import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        int[] brr = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(arr);
        Arrays.sort(brr);
        int x = 0;
        int y = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (x >= n && y >= m) break;
            if (arr[x] > brr[y]) {
                sb.append(brr[y]).append(" ");
                y++;
            } else {
                sb.append(arr[x]).append(" ");
                x++;
            }
            if (x >= n) {
                while (y < m) {
                    sb.append(brr[y++]).append(" ");
                }
            } else if (y >= m) {
                while (x < n) {
                    sb.append(arr[x++]).append(" ");
                }
            }
        }
        System.out.println(sb);


    }
}
