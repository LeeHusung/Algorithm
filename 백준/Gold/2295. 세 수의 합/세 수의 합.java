import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            set.add(arr[i]);
        }
        Arrays.sort(arr);

        long answer = Long.MIN_VALUE;

//        while (true) {
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            long tmp = arr[i];
            int left = 0;
            int right = i;
            for (int j = 0; j <= right; j++) {
                left = 0;
                right = i;
                while (left <= right) {
                    long sum = arr[j] + arr[left] + arr[right];
                    if (sum < tmp) {
                        left++;
                    } else if (sum > tmp) right--;
                    else {
                        answer = sum;
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (flag) break;
        }

//        }


        System.out.println(answer);
    }
}
