import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[][] arr, cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        arr = new int[n][m];

        for (int i = 0; i < k; i++) {
            String[] s1 = br.readLine().split(" ");
            int r = Integer.parseInt(s1[0]);
            int c = Integer.parseInt(s1[1]);
            cur = new int[r][c];
            for (int j = 0; j < r; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int l = 0; l < c; l++) {
                    cur[j][l] = Integer.parseInt(st.nextToken());
                }
            }

            if (r > n && c > m) continue;
            for (int j = 0; j < 4; j++) {
                if (check(j)) {
                    break;
                }
            }
        }
        int cnt = 0;
        for (int j = 0; j < arr.length; j++) {
            for (int l = 0; l < arr[0].length; l++) {
                if (arr[j][l] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(int dir) {
        if (dir == 0) {
            for (int i = 0; i <= n - cur.length; i++) {
                for (int j = 0; j <= m - cur[0].length; j++) {
                    boolean flag = false;
                    for (int l = i; l < i + cur.length; l++) {
                        for (int o = j; o < j + cur[0].length; o++) {
                            if (arr[l][o] == 1 && cur[l - i][o - j] == 1) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) break;
                    }
                    if (!flag) {
                        for (int l = i; l < i + cur.length; l++) {
                            for (int o = j; o < j + cur[0].length; o++) {
                                if (cur[l - i][o - j] == 1) arr[l][o] = 1;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        if (dir == 1) {
            int[][] tmp = new int[cur[0].length][cur.length];
            for (int i = 0; i < cur.length; i++) {
                for (int j = 0; j < cur[0].length; j++) {
                    if (cur[i][j] == 1) {
                        tmp[j][Math.abs(i - (cur.length - 1))] = 1;
                    }
                }
            }
            cur = new int[tmp.length][tmp[0].length];
            for (int i = 0; i < tmp.length; i++) {
                cur[i] = tmp[i].clone();
            }
            for (int i = 0; i <= n - cur.length; i++) {
                for (int j = 0; j <= m - cur[0].length; j++) {
                    boolean flag = false;
                    for (int l = i; l < i + cur.length; l++) {
                        for (int o = j; o < j + cur[0].length; o++) {
                            if (arr[l][o] == 1 && cur[l - i][o - j] == 1) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) break;
                    }
                    if (!flag) {
                        for (int l = i; l < i + cur.length; l++) {
                            for (int o = j; o < j + cur[0].length; o++) {
                                if (cur[l - i][o - j] == 1) arr[l][o] = 1;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        if (dir == 2) {
            int[][] tmp = new int[cur[0].length][cur.length];
            for (int i = 0; i < cur.length; i++) {
                for (int j = 0; j < cur[0].length; j++) {
                    if (cur[i][j] == 1) {
                        tmp[j][Math.abs(i - (cur.length - 1))] = 1;
                    }
                }
            }
            cur = new int[tmp.length][tmp[0].length];
            for (int i = 0; i < tmp.length; i++) {
                cur[i] = tmp[i].clone();
            }
            for (int i = 0; i <= n - cur.length; i++) {
                for (int j = 0; j <= m - cur[0].length; j++) {
                    boolean flag = false;
                    for (int l = i; l < i + cur.length; l++) {
                        for (int o = j; o < j + cur[0].length; o++) {
                            if (arr[l][o] == 1 && cur[l - i][o - j] == 1) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) break;
                    }
                    if (!flag) {
                        for (int l = i; l < i + cur.length; l++) {
                            for (int o = j; o < j + cur[0].length; o++) {
                                if (cur[l - i][o - j] == 1) arr[l][o] = 1;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        if (dir == 3) {
            int[][] tmp = new int[cur[0].length][cur.length];
            for (int i = 0; i < cur.length; i++) {
                for (int j = 0; j < cur[0].length; j++) {
                    if (cur[i][j] == 1) {
                        tmp[j][Math.abs(i - (cur.length - 1))] = 1;                    }
                }
            }
            cur = new int[tmp.length][tmp[0].length];
            for (int i = 0; i < tmp.length; i++) {
                cur[i] = tmp[i].clone();
            }
            for (int i = 0; i <= n - cur.length; i++) {
                for (int j = 0; j <= m - cur[0].length; j++) {
                    boolean flag = false;
                    for (int l = i; l < i + cur.length; l++) {
                        for (int o = j; o < j + cur[0].length; o++) {
                            if (arr[l][o] == 1 && cur[l - i][o - j] == 1) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) break;
                    }
                    if (!flag) {
                        for (int l = i; l < i + cur.length; l++) {
                            for (int o = j; o < j + cur[0].length; o++) {
                                if (cur[l - i][o - j] == 1) arr[l][o] = 1;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
