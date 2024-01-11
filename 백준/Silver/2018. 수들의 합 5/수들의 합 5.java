import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //2018

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int answer = 0;
            for (int j = i; j <= n; j++) {
                answer += j;
                if (answer > n) break;
                if (answer == n) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);


    }
}
