import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = Integer.MAX_VALUE;
        String[] split = s.split("-");
        for (int i = 0; i < split.length; i++) {
            String[] sss = split[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < sss.length; j++) {
                sum += Integer.parseInt(sss[j]);
            }

            if (answer == Integer.MAX_VALUE) {
                answer = sum;
            } else answer -= sum;

        }
        System.out.println(answer);

    }
}
