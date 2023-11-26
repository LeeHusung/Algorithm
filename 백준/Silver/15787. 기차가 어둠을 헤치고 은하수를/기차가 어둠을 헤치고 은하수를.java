import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] split = input.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        int[][] arr = new int[n + 1][21];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            String[] split2 = s.split(" ");

            if (split2.length == 3) {
                int command = Integer.parseInt(split2[0]);
                int train = Integer.parseInt(split2[1]);
                int zari = Integer.parseInt(split2[2]);

                if (command == 1) {
                    if (arr[train][zari] == 1) continue;
                    arr[train][zari] = 1;
                } else if (command == 2) {
                    if (arr[train][zari] == 0) continue;
                    arr[train][zari] = 0;
                }
            }

            if (split2.length == 2) {
                int command = Integer.parseInt(split2[0]);
                int train = Integer.parseInt(split2[1]);
                if (command == 3) {
                    for (int j = 20; j > 1; j--) {
                        arr[train][j] = arr[train][j - 1];
                    }
                    arr[train][1] = 0;
                } else if (command == 4) {
                    for (int j = 1; j < 20; j++) {
                        arr[train][j] = arr[train][j + 1];
                    }
                    arr[train][20] = 0;
                }
            }
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        //시초
//        for (int i = 1; i < n; i++) {
//            int[] train = arr[i];
//            boolean flag = false;
//            for (int j = i - 1; j >= 0; j--) {
//                flag = false;
//                int[] preTrain = arr[j];
//                for (int k = 0; k < preTrain.length; k++) {
//                    if (train[k] != preTrain[k]) {
//                        flag = true;
//                        break;
//                    }
//                }
//            }
//            if (flag) {
//                answer++;
//            }
//        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                sb.append(arr[i][j]);
            }
            set.add(sb.toString());
        }

        System.out.println(set.size());
    }
}
