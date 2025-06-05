import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> result = new ArrayList<>();

        result.add(list.get(0));
        for (int i = 1; i < n; i++) {
            Integer cur = list.get(i);
            if (result.get(result.size() - 1) < cur) {
                result.add(cur);
            } else {
                int x = -Collections.binarySearch(result, cur) - 1;
                result.set(x, cur);
            }
        }

        System.out.println(n - result.size());
    }
}
