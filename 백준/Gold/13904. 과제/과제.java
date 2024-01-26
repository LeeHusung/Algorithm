import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        }
        Collections.sort(list, (a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);

        int sum = 0;
        for (int i = n; i > 0; i--) {
            int max = 0;
            int idx = -1;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j)[0] >= i && list.get(j)[1] > max) {
                    max = list.get(j)[1];
                    idx = j;
                }
            }

            if (idx == -1) continue;
            sum += max;
            list.remove(idx);

        }
        System.out.println(sum);

    }
}
