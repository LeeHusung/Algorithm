import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Cubic {
        int m, v;

        public Cubic(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        Cubic[] cubics = new Cubic[n];
        int[] bags = new int[k];

        PriorityQueue<Cubic> res = new PriorityQueue<>((a, b) -> b.v - a.v);

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            int m = Integer.parseInt(s1[0]);
            int v = Integer.parseInt(s1[1]);
            cubics[i] = new Cubic(m, v);
        }

        Arrays.sort(cubics, (a, b) -> a.m - b.m);
        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(br.readLine());
            bags[i] = x;
        }
        Arrays.sort(bags);

        long answer = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && cubics[idx].m <= bags[i]) {
                res.offer(cubics[idx++]);
            }
            if (!res.isEmpty()) {
                answer += res.poll().v;
            }
        }
        System.out.println(answer);


    }
}
