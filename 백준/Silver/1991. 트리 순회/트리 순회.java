import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static class Node {
        int leftNode;
        int rightNode;

        public Node(int leftNode, int rightNode) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
    static int n;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = s[0].charAt(0) - 'A' + 1;
            int b = s[1].charAt(0) - 'A' + 1;
            int c = s[2].charAt(0) - 'A' + 1;
            graph.get(a).add(new Node(b, c));
        }
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j < graph.get(i).size(); j++) {
//                System.out.print(graph.get(i).get(j).leftNode + " " + graph.get(i).get(j).rightNode);
//            }
//            System.out.println();
//        }

        roofBefore(1);
        sb.append("\n");
        roofMiddle(1);
        sb.append("\n");
        roofAfter(1);
        System.out.println(sb);
    }

    private static void roofAfter(int start) {
        for (Node node : graph.get(start)) {
            int leftNode = node.leftNode;
            int rightNode = node.rightNode;
            if (leftNode != -18) roofAfter(leftNode);
            if (rightNode != -18) roofAfter(rightNode);
            sb.append((char) (start + 'A' - 1));
        }
    }

    private static void roofMiddle(int start) {
        for (Node node : graph.get(start)) {
            int leftNode = node.leftNode;
            int rightNode = node.rightNode;
            if (leftNode != -18) roofMiddle(leftNode);
            sb.append((char) (start + 'A' - 1));
            if (rightNode != -18) roofMiddle(rightNode);
        }
    }

    private static void roofBefore(int start) {
        for (Node node : graph.get(start)) {
            int leftNode = node.leftNode;
            int rightNode = node.rightNode;
            sb.append((char) (start + 'A' - 1));
            if (leftNode != -18) roofBefore(leftNode);
            if (rightNode != -18) roofBefore(rightNode);
        }
    }


}
