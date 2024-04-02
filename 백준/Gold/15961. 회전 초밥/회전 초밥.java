import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + k-1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < n + k-1; i++) {
            arr[i] = arr[i-n];
        }

        int[] check = new int[3001];
        int res = 1;
        check[c]++;

        for (int i = 0; i < k; i++) {
            if (check[arr[i]] == 0) res++;
            check[arr[i]]++;
        }

        int cnt = res;
        for (int i = 1; i < n; i++) {
            int p = arr[i - 1];
            check[p]--;
            if (check[p] == 0) cnt--;
            int add = arr[i + k-1];
            if (check[add] == 0) cnt++;
            check[add]++;

            res = Math.max(res, cnt);
        }

        System.out.println(res);

    }
}
