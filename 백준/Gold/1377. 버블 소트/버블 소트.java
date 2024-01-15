import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Point(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }
        System.out.println(max + 1);
        
    }
    static class Point implements Comparable<Point> {
        int value;
        int index;

        public Point(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Point o) {
            return this.value - o.value;
        }
    }
}
