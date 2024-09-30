import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int o = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if (o == 1) {
                union(p, q);
            } else if (o == 2) {
                fight(p, q);
            }
        }
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < parent.length; i++) {
            if (arr[find(i)] > 0) {
                set.add(find(i));
            }
        }
        sb.append(set.size()).append("\n");
        List<Integer> list = new ArrayList<>();
        for (Integer x : set) {
            list.add(arr[x]);
        }
        Collections.sort(list);
        for (Integer x : list) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);

//        for (int i = 1; i <= n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        for (int i = 1; i <= n; i++) {
//            System.out.print(parent[i] + " ");
//        }
    }

    private static void fight(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return; // 같은 나라면 싸울 필요 없음

        if (arr[rootX] < arr[rootY]) {
            arr[rootY] -= arr[rootX];
            arr[rootX] = 0;
            parent[rootX] = rootY; // x가 y에게 병합됨
        } else if (arr[rootX] > arr[rootY]) {
            arr[rootX] -= arr[rootY];
            arr[rootY] = 0;
            parent[rootY] = rootX; // y가 x에게 병합됨
        } else { // 병력이 같은 경우
            arr[rootX] = arr[rootY] = 0;
            parent[rootX] = parent[rootY] = 0; // 둘 다 멸망
        }
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rootX < rootY) {
                parent[rootY] = rootX;
                arr[rootX] += arr[rootY];
                arr[rootY] = 0;
            } else {
                parent[rootX] = rootY;
                arr[rootY] += arr[rootX];
                arr[rootX] = 0;
            }
        }
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
