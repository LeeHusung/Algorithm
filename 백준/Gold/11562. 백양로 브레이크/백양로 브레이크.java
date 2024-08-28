import static java.util.Arrays.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] arr = new int[m][3];
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            fill(dist[i], 9999999);
        }
        for (int i = 1; i < n + 1; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s1[0]);
            arr[i][1] = Integer.parseInt(s1[1]);
            arr[i][2] = Integer.parseInt(s1[2]);
            dist[arr[i][0]][arr[i][1]] = 0;
            dist[arr[i][1]][arr[i][0]] = 0;
            if (arr[i][2] == 0) {
                dist[arr[i][1]][arr[i][0]] = 1;
            }
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
//                    if (i==j) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String[] s1 = br.readLine().split(" ");
            int s = Integer.parseInt(s1[0]);
            int e = Integer.parseInt(s1[1]);
            sb.append(dist[s][e]).append("\n");
        }

        System.out.println(sb);

    }
}
