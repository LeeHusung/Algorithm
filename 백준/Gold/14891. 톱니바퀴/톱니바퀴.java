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
            for (int k = 0; k < s.length(); k++) {
                graph.get(i).addLast(s.charAt(k) - '0');
            }
        }

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int tobniNum = sc.nextInt();
            int direction = sc.nextInt();
            LinkedList<Integer> list = graph.get(tobniNum);
            int[] change = new int[4 + 1];
            change[tobniNum] = direction;
            int x = tobniNum;
            while (x < 4) {
                LinkedList<Integer> list1 = graph.get(x + 1);
                if (list1.get(6) != list.get(2)) {
                    change[x + 1] = -change[x];
                }
                x++;
                list = list1;
            }
            list = graph.get(tobniNum);
            int y = tobniNum;
            while (y > 1) {
                LinkedList<Integer> list1 = graph.get(y - 1);
                if (list1.get(2) != list.get(6)) {
                    change[y - 1] = -change[y];
                }
                y--;
                list = list1;
            }

            for (int j = 1; j <= 4; j++) {
                LinkedList<Integer> listsss = graph.get(j);
                if (change[j] == 1) {
                    listsss.addFirst(listsss.pollLast());
                }
                if (change[j] == -1) {
                    listsss.addLast(listsss.pollFirst());
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
