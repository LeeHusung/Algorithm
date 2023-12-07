import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[n];
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
            int[] answer = new int[n];
            Arrays.sort(arr, (a, b) -> b - a);
            int idx = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j % 2 == 0) answer[idx++] = arr[j];
                else answer[n - idx] = arr[j];
            }
            int min = 0;
            for (int j = 0; j < answer.length - 1; j++) {
                min = Math.max(min, Math.abs(answer[j + 1] - answer[j]));
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);

    }
}
