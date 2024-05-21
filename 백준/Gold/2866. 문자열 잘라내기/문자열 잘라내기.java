import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            arr[i] = input.toCharArray();
        }
        Set<String> set = new HashSet<>();
        int answer = 0;
        boolean flag = false;
        String[] after = new String[c];

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < r; j++) {
                sb.append(arr[j][i]);
            }
            after[i] = sb.toString();
        }

        for (int i = 0; i < r; i++) {
            set = new HashSet<>();
            for (int j = 0; j < c; j++) {
                if (set.contains(after[j].substring(i))) {
                    flag = true;
                    break;
                }
                set.add(after[j].substring(i));
            }
            if (flag) break;
            answer++;
        }

        System.out.println(answer);

    }
}
