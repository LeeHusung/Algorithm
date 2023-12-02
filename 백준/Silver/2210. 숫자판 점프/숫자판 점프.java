import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    static int[][] arr;
    static Set<String> set = new HashSet<>();
    static List<Integer> list = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void D(int x, int y, String str) {
        if (str.length() == 6) {
            set.add(str);
        } else {
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    list.add(arr[nx][ny]);
                    D(nx, ny, str + String.valueOf(arr[nx][ny]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                D(i, j, String.valueOf(arr[i][j]));
            }
        }
        System.out.println(set.size());

    }
}
