import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start <= end) {
                int left = arr[start];
                int right = arr[end];
                if (arr[i] + left + right == 0) {
                    if (left == right) {
                        cnt += end - start;
                        start++;
                    } else {
                        long lCnt = 0;
                        long rCnt = 0;
                        while (right == arr[end--]) {
                            rCnt++;
                            if (right != arr[end]) {
                                break;
                            }
                        }
                        while (left == arr[start++]) {
                            lCnt++;
                            if (left != arr[start]) {
                                break;
                            }
                        }
                        cnt +=  lCnt * rCnt;
                    }
                } else if (arr[i] + arr[start] + arr[end] < 0) {
                    start++;
                } else end--;
            }
        }
        System.out.println(cnt);
    }
}
