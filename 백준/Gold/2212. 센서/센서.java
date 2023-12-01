import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        List<Integer> distanceBetweenSensors = new LinkedList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            distanceBetweenSensors.add(arr[i + 1] - arr[i]);
        }

        Collections.sort(distanceBetweenSensors, (a, b) -> b - a);

        int answer = 0;
        for (int i = k - 1; i < distanceBetweenSensors.size(); i++) {
            answer += distanceBetweenSensors.get(i);
        }
        System.out.println(answer);
    }
}
