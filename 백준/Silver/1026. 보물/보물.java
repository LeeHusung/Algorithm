import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Integer[] arr = new Integer[n];
        Integer[] arr2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(arr, (a, b) -> b - a);
        Arrays.sort(arr2, (a, b) -> a - b);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * arr2[i];
        }
        System.out.println(sum);
    }
}
