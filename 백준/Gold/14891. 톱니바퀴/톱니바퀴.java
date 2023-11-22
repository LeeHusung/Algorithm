import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        for (int i = 0; i <= 4; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 1; i <= 4; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                graph.get(i).add(s.charAt(j) - '0');
            }
        }

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int tobni = sc.nextInt();
            int direction = sc.nextInt();
            int[] change = new int[5];
            change[tobni] = direction;

            for (int j = tobni; j < 4; j++) {
                if (graph.get(j).get(2) != graph.get(j + 1).get(6)) {
                    change[j + 1] = -change[j];
                }
            }
            for (int j = tobni; j > 1; j--) {
                if (graph.get(j).get(6) != graph.get(j - 1).get(2)) {
                    change[j - 1] = -change[j];
                }
            }

            for (int j = 1; j <= 4; j++) {
                LinkedList<Integer> list = graph.get(j);
                if (change[j] == 1) {
                    list.addFirst(list.pollLast());
                } else if (change[j] == -1) {
                    list.addLast(list.pollFirst());
                }
            }
        }




        int sum = 0;
        if (graph.get(1).get(0) == 1) sum += 1;
        if (graph.get(2).get(0) == 1) sum += 2;
        if (graph.get(3).get(0) == 1) sum += 4;
        if (graph.get(4).get(0) == 1) sum += 8;

        System.out.println(sum);
    }
}
