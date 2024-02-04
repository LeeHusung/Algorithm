import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[arr.length - 1] - arr[0];
        int answer = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            int cnt = 1;
            int s = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - s >= middle) {
                    s = arr[i];
                    cnt++;
                }
            }
            if (cnt >= c) {
                answer = middle;
                start = middle + 1;
            } else end = middle - 1;
        }

        System.out.println(answer);


    }
}
