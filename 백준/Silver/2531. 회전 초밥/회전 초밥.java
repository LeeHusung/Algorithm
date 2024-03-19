import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < k; i++) {
            list.add(list.get(i));
        }

        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size() - k; i++) {
            for (int j = i; j < i + k; j++) {
                set.add(list.get(j));
            }
            set.remove(c);
            max = Math.max(max, set.size());
            set.clear();
        }
        System.out.println(max + 1);
    }
}
