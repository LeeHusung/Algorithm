import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            set.add(Integer.parseInt(s[i]));
        }

        StringBuilder sb = new StringBuilder();


        int m = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < s2.length; i++) {
            int x = Integer.parseInt(s2[i]);
            if (set.contains(x)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);

    }
}
