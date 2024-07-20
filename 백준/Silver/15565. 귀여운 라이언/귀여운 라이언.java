import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) {
                list.add(i);
            }
        }

        if (list.size() < k) {
            System.out.println(-1);
            return;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= list.size() - k; i++) {
            int x = list.get(i + k - 1) - list.get(i) + 1;
            min = Math.min(min, x);
        }
        System.out.println(min);

    }
}
