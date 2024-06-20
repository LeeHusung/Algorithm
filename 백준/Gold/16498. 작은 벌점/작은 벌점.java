import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int[] aa = new int[a];
        int[] bb = new int[b];
        int[] cc = new int[c];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < a; i++) {
            aa[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < b; i++) {
            bb[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < c; i++) {
            cc[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aa);
        Arrays.sort(bb);
        Arrays.sort(cc);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < bb.length; j++) {
                for (int k = 0; k < cc.length; k++) {
                    int x = Math.abs(Math.max(aa[i], Math.max(bb[j], cc[k])) - Math.min(aa[i], Math.min(bb[j], cc[k])));
                    min = Math.min(min, x);
                }
            }
        }
        System.out.println(min);
    }
}
