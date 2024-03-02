import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr, ch, cnt;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();

    private static void D(int idx, int goal) {
        if (ch[arr[idx]] == 0) {
            ch[arr[idx]] = 1;
            D(arr[idx], goal);
            ch[arr[idx]] = 0;
        }
        if (arr[idx] == goal) {
            list.add(idx);
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        ch = new int[n + 1];
        cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                D(i, i);
                ch[i] = 0;
            }
        }
        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for (int x : list) {
            sb.append(x).append("\n");
        }
        System.out.println(sb);


    }

}