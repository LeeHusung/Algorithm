import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[n];
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
            LinkedList<Integer> list = new LinkedList<>();
            Arrays.sort(arr, (a, b) -> b - a);
            for (int j = 0; j < arr.length; j++) {
                if (j % 2 == 0) list.addLast(arr[j]);
                else list.addFirst(arr[j]);
            }
            int min = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                min = Math.max(min, Math.abs(list.get(j + 1) - list.get(j)));
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);

    }
}
