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
        int[] arr = new int[n + m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        for (int i = n; i < n + m; i++) {
            arr[i] = Integer.parseInt(s2[i - n]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);


    }
}
