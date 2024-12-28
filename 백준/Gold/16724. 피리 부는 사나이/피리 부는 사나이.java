import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    static int n, m;
    static char[][] arr;
    static int[][] ch;
    static List<Node> list = new ArrayList<>();
    static int answer = 0;

    private static void D(int x, int y) {
        list.add(new Node(x, y));
        ch[x][y] = 1;
        if (arr[x][y] == 'D') {
            x++;
        }
        if (arr[x][y] == 'U') {
            x--;
        }
        else if (arr[x][y] == 'L') {
            y--;
        }
        else if (arr[x][y] == 'R') {
            y++;
        }
        if (ch[x][y] == 1) {
            if (list.contains(new Node(x, y))) {
                answer++;
            }
        } else D(x, y);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new char[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 0) {
                    list = new ArrayList<>();
                    D(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int x;
        int y;

        public Node(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
