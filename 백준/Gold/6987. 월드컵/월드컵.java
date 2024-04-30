import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static int[][] matches = {{0,1}, {0,2}, {0,3}, {0,4}, {0,5}, {1,2}, {1,3}, {1,4}, {1,5}, {2,3}, {2,4}, {2,5}, {3,4}, {3,5}, {4,5}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 4;
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            arr = new int[6][3];
            int sum = 0;
            int idx = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(s[idx++]);
                    sum += arr[i][j];
                }
            }
            if (sum != 30) {
                sb.append(0).append(" ");
                continue;
            }

            if (D(0)) sb.append(1).append(" ");
            else sb.append(0).append(" ");

        }
        System.out.println(sb);

    }

    private static boolean D(int L) {
        if (L == 15) {
            return true;
        }

        if (arr[matches[L][0]][0] > 0 && arr[matches[L][1]][2] > 0) {
            arr[matches[L][0]][0]--;
            arr[matches[L][1]][2]--;
            if (D(L + 1)) return true;
            arr[matches[L][0]][0]++;
            arr[matches[L][1]][2]++;
        }
        if (arr[matches[L][0]][1] > 0 && arr[matches[L][1]][1] > 0) {
            arr[matches[L][0]][1]--;
            arr[matches[L][1]][1]--;
            if (D(L + 1)) return true;
            arr[matches[L][0]][1]++;
            arr[matches[L][1]][1]++;
        }
        if (arr[matches[L][0]][2] > 0 && arr[matches[L][1]][0] > 0) {
            arr[matches[L][0]][2]--;
            arr[matches[L][1]][0]--;
            if (D(L + 1)) return true;
            arr[matches[L][0]][2]++;
            arr[matches[L][1]][0]++;
        }

        return false;
    }
}
