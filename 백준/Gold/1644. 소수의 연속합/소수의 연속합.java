import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                list.add(i);
            }
        }

        long answer = 0;
        for (int i = 0; i < list.size(); i++) {
            long sum = 0;
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);
                if (sum > n) break;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
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
