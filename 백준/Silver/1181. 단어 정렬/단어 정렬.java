import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        List<String> res = new ArrayList<>();
        for (String s : arr) {
            if (res.contains(s)) continue;
            res.add(s);
        }
        for (String re : res) {
            System.out.println(re);
        }
    }
}