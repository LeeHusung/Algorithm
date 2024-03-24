import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i]) continue;
            list.add(i);
            for (int j = i * 2; j <= n; j+= i) {
                arr[j] = true;
            }
        }

        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        long answer = 0;
        int x = 0;
        long sum = 0;
        for (int y = 0; y < result.length; y++) {
            sum += result[y];
            if (sum > n) {
                while (true) {
                    sum -= result[x++];
                    if (sum <= n) break;
                }
            }
            if (sum == n) answer++;
        }

        System.out.println(answer);
        
    }

    

    public static boolean check(int k) {
        if (k == 1) return false;
        if (k == 2 || k == 3) return true;
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) return false;
        }
        return true;
    }
}
