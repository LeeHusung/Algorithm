import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        int answer = arr[arr.length - 1] - arr[0];
        Integer[] list = new Integer[n - 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(list, (a, b) -> b - a);

        int sum = 0;
        for (int i = 0; i < m - 1; i++) {
            sum += list[i];
        }
        System.out.println(answer - sum);
    }
}
