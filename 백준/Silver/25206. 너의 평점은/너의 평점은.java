import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double average = 0;
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        for (int i = 0; i < 20; i++) {
            String[] s = br.readLine().split(" ");
            String subject = s[0];
            double score = Double.parseDouble(s[1]);
            String grade = s[2];
            if (grade.equals("P")) continue;
            sum += score;
            average += score * map.get(grade);
        }
        System.out.println(average / sum);
    }
}