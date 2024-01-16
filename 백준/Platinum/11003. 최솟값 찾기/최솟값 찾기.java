
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        LinkedList<Node> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            while (!list.isEmpty() && list.peekLast().value > A[i]) {
                list.pollLast();
            }

            list.add(new Node(i, A[i]));
            if (list.peekFirst().idx <= i - L) {
                list.removeFirst();
            }
            sb.append(list.peekFirst().value).append(" ");

        }
        System.out.println(sb.toString());


    }
}
