import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, I, M;
    static int[][] fishes;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        I = Integer.parseInt(s[1]);
        M = Integer.parseInt(s[2]);
        max = 0;

        fishes = new int[M][2];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            fishes[i][0] = Integer.parseInt(st.nextToken());
            fishes[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
               search(fishes[i], fishes[j]);
            }
        }

        System.out.println(max);
    }

    private static void search(int[] fish1, int[] fish2) {
        int y = fish1[0];
        int x = fish2[1];

        int v = 1;
        int h = (I - 2 * v) / 2;

        while (h > 0) {
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (x <= fishes[i][1] && fishes[i][1] <= x + h &&
                        y <= fishes[i][0] && fishes[i][0] <= y + v) {
                    cnt++;
                }
            }

            max = Math.max(max, cnt);

            v++;
            h = (I - 2 * v) / 2;
        }
    }
}
