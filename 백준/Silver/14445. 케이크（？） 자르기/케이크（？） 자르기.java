import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n == 1) {
            long answer = 0;
            System.out.println(answer);
            return;
        }
        long answer = n - (n / 2);

        System.out.println(answer);



    }
}
