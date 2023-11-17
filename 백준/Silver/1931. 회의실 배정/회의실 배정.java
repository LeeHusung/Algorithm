import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static class Node implements Comparable<Node> {
        long x, y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y == o.y) return (int) (this.x - o.x); 
            else return (int) (this.y - o.y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            list.add(new Node(x, y));
        }
        Collections.sort(list);

        long start = list.get(0).x;
        long end = list.get(0).y;
        int answer = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).x >= end) {
                start = list.get(i).x;
                end = list.get(i).y;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
