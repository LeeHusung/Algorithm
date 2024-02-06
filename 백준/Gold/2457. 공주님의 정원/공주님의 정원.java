import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] endDays = new int[366];
        int n = Integer.parseInt(br.readLine());

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int start = 0;
        int end = 0;
        for (int i = 0; i < 3; i++) {
            start += months[i];
        }
        start += 1;
        for (int i = 0; i < 11; i++) {
            end += months[i];
        }
        end += 30;
        int[] want = {start, end};

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            int startMonth = Integer.parseInt(s[0]);
            int startDate = Integer.parseInt(s[1]);
            int endMonth = Integer.parseInt(s[2]);
            int endDate = Integer.parseInt(s[3]);
            for (int j = 0; j < startMonth; j++) {
                startDate += months[j];
            }
            for (int j = 0; j < endMonth; j++) {
                endDate += months[j];
            }
            endDays[startDate] = Math.max(endDays[startDate], endDate);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int cnt = 0;
        int day = 60;
        int lastDay = 1;
        while (day < 335) {
            int max = 0;
            for (int i = lastDay; i <= day; i++) {
                max = Math.max(max, endDays[i]);
            }
            if (max == 0) break;
            lastDay = day;
            day = max;
            cnt++;

        }

        if (day >= 335) {
            System.out.println(cnt);
        } else System.out.println(0);

    }
}
