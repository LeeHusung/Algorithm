import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] twoArr = new int[n + 1];
        int[] sum = new int[n + 1];
        int[] twoSum = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = n;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            twoArr[k--] = arr[i];
            sum[i] = sum[i - 1] + arr[i];
        }

        int idx = 1;
        for (int i = n; i > 0; i--) {
            twoSum[idx] = twoSum[idx - 1] + arr[i];
            idx++;
        }

        //꿀통 맨 마지막
        int one = sum[n] - sum[1];
        int max = 0;
        for (int i = 2; i <= n; i++) {
            int tmp = one;
            tmp -= arr[i];
            int twoTmp = sum[n] - sum[i];
            max = Math.max(max, tmp + twoTmp);
        }

        //꿀통 맨 처음
        one = twoSum[n] - twoSum[1];
        for (int i = 2; i <= n; i++) {
            int tmp = one;
            tmp -= twoArr[i];
            int twoTmp = twoSum[n] - twoSum[i];
            max = Math.max(max, tmp + twoTmp);
        }

        //꿀통 가운데
        one = 1;
        int two = n;
        for (int i = 2; i < n; i++) {
            int z = sum[i] - sum[one];
            int z2 = sum[two-1] - sum[i-1];
            max = Math.max(max, z + z2);
        }

        System.out.println(max);
    }
}
