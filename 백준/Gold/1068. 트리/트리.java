import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int removeNode = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int root = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (x == -1) {
                root = i;
                continue;
            }
            graph.get(x).add(i);
        }
        if (root == removeNode) {
            System.out.println(0);
            return;
        }

//        for (int i = 0; i < graph.size(); i++) {
//            for (int j = 0; j < graph.get(i).size(); j++) {
//                if (graph.get(i).get(j) == removeNode) {
//                    graph.get(i).remove(j);
//                }
//            }
//        }
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int p = q.poll();
            boolean isLeaf = true;
            for (int x : graph.get(p)) {
                if (x == removeNode) continue;
                q.offer(x);
                isLeaf = false;
            }
            if (isLeaf) answer++;
        }

        System.out.println(answer);

//        for (ArrayList<Integer> x : graph) {
//            for (Integer y : x) {
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }




    }
}
