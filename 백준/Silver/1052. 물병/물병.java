import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;
        int cnt = 0;
        while (true) {
            cnt = 0;
            int copy = n;
            while (copy != 0) {
                if (copy % 2 == 1) cnt++;
                copy /= 2;
            }
            if (cnt <= k) break;
            answer++;
            n++;
        }
        System.out.println(answer);
    }
}
