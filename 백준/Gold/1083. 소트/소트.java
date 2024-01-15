import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int s = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int max_idx = -1;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) > list.get(i) && s >= j - i) {
                    if (list.get(j) > max) {
                        max = list.get(j);
                        max_idx = j;
                    }
                }
            }
            if (max_idx != -1) {
                list.remove(max_idx);
                list.add(i, max);
                s -= max_idx - i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : list) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}
