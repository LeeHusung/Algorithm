import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long n, min;
    static Long[] arr, cur;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Long[(int)n];
        cur = new Long[4];
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i <= n - 4; i++) {
            for (int j = i + 3; j < n; j++) {
                long elsa = arr[i] + arr[j];
                int x = i + 1;
                int y = j - 1;
                while (x <= y) {
                    long anna = arr[x] + arr[y];
                    if (anna > elsa) y--;
                    else if (anna < elsa) x++;
                    else {
                        System.out.println(0);
                        System.exit(0);
                    }
                    min = Math.min(min, Math.abs(elsa - anna));
                }
            }
        }


        System.out.println(min);
    }


}
