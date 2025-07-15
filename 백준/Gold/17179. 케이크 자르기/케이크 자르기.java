import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int l = Integer.parseInt(input[2]);
        int[] arr = new int[m + 2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int s = Integer.parseInt(br.readLine());
            arr[i + 1] = s;
        }
        arr[arr.length - 1] = l;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                set.add(Math.abs(arr[i] - arr[j]));
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
//        System.out.println(list);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(br.readLine());
            int s = 0;
            int e = list.size() - 1;
            int answer = 0;
            while (s <= e) {
                int middle = (s + e) / 2;
                int k = 0;
                int cnt = 0;
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j] - k >= list.get(middle)) {
                        cnt++;
                        k = arr[j];
                    }
                }
//                System.out.println("cnt: " + cnt);
                if (cnt >= q + 1) {
//                    System.out.println("middle: " + middle);
                    s = middle + 1;
                    answer = list.get(middle);
                } else {
                    e = middle - 1;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
