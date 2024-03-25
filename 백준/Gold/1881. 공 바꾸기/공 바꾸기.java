import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] box = new int[4];
        Arrays.fill(box, -1);
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int one = arr[i];
            boolean flag = false;
            for (int b : box) {
                if (b == one) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            for (int j = 0; j < box.length; j++) {
                if (box[j] == -1) {
                    box[j] = one;
                    answer++;
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            int[] rest = new int[10];
            Arrays.fill(rest, 100000);
            int p = 1;
            for (int j = n-1; j >= i; j--) {
                int k = arr[j];
                for (int l = 0; l < box.length; l++) {
                    if (k == box[l]) {
                        rest[k] = j;
                        break;
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            int idx = -1;
            for (int j = 0; j < box.length; j++) {
                if (rest[box[j]] > max) {
                    max = rest[box[j]];
                    idx = box[j];
                }
            }
            for (int j = 0; j < box.length; j++) {
                if (box[j] == idx) {
                    box[j] = one;
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
