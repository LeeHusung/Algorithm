import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] score = new boolean[1000001];
        int[] arr = new int[n];
        int[] res = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            score[arr[i]] = true;
        }

        for (int x : arr) {
            for (int i = x; i < 1000001; i+=x) {
                if (score[i]) {
                    res[x]++;
                    res[i]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            sb.append(res[x]).append(" ");
        }
        System.out.println(sb);
    }
}
