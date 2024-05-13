import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, l;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Queue<int[]> list = new ArrayDeque<>();
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                int x = arr[i][j];
                int y = arr[i][j + 1];
                if (Math.abs(x - y) >= 2) {
                    flag = true;
                    break;
                }
                if (x < y && Math.abs(x - y) == 1) {
                    int cnt = 0;
                    for (int k = j; k >= j - l + 1; k--) {
                        if (k >= 0) {
                            cnt++;
                            for (int[] z : list) {
                                if (z[0] == i && z[1] == k) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) break;
                            if (arr[i][k] == x) {
                                list.add(new int[]{i, k});
                            } else {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (cnt < l) {
                        flag = true;
                        break;
                    }
                    if (flag) break;
                } else if (x > y && Math.abs(x - y) == 1) {
                    int cnt = 0;
                    for (int k = j + 1; k < j + 1 + l; k++) {
                        for (int[] z : list) {
                            if (z[0] == i && z[1] == k) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) break;
                        if (k < n && arr[i][k] == y) {
                            cnt++;
                            list.add(new int[]{i, k});
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    if (cnt < l) {
                        flag = true;
                        break;
                    }
                    if (flag) break;
                }
            }
            if (!flag) {
                answer++;
            }
        }
        list.clear();
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                int x = arr[j][i];
                int y = arr[j + 1][i];
                if (Math.abs(x - y) >= 2) {
                    flag = true;
                    break;
                }
                if (x < y && Math.abs(x - y) == 1) {
                    int cnt = 0;
                    for (int k = j; k >= j - l + 1; k--) {
                        if (k >= 0) {
                            cnt++;
                            for (int[] z : list) {
                                if (z[0] == k && z[1] == i) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) break;
                            if (arr[k][i] == x) {
                                list.add(new int[]{k, i});
                            } else {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (cnt < l) {
                        flag = true;
                        break;
                    }
                    if (flag) break;
                } else if (x > y && Math.abs(x - y) == 1) {
                    int cnt = 0;
                    for (int k = j + 1; k < j + 1 + l; k++) {
                        for (int[] z : list) {
                            if (z[0] == k && z[1] == i) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) break;
                        if (k < n && arr[k][i] == y) {
                            cnt++;
                            list.add(new int[]{k, i});
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    if (cnt < l) {
                        flag = true;
                        break;
                    }
                    if (flag) break;
                }
            }
            if (!flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
