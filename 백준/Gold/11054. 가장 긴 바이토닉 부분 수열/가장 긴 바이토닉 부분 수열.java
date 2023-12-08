import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] increaseDP = new int[n + 1];
        int[] decreaseDP = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }

        increaseDP[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            increaseDP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) increaseDP[i] = Math.max(increaseDP[i], increaseDP[j] + 1);
            }
        }
        decreaseDP[n] = 1;
        for (int i = n - 1; i > 0; i--) {
            decreaseDP[i] = 1;
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) decreaseDP[i] = Math.max(decreaseDP[i], decreaseDP[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < increaseDP.length; i++) {
            max = Math.max(increaseDP[i] + decreaseDP[i], max);
        }
        System.out.println(max - 1);



    }
}
